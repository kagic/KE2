package mod.ke2.entity.gem;

import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAmethyst extends AbstractQuartz {
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/amethyst/index"), EntityAmethyst.class);
	}

	public EntityAmethyst(World world) {
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
		return Ke2Sounds.GEM_AMETHYST;
	}
}
