package mod.ke2.api.injection;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CruxCandidate {
	private final IBlockState state;
	private final World world;
	private final BlockPos pos;
	public CruxCandidate(IBlockState state, World world, BlockPos pos) {
		this.state = state;
		this.world = world;
		this.pos = pos;
	}
	public IBlockState getState() {
		return this.state;
	}
	public World getWorld() {
		return this.world;
	}
	public BlockPos getPos() {
		return this.pos;
	}
	public Random getRNG() {
		return this.world.rand;
	}
}
