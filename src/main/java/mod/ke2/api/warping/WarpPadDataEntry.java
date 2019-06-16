package mod.ke2.api.warping;

import net.minecraft.nbt.NBTTagCompound;

public class WarpPadDataEntry {
	protected WarpPadPos pos = null;
	protected String name = "";
	protected boolean valid = false;
	protected boolean clear = false;
	public WarpPadDataEntry(String name, boolean valid, boolean clear, WarpPadPos pos) {
		this.name = name;
		this.valid = valid;
		this.clear = clear;
		this.pos = pos;
	}
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setString("Name", this.getName());
		compound.setBoolean("IsValid", this.isValid());
		compound.setBoolean("IsClear", this.isClear());
		this.pos.writeToNBT(compound);
		return compound;
	}
	public String getName() {
		return this.name;
	}
	public boolean isValid() {
		return this.valid;
	}
	public boolean isClear() {
		return this.clear;
	}
	public WarpPadPos getPos() {
		return this.pos;
	}
	public static WarpPadDataEntry readFromNBT(NBTTagCompound compound) {
		String name = compound.getString("Name");
		boolean isValid = compound.getBoolean("IsValid");
		boolean isClear = compound.getBoolean("IsClear");
		WarpPadPos pos = WarpPadPos.readFromNBT(compound);
		return new WarpPadDataEntry(name, isValid, isClear, pos);
	}
}