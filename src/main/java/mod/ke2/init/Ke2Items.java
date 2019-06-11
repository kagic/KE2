package mod.ke2.init;

import mod.ke2.KAGIC;
import mod.ke2.item.ItemEssence;
import mod.ke2.item.ItemGemDestabilizer;
import mod.ke2.item.ItemGemDust;
import mod.ke2.item.ItemGemShard;
import mod.ke2.item.ItemGemStaff;
import mod.ke2.item.ItemGemstone;
import mod.ke2.item.ItemManual;
import mod.ke2.item.ItemTablet;
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
	public static final ItemTablet TABLET = new ItemTablet();
	
	public static void register(RegistryEvent.Register<Item> event) {
		registerItem(ANXIOUS_ESSENCE, new ResourceLocation("ke2:anxious_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(AWKWARD_ESSENCE, new ResourceLocation("ke2:awkward_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(PRIDEFUL_ESSENCE, new ResourceLocation("ke2:prideful_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(IMPULSIVE_ESSENCE, new ResourceLocation("ke2:impulsive_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(JEALOUS_ESSENCE, new ResourceLocation("ke2:jealous_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(OBSESSIVE_ESSENCE, new ResourceLocation("ke2:obsessive_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(DEPENDENT_ESSENCE, new ResourceLocation("ke2:dependent_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(CARELESS_ESSENCE, new ResourceLocation("ke2:careless_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(TEMPERPLASM, new ResourceLocation("ke2:temperplasm"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(MANUAL, new ResourceLocation("ke2:manual"), event, Ke2CreativeTabs.GEM_TECH);
		registerItem(GEM_STAFF, new ResourceLocation("ke2:gem_staff"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(WARP_WHISTLE, new ResourceLocation("ke2:warp_whistle"), event, Ke2CreativeTabs.GEM_TECH);
		registerItem(GEM_DESTABILIZER, new ResourceLocation("ke2:gem_destabilizer"), event, Ke2CreativeTabs.GEM_TECH);
		registerItem(COLORED_GEMSTONE, new ResourceLocation("ke2:colored_gemstone"), event, Ke2CreativeTabs.GEM_STONES);
		registerItem(GEM_SHARD, new ResourceLocation("ke2:gem_shard"), event, Ke2CreativeTabs.GEM_STONES);
		registerItem(GEM_DUST, new ResourceLocation("ke2:gem_dust"), event, Ke2CreativeTabs.GEM_CREATION);
		registerItem(TABLET, new ResourceLocation("ke2:tablet"), event, Ke2CreativeTabs.GEM_TECH);
		
		for (Item item : Ke2Blocks.ITEMS) {
			registerItem(item, null, event, Ke2CreativeTabs.GEM_BLOCKS);
		}
	}
	public static void registerItem(Item item, ResourceLocation name, RegistryEvent.Register<Item> event, CreativeTabs tab) {
		event.getRegistry().register(item.getRegistryName() == null ? item.setCreativeTab(tab).setRegistryName(name) : item.setCreativeTab(tab));
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}