package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityLapisLazuli extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/hair_default"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/outfit_default"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/skin_default"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/cut_triangular"), VariantPath.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_gemstone"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_hair"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_outfit"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_skin"), VariantColor.class), EntityLapisLazuli.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/lapis_lazuli/color_visor"), VariantColor.class), EntityLapisLazuli.class);
	}
	public EntityLapisLazuli(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
