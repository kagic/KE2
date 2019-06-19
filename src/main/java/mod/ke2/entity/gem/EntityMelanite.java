package mod.ke2.entity.gem;

import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMelanite extends AbstractGarnet {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/melanite/color_gemstone"), VariantColor.class), EntityMelanite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/melanite/color_hair"), VariantColor.class), EntityMelanite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/melanite/color_outfit"), VariantColor.class), EntityMelanite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/melanite/color_skin"), VariantColor.class), EntityMelanite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/melanite/color_visor"), VariantColor.class), EntityMelanite.class);
	}
	
	public EntityMelanite(World world) {
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
