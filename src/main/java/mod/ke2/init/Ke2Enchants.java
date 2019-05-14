package mod.ke2.init;

import mod.ke2.enchant.EnchantShard;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;

public class Ke2Enchants {
	public static final EnchantShard WHITE_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_WHITE);
	public static final EnchantShard ORANGE_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_ORANGE);
	public static final EnchantShard MAGENTA_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_MAGENTA);
	public static final EnchantShard LIGHTBLUE_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_LIGHTBLUE);
	public static final EnchantShard YELLOW_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_YELLOW);
	public static final EnchantShard LIME_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_LIME);
	public static final EnchantShard PINK_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_PINK);
	public static final EnchantShard GRAY_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_GRAY);
	public static final EnchantShard SILVER_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_SILVER);
	public static final EnchantShard CYAN_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_CYAN);
	public static final EnchantShard PURPLE_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_PURPLE);
	public static final EnchantShard BLUE_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_BLUE);
	public static final EnchantShard BROWN_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_BROWN);
	public static final EnchantShard GREEN_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_GREEN);
	public static final EnchantShard RED_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_RED);
	public static final EnchantShard BLACK_GEM_SHARD = new EnchantShard(Ke2Gems.BASIC_BLACK);
	public static final EnumEnchantmentType BUBBLE = EnumHelper.addEnchantmentType("bubble", (item)->(item instanceof ItemSword));
	
	public static void register(RegistryEvent.Register<Enchantment> event) {
		registerEnchant(WHITE_GEM_SHARD, event);
		registerEnchant(ORANGE_GEM_SHARD, event);
		registerEnchant(MAGENTA_GEM_SHARD, event);
		registerEnchant(LIGHTBLUE_GEM_SHARD, event);
		registerEnchant(YELLOW_GEM_SHARD, event);
		registerEnchant(LIME_GEM_SHARD, event);
		registerEnchant(PINK_GEM_SHARD, event);
		registerEnchant(GRAY_GEM_SHARD, event);
		registerEnchant(SILVER_GEM_SHARD, event);
		registerEnchant(CYAN_GEM_SHARD, event);
		registerEnchant(PURPLE_GEM_SHARD, event);
		registerEnchant(BLUE_GEM_SHARD, event);
		registerEnchant(BROWN_GEM_SHARD, event);
		registerEnchant(GREEN_GEM_SHARD, event);
		registerEnchant(RED_GEM_SHARD, event);
		registerEnchant(BLACK_GEM_SHARD, event);
		registerEnchant(BUBBLE, event);
	}
	private static void registerEnchant(Enchantment enchant, RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().register(enchant);
	}
}
