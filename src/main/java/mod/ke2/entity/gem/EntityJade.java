package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.api.variants.types.TagType;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityJade extends EntityGem {
	public static final ArrayList<TagType> JADE_SHAPES = new ArrayList<TagType>();
	public static final ArrayList<TagType> JADE_COLORS = new ArrayList<TagType>();
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/jade/index"), EntityJade.class);
		EntityJade.JADE_COLORS.add(new TagType(50, "ke2:jade.color.green"));
		EntityJade.JADE_COLORS.add(new TagType(50, "ke2:jade.color.yellow"));
		EntityJade.JADE_COLORS.add(new TagType(15, "ke2:jade.color.purple"));
		EntityJade.JADE_COLORS.add(new TagType(5, "ke2:jade.color.orange"));
		EntityJade.JADE_COLORS.add(new TagType(3, "ke2:jade.color.red"));
		EntityJade.JADE_COLORS.add(new TagType(1, "ke2:jade.color.white"));
		EntityJade.JADE_COLORS.add(new TagType(1, "ke2:jade.color.black"));
		EntityJade.JADE_SHAPES.add(new TagType(50, "ke2:jade.shape.bell"));
		EntityJade.JADE_SHAPES.add(new TagType(10, "ke2:jade.shape.spur"));
		EntityJade.JADE_SHAPES.add(new TagType(10, "ke2:jade.shape.rack"));
		EntityJade.JADE_SHAPES.add(new TagType(10, "ke2:jade.shape.worm"));
	}
	protected static final DataParameter<String> JADE_COLOR = EntityDataManager.<String>createKey(EntityJade.class, DataSerializers.STRING);
	protected static final DataParameter<String> JADE_SHAPE = EntityDataManager.<String>createKey(EntityJade.class, DataSerializers.STRING);

	public EntityJade(World world) {
		super(world);
		this.dataManager.register(EntityJade.JADE_COLOR, "ke2:jade.color.green");
		this.dataManager.register(EntityJade.JADE_SHAPE, "ke2:jade.shape.bell");
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setJadeColor(this.generateJadeColor());
		this.setJadeShape(this.generateJadeShape());
		return super.onInitialSpawn(difficulty, data);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setJadeColor(compound.getString("JadeColor"));
		this.setJadeShape(compound.getString("JadeShape"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("JadeColor", this.getJadeColor());
		compound.setString("JadeShape", this.getJadeShape());
	}

	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		// Jades have no legs and are thus completely
		// silent.
	}

	@Override
	public int generateSkinColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.skin", this.getJadeColor(), this.getJadeShape());
	}

	@Override
	public int generateHairColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.hair", this.getJadeColor(), this.getJadeShape());
	}

	@Override
	public int generateOutfitColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.outfit", this.getJadeColor(), this.getJadeShape());
	}

	@Override
	public int generateVisorColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.visor", this.getJadeColor(), this.getJadeShape());
	}

	@Override
	public int generateGemstoneColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.gemstone", this.getJadeColor(), this.getJadeShape());
	}

	@Override
	public void onInventoryChanged(IInventory inventory) {

	}

	@Override
	public int generateGemstoneCut() {
		return 0;
	}

	public void setJadeColor(String color) {
		this.dataManager.set(EntityJade.JADE_COLOR, color);
	}

	public String getJadeColor() {
		return this.dataManager.get(EntityJade.JADE_COLOR);
	}

	public String generateJadeColor() {
		return TagType.weigh(EntityJade.JADE_COLORS).getTag();
	}

	public void setJadeShape(String shape) {
		this.dataManager.set(EntityJade.JADE_SHAPE, shape);
	}

	public String getJadeShape() {
		return this.dataManager.get(EntityJade.JADE_SHAPE);
	}

	public String generateJadeShape() {
		return TagType.weigh(EntityJade.JADE_SHAPES).getTag();
	}
	
	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_JADE;
	}
}
