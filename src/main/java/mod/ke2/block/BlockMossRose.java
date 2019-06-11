package mod.ke2.block;

import mod.ke2.init.Ke2Blocks;
import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMossRose extends BlockBush {
	protected static final AxisAlignedBB MOSS_ROSE_SELECTION = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, -0.125D, 1.0D);
	protected static final AxisAlignedBB MOSS_ROSE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, -0.125D, 1.0D);
	public BlockMossRose() {
		super(Material.PLANTS, MapColor.PINK);
		this.setUnlocalizedName("moss_rose");
		this.setLightLevel(4.0F);
    	this.setCreativeTab(Ke2CreativeTabs.GEM_CREATION);
	}
	@Override
	protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Ke2Blocks.MAGIC_MOSS && state.getValue(BlockMagicMoss.SHORT);
    }
	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos.down());
        return state.getBlock() == Ke2Blocks.MAGIC_MOSS && state.getValue(BlockMagicMoss.SHORT);
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return MOSS_ROSE_SELECTION;
    }
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MOSS_ROSE_AABB;
    }
	@Override
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
	@Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
