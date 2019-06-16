package mod.ke2.handles;

import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleFactions {
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent e) {
		if (e.getEntity() instanceof EntityPlayer) {
			WorldDataFactions factions = WorldDataFactions.get(e.getWorld());
			factions.addFaction(e.getEntity().getUniqueID());
		}
	}
}
