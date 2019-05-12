package mod.ke2.world.data;

public class WarpPadDataEntry {
	public String name = "";
	public boolean valid = false;
	public boolean clear = false;
	
	public WarpPadDataEntry(String name, boolean valid, boolean clear) {
		this.name = name;
		this.valid = valid;
		this.clear = clear;
	}
}