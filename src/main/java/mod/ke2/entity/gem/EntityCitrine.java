package mod.ke2.entity.gem;

import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityCitrine extends AbstractQuartz {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/citrine/color_gemstone"), VariantColor.class), EntityCitrine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/citrine/color_hair"), VariantColor.class), EntityCitrine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/citrine/color_outfit"), VariantColor.class), EntityCitrine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/citrine/color_skin"), VariantColor.class), EntityCitrine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/citrine/color_visor"), VariantColor.class), EntityCitrine.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/citrine/color_eyes"), VariantColor.class), EntityCitrine.class);
	}
	public EntityCitrine(World world) {
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
