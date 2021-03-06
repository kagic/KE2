package mod.ke2.proxy;

import mod.ke2.block.BlockCarbonite;
import mod.ke2.client.gui.GuiWarpPad;
import mod.ke2.init.Ke2Colors;
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

public class ClientProxy implements CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {

	}

	@Override
	public void init(FMLInitializationEvent e) {
		Ke2Colors.register();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		BlockCarbonite.registerConversionTables();
	}

	@Override
	public boolean isClient() {
		return true;
	}

	@Override
	public boolean isServer() {
		return false;
	}

	@Override
	public void addParticle(IParticleFactory factory, World world, double x, double y, double z, double dX, double dY, double dZ, int color) {
		Minecraft.getMinecraft().effectRenderer.addEffect(factory.createParticle(-1, world, x, y, z, dX, dY, dZ, color));
	}

	@Override
	public Object getClientGuiElement(int i, EntityPlayer player, World world, int x, int y, int z) {
		if (world == null || world.isRemote) {
			switch (i) {
				case CommonProxy.GUI_WARP_PAD :
					TileEntity pad = world.getTileEntity(new BlockPos(x, y, z));
					if (pad instanceof TileEntityWarpPadCore) {
						return new GuiWarpPad((TileEntityWarpPadCore) pad);
					}
				case CommonProxy.GUI_WARP_PAD_SELECTION :
					break;
			}
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int i, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public void openGuiScreen(GuiScreen screen) {
		Minecraft.getMinecraft().displayGuiScreen(screen);
	}
}
