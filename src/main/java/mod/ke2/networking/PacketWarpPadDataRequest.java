package mod.ke2.networking;

import io.netty.buffer.ByteBuf;
import mod.ke2.init.Ke2Messages;
import mod.ke2.world.data.WorldDataWarpPads;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketWarpPadDataRequest implements IMessage {
	private boolean isGalaxy;
	private int x;
	private int y;
	private int z;
	
	public PacketWarpPadDataRequest() {}
	
	public PacketWarpPadDataRequest(boolean isGalaxy, int x, int y, int z) {
		this.isGalaxy = isGalaxy;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.isGalaxy = buf.readBoolean();
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(this.isGalaxy);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
	}

	public static class Handler implements IMessageHandler<PacketWarpPadDataRequest, IMessage> {
		@Override
		public IMessage onMessage(PacketWarpPadDataRequest message, MessageContext context) {
			((WorldServer) context.getServerHandler().player.world).addScheduledTask(() -> handle(message, context));
			return null;
		}
		
		private void handle(PacketWarpPadDataRequest message, MessageContext context) {
			EntityPlayerMP player = context.getServerHandler().player;
			World world = player.getEntityWorld();
			WorldDataWarpPads data = WorldDataWarpPads.get(world);
			Ke2Messages.INSTANCE.sendTo(new PacketWarpPadData(
				data.writeToNBT(new NBTTagCompound())),
			context.getServerHandler().player);
		}
	}
}
