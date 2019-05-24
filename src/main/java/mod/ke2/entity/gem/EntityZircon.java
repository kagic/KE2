package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityZircon extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/hair_default"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/outfit_default"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/skin_default"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/cut_triangular"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_gemstone"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_hair"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_outfit"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_skin"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_visor"), VariantColor.class), EntityZircon.class);
	}
	public EntityZircon(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
