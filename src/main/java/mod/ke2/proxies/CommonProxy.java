package mod.ke2.proxies;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface CommonProxy {
	public void preInit(FMLPreInitializationEvent e);
	public void init(FMLInitializationEvent e);
	public void postInit(FMLPostInitializationEvent e);
	public void addShardParticle(World world, double x, double y, double z, double dX, double dY, double dZ, int color);
}
