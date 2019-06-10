package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityKunzite extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/hair_default"), VariantPath.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/outfit_default"), VariantPath.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/skin_default"), VariantPath.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/cut_triangular"), VariantPath.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/color_gemstone"), VariantColor.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/color_hair"), VariantColor.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/color_outfit"), VariantColor.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/color_skin"), VariantColor.class), EntityKunzite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/kunzite/color_visor"), VariantColor.class), EntityKunzite.class);
	}
	public EntityKunzite(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
}
