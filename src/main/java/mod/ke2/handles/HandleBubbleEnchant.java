package mod.ke2.handles;

import java.util.List;
import java.util.Map;

import mod.ke2.entity.machine.EntityBubble;
import mod.ke2.init.Ke2Enchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleBubbleEnchant {
	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.RightClickBlock e) {
		if (!e.getWorld().isRemote) {
			if (!e.getItemStack().isEmpty()) {
				EntityPlayer player = e.getEntityPlayer();
				EnumHand hand = player.getActiveHand();
				ItemStack itemstack = player.getHeldItem(hand);
				if (itemstack.isItemEnchanted()) {
					Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(itemstack);
					if (enchants.containsKey(Ke2Enchants.BUBBLE)) {
						BlockPos pos = e.getPos();
						World world = e.getWorld();
						List<EntityItem> items = world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos).grow(1, 1, 1));
						for (EntityItem item : items) {
							if (!item.isDead) {
								for (@SuppressWarnings("unused")
								EntityItem Item : items) {
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
		}
	}
}
