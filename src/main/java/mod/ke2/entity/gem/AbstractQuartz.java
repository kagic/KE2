package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class AbstractQuartz extends EntityGem {
	private static final DataParameter<Boolean> CHARGED = EntityDataManager.<Boolean>createKey(AbstractQuartz.class, DataSerializers.BOOLEAN);
	public boolean chargedByTakingDamageNotDelivering;
	private int ticksCharged = 0;
	private int hitCount = 0;
	public AbstractQuartz(World world) {
		super(world);
		this.setSize(0.9F, 2.3F);
		this.dataManager.register(CHARGED, false);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	}
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
    	if (this.isPerfect()) {
    		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
    	}
    	else if (this.isDefective()) {
    		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    	}
    	else {
    		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
    	}
        return super.onInitialSpawn(difficulty, livingdata);
    }
    @Override
	public void onLivingUpdate() {
		if (this.ticksCharged < 0) {
			this.setCharged(false);
		}
		else if (!this.isCharged() && this.hitCount > 6) {
			this.setCharged(true);
		}
		else {
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
	@Override
    public int getBrightnessForRender() {
        return this.isCharged() ? 0xFFFFFF : super.getBrightnessForRender();
	}
    @Override
	public float getBrightness() {
        return this.isCharged() ? 1.0F : super.getBrightness();
    }
	public void setCharged(boolean charged) {
		this.dataManager.set(CHARGED, charged);
	}
	public boolean isCharged() {
		return this.dataManager.get(CHARGED);
	}
}
