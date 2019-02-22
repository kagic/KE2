package mod.kagic.injection;

import java.util.ArrayList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class CruxEntry {
	public static final double CRUX_TRACE = 0.10;
	public static final double CRUX_PARTIAL = 0.25;
	public static final double CRUX_AVERAGE = 0.50;
	public static final double CRUX_PRECO = 1.00;
	public static final double CRUX_TOTAL = 4.50;
	public static final double CRUX_BLOCK = 9.00;
	private final IBlockState state;
	private final double yield;
	private final int limit;
	public CruxEntry(IBlockState state, double yield, int limit) {
		this.state = state;
		this.yield = yield;
		this.limit = limit;
	}
	public CruxEntry(IBlockState state, double yield) {
		this(state, yield, 255);
	}
	public IBlockState getState() {
		return this.state;
	}
	public double getYield() {
		return this.yield;
	}
	public int getLimit() {
		return this.limit;
	}
	public static void fromOreDict(ArrayList<CruxEntry> cruxes, double yield, int limit, String...ores) {
		for (int i = 0; i < ores.length; ++i) {
			NonNullList<ItemStack> stacks = OreDictionary.getOres(ores[i]);
			for (ItemStack stack : stacks) {
				if (stack.getItem() instanceof ItemBlock) {
					IBlockState state = ((ItemBlock)(stack.getItem())).getBlock().getStateFromMeta(stack.getMetadata());
					cruxes.add(new CruxEntry(state, yield, limit));
				}
			}
		}
	}
	public static void fromOreDict(ArrayList<CruxEntry> cruxes, double yield, String...ores) {
		CruxEntry.fromOreDict(cruxes, yield, 255, ores);
	}
}
