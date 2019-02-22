package mod.kagic.init;

import mod.kagic.items.ItemGem;
import mod.kagic.items.ItemGemDestabilizer;
import mod.kagic.items.ItemGemDust;
import mod.kagic.items.ItemGemShard;
import mod.kagic.items.ItemGemStaff;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class Ke2Items {
	public static final ItemGemStaff GEM_STAFF = new ItemGemStaff();

	public static final ItemGemDestabilizer WHITE_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_WHITE);
	public static final ItemGemShard WHITE_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_WHITE);
	public static final ItemGemDust WHITE_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_WHITE);
	public static final ItemGemDestabilizer ORANGE_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_ORANGE);
	public static final ItemGemShard ORANGE_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_ORANGE);
	public static final ItemGemDust ORANGE_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_ORANGE);
	public static final ItemGemDestabilizer MAGENTA_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_MAGENTA);
	public static final ItemGemShard MAGENTA_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_MAGENTA);
	public static final ItemGemDust MAGENTA_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_MAGENTA);
	public static final ItemGemDestabilizer LIGHTBLUE_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_LIGHTBLUE);
	public static final ItemGemShard LIGHTBLUE_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_LIGHTBLUE);
	public static final ItemGemDust LIGHTBLUE_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_LIGHTBLUE);
	public static final ItemGemDestabilizer YELLOW_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_YELLOW);
	public static final ItemGemShard YELLOW_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_YELLOW);
	public static final ItemGemDust YELLOW_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_YELLOW);
	public static final ItemGemDestabilizer LIME_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_LIME);
	public static final ItemGemShard LIME_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_LIME);
	public static final ItemGemDust LIME_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_LIME);
	public static final ItemGemDestabilizer PINK_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_PINK);
	public static final ItemGemShard PINK_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_PINK);
	public static final ItemGemDust PINK_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_PINK);
	public static final ItemGemDestabilizer GRAY_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_GRAY);
	public static final ItemGemShard GRAY_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_GRAY);
	public static final ItemGemDust GRAY_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_GRAY);
	public static final ItemGemDestabilizer SILVER_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_SILVER);
	public static final ItemGemShard SILVER_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_SILVER);
	public static final ItemGemDust SILVER_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_SILVER);
	public static final ItemGemDestabilizer CYAN_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_CYAN);
	public static final ItemGemShard CYAN_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_CYAN);
	public static final ItemGemDust CYAN_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_CYAN);
	public static final ItemGemDestabilizer PURPLE_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_PURPLE);
	public static final ItemGemShard PURPLE_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_PURPLE);
	public static final ItemGemDust PURPLE_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_PURPLE);
	public static final ItemGemDestabilizer BLUE_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_BLUE);
	public static final ItemGemShard BLUE_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_BLUE);
	public static final ItemGemDust BLUE_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_BLUE);
	public static final ItemGemDestabilizer BROWN_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_BROWN);
	public static final ItemGemShard BROWN_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_BROWN);
	public static final ItemGemDust BROWN_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_BROWN);
	public static final ItemGemDestabilizer GREEN_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_GREEN);
	public static final ItemGemShard GREEN_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_GREEN);
	public static final ItemGemDust GREEN_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_GREEN);
	public static final ItemGemDestabilizer RED_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_RED);
	public static final ItemGemShard RED_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_RED);
	public static final ItemGemDust RED_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_RED);
	public static final ItemGemDestabilizer BLACK_GEM_DESTABILIZER = new ItemGemDestabilizer(Ke2Gems.BASIC_BLACK);
	public static final ItemGemShard BLACK_GEM_SHARD = new ItemGemShard(Ke2Gems.BASIC_BLACK);
	public static final ItemGemDust BLACK_GEM_DUST = new ItemGemDust(Ke2Gems.BASIC_BLACK);
	
	public static void register(RegistryEvent.Register<Item> event) {
		registerItem(GEM_STAFF, new ResourceLocation("kagic:gem_staff"), event);
		
		registerItem(WHITE_GEM_DESTABILIZER, new ResourceLocation("kagic:white_gem_destabilizer"), event);
		registerItem(WHITE_GEM_SHARD, new ResourceLocation("kagic:white_gem_shard"), event);
		registerItem(WHITE_GEM_DUST, new ResourceLocation("kagic:white_gem_dust"), event);
		registerItem(ORANGE_GEM_DESTABILIZER, new ResourceLocation("kagic:orange_gem_destabilizer"), event);
		registerItem(ORANGE_GEM_SHARD, new ResourceLocation("kagic:orange_gem_shard"), event);
		registerItem(ORANGE_GEM_DUST, new ResourceLocation("kagic:orange_gem_dust"), event);
		registerItem(MAGENTA_GEM_DESTABILIZER, new ResourceLocation("kagic:magenta_gem_destabilizer"), event);
		registerItem(MAGENTA_GEM_SHARD, new ResourceLocation("kagic:magenta_gem_shard"), event);
		registerItem(MAGENTA_GEM_DUST, new ResourceLocation("kagic:magenta_gem_dust"), event);
		registerItem(LIGHTBLUE_GEM_DESTABILIZER, new ResourceLocation("kagic:lightblue_gem_destabilizer"), event);
		registerItem(LIGHTBLUE_GEM_SHARD, new ResourceLocation("kagic:lightblue_gem_shard"), event);
		registerItem(LIGHTBLUE_GEM_DUST, new ResourceLocation("kagic:lightblue_gem_dust"), event);
		registerItem(YELLOW_GEM_DESTABILIZER, new ResourceLocation("kagic:yellow_gem_destabilizer"), event);
		registerItem(YELLOW_GEM_SHARD, new ResourceLocation("kagic:yellow_gem_shard"), event);
		registerItem(YELLOW_GEM_DUST, new ResourceLocation("kagic:yellow_gem_dust"), event);
		registerItem(LIME_GEM_DESTABILIZER, new ResourceLocation("kagic:lime_gem_destabilizer"), event);
		registerItem(LIME_GEM_SHARD, new ResourceLocation("kagic:lime_gem_shard"), event);
		registerItem(LIME_GEM_DUST, new ResourceLocation("kagic:lime_gem_dust"), event);
		registerItem(PINK_GEM_DESTABILIZER, new ResourceLocation("kagic:pink_gem_destabilizer"), event);
		registerItem(PINK_GEM_SHARD, new ResourceLocation("kagic:pink_gem_shard"), event);
		registerItem(PINK_GEM_DUST, new ResourceLocation("kagic:pink_gem_dust"), event);
		registerItem(GRAY_GEM_DESTABILIZER, new ResourceLocation("kagic:gray_gem_destabilizer"), event);
		registerItem(GRAY_GEM_SHARD, new ResourceLocation("kagic:gray_gem_shard"), event);
		registerItem(GRAY_GEM_DUST, new ResourceLocation("kagic:gray_gem_dust"), event);
		registerItem(SILVER_GEM_DESTABILIZER, new ResourceLocation("kagic:silver_gem_destabilizer"), event);
		registerItem(SILVER_GEM_SHARD, new ResourceLocation("kagic:silver_gem_shard"), event);
		registerItem(SILVER_GEM_DUST, new ResourceLocation("kagic:silver_gem_dust"), event);
		registerItem(CYAN_GEM_DESTABILIZER, new ResourceLocation("kagic:cyan_gem_destabilizer"), event);
		registerItem(CYAN_GEM_SHARD, new ResourceLocation("kagic:cyan_gem_shard"), event);
		registerItem(CYAN_GEM_DUST, new ResourceLocation("kagic:cyan_gem_dust"), event);
		registerItem(PURPLE_GEM_DESTABILIZER, new ResourceLocation("kagic:purple_gem_destabilizer"), event);
		registerItem(PURPLE_GEM_SHARD, new ResourceLocation("kagic:purple_gem_shard"), event);
		registerItem(PURPLE_GEM_DUST, new ResourceLocation("kagic:purple_gem_dust"), event);
		registerItem(BLUE_GEM_DESTABILIZER, new ResourceLocation("kagic:blue_gem_destabilizer"), event);
		registerItem(BLUE_GEM_SHARD, new ResourceLocation("kagic:blue_gem_shard"), event);
		registerItem(BLUE_GEM_DUST, new ResourceLocation("kagic:blue_gem_dust"), event);
		registerItem(BROWN_GEM_DESTABILIZER, new ResourceLocation("kagic:brown_gem_destabilizer"), event);
		registerItem(BROWN_GEM_SHARD, new ResourceLocation("kagic:brown_gem_shard"), event);
		registerItem(BROWN_GEM_DUST, new ResourceLocation("kagic:brown_gem_dust"), event);
		registerItem(GREEN_GEM_DESTABILIZER, new ResourceLocation("kagic:green_gem_destabilizer"), event);
		registerItem(GREEN_GEM_SHARD, new ResourceLocation("kagic:green_gem_shard"), event);
		registerItem(GREEN_GEM_DUST, new ResourceLocation("kagic:green_gem_dust"), event);
		registerItem(RED_GEM_DESTABILIZER, new ResourceLocation("kagic:red_gem_destabilizer"), event);
		registerItem(RED_GEM_SHARD, new ResourceLocation("kagic:red_gem_shard"), event);
		registerItem(RED_GEM_DUST, new ResourceLocation("kagic:red_gem_dust"), event);
		registerItem(BLACK_GEM_DESTABILIZER, new ResourceLocation("kagic:black_gem_destabilizer"), event);
		registerItem(BLACK_GEM_SHARD, new ResourceLocation("kagic:black_gem_shard"), event);
		registerItem(BLACK_GEM_DUST, new ResourceLocation("kagic:black_gem_dust"), event);
		
		for (Item item : Ke2Blocks.ITEMS) {
			registerItem(item, null, event);
		}
	}
	public static void registerGemItem(ItemGem normal, ItemGem cracked, ResourceLocation name, RegistryEvent.Register<Item> event) {
		Ke2Items.registerItem(cracked, new ResourceLocation(name.getResourcePath(), "cracked_" + name.getResourceDomain()), event);
		Ke2Items.registerItem(normal, name, event);
		Ke2Gems.NORMAL_TO_CRACKED.put(normal, cracked);
		Ke2Gems.CRACKED_TO_NORMAL.put(cracked, normal);
	}
	public static void registerItem(Item item, ResourceLocation name, RegistryEvent.Register<Item> event, String...meta) {
		event.getRegistry().register(name == null ? (item.getRegistryName() != null ? item : item.setRegistryName("kagic:" + ((ItemBlock)(item)).getBlock().getUnlocalizedName().replaceAll("tile\\.", ""))) : item.setRegistryName(name));
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			for (int i = 0; i < meta.length; ++i) {
				ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), meta[i]));
			}
		}
	}
	public static void registerItem(Item item, ResourceLocation name, RegistryEvent.Register<Item> event) {
		Ke2Items.registerItem(item, name, event, "inventory");
	}
}