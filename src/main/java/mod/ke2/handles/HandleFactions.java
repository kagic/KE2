package mod.ke2.handles;

import java.util.UUID;

import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleFactions {
	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (e.getTarget() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)(e.getTarget());
			// So the whole idea here is sending a FACTION REQUEST.
			// How the fuck do I do that?
			// ...reading time.
		}
	}
	@SubscribeEvent
	public void onLoadFromFile(PlayerEvent.LoadFromFile e) {
		if (e.getEntityPlayer() instanceof EntityPlayer) {
			WorldDataFactions factions = WorldDataFactions.get(e.getEntity().world);
			if (factions.getFaction(UUID.fromString(e.getPlayerUUID())) == null) {
				factions.addFaction(UUID.fromString(e.getPlayerUUID()));
			}
		}
	}
}
