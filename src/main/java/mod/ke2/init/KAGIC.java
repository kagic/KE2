package mod.ke2.init;

import com.google.gson.Gson;

import mod.ke2.blocks.BlockCarbonite;
import mod.ke2.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = KAGIC.MODID, version = KAGIC.VERSION, acceptedMinecraftVersions = KAGIC.MCVERSION)
public class KAGIC {
    public static final String VERSION = "@version";
    public static final String MCVERSION = "1.12.2";
	public static final String MODID = "ke2";
	public static final Gson JSON = new Gson();
	
	@SidedProxy(clientSide = "mod.ke2.proxies.ClientProxy", serverSide = "mod.ke2.proxies.ServerProxy")
	public static CommonProxy proxy;
	
    @Instance
    public static KAGIC instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	Ke2WorldGen.register();
    	Ke2Recipes.register();
    	Ke2Entities.register(0);
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Ke2Handles.register();
    	Ke2TileEntities.register();
    	Ke2Entities.register(1);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	BlockCarbonite.registerConversionTables();
    	Ke2Configs.register();
    	Ke2Cruxes.register();
    }
    @EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
    	//e.registerServerCommand(new CommandGetCrux());
    }
    
    @Mod.EventBusSubscriber(modid = KAGIC.MODID)
	public static class RegistrationHandler {
    	@SubscribeEvent
		public static void registerEnchants(RegistryEvent.Register<Enchantment> event) {
			Ke2Enchants.register(event);
		}
    	@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			Ke2Items.register(event);
		}
    	@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			Ke2Blocks.register(event);
		}
		@SubscribeEvent
		public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
			Ke2Sounds.register(event);
		}
	}
}
