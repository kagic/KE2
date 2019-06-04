package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityAquamarine extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/hair_default"), VariantPath.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/outfit_default"), VariantPath.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/skin_default"), VariantPath.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/cut_teardrop"), VariantPath.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/color_gemstone"), VariantColor.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/color_hair"), VariantColor.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/color_outfit"), VariantColor.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/color_skin"), VariantColor.class), EntityAquamarine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aquamarine/color_visor"), VariantColor.class), EntityAquamarine.class);
	}
	protected static final DataParameter<Boolean> WINGED = EntityDataManager.<Boolean>createKey(EntityAquamarine.class, DataSerializers.BOOLEAN);
	public EntityAquamarine(World world) {
		super(world);
		this.dataManager.register(WINGED, false);
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
	public void setWinged(boolean winged) {
		this.dataManager.set(WINGED, winged);
	}
	public boolean isWinged() {
		return this.dataManager.get(WINGED);
	}
}
