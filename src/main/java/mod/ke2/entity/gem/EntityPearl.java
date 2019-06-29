package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.api.variants.types.TagType;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPearl extends EntityGem {
	public static final ArrayList<TagType> PEARL_COLORS = new ArrayList<TagType>();
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/hair_default"), VariantPath.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/outfit_default"), VariantPath.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/skin_default"), VariantPath.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/color_gemstone"), VariantColor.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/color_hair"), VariantColor.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/color_outfit"), VariantColor.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/color_skin"), VariantColor.class), EntityPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pearl/color_visor"), VariantColor.class), EntityPearl.class);
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.red"));
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.orange"));
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.yellow"));
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.green"));
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.blue"));
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.violet"));
		EntityPearl.PEARL_COLORS.add(new TagType(5, "ke2:pearl.color.pink"));
		EntityPearl.PEARL_COLORS.add(new TagType(1, "ke2:pearl.color.white"));
		EntityPearl.PEARL_COLORS.add(new TagType(1, "ke2:pearl.color.cream"));
		EntityPearl.PEARL_COLORS.add(new TagType(1, "ke2:pearl.color.black"));
	}
	protected static final DataParameter<String> PEARL_COLOR = EntityDataManager.<String>createKey(EntityPearl.class, DataSerializers.STRING);
	
	public EntityPearl(World world) {
		super(world);
		this.dataManager.register(EntityPearl.PEARL_COLOR, "ke2:pearl.color.blue");
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setPearlColor(this.generatePearlColor());
		return super.onInitialSpawn(difficulty, data);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setPearlColor(compound.getString("PearlColor"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("PearlColor", this.getPearlColor());
	}
	
	@Override
	public int generateSkinColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.skin", this.getPearlColor());
	}
	
	@Override
	public int generateHairColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.hair", this.getPearlColor());
	}
	
	@Override
	public int generateOutfitColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.outfit", this.getPearlColor());
	}
	
	@Override
	public int generateVisorColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.visor", this.getPearlColor());
	}
	
	@Override
	public int generateGemstoneColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.gemstone", this.getPearlColor());
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	
	public void setPearlColor(String color) {
		this.dataManager.set(EntityPearl.PEARL_COLOR, color);
	}
	
	public String getPearlColor() {
		return this.dataManager.get(EntityPearl.PEARL_COLOR);
	}
	
	public String generatePearlColor() {
		return TagType.weigh(EntityPearl.PEARL_COLORS).getTag();
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_PEARL;
	}
}
