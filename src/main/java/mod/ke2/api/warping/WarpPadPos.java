package mod.ke2.api.warping.pos;

import net.minecraft.util.math.BlockPos;

public class GalaxyWarpPadPos extends WarpPadPos {
	protected final int dimension;
	public GalaxyWarpPadPos(int color, int dimension, BlockPos pos) {
		this(color, dimension, pos.getX(), pos.getY(), pos.getZ());
	}
	public GalaxyWarpPadPos(int color, int dimension, double x, double y, double z) {
		super(color, x, y, z);
		this.dimension = dimension;
	}
    public int compareTo(GalaxyWarpPadPos party) {
        if (this.dimension == party.dimension) {
        	return super.compareTo(party);
        }
        else {
        	return this.dimension - party.dimension;
        }
    }
	@Override
	public int hashCode() {
        return super.hashCode() * 31 + this.dimension;
    }
}
