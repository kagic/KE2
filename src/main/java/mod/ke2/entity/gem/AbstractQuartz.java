package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.init.Ke2Gems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class AbstractQuartz extends EntityGem {
	public static final ArrayList<Class<? extends AbstractQuartz>> GLOBAL_VARIANT_CLASSES = new ArrayList<Class<? extends AbstractQuartz>>();
	public static final ArrayList<ResourceLocation> GLOBAL_VARIANT_PATHS = new ArrayList<ResourceLocation>();
	static {
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityAgate.class);
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityAmethyst.class);
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityAquaAuraQuartz.class);
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityCarnelian.class);
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityCitrine.class);
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityJasper.class);
		AbstractQuartz.GLOBAL_VARIANT_CLASSES.add(EntityRoseQuartz.class);
	}
	protected static final DataParameter<String> VARIANT_EYES = EntityDataManager.<String>createKey(AbstractQuartz.class, DataSerializers.STRING);
	protected static final DataParameter<Integer> COLOR_RGB_EYES = EntityDataManager.<Integer>createKey(AbstractQuartz.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> CHARGED = EntityDataManager.<Boolean>createKey(AbstractQuartz.class, DataSerializers.BOOLEAN);
	public boolean chargedByTakingDamageNotDelivering;
	private int ticksCharged = 0;
	private int hitCount = 0;

	public AbstractQuartz(World world) {
		super(world);
		this.setSize(0.9F, 2.3F);
		this.dataManager.register(AbstractQuartz.VARIANT_EYES, "");
		this.dataManager.register(AbstractQuartz.COLOR_RGB_EYES, 0);
		this.dataManager.register(AbstractQuartz.CHARGED, false);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		data = super.onInitialSpawn(difficulty, data);
		this.setEyesVariant(this.generateEyesVariant());
		this.setEyesColor(this.generateEyesColor());
		return data;
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setEyesVariant(compound.getString("EyesVariant"));
		this.setEyesColor(compound.getInteger("EyesColor"));
		this.setCharged(compound.getBoolean("Charged"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("EyesVariant", this.getEyesVariant());
		compound.setInteger("EyesColor", this.getEyesColor());
		compound.setBoolean("Charged", this.isCharged());
	}

	@Override
	public void onLivingUpdate() {
		if (this.ticksCharged < 0) {
			this.setCharged(false);
		} else if (!this.isCharged() && this.hitCount > 6) {
			this.setCharged(true);
		} else {
			this.ticksCharged -= 1;
		}
		super.onLivingUpdate();
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.chargedByTakingDamageNotDelivering) {
			this.ticksCharged += 20 + this.world.rand.nextInt(20);
			this.hitCount += 1;
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!this.world.isRemote) {
			this.attackEntityAsMob(target);
		}
		super.attackEntityWithRangedAttack(target, distanceFactor);
	}

	@Override
	public boolean attackEntityAsMob(Entity target) {
		if (!this.chargedByTakingDamageNotDelivering) {
			this.ticksCharged += 20 + this.world.rand.nextInt(20);
			this.hitCount += 1;
		}
		return super.attackEntityAsMob(target);
	}

	public String generateEyesVariant() {
		return VariantHelper.loadVariantPath(this, "ke2:quartz.texture.eyes");
	}

	public void setEyesVariant(String variant) {
		this.dataManager.set(AbstractQuartz.VARIANT_EYES, variant);
	}

	public String getEyesVariant() {
		return this.dataManager.get(AbstractQuartz.VARIANT_EYES);
	}

	public int generateEyesColor() {
		return VariantHelper.loadVariantColor(this, "ke2:quartz.color.eyes");
	}

	public void setEyesColor(int color) {
		this.dataManager.set(AbstractQuartz.COLOR_RGB_EYES, color);
	}

	public int getEyesColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xCCCCCC;
		} else {
			return this.dataManager.get(AbstractQuartz.COLOR_RGB_EYES);
		}
	}

	@Override
	public int getBrightnessForRender() {
		return this.isCharged() ? 0xFFFFFF : super.getBrightnessForRender();
	}

	@Override
	public float getBrightness() {
		return this.isCharged() ? 1.0F : super.getBrightness();
	}

	public void setCharged(boolean charged) {
		this.dataManager.set(AbstractQuartz.CHARGED, charged);
	}

	public boolean isCharged() {
		return this.dataManager.get(AbstractQuartz.CHARGED);
	}
}
