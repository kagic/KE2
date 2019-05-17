package mod.ke2.api.warping;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public class WarpPadPos extends BlockPos {
	protected final int dimension;
	protected final int color;
	public WarpPadPos(int color, int dimension, BlockPos pos) {
		this(color, dimension, pos.getX(), pos.getY(), pos.getZ());
	}
	public WarpPadPos(int color, int dimension, double x, double y, double z) {
		super(x, y, z);
		this.dimension = dimension;
		this.color = color;
	}
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("Dimension", this.getDimension());
		compound.setInteger("Color", this.getColor());
		compound.setDouble("X", this.getX());
		compound.setDouble("Y", this.getY());
		compound.setDouble("Z", this.getZ());
		return compound;
	}
	public int getDimension() {
		return this.dimension;
	}
	public int getColor() {
		return this.color;
	}
    public int compareTo(WarpPadPos party) {
    	if (this.color == party.color) {
            if (this.dimension == party.dimension) {
            	return super.compareTo(party);
            }
            else {
            	return this.dimension - party.dimension;
            }
        }
        else {
        	return this.color - party.color;
        }
    }
	@Override
	public int hashCode() {
        return super.hashCode() * 31 + this.dimension * 31 + this.color;
    }
	public static WarpPadPos readFromNBT(NBTTagCompound compound) {
		int dimension = compound.getInteger("Dimension");
		int color = compound.getInteger("Color");
		double x = compound.getDouble("X");
		double y = compound.getDouble("Y");
		double z = compound.getDouble("Z");
		return new WarpPadPos(color, dimension, x, y, z);
	}
}
