package mod.ke2.networking;

import io.netty.buffer.ByteBuf;
import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.ke2.KAGIC;
import mod.ke2.api.warping.pos.GalaxyWarpPadPos;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketGalaxyWarpPadSignal implements IMessage {
	private BlockPos sourcePad;
	private GalaxyWarpPadPos destinationPad;
	
	public PacketGalaxyWarpPadSignal(BlockPos source, GalaxyWarpPadPos dest) {
		this.sourcePad = source;
		this.destinationPad = dest;
	}
	
	public PacketGalaxyWarpPadSignal() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.sourcePad = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		this.destinationPad = new GalaxyWarpPadPos(buf.readInt(), new BlockPos(buf.readInt(), buf.readInt(), buf.readInt()));
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.sourcePad.getX());
		buf.writeInt(this.sourcePad.getY());
		buf.writeInt(this.sourcePad.getZ());
		buf.writeInt(this.destinationPad.getDimension());
		buf.writeInt(this.destinationPad.getPos().getX());
		buf.writeInt(this.destinationPad.getPos().getY());
		buf.writeInt(this.destinationPad.getPos().getZ());
	}

	public static class GalaxySignalMessageHandler implements IMessageHandler<PacketGalaxyWarpPadSignal, IMessage> {
		@Override
		public IMessage onMessage(PacketGalaxyWarpPadSignal message, MessageContext ctx) {
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
			return null;
		}
		
		private void handle(PacketGalaxyWarpPadSignal message, MessageContext ctx) {
			EntityPlayerMP playerEntity = ctx.getServerHandler().player;
			World world = playerEntity.getEntityWorld();
			TileEntityGalaxyPadCore te = (TileEntityGalaxyPadCore) world.getTileEntity(message.sourcePad);
			if (te != null) {
				te.beginWarp(message.destinationPad);
			} else {
				KAGIC.instance.chatInfoMessage("TE was null!");				
			}
		}
	}
}
