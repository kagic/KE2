package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMotherOfPearl extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/hair_default"), VariantPath.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/outfit_default"), VariantPath.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/skin_default"), VariantPath.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/cut_triangular"), VariantPath.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/color_gemstone"), VariantColor.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/color_hair"), VariantColor.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/color_outfit"), VariantColor.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/color_skin"), VariantColor.class), EntityMotherOfPearl.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/mother_of_pearl/color_visor"), VariantColor.class), EntityMotherOfPearl.class);
	}
	public EntityMotherOfPearl(World world) {
		super(world);
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
