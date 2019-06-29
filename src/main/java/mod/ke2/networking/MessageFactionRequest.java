package mod.ke2.networking;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import mod.ke2.KAGIC;
import mod.ke2.client.gui.GuiFactionRequest;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFactionRequest implements IMessage {
	private String requester;
	private String responder;
	
	public MessageFactionRequest(UUID requester, UUID responder) {
		if (requester != null) {
			this.requester = requester.toString();
		}
		if (responder != null) {
			this.responder = responder.toString();
		}
	}
	
	public MessageFactionRequest() {
		this(null, null);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.requester.length());
		buf.writeBytes(this.requester.getBytes());
		buf.writeInt(this.responder.length());
		buf.writeBytes(this.responder.getBytes());
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		byte[] bytes = new byte[buf.readInt()];
		buf.readBytes(bytes);
		this.requester = new String(bytes);
		bytes = new byte[buf.readInt()];
		buf.readBytes(bytes);
		this.responder = new String(bytes);
	}
	
	public UUID getRequesterUUID() {
		return UUID.fromString(this.requester);
	}
	
	public UUID getResponderUUID() {
		return UUID.fromString(this.responder);
	}
	
	public static class Handler implements IMessageHandler<MessageFactionRequest, IMessage> {
		@Override
		public IMessage onMessage(MessageFactionRequest message, MessageContext context) {
			EntityPlayer requester = Minecraft.getMinecraft().world.getPlayerEntityByUUID(message.getRequesterUUID());
			EntityPlayer responder = Minecraft.getMinecraft().world.getPlayerEntityByUUID(message.getResponderUUID());
			if (requester != null && responder != null) {
				KAGIC.proxy.openGuiScreen(new GuiFactionRequest(requester, responder));
			}
			return null;
		}
	}
}
