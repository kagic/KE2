package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityRutile extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/hair_default"), VariantPath.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/outfit_default"), VariantPath.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/skin_default"), VariantPath.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/color_gemstone"), VariantColor.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/color_hair"), VariantColor.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/color_outfit"), VariantColor.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/color_skin"), VariantColor.class), EntityRutile.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/rutile/color_visor"), VariantColor.class), EntityRutile.class);
	}
	
	public EntityRutile(World world) {
		super(world);
		this.changesScaleBasedOnCondition = false;
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
}
