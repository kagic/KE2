package mod.kagic.init;

import mod.kagic.enchant.EnchantShard;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;

public class AmEnchants {
	public static final EnchantShard WHITE_GEM_SHARD = new EnchantShard(0);
	public static final EnchantShard ORANGE_GEM_SHARD = new EnchantShard(1);
	public static final EnchantShard MAGENTA_GEM_SHARD = new EnchantShard(2);
	public static final EnchantShard LIGHTBLUE_GEM_SHARD = new EnchantShard(3);
	public static final EnchantShard YELLOW_GEM_SHARD = new EnchantShard(4);
	public static final EnchantShard LIME_GEM_SHARD = new EnchantShard(5);
	public static final EnchantShard PINK_GEM_SHARD = new EnchantShard(6);
	public static final EnchantShard GRAY_GEM_SHARD = new EnchantShard(7);
	public static final EnchantShard LIGHT_GRAY_GEM_SHARD = new EnchantShard(8);
	public static final EnchantShard CYAN_GEM_SHARD = new EnchantShard(9);
	public static final EnchantShard PURPLE_GEM_SHARD = new EnchantShard(10);
	public static final EnchantShard BLUE_GEM_SHARD = new EnchantShard(11);
	public static final EnchantShard BROWN_GEM_SHARD = new EnchantShard(12);
	public static final EnchantShard GREEN_GEM_SHARD = new EnchantShard(13);
	public static final EnchantShard RED_GEM_SHARD = new EnchantShard(14);
	public static final EnchantShard BLACK_GEM_SHARD = new EnchantShard(15);
	
	public static void register(RegistryEvent.Register<Enchantment> event) {
		registerEnchant(WHITE_GEM_SHARD, event);
		registerEnchant(ORANGE_GEM_SHARD, event);
		registerEnchant(MAGENTA_GEM_SHARD, event);
		registerEnchant(LIGHTBLUE_GEM_SHARD, event);
		registerEnchant(YELLOW_GEM_SHARD, event);
		registerEnchant(LIME_GEM_SHARD, event);
		registerEnchant(PINK_GEM_SHARD, event);
		registerEnchant(GRAY_GEM_SHARD, event);
		registerEnchant(LIGHT_GRAY_GEM_SHARD, event);
		registerEnchant(CYAN_GEM_SHARD, event);
		registerEnchant(PURPLE_GEM_SHARD, event);
		registerEnchant(BLUE_GEM_SHARD, event);
		registerEnchant(BROWN_GEM_SHARD, event);
		registerEnchant(GREEN_GEM_SHARD, event);
		registerEnchant(RED_GEM_SHARD, event);
		registerEnchant(BLACK_GEM_SHARD, event);
	}
	private static void registerEnchant(Enchantment enchant, RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().register(enchant);
	}
}
