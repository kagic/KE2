package mod.ke2.proxy;

import mod.ke2.block.BlockCarbonite;
import mod.ke2.client.gui.GuiWarpPad;
import mod.ke2.client.gui.GuiWarpPadContainer;
import mod.ke2.client.gui.GuiWarpPadSelectionContainer;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		
	}
	@Override
	public void init(FMLInitializationEvent e) {
		
	}
	@Override
	public void postInit(FMLPostInitializationEvent e) {
    	BlockCarbonite.registerConversionTables();
	}
	@Override
	public boolean isClient() {
		return false;
	}
	@Override
	public boolean isServer() {
		return true;
	}
	@Override
	public void addParticle(IParticleFactory factory, World world, double x, double y, double z, double dX, double dY, double dZ, int color) {
		// Reserved for client functionality.
	}
	public Object getClientGuiElement(int i, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	@Override
	public Object getServerGuiElement(int i, EntityPlayer player, World world, int x, int y, int z) {
		switch (i) {
		case CommonProxy.GUI_WARP_PAD:
			return new GuiWarpPadContainer();
		case CommonProxy.GUI_WARP_PAD_SELECTION:
			return new GuiWarpPadSelectionContainer();
		}
		return null;
	}
	@Override
	public void openGuiScreen(GuiScreen screen) {
		// Reserved for client functionality.
	}
}
