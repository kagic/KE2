package mod.ke2.api.warping.pos;

import net.minecraft.util.math.BlockPos;

public class WarpPadPos extends BlockPos {
	protected final int color;
	public WarpPadPos(int color, BlockPos pos) {
		this(color, pos.getX(), pos.getY(), pos.getZ());
	}
	public WarpPadPos(int color, double x, double y, double z) {
		super(x, y, z);
		this.color = color;
	}
    public int compareTo(WarpPadPos party) {
        if (this.color == party.color) {
        	return super.compareTo(party);
        }
        else {
        	return this.color - party.color;
        }
    }
	@Override
	public int hashCode() {
        return super.hashCode() * 31 + this.color;
    }
}
