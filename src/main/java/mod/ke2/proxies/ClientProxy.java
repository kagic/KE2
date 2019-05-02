package mod.ke2.proxies;

import mod.ke2.blocks.BlockCarbonite;
import mod.ke2.command.CommandReportBug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.world.World;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		
	}
	@Override
	public void init(FMLInitializationEvent e) {
		ClientCommandHandler.instance.registerCommand(new CommandReportBug());
	}
	@Override
	public void postInit(FMLPostInitializationEvent e) {
    	BlockCarbonite.registerConversionTables();
	}
	@Override
	public void addParticle(IParticleFactory factory, World world, double x, double y, double z, double dX, double dY, double dZ, int color) {
		Minecraft.getMinecraft().effectRenderer.addEffect(factory.createParticle(-1, world, x, y, z, dX, dY, dZ, color));
	}
}
