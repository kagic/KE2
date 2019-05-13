package mod.ke2.networking;

import io.netty.buffer.ByteBuf;
import mod.kagic.worlddata.WorldDataGalaxyPad;
import mod.kagic.worlddata.WorldDataWarpPad;
import mod.ke2.init.Ke2Packets;
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

	public static class PadDataRequestMessageHandler implements IMessageHandler<PacketWarpPadDataRequest, IMessage> {
		@Override
		public IMessage onMessage(PacketWarpPadDataRequest message, MessageContext ctx) {
			((WorldServer) ctx.getServerHandler().player.world).addScheduledTask(() -> handle(message, ctx));
			return null;
		}
		
		private void handle(PacketWarpPadDataRequest message, MessageContext ctx) {
			EntityPlayerMP playerEntity = ctx.getServerHandler().player;
			World world = playerEntity.getEntityWorld();
			NBTTagCompound data = new NBTTagCompound();
			if (message.isGalaxy) {
				WorldDataGalaxyPad padData = WorldDataGalaxyPad.get(world);
				data = padData.writeToNBT(data);
				data.setBoolean("galaxy", true);
				Ke2Packets.INSTANCE.sendTo(new PacketWarpPadData(data, message.x, message.y, message.z), ctx.getServerHandler().player);
			} else {
				WorldDataWarpPad padData = WorldDataWarpPad.get(world);
				data = padData.writeToNBT(data);
				data.setBoolean("galaxy", false);
				Ke2Packets.INSTANCE.sendTo(new PacketWarpPadData(data, message.x, message.y, message.z), ctx.getServerHandler().player);
			}
		}
	}
}
