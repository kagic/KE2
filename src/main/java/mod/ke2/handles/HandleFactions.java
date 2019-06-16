package mod.ke2.handles;

import java.util.UUID;

import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleFactions {
	@SubscribeEvent
	public void onLoadFromFile(PlayerEvent.LoadFromFile e) {
		if (e.getEntityPlayer() instanceof EntityPlayer) {
			WorldDataFactions factions = WorldDataFactions.get(e.getEntity().world);
			factions.addFaction(UUID.fromString(e.getPlayerUUID()));
		}
	}
}
