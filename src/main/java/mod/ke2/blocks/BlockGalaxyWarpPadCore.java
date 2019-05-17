package mod.ke2.blocks;

import mod.ke2.tileentity.TileEntityGalaxyWarpPadCore;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGalaxyWarpPadCore extends BlockWarpPadCore {
	public BlockGalaxyWarpPadCore() {
		super();
        this.setUnlocalizedName("galaxy_warp_pad_core");
	}
	@Override
	protected TileEntityWarpPadCore getWarpPad(World world, BlockPos pos) {
		return (TileEntityWarpPadCore) world.getTileEntity(pos);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGalaxyWarpPadCore();
	}
}
