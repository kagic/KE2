package mod.ke2.init;

import mod.ke2.KAGIC;
import mod.ke2.networking.MessageFactionRequest;
import mod.ke2.networking.MessageFactionResponse;
import mod.ke2.networking.PacketEntityTeleport;
import mod.ke2.networking.PacketWarpPadData;
import mod.ke2.networking.PacketWarpPadDataRequest;
import mod.ke2.networking.PacketWarpPadName;
import mod.ke2.networking.PacketWarpPadSignal;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Ke2Messages {
	public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(KAGIC.MODID);
	private static int ID = 0;
	public static void register(String channel) {
		Ke2Messages.INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channel);
		register();
	}
	public static void register() {
		registerMessage(MessageFactionRequest.Handler.class, MessageFactionRequest.class, Side.CLIENT);
		registerMessage(MessageFactionResponse.Handler.class, MessageFactionResponse.class, Side.SERVER);
		
		registerMessage(PacketWarpPadName.Handler.class, PacketWarpPadName.class, Side.SERVER);
		registerMessage(PacketWarpPadDataRequest.Handler.class, PacketWarpPadDataRequest.class, Side.SERVER);
		registerMessage(PacketWarpPadData.Handler.class, PacketWarpPadData.class, Side.CLIENT);
		registerMessage(PacketWarpPadSignal.Handler.class, PacketWarpPadSignal.class, Side.SERVER);
		registerMessage(PacketEntityTeleport.Handler.class, PacketEntityTeleport.class, Side.CLIENT);
	}
	public static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> handler, Class<REQ> type, Side side) {
		Ke2Messages.INSTANCE.registerMessage(handler, type, Ke2Messages.ID, side);
		++Ke2Messages.ID;
	}
}
