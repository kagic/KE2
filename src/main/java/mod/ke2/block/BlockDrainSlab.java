package mod.ke2.block;

import java.util.Random;

import mod.ke2.init.Ke2Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDrainSlab extends Block {
	protected static final AxisAlignedBB DRAIN_SLAB_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	private final String color;
	
	public BlockDrainSlab(String color, int level) {
		super(BlockDrainBlock.DRAINED);
		switch (level) {
			case 0 :
				this.setUnlocalizedName("light_" + color + "_drain_slab");
				break;
			case 1 :
				this.setUnlocalizedName("banded_" + color + "_drain_slab");
				break;
			case 2 :
				this.setUnlocalizedName("dark_" + color + "_drain_slab");
				break;
		}
		this.color = color;
		this.setResistance(100);
		this.setHardness(3);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return null; // Drain slabs are part of a
						// multi-block structure, and as
						// such should be as hidden from the
						// user.
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		if (this == Ke2Blocks.LIGHT_PURPLE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.LIGHT_PURPLE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.BANDED_PURPLE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.BANDED_PURPLE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.DARK_PURPLE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.DARK_PURPLE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.LIGHT_ORANGE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.LIGHT_ORANGE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.BANDED_ORANGE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.BANDED_ORANGE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.DARK_ORANGE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.DARK_ORANGE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.LIGHT_BLUE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.LIGHT_BLUE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.BANDED_BLUE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.BANDED_BLUE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.DARK_BLUE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.DARK_BLUE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.LIGHT_BLUE_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.LIGHT_BLUE_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.BANDED_RED_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.BANDED_RED_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.DARK_RED_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.DARK_RED_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.LIGHT_RED_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.LIGHT_RED_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.BANDED_RED_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.BANDED_RED_DRAIN_BLOCK);
		}
		if (this == Ke2Blocks.DARK_RED_DRAIN_SLAB) {
			return new ItemStack(Ke2Blocks.DARK_RED_DRAIN_BLOCK);
		}
		return new ItemStack(this);
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
		switch (this.color) {
			case "purple" :
				return MapColor.PURPLE_STAINED_HARDENED_CLAY;
			case "orange" :
				return MapColor.ORANGE_STAINED_HARDENED_CLAY;
			case "blue" :
				return MapColor.BLUE_STAINED_HARDENED_CLAY;
			case "red" :
				return MapColor.RED_STAINED_HARDENED_CLAY;
			default :
				return MapColor.PURPLE_STAINED_HARDENED_CLAY;
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (world.getBlockState(pos.up()).getBlock() instanceof BlockDrainBlock) {
			super.neighborChanged(state, world, pos, block, fromPos);
		} else {
			world.destroyBlock(pos, false);
		}
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (world.getBlockState(pos.up()).getBlock() instanceof BlockDrainBlock) {
			super.onBlockAdded(world, pos, state);
		} else {
			world.destroyBlock(pos, false);
		}
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (world.getBlockState(pos.up()).getBlock() instanceof BlockDrainBlock) {
			world.destroyBlock(pos.up(), true);
		}
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BlockDrainSlab.DRAIN_SLAB_AABB;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return BlockDrainSlab.DRAIN_SLAB_AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return true;
	}
}
