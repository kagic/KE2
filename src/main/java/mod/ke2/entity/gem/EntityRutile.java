package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRutile extends EntityGem {
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/rutile/index"), EntityRutile.class);
	}
	
	public EntityRutile(World world) {
		super(world);
		this.changesScaleBasedOnCondition = false;
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
		return Ke2Sounds.GEM_RUTILE;
	}
}
