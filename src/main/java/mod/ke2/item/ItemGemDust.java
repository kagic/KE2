package mod.ke2.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class ItemGemDust extends Item {
	public static final int[] DEFAULT_GEM_DUST_COLORS = new int[] {
		0xffffff,
		0xfdc84d,
		0xeb3dfe,
		0xceedf4,
		0xf4e900,
		0xb6feab,
		0xf8c2eb,
		0x9aa4af,
		0xdddddd,
		0xa8dcdf,
		0xb185cf,
		0xa0b7eb,
		0xe9d5c9,
		0x2ed6a8,
		0xfd4813,
		0x2e2941
	};
	public ItemGemDust() {
		this.setUnlocalizedName("gem_dust");
		this.setMaxStackSize(64);
	}
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
    		for (int color : ItemGemDust.DEFAULT_GEM_DUST_COLORS) {
    			NBTTagCompound compound = new NBTTagCompound();
	        	compound.setInteger("Color", color);
	        	ItemStack stack = new ItemStack(this);
	        	stack.setTagCompound(compound);
	            items.add(stack);
    		}
        }
    }
}
