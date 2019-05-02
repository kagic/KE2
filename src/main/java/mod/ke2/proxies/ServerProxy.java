package mod.ke2.proxies;

import mod.ke2.blocks.BlockCarbonite;
import net.minecraft.client.particle.IParticleFactory;
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
	public void addParticle(IParticleFactory factory, World world, double x, double y, double z, double dX, double dY, double dZ, int color) {
		// Reserved for client functionality.
	}
}
