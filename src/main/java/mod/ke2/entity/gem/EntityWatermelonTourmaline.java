package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Gems;
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

public class EntityWatermelonTourmaline extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/hair_default"), VariantPath.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/outfit_default"), VariantPath.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/skin_default"), VariantPath.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_gemstone"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_hair"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_outfit"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_skin"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_visor"), VariantColor.class), EntityWatermelonTourmaline.class);
	}
	private static final DataParameter<Integer> COLOR_RGB_TOP = EntityDataManager.<Integer>createKey(EntityWatermelonTourmaline.class, DataSerializers.VARINT);
	
	public EntityWatermelonTourmaline(World world) {
		super(world);
		this.dataManager.register(EntityWatermelonTourmaline.COLOR_RGB_TOP, 0);
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		data = super.onInitialSpawn(difficulty, data);
		this.setTopColor(this.generateTopColor());
		return data;
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setTopColor(compound.getInteger("TopColor"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("TopColor", this.getTopColor());
	}
	
	public int generateTopColor() {
		return VariantHelper.loadVariantColor(this, "ke2:watermelon_tourmaline.color.top");
	}
	
	public void setTopColor(int color) {
		this.dataManager.set(EntityWatermelonTourmaline.COLOR_RGB_TOP, color);
	}
	
	public int getTopColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xCCCCCC;
		} else {
			return this.dataManager.get(EntityWatermelonTourmaline.COLOR_RGB_TOP);
		}
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_WATERMELON_TOURMALINE;
	}
}
