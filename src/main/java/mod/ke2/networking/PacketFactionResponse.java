package mod.ke2.networking;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import io.netty.buffer.ByteBuf;
import mod.ke2.KAGIC;
import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.api.warping.WarpPadPos;
import mod.ke2.client.gui.GuiWarpPadSelection;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketFactionResponse implements IMessage {
	private NBTTagCompound data;
	public PacketFactionResponse() { }
	public PacketFactionResponse(NBTTagCompound data) {
		this.data = data;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		byte[] bytes = new byte[buf.readInt()]; buf.readBytes(bytes);
		ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
		try {
			this.data = CompressedStreamTools.readCompressed(stream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void toBytes(ByteBuf buf) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			CompressedStreamTools.writeCompressed(this.data, stream);
			buf.writeInt(stream.size()); buf.writeBytes(stream.toByteArray());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public NBTTagCompound getData() {
		return this.data;
	}
	public static class Handler implements IMessageHandler<PacketFactionResponse, IMessage> {
		@Override
		public IMessage onMessage(PacketFactionResponse message, MessageContext context) {
			FMLCommonHandler.instance().getWorldThread(context.netHandler).addScheduledTask(() -> handle(message, context));
			return null;
		}
		private LinkedHashMap<WarpPadPos, WarpPadDataEntry> generate(NBTTagCompound data) {
			LinkedHashMap<WarpPadPos, WarpPadDataEntry> map = new LinkedHashMap<WarpPadPos, WarpPadDataEntry>();
			NBTTagList list = data.getTagList("WarpPads", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i < list.tagCount(); ++i) {
				WarpPadDataEntry entry = WarpPadDataEntry.readFromNBT(list.getCompoundTagAt(i));
				map.put(entry.getPos(), entry);
			}
			return map;
		}
		private void handle(PacketFactionResponse message, MessageContext context) {
			GuiScreen screen = new GuiWarpPadSelection(this.generate(message.getData()), WarpPadDataEntry.readFromNBT(message.getData()));
			KAGIC.proxy.openGuiScreen(screen);
		}
	}
}
