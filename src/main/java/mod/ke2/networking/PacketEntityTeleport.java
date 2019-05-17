package mod.ke2.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketEntityTeleport implements IMessage {
	private int entityID;
	private double x;
	private double y;
	private double z;
	public PacketEntityTeleport() { }
	public PacketEntityTeleport(int entityID, double x, double y, double z) {
		this.entityID = entityID;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		this.entityID = buf.readInt();
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.z = buf.readDouble();
	}
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeDouble(this.x);
		buf.writeDouble(this.y);
		buf.writeDouble(this.z);
	}
	public static class Handler implements IMessageHandler<PacketEntityTeleport, IMessage> {
		@Override
		public IMessage onMessage(PacketEntityTeleport message, MessageContext context) {
			FMLCommonHandler.instance().getWorldThread(context.netHandler).addScheduledTask(() -> handle(message, context));
			return null;
		}
		private void handle(PacketEntityTeleport message, MessageContext context) {
			WorldClient world = Minecraft.getMinecraft().world;
			Entity e = world.getEntityByID(message.entityID);
			e.setPositionAndUpdate(message.x, message.y, message.z);
		}
	}
}
