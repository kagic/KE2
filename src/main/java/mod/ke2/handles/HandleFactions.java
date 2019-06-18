package mod.ke2.handles;

import java.util.UUID;

import mod.ke2.init.Ke2Items;
import mod.ke2.init.Ke2Messages;
import mod.ke2.networking.MessageFactionRequest;
import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleFactions {
	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (e.getItemStack().getItem() == Ke2Items.GEM_STAFF && e.getTarget() instanceof EntityPlayerMP) {
			Ke2Messages.INSTANCE.sendTo(
					new MessageFactionRequest(e.getEntityPlayer().getUniqueID(),
					e.getTarget().getUniqueID()),
					(EntityPlayerMP)(e.getTarget()));
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
