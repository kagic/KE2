package mod.ke2.block;

import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;

public class BlockWarpPadEdge extends BlockStairs {
	private final int color;
	public BlockWarpPadEdge(IBlockState state) {
		super(state);
        this.setCreativeTab(Ke2CreativeTabs.GEM_TECH);
		this.color = ((BlockWarpPadFrame)(state.getBlock())).getColor();
        this.setUnlocalizedName(EnumDyeColor.byMetadata(this.color).toString().toLowerCase() + "_warp_pad_edge");
    	this.setResistance(30);
    	this.setHardness(2);
	}
	public int getColor() {
		return this.color;
	}
}