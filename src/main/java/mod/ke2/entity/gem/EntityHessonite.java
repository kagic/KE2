package mod.ke2.entity.gem;

import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHessonite extends AbstractGarnet {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hessonite/color_gemstone"), VariantColor.class), EntityHessonite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hessonite/color_hair"), VariantColor.class), EntityHessonite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hessonite/color_outfit"), VariantColor.class), EntityHessonite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hessonite/color_skin"), VariantColor.class), EntityHessonite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/hessonite/color_visor"), VariantColor.class), EntityHessonite.class);
	}
	
	public EntityHessonite(World world) {
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
