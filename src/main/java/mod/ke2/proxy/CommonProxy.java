package mod.ke2.proxy;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;

public interface CommonProxy extends IGuiHandler {
	int GUI_WARP_PAD = 0;
	int GUI_WARP_PAD_SELECTION = 1;

	void preInit(FMLPreInitializationEvent e);

	void init(FMLInitializationEvent e);

	void postInit(FMLPostInitializationEvent e);

	boolean isClient();

	boolean isServer();

	void addParticle(IParticleFactory factory, World world, double x, double y, double z, double dX, double dY, double dZ, int color);

	@Override
	Object getServerGuiElement(int i, EntityPlayer player, World world, int x, int y, int z);

	@Override
	Object getClientGuiElement(int i, EntityPlayer player, World world, int x, int y, int z);

	void openGuiScreen(GuiScreen screen);
}
