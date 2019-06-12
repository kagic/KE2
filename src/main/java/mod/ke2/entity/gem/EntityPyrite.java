package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityPyrite extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/hair_default"), VariantPath.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/hair_forehead"), VariantPath.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/outfit_default"), VariantPath.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/outfit_doc"), VariantPath.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/outfit_navy"), VariantPath.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/skin_default"), VariantPath.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/color_gemstone"), VariantColor.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/color_hair"), VariantColor.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/color_outfit"), VariantColor.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/color_skin"), VariantColor.class), EntityPyrite.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/pyrite/color_visor"), VariantColor.class), EntityPyrite.class);
	}
	public EntityPyrite(World world) {
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
