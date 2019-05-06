package mod.ke2.entity.gem;

import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityAmethyst extends AbstractQuartz {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/amethyst/color_gemstone"), VariantColor.class), EntityAmethyst.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/amethyst/color_hair"), VariantColor.class), EntityAmethyst.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/amethyst/color_outfit"), VariantColor.class), EntityAmethyst.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/amethyst/color_skin"), VariantColor.class), EntityAmethyst.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/amethyst/color_visor"), VariantColor.class), EntityAmethyst.class);
	}
	public EntityAmethyst(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
