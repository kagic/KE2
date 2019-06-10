package mod.ke2.init;

import mod.ke2.KAGIC;
import mod.ke2.item.ItemEssence;
import mod.ke2.item.ItemGemstone;
import mod.ke2.item.ItemGemDestabilizer;
import mod.ke2.item.ItemGemDust;
import mod.ke2.item.ItemGemShard;
import mod.ke2.item.ItemGemStaff;
import mod.ke2.item.ItemManual;
import mod.ke2.item.ItemTemperplasm;
import mod.ke2.item.ItemWarpWhistle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class Ke2Items {
	public static final ItemEssence ANXIOUS_ESSENCE = new ItemEssence(ItemEssence.Color.WHITE);
	public static final ItemEssence AWKWARD_ESSENCE = new ItemEssence(ItemEssence.Color.RED);
	public static final ItemEssence PRIDEFUL_ESSENCE = new ItemEssence(ItemEssence.Color.ORANGE);
	public static final ItemEssence IMPULSIVE_ESSENCE = new ItemEssence(ItemEssence.Color.YELLOW);
	public static final ItemEssence JEALOUS_ESSENCE = new ItemEssence(ItemEssence.Color.GREEN);
	public static final ItemEssence OBSESSIVE_ESSENCE = new ItemEssence(ItemEssence.Color.BLUE);
	public static final ItemEssence DEPENDENT_ESSENCE = new ItemEssence(ItemEssence.Color.VIOLET);
	public static final ItemEssence CARELESS_ESSENCE = new ItemEssence(ItemEssence.Color.PINK);
	public static final ItemTemperplasm TEMPERPLASM = new ItemTemperplasm();
	public static final ItemManual MANUAL = new ItemManual();
	public static final ItemGemStaff GEM_STAFF = new ItemGemStaff();
	public static final ItemWarpWhistle WARP_WHISTLE = new ItemWarpWhistle();
	public static final ItemGemDestabilizer GEM_DESTABILIZER = new ItemGemDestabilizer();
	public static final ItemGemstone COLORED_GEMSTONE = new ItemGemstone("colored_gemstone");
	public static final ItemGemShard GEM_SHARD = new ItemGemShard();
	public static final ItemGemDust GEM_DUST = new ItemGemDust();
	
	public static void register(RegistryEvent.Register<Item> event) {
		registerItem(ANXIOUS_ESSENCE, new ResourceLocation("ke2:anxious_essence"), event);
		registerItem(AWKWARD_ESSENCE, new ResourceLocation("ke2:awkward_essence"), event);
		registerItem(PRIDEFUL_ESSENCE, new ResourceLocation("ke2:prideful_essence"), event);
		registerItem(IMPULSIVE_ESSENCE, new ResourceLocation("ke2:impulsive_essence"), event);
		registerItem(JEALOUS_ESSENCE, new ResourceLocation("ke2:jealous_essence"), event);
		registerItem(OBSESSIVE_ESSENCE, new ResourceLocation("ke2:obsessive_essence"), event);
		registerItem(DEPENDENT_ESSENCE, new ResourceLocation("ke2:dependent_essence"), event);
		registerItem(CARELESS_ESSENCE, new ResourceLocation("ke2:careless_essence"), event);
		registerItem(TEMPERPLASM, new ResourceLocation("ke2:temperplasm"), event);
		registerItem(MANUAL, new ResourceLocation("ke2:manual"), event);
		registerItem(GEM_STAFF, new ResourceLocation("ke2:gem_staff"), event);
		registerItem(WARP_WHISTLE, new ResourceLocation("ke2:warp_whistle"), event);
		registerItem(GEM_DESTABILIZER, new ResourceLocation("ke2:gem_destabilizer"), event);
		registerItem(COLORED_GEMSTONE, new ResourceLocation("ke2:colored_gemstone"), event);
		registerItem(GEM_SHARD, new ResourceLocation("ke2:gem_shard"), event);
		registerItem(GEM_DUST, new ResourceLocation("ke2:gem_dust"), event);
		
		for (Item item : Ke2Blocks.ITEMS) {
			registerItem(item, null, event);
		}
	}
	public static void registerGemItem(ItemGemstone normal, ItemGemstone cracked, ResourceLocation name, RegistryEvent.Register<Item> event) {
		if (!Ke2Gems.NORMAL_TO_CRACKED.containsKey(normal)) {
			Ke2Items.registerItem(cracked, new ResourceLocation(name.getResourcePath(), "cracked_" + name.getResourceDomain()), event, Ke2CreativeTabs.GEMSTONES);
			Ke2Items.registerItem(normal, name, event, Ke2CreativeTabs.GEMSTONES);
			Ke2Gems.NORMAL_TO_CRACKED.put(normal, cracked);
			Ke2Gems.CRACKED_TO_NORMAL.put(cracked, normal);
		}
		else {
			KAGIC.LOGGER.warn("Gem '%s' already exists! Skipping!", name);
			KAGIC.LOGGER.warn("Report this to addon or mod author!");
		}
	}
	public static void registerItem(Item item, ResourceLocation name, RegistryEvent.Register<Item> event, CreativeTabs tab) {
		event.getRegistry().register(item.getRegistryName() == null ? item.setCreativeTab(tab).setRegistryName(name) : item.setCreativeTab(tab));
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
	public static void registerItem(Item item, ResourceLocation name, RegistryEvent.Register<Item> event) {
		registerItem(item, name, event, Ke2CreativeTabs.GEM_TECH);
	}
}