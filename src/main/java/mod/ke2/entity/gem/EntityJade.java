package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.api.variants.types.TagType;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityJade extends EntityGem {
	public static final ArrayList<TagType> JADE_SHAPES = new ArrayList<TagType>();
	public static final ArrayList<TagType> JADE_COLORS = new ArrayList<TagType>();
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/hair_default"), VariantPath.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/outfit_default"), VariantPath.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/skin_default"), VariantPath.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/color_gemstone"), VariantColor.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/color_hair"), VariantColor.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/color_outfit"), VariantColor.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/color_skin"), VariantColor.class), EntityJade.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/jade/color_visor"), VariantColor.class), EntityJade.class);
		EntityJade.JADE_COLORS.add(new TagType(50, "ke2:jade.color.green")); // jump
																				// boost
		EntityJade.JADE_COLORS.add(new TagType(50, "ke2:jade.color.yellow")); // haste
		EntityJade.JADE_COLORS.add(new TagType(15, "ke2:jade.color.purple")); // regeneration
		EntityJade.JADE_COLORS.add(new TagType(5, "ke2:jade.color.orange")); // fire
																				// resistance
		EntityJade.JADE_COLORS.add(new TagType(3, "ke2:jade.color.red")); // strength
		EntityJade.JADE_COLORS.add(new TagType(1, "ke2:jade.color.white")); // speed
		EntityJade.JADE_COLORS.add(new TagType(1, "ke2:jade.color.black")); // wither
																			// (to
																			// enemies)
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
}
