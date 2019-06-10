package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityWatermelonTourmaline extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/hair_default"), VariantPath.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/outfit_default"), VariantPath.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/skin_default"), VariantPath.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_gemstone"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_hair"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_outfit"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_skin"), VariantColor.class), EntityWatermelonTourmaline.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/watermelon_tourmaline/color_visor"), VariantColor.class), EntityWatermelonTourmaline.class);
	}
	public EntityWatermelonTourmaline(World world) {
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
