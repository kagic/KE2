package mod.ke2.init;

import mod.ke2.enchant.EnchantBubble;
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
	public static final EnchantBubble BUBBLE = new EnchantBubble();

	public static void register(RegistryEvent.Register<Enchantment> event) {
		Ke2Enchants.registerEnchant(Ke2Enchants.WHITE_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.ORANGE_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.MAGENTA_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.LIGHTBLUE_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.YELLOW_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.LIME_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.PINK_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.GRAY_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.SILVER_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.CYAN_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.PURPLE_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.BLUE_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.BROWN_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.GREEN_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.RED_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.BLACK_GEM_SHARD, event);
		Ke2Enchants.registerEnchant(Ke2Enchants.BUBBLE, event);
	}

	private static void registerEnchant(Enchantment enchant, RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().register(enchant);
	}
}
