package mod.ke2.api.injection;

import java.util.ArrayList;
import java.util.PriorityQueue;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExitHole {
	private final BlockPos[] blocks;
	private final EnumFacing facing;
	private final boolean canCreate;
	private final boolean meltRocks;
	private final boolean direction;
	private final boolean addSlabs;
	private final int minY;

	public ExitHole(BlockPos[] blocks, EnumFacing facing, boolean canCreate, boolean meltRocks, boolean direction, boolean addSlabs, int y) {
		this.blocks = blocks;
		this.facing = facing;
		this.canCreate = canCreate;
		this.meltRocks = meltRocks;
		this.direction = direction;
		this.addSlabs = addSlabs;
		this.minY = y;
	}

	public EnumFacing getFacing() {
		return this.facing;
	}

	public float getAngle() {
		return this.facing.getHorizontalAngle();
	}

	public boolean canCreate() {
		return this.canCreate;
	}

	public boolean createRockMelt() {
		return this.meltRocks;
	}

	public void emerge(World world) {
		for (BlockPos block : this.blocks) {
			world.destroyBlock(block, false);
			InjectorResult.drain(world, this.direction ? block.north() : block.east());
			InjectorResult.drain(world, this.direction ? block.south() : block.west());
			if (block.getY() == this.minY) {
				InjectorResult.drain(world, block.down());
			} else {
				InjectorResult.drain(world, block.up());
			}
		}
		for (BlockPos block : this.blocks) {
			if (!world.isAirBlock(block.up())) {
				InjectorResult.drainSlab(world, block);
			}
		}
	}

	public static ExitHole create(World world, BlockPos pos, double height, double width, boolean meltRocks) {
		ArrayList<BlockPos> blocksToDelete = new ArrayList<BlockPos>();
		PriorityQueue<ExitPotential> exitQueue = new PriorityQueue<ExitPotential>(4, new ExitPotential());
		exitQueue.add(new ExitPotential(false, 0, 10, 'o'));
		int widthBegin = (int) Math.ceil(width / -2.0);
		int widthEnd = (int) Math.ceil(width / 2.0);
		boolean addSlabs = height % 1.0D > 0.0D && height % 1.0D < 0.5D;
		height = Math.ceil(height);
		for (int x = -1; x >= -9; --x) {
			BlockPos check = pos.add(x, 0, 0);
			if (world.isAirBlock(check)) {
				boolean seesSky = world.canSeeSky(check);
				int light = world.getLight(check);
				exitQueue.add(new ExitPotential(seesSky, light, -x, 'w'));
				break;
			}
		}
		for (int x = 1; x <= 9; ++x) {
			BlockPos check = pos.add(x, 0, 0);
			if (world.isAirBlock(check)) {
				boolean seesSky = world.canSeeSky(check);
				int light = world.getLight(check);
				exitQueue.add(new ExitPotential(seesSky, light, x, 'e'));
				break;
			}
		}
		for (int z = -1; z >= -9; --z) {
			BlockPos check = pos.add(0, 0, z);
			if (world.isAirBlock(check)) {
				boolean seesSky = world.canSeeSky(check);
				int light = world.getLight(check);
				exitQueue.add(new ExitPotential(seesSky, light, -z, 'n'));
				break;
			}
		}
		for (int z = 1; z <= 9; ++z) {
			BlockPos check = pos.add(0, 0, z);
			if (world.isAirBlock(check)) {
				boolean seesSky = world.canSeeSky(check);
				int light = world.getLight(check);
				exitQueue.add(new ExitPotential(seesSky, light, z, 's'));
				break;
			}
		}
		for (int y = 0; y < height; ++y) {
			blocksToDelete.add(pos.up(y));
		}
		EnumFacing facing = EnumFacing.NORTH;
		ExitPotential exit = exitQueue.peek();
		switch (exit.direction) {
			case 'n' :
				facing = EnumFacing.NORTH;
				for (int z = 0; z <= exit.length; ++z) {
					for (int y = 0; y < height; ++y) {
						for (int x = widthBegin; x < widthEnd; ++x) {
							blocksToDelete.add(pos.add(x, y, -z));
						}
					}
				}
				break;
			case 's' :
				facing = EnumFacing.SOUTH;
				for (int z = 0; z <= exit.length; ++z) {
					for (int y = 0; y < height; ++y) {
						for (int x = widthBegin; x < widthEnd; ++x) {
							blocksToDelete.add(pos.add(x, y, z));
						}
					}
				}
				break;
			case 'e' :
				facing = EnumFacing.EAST;
				for (int x = 0; x <= exit.length; ++x) {
					for (int y = 0; y < height; ++y) {
						for (int z = widthBegin; z < widthEnd; ++z) {
							blocksToDelete.add(pos.add(x, y, z));
						}
					}
				}
				break;
			case 'w' :
				facing = EnumFacing.WEST;
				for (int x = 0; x <= exit.length; ++x) {
					for (int y = 0; y < height; ++y) {
						for (int z = widthBegin; z < widthEnd; ++z) {
							blocksToDelete.add(pos.add(-x, y, z));
						}
					}
				}
				break;
		}
		boolean direction = exit.direction == 'e' || exit.direction == 'w';
		return new ExitHole(blocksToDelete.toArray(new BlockPos[0]), facing, blocksToDelete.size() <= height * width, meltRocks, direction, addSlabs, pos.getY());
	}
}
