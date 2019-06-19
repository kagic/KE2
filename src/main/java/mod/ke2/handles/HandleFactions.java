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
		EntityPlayer requester = (EntityPlayer)(e.getEntityPlayer());
		EntityPlayer responder = (EntityPlayer)(e.getTarget());
		if (e.getItemStack().getItem() == Ke2Items.GEM_STAFF && responder instanceof EntityPlayerMP) {
			Ke2Messages.INSTANCE.sendTo(new MessageFactionRequest(requester.getUniqueID(), responder.getUniqueID()), (EntityPlayerMP)(responder));
			requester.sendMessage(new TextComponentTranslation("gui.ke2.faction.sent_request_to", responder.getName()));
			System.out.println(requester.getName());
			System.out.println(responder.getName());
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
