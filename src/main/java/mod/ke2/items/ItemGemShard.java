package mod.ke2.items;

import java.util.ArrayList;

import mod.ke2.init.KAGIC;
import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;

public class ItemGemShard extends Item {
	public static final ArrayList<Item> SHARD_COLORS = new ArrayList<Item>();
	public int color;
	public ItemGemShard(int index) {
		String name = EnumDyeColor.byMetadata(index).toString().toLowerCase();
		this.setUnlocalizedName(name + "_gem_shard");
		this.setMaxStackSize(64);
		this.setCreativeTab(Ke2CreativeTabs.GEM_TECH);
		ItemGemShard.SHARD_COLORS.add(this);
		this.color = index;
	}
}
