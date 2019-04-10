package mod.ke2.init;

import java.util.Collections;
import java.util.Comparator;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Ke2CreativeTabs extends CreativeTabs {
	public static final Ke2CreativeTabs GOOD_GEMS = new Ke2CreativeTabs(Ke2Items.YELLOW_GEM_DESTABILIZER);
	public static final Ke2CreativeTabs BAD_GEMS = new Ke2CreativeTabs(Ke2Items.YELLOW_GEM_DESTABILIZER);
	public static final Ke2CreativeTabs GEM_TECH = new Ke2CreativeTabs(Ke2Items.YELLOW_GEM_DESTABILIZER);
	public static final Ke2CreativeTabs MISCELLANEOUS = new Ke2CreativeTabs(Ke2Items.BLACK_GEM_DUST);
	private final Item item;
	public Ke2CreativeTabs(Item item) {
		super(CreativeTabs.getNextID(), KAGIC.MODID);
		this.item = item;
	}
	public Ke2CreativeTabs(Block block) {
		this(Item.getItemFromBlock(block));
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
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(this.item);
	}
}
