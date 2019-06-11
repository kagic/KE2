package mod.ke2.block;

import java.util.Random;

import mod.ke2.api.injection.InjectorResult;
import mod.ke2.init.Ke2Blocks;
import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDrainLily extends BlockBush {
	private final String prefix;
	public BlockDrainLily(String prefix) {
		super(Material.PLANTS);
		this.setUnlocalizedName(prefix + "_drain_lily");
		this.setLightLevel(4.0F);
		this.setTickRandomly(true);
		this.prefix = prefix;
    	this.setCreativeTab(Ke2CreativeTabs.GEM_CREATION);
	}
	@Override
	protected boolean canSustainBush(IBlockState state) {
        return state.isTopSolid();
    }
	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		return world.isSideSolid(pos.down(), EnumFacing.UP);
    }
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		IBlockState down = world.getBlockState(pos.down());
		if (down.isSideSolid(world, pos, EnumFacing.UP)) {
			super.updateTick(world, pos, state, random);
			if (down.getMaterial() == BlockDrainBlock.DRAINED) {
				BlockPos check = pos.add(world.rand.nextInt(3) - 1, 0, world.rand.nextInt(3) - 1);
				if (world.isAirBlock(check) && world.isSideSolid(check.down(), EnumFacing.UP)) {
					IBlockState lily = Ke2Blocks.VALLEY_DRAIN_LILY.getDefaultState();
					switch (this.prefix) {
					case "desert":
						lily = Ke2Blocks.DESERT_DRAIN_LILY.getDefaultState();
						break;
					case "alpine":
						lily = Ke2Blocks.ALPINE_DRAIN_LILY.getDefaultState();
						break;
					case "nether":
						lily = Ke2Blocks.NETHER_DRAIN_LILY.getDefaultState();
						break;
					}
					world.setBlockState(check, lily);
				}
			}
			else {
				Block[] blocks = InjectorResult.PURPLE_DRAIN_BLOCKS;
				switch (this.prefix) {
				case "desert":
					blocks = InjectorResult.ORANGE_DRAIN_BLOCKS;
					break;
				case "alpine":
					blocks = InjectorResult.BLUE_DRAIN_BLOCKS;
					break;
				case "nether":
					blocks = InjectorResult.RED_DRAIN_BLOCKS;
					break;
				}
				InjectorResult.drain(world, pos.down(), blocks);
			}
		}
		else {
			world.destroyBlock(pos, true);
		}
	}
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
		switch (this.prefix) {
		case "desert":
			return MapColor.YELLOW;
		case "alpine":
			return MapColor.LIGHT_BLUE;
		case "nether":
			return MapColor.RED;
		}
		return MapColor.PURPLE;
    }
}
