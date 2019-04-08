package mod.ke2.init;

import java.util.Collections;
import java.util.Comparator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;

public class Ke2 {
	public static final DamageSource DAMAGE_CRACKED = new DamageSource("gem_cracked");
	public static final DamageSource DAMAGE_SHATTERED = new DamageSource("gem_shattered");
	public static final DamageSource DAMAGE_POOFED = new DamageSource("gem_poofed");
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
}
