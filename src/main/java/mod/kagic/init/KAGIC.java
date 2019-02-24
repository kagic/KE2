package mod.kagic.init;

import java.util.Collections;
import java.util.Comparator;

import mod.kagic.command.CommandGetCrux;
import mod.kagic.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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
	public static final String MODID = "kagic";
	public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(CreativeTabs.getNextID(), KAGIC.MODID) {
		@Override
		public ItemStack getTabIconItem() {
			int index = (int)(System.currentTimeMillis() / 1000L) % 16;
			switch (index) {
			case Ke2Gems.BASIC_WHITE:
				return new ItemStack(Ke2Items.WHITE_GEM_SHARD);
			case Ke2Gems.BASIC_ORANGE:
				return new ItemStack(Ke2Items.ORANGE_GEM_SHARD);
			case Ke2Gems.BASIC_MAGENTA:
				return new ItemStack(Ke2Items.MAGENTA_GEM_SHARD);
			case Ke2Gems.BASIC_LIGHTBLUE:
				return new ItemStack(Ke2Items.LIGHTBLUE_GEM_SHARD);
			case Ke2Gems.BASIC_YELLOW:
				return new ItemStack(Ke2Items.YELLOW_GEM_SHARD);
			case Ke2Gems.BASIC_LIME:
				return new ItemStack(Ke2Items.LIME_GEM_SHARD);
			case Ke2Gems.BASIC_PINK:
				return new ItemStack(Ke2Items.PINK_GEM_SHARD);
			case Ke2Gems.BASIC_GRAY:
				return new ItemStack(Ke2Items.GRAY_GEM_SHARD);
			case Ke2Gems.BASIC_SILVER:
				return new ItemStack(Ke2Items.SILVER_GEM_SHARD);
			case Ke2Gems.BASIC_CYAN:
				return new ItemStack(Ke2Items.CYAN_GEM_SHARD);
			case Ke2Gems.BASIC_PURPLE:
				return new ItemStack(Ke2Items.PURPLE_GEM_SHARD);
			case Ke2Gems.BASIC_BLUE:
				return new ItemStack(Ke2Items.BLUE_GEM_SHARD);
			case Ke2Gems.BASIC_BROWN:
				return new ItemStack(Ke2Items.BROWN_GEM_SHARD);
			case Ke2Gems.BASIC_GREEN:
				return new ItemStack(Ke2Items.GREEN_GEM_SHARD);
			case Ke2Gems.BASIC_RED:
				return new ItemStack(Ke2Items.RED_GEM_SHARD);
			default:
				return new ItemStack(Ke2Items.BLACK_GEM_SHARD);
			}
		}
		@Override
		public void displayAllRelevantItems(NonNullList<ItemStack> items) {
			super.displayAllRelevantItems(items);
	        Collections.sort(items, new Comparator<ItemStack>() {
				@Override
				public int compare(ItemStack left, ItemStack right) {
					return left.getUnlocalizedName().compareTo(right.getUnlocalizedName());
				}
	        });
	    }
	};

	@SidedProxy(clientSide = "mod.kagic.proxies.ClientProxy", serverSide = "mod.kagic.proxies.ServerProxy")
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
    	Ke2Configs.register();
    	Ke2Skills.register();
    	Ke2Cruxes.register();
    }
    @EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
    	e.registerServerCommand(new CommandGetCrux());
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
