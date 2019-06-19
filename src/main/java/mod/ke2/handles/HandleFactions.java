package mod.ke2.handles;

import java.util.UUID;

import mod.ke2.init.Ke2Items;
import mod.ke2.init.Ke2Messages;
import mod.ke2.networking.MessageFactionRequest;
import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleFactions {
	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (e.getTarget() instanceof EntityPlayerMP) {
			EntityPlayer requester = e.getEntityPlayer();
			EntityPlayer responder = (EntityPlayer) e.getTarget();
			if (e.getItemStack().getItem() == Ke2Items.GEM_STAFF) {
				WorldDataFactions factions = WorldDataFactions.get(e.getWorld());
				if (factions.getFaction(requester.getUniqueID()).equals(factions.getFaction(responder.getUniqueID()))) {
					requester.sendMessage(new TextComponentTranslation("gui.ke2.faction.in_same_faction", responder.getName()));
				} else if (requester.isSneaking()) {
					Ke2Messages.INSTANCE.sendTo(new MessageFactionRequest(requester.getUniqueID(), responder.getUniqueID()), (EntityPlayerMP) responder);
					requester.sendMessage(new TextComponentTranslation("gui.ke2.faction.sent_request_to", responder.getName()));
				} else {
					requester.sendMessage(new TextComponentTranslation("gui.ke2.faction.in_different_factions", responder.getName()));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onLoadFromFile(PlayerEvent.LoadFromFile e) {
		if (e.getEntity() instanceof EntityPlayer) {
			WorldDataFactions factions = WorldDataFactions.get(e.getEntity().world);
			if (factions.getFaction(UUID.fromString(e.getPlayerUUID())) == null) {
				factions.addFaction(UUID.fromString(e.getPlayerUUID()));
			}
		}
	}
}
