package mod.kagic.handles;

public class HandleCapturing {
	/*@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (!e.getWorld().isRemote) {
			List<EntityItem> items = e.getEntityPlayer().world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(e.getPos()).grow(1, 1, 1));
			for (EntityItem item : items) {
				if (!item.isDead) {
					if (e.getItemStack().getItem() == AmItems.GEM_STAFF || e.getItemStack().getItem() == AmItems.COMMANDER_STAFF) {
						List<EntityGem> list = e.getEntityPlayer().world.<EntityGem>getEntitiesWithinAABB(EntityGem.class, e.getEntityPlayer().getEntityBoundingBox().grow(4, 4, 4));
						double distance = Double.MAX_VALUE;
						EntityGem gem = null;
						for (EntityGem testedGem : list) {
							if (testedGem.isOwnedBy(e.getEntityPlayer())) {
								double newDistance = e.getEntityPlayer().getDistanceSq(testedGem);
								if (newDistance <= distance) {
									distance = newDistance;
									gem = testedGem;
								}
							}
						}
						if (gem != null) {
							EntityBubble bubble = new EntityBubble(e.getWorld());
							bubble.setColor(gem == null ? e.getWorld().rand.nextInt(0xFFFFFF) : gem.getGemColor());
							bubble.setItem(item.getItem());
							bubble.setPosition(item.posX, item.posY, item.posZ);
							bubble.setHealth(0.5F);
							bubble.motionY = e.getWorld().rand.nextDouble() / 2;
							bubble.playBubbleSound();
							item.setDead();
							e.getWorld().spawnEntity(bubble);
						}
					}
				}
			}
		}
	}*/
}
