package mod.ke2.networking;

import io.netty.buffer.ByteBuf;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketWarpPadName implements IMessage{
	private String name;
	private int x;
	private int y;
	private int z;
	
	public PacketWarpPadName() {}
	
	public PacketWarpPadName(String name, int x, int y, int z) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.name);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.name = ByteBufUtils.readUTF8String(buf);
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
	}
	
	public static class Handler implements IMessageHandler<PacketWarpPadName, IMessage> {
		@Override
		public IMessage onMessage(PacketWarpPadName message, MessageContext context) {
			FMLCommonHandler.instance().getWorldThread(context.netHandler).addScheduledTask(() -> handle(message, context));
			return null;
		}
		
		private void handle(PacketWarpPadName message, MessageContext context) {
			EntityPlayerMP player = context.getServerHandler().player;
			World world = player.getEntityWorld();
			TileEntityWarpPadCore pad = (TileEntityWarpPadCore) world.getTileEntity(new BlockPos(message.x, message.y, message.z));
			if (pad != null) {
				pad.setName(message.name);
			}
		}
	}
}
