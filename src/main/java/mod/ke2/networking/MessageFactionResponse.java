package mod.ke2.networking;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFactionResponse implements IMessage {
	private String requester;
	private String responder;
	private boolean accepted;
	public MessageFactionResponse(UUID requester, UUID responder, boolean accepted) {
		if (requester != null) {
			this.requester = requester.toString();
		}
		if (responder != null) {
			this.responder = responder.toString();
		}
		this.accepted = accepted;
	}
	public MessageFactionResponse() {
		this(null, null, false);
	}
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.requester.length()); buf.writeBytes(this.requester.getBytes());
		buf.writeInt(this.responder.length()); buf.writeBytes(this.responder.getBytes());
		buf.writeInt(this.accepted ? 0 : 1);
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		byte[] bytes = new byte[buf.readInt()]; buf.readBytes(bytes);
		this.requester = new String(bytes);
		bytes = new byte[buf.readInt()]; buf.readBytes(bytes);
		this.responder = new String(bytes);
		this.accepted = buf.readInt() == 1;
	}
	public UUID getRequesterUUID() {
		return UUID.fromString(this.requester);
	}
	public UUID getResponderUUID() {
		return UUID.fromString(this.responder);
	}
	public boolean accepted() {
		return this.accepted;
	}
	public static class Handler implements IMessageHandler<MessageFactionResponse, IMessage> {
		@Override
		public IMessage onMessage(MessageFactionResponse message, MessageContext context) {
			EntityPlayer requester = Minecraft.getMinecraft().world.getPlayerEntityByUUID(message.getRequesterUUID());
			EntityPlayer responder = Minecraft.getMinecraft().world.getPlayerEntityByUUID(message.getResponderUUID());
			WorldDataFactions factions = WorldDataFactions.get(Minecraft.getMinecraft().world);
			if (requester != null && responder != null) {
				if (message.accepted()) {
					requester.sendMessage(new TextComponentTranslation("gui.ke2.faction.accepted_the_request", responder.getName()));
					responder.sendMessage(new TextComponentTranslation("gui.ke2.faction.joined_faction", requester.getName()));
					System.out.println(requester.getName());
					System.out.println(responder.getName());
					factions.setFaction(responder.getUniqueID(), factions.getFaction(requester.getUniqueID()));
				}
				else {
					requester.sendMessage(new TextComponentTranslation("gui.ke2.faction.rejected_the_request", responder.getName()));
					responder.sendMessage(new TextComponentTranslation("gui.ke2.faction.rejected_faction", requester.getName()));
				}
			}
			return null;
		}
	}
}
