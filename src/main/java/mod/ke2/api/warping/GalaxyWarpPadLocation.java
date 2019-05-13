package mod.ke2.api.warping;

import net.minecraft.util.math.BlockPos;

public class GalaxyWarpPadLocation {
	private final int dimension;
	private final BlockPos pos;
	
	public GalaxyWarpPadLocation(int dimension, BlockPos pos) {
		this.dimension = dimension;
		this.pos = pos;
	}

	public int getDimension() {
		return this.dimension;
	}
	
	public BlockPos getPos() {
		return this.pos;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		
		if (!(other instanceof GalaxyWarpPadLocation)) {
			return false;
		}
		
		GalaxyWarpPadLocation otherLoc = (GalaxyWarpPadLocation) other;
		return this.dimension == otherLoc.dimension && this.pos.equals(otherLoc.pos);
	}
	
	@Override
	public int hashCode() {
		return this.pos.hashCode() * 31 + this.dimension;
	}
}
