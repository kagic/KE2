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
	public static final int GUI_WARP_PAD = 0;
	public static final int GUI_WARP_PAD_SELECTION = 1;
	
	public void preInit(FMLPreInitializationEvent e);
	public void init(FMLInitializationEvent e);
	public void postInit(FMLPostInitializationEvent e);
	public boolean isClient();
	public boolean isServer();
	public void addParticle(IParticleFactory factory, World world, double x, double y, double z, double dX, double dY, double dZ, int color);
	@Override
	public Object getServerGuiElement(int i, EntityPlayer player, World world, int x, int y, int z);
	@Override
	public Object getClientGuiElement(int i, EntityPlayer player, World world, int x, int y, int z);
	public void openGuiScreen(GuiScreen screen);
}
