package mod.kagic.proxies;

import mod.kagic.client.particle.ParticleShard;
import net.minecraft.client.Minecraft;
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
		
	}
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	@Override
	public void addShardParticle(World world, double x, double y, double z, double dX, double dY, double dZ, int color) {
		Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleShard(world, x, y, z, dX, dY, dZ, color));
	}
}
