package mod.ke2.handles;

import java.util.List;

import mod.ke2.entity.machine.EntityBubble;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleBubbleEnchant {
		@SubscribeEvent
		public void onEntityInteract(PlayerInteractEvent.RightClickBlock e) {
			if (!e.getWorld().isRemote) {
			BlockPos pos = e.getPos();
			World world = e.getWorld();			
			List<EntityItem> items = world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos).grow(1, 1, 1));
				for (EntityItem item : items) {
					if (!item.isDead) {
						for (EntityItem Item : items) {
							EntityBubble bubble = new EntityBubble(world);
							bubble.setColor(0);
							bubble.setItem(item.getItem());
							bubble.setPosition(item.posX, item.posY, item.posZ);
							bubble.setHealth(0.5F);
							bubble.motionY = world.rand.nextDouble() / 2;
							bubble.playBubbleSound();
							item.setDead();
							world.spawnEntity(bubble);
						}
					}
				}
			}
		}
}
