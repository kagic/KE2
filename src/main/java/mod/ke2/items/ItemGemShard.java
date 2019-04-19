package mod.ke2.items;

import java.util.ArrayList;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;

public class ItemGemShard extends Item {
	public static final ArrayList<Item> SHARD_COLORS = new ArrayList<Item>();
	public int color;
	public ItemGemShard(int index) {
		String name = EnumDyeColor.byMetadata(index).toString().toLowerCase();
		this.setUnlocalizedName(name + "_gem_shard");
		this.setMaxStackSize(64);
		ItemGemShard.SHARD_COLORS.add(this);
		this.color = index;
	}
}
