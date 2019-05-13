package mod.ke2.api.warping;

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