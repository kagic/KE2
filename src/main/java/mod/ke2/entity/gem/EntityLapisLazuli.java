package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityLapisLazuli extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/hair_default"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/outfit_default"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/skin_default"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_gemstone"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_hair"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_outfit"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_skin"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_visor"), VariantColor.class), EntityLapisLazuli.class);
	}
	protected static final DataParameter<Boolean> WINGED = EntityDataManager.<Boolean>createKey(EntityLapisLazuli.class, DataSerializers.BOOLEAN);
	
	public EntityLapisLazuli(World world) {
		super(world);
		this.dataManager.register(EntityLapisLazuli.WINGED, false);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setWinged(compound.getBoolean("Winged"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Winged", this.isWinged());
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	
	public void setWinged(boolean winged) {
		this.dataManager.set(EntityLapisLazuli.WINGED, winged);
	}
	
	public boolean isWinged() {
		return this.dataManager.get(EntityLapisLazuli.WINGED);
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_LAPIS_LAZULI;
	}
}
