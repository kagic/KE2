package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHiddenite extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/hair_default"), VariantPath.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/outfit_default"), VariantPath.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/skin_default"), VariantPath.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/cut_triangular"), VariantPath.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/color_gemstone"), VariantColor.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/color_hair"), VariantColor.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/color_outfit"), VariantColor.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/color_skin"), VariantColor.class), EntityHiddenite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hiddenite/color_visor"), VariantColor.class), EntityHiddenite.class);
	}
	public EntityHiddenite(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
