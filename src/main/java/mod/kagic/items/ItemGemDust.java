package mod.kagic.items;

import java.util.ArrayList;

import mod.kagic.init.KAGIC;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;

public class ItemGemDust extends Item {
	public static final ArrayList<Item> DUST_COLORS = new ArrayList<Item>();
	public int color;
	public ItemGemDust(int index) {
		String name = EnumDyeColor.byMetadata(index).toString().toLowerCase();
		this.setUnlocalizedName(name + "_gem_dust");
		this.setMaxStackSize(64);
		this.setCreativeTab(KAGIC.CREATIVE_TAB);
		ItemGemDust.DUST_COLORS.add(this);
		this.color = index;
	}
}
