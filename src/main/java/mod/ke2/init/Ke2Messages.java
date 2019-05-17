package mod.ke2.init;

import mod.ke2.networking.PacketEntityTeleport;
import mod.ke2.networking.PacketGalaxyWarpPadSignal;
import mod.ke2.networking.PacketWarpPadData;
import mod.ke2.networking.PacketWarpPadDataRequest;
import mod.ke2.networking.PacketWarpPadName;
import mod.ke2.networking.PacketWarpPadSignal;
import mod.ke2.networking.PacketEntityTeleport.EntityTeleportMessageHandler;
import mod.ke2.networking.PacketGalaxyWarpPadSignal.GalaxySignalMessageHandler;
import mod.ke2.networking.PacketWarpPadData.PadDataMessageHandler;
import mod.ke2.networking.PacketWarpPadDataRequest.PadDataRequestMessageHandler;
import mod.ke2.networking.PacketWarpPadName.TENameMessageHandler;
import mod.ke2.networking.PacketWarpPadSignal.WarpSignalMessageHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Ke2Packets {
	private static int packetID = 0;
	public static SimpleNetworkWrapper INSTANCE = null;
	
	public static int nextID() {
		return packetID++;
	}
	
	public static void registerMessages(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		registerMessages();
	}
	
	public static void registerMessages() {
		INSTANCE.registerMessage(PacketWarpPadName.TENameMessageHandler.class, PacketWarpPadName.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketWarpPadDataRequest.PadDataRequestMessageHandler.class, PacketWarpPadDataRequest.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketWarpPadData.PadDataMessageHandler.class, PacketWarpPadData.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(PacketWarpPadSignal.WarpSignalMessageHandler.class, PacketWarpPadSignal.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketEntityTeleport.EntityTeleportMessageHandler.class, PacketEntityTeleport.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(PacketGalaxyWarpPadSignal.GalaxySignalMessageHandler.class, PacketGalaxyWarpPadSignal.class, nextID(), Side.SERVER);
	}
}
