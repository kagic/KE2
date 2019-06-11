package mod.ke2.init;

import mod.ke2.KAGIC;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Ke2CreativeTabs extends CreativeTabs {
	public static final Ke2CreativeTabs GEM_STONES = new Ke2CreativeTabs(0, "gem_stones");
	public static final Ke2CreativeTabs GEM_CREATION = new Ke2CreativeTabs(1, "gem_creation");
	public static final Ke2CreativeTabs GEM_TECH = new Ke2CreativeTabs(2, "gem_tech");
	public static final Ke2CreativeTabs GEM_BLOCKS = new Ke2CreativeTabs(3, "gem_blocks");
	private final int item;
	public Ke2CreativeTabs(int item, String suffix) {
		super(KAGIC.MODID + "_" + suffix);
		this.item = item;
	}
	@Override
	public ItemStack getTabIconItem() {
		if (this.item == 0) {		// Gemstones.
			ItemStack stack = new ItemStack(Ke2Items.COLORED_GEMSTONE);
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("GemstoneColor", 0xd172dc);
			compound.setInteger("GemstoneCut", 3);
			stack.setTagCompound(compound);
			return stack;
		}
		if (this.item == 1) {		// Gem Creation.
			ItemStack stack = new ItemStack(Ke2Items.GEM_STAFF);
			return stack;
		}
		if (this.item == 2) {		// Gem Tech.
			ItemStack stack = new ItemStack(Ke2Items.GEM_DESTABILIZER);
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("UpperColor", 0xa5e3a0);
			compound.setInteger("LowerColor", 0x15c907);
			compound.setBoolean("Primed", true);
			stack.setTagCompound(compound);
			return stack;
		}
		if (this.item == 3) {		// Gem Blocks.
			ItemStack stack = new ItemStack(Ke2Items.OBSESSIVE_ESSENCE);
			return stack;
		}
		return ItemStack.EMPTY;
	}
}
