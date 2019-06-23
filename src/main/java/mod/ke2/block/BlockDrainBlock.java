package mod.ke2.block;

import java.util.Random;

import mod.ke2.api.injection.InjectorResult;
import mod.ke2.init.Ke2Blocks;
import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDrainBlock extends Block {
	public static final Material DRAINED = new Material(MapColor.BLACK) {
		@Override
		public EnumPushReaction getMobilityFlag() {
			return EnumPushReaction.BLOCK;
		}

		@Override
		public boolean isToolNotRequired() {
			return false;
		}
	};
	private final boolean canBeEnriched;
	private final String color;

	public BlockDrainBlock(boolean canBeEnriched, String color, int level) {
		super(BlockDrainBlock.DRAINED);
		this.setCreativeTab(Ke2CreativeTabs.GEM_CREATION);
		switch (level) {
			case 0 :
				this.setUnlocalizedName("light_" + color + "_drain_block");
				break;
			case 1 :
				this.setUnlocalizedName("banded_" + color + "_drain_block");
				break;
			case 2 :
				this.setUnlocalizedName("dark_" + color + "_drain_block");
				break;
			case 3 :
				this.setUnlocalizedName("eroded_" + color + "_drain_block");
				break;
		}
		this.canBeEnriched = canBeEnriched;
		this.color = color;
		this.setResistance(100);
		this.setHardness(3);
		this.setTickRandomly(true);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		super.updateTick(world, pos, state, random);
		if (this.canBeEnriched) {
			IBlockState convert = Blocks.DIRT.getDefaultState();
			boolean enriching = false;
			for (int x = -1; x < 2 && !enriching; ++x) {
				for (int z = -1; z < 2 && !enriching; ++z) {
					if (world.getBlockState(pos.add(x, 0, z)).getMaterial() == Material.GRASS) {
						convert = world.getBlockState(pos.add(x, 0, z));
						enriching = true;
					}
				}
			}
			if (enriching) {
				world.setBlockState(pos, convert);
			}
		} else {
			boolean eroding = false;
			if (world.isRaining()) {
				eroding = true;
			} else {
				for (int y = -1; y < 2 && !eroding; ++y) {
					for (int x = -1; x < 2 && !eroding; ++x) {
						for (int z = -1; z < 2 && !eroding; ++z) {
							IBlockState block = world.getBlockState(pos.add(x, y, z));
							if (block.getMaterial() == Material.WATER) {
								eroding = true;
							} else if (block.getMaterial() == Material.WOOD) {
								InjectorResult.drain(world, pos.add(x, y, z));
							}
						}
					}
				}
			}
			if (eroding) {
				world.setBlockState(pos, this.getErodedState());
			}
		}
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

	public IBlockState getErodedState() {
		switch (this.color) {
			case "purple" :
				return Ke2Blocks.ERODED_PURPLE_DRAIN_BLOCK.getDefaultState();
			case "orange" :
				return Ke2Blocks.ERODED_ORANGE_DRAIN_BLOCK.getDefaultState();
			case "blue" :
				return Ke2Blocks.ERODED_BLUE_DRAIN_BLOCK.getDefaultState();
			case "red" :
				return Ke2Blocks.ERODED_RED_DRAIN_BLOCK.getDefaultState();
			default :
				return Ke2Blocks.ERODED_PURPLE_DRAIN_BLOCK.getDefaultState();
		}
	}
}
