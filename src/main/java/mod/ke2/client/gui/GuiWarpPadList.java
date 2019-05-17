package mod.ke2.client.gui;

import java.util.Iterator;
import java.util.SortedMap;

import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.api.warping.WarpPadListEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.util.math.BlockPos;

public class GuiWarpPadList extends GuiListExtended {
	private final WarpPadListEntry[] entries;
	private final Minecraft mc;
	public GuiWarpPadList(BlockPos source, SortedMap<Double, WarpPadDataEntry> positions, Minecraft mc, int width, int height, int top, int bottom, int slotHeight) {
		super(mc, width, height, top + 30, bottom - 30, slotHeight);
		this.entries = new WarpPadListEntry[positions.size()];
		this.mc = mc;
		Iterator<WarpPadDataEntry> it = positions.values().iterator(); int i = 0;
		while (it.hasNext()) {
			this.entries[i] = new WarpPadListEntry(this, source, it.next());
			++i;
		}
	}
	public Minecraft getInstance() {
		return this.mc;
	}
	@Override
	public IGuiListEntry getListEntry(int index) {
		return this.entries[index];
	}
	@Override
	protected int getSize() {
		return this.entries.length;
	}
}
