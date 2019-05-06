package mod.ke2.init;

import mod.ke2.KAGIC;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Ke2CreativeTabs extends CreativeTabs {
	public static final Ke2CreativeTabs GEMSTONES = new Ke2CreativeTabs(Ke2Items.GREEN_GEM_SHARD, "gemstones");
	public static final Ke2CreativeTabs GEM_TECH = new Ke2CreativeTabs(Ke2Items.GREEN_GEM_DESTABILIZER, "gem_tech");
	private final Item item;
	public Ke2CreativeTabs(Item item, String suffix) {
		super(KAGIC.MODID + "_" + suffix);
		this.item = item;
	}
	public Ke2CreativeTabs(Block block, String suffix) {
		this(Item.getItemFromBlock(block), suffix);
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(this.item);
	}
}
