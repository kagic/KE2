package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public class EntityEmerald extends EntityGem {
	public EntityEmerald(World world) {
		super(world);
	}
	@Override
	public int generateGemstonePosition() {
		return Ke2Gems.GEMSTONE_CHEST;
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
