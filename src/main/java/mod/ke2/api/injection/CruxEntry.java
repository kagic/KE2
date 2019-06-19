package mod.ke2.api.injection;

import com.google.common.base.Predicate;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Cruxes;
import mod.ke2.init.Ke2Gems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class CruxEntry {
	public static final double CRUX_TRACE = 0.10;
	public static final double CRUX_PARTIAL = 0.25;
	public static final double CRUX_AVERAGE = 0.50;
	public static final double CRUX_COMMON = 1.00;
	public static final double CRUX_TOTAL = 4.50;
	public static final double CRUX_BLOCK = 9.00;
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
	
	public static void fromOreDict(ResourceLocation gem, double yield, int min, int max, String... ores) {
		for (int i = 0; i < ores.length; ++i) {
			NonNullList<ItemStack> stacks = OreDictionary.getOres(ores[i]);
			for (ItemStack stack : stacks) {
				if (stack.getItem() instanceof ItemBlock) {
					IBlockState state = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
					Ke2Cruxes.addCrux(gem, new CruxEntry(state, yield, min, max));
				}
			}
		}
	}
	
	public static void fromOreDict(Class<? extends EntityGem> gem, double yield, int min, int max, String... ores) {
		CruxEntry.fromOreDict(Ke2Gems.REGISTRY_REVERSE.get(gem), yield, min, max, ores);
	}
	
	public static void fromOreDict(ResourceLocation gem, double yield, String... ores) {
		CruxEntry.fromOreDict(gem, yield, 0, 255, ores);
	}
	
	public static void fromOreDict(Class<? extends EntityGem> gem, double yield, String... ores) {
		CruxEntry.fromOreDict(gem, yield, 0, 255, ores);
	}
}
