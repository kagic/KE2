package mod.ke2.entity.gem;

import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAquaAuraQuartz extends AbstractQuartz {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aqua_aura_quartz/color_gemstone"), VariantColor.class), EntityAquaAuraQuartz.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aqua_aura_quartz/color_hair"), VariantColor.class), EntityAquaAuraQuartz.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aqua_aura_quartz/color_outfit"), VariantColor.class), EntityAquaAuraQuartz.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aqua_aura_quartz/color_skin"), VariantColor.class), EntityAquaAuraQuartz.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aqua_aura_quartz/color_visor"), VariantColor.class), EntityAquaAuraQuartz.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/aqua_aura_quartz/color_eyes"), VariantColor.class), EntityAquaAuraQuartz.class);
	}
	
	public EntityAquaAuraQuartz(World world) {
		super(world);
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_AQUA_AURA_QUARTZ;
	}
}
