package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityDesertGlass extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/hair_default"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/outfit_default"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/skin_default"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/cut_triangular"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_gemstone"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_hair"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_outfit"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_skin"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_visor"), VariantColor.class), EntityDesertGlass.class);
	}
	public EntityDesertGlass(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
