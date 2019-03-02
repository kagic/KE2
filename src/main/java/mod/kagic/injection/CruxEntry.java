package mod.kagic.injection;

import java.util.ArrayList;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class CruxEntry {
	public static final double CRUX_TRACE 	= 0.10;
	public static final double CRUX_PARTIAL = 0.25;
	public static final double CRUX_AVERAGE = 0.50;
	public static final double CRUX_COMMON 	= 1.00;
	public static final double CRUX_TOTAL 	= 4.50;
	public static final double CRUX_BLOCK 	= 9.00;
	private final Predicate<CruxCandidate> predicate;
	private final double yield;
	public CruxEntry(Predicate<CruxCandidate> predicate, double yield) {
		this.predicate = predicate;
		this.yield = yield;
	}
	public CruxEntry(IBlockState state, double yield, int min, int max) {
		this(new Predicate<CruxCandidate>() {
			@Override
			public boolean apply(CruxCandidate input) {
				float y = input.getPos().getY();
				if (min < y && y < max) {
					return input.getState().equals(state);
				}
				return false;
			}
		}, yield);
	}
	public CruxEntry(IBlockState state, double yield) {
		this(state, yield, 0, 255);
	}
	public double getYield(CruxCandidate input) {
		return this.predicate.apply(input) ? this.yield : 0.0;
	}
	public static void fromOreDict(ArrayList<CruxEntry> cruxes, double yield, int min, int max, String...ores) {
		for (int i = 0; i < ores.length; ++i) {
			NonNullList<ItemStack> stacks = OreDictionary.getOres(ores[i]);
			for (ItemStack stack : stacks) {
				if (stack.getItem() instanceof ItemBlock) {
					IBlockState state = ((ItemBlock)(stack.getItem())).getBlock().getStateFromMeta(stack.getMetadata());
					cruxes.add(new CruxEntry(state, yield, min, max));
				}
			}
		}
	}
	public static void fromOreDict(ArrayList<CruxEntry> cruxes, double yield, String...ores) {
		CruxEntry.fromOreDict(cruxes, yield, 0, 255, ores);
	}
}
