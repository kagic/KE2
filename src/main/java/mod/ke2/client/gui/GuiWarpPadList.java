package mod.ke2.client.gui;

import java.util.Iterator;
import java.util.SortedMap;

import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.init.Ke2Packets;
import mod.ke2.networking.PacketWarpPadSignal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

public class GuiWarpPadList extends GuiListExtended {
	private final GuiListExtended.IGuiListEntry[] padListEntries;
	private final GuiWarpPadSelection selectionScreen;
	private final Minecraft minecraft;
	public GuiWarpPadList(GuiWarpPadSelection parent, BlockPos source, SortedMap<Double, BlockPos> positions, Minecraft minecraft, int width, int height, int top, int bottom, int slot) {
		super(minecraft, width, height, top + 30, bottom - 30, slot);
		this.minecraft = minecraft;
		this.selectionScreen = parent;
		this.padListEntries = new GuiListExtended.IGuiListEntry[positions.size()];
		Iterator<BlockPos> it = positions.values().iterator();
		int i = 0;
		while (it.hasNext()) {
			BlockPos pos = it.next();
			WarpPadDataEntry data = this.selectionScreen.getPadDataEntry(pos);
			this.padListEntries[i] = new PadListEntry(source, pos, data);
			++i;
		}
	}
	@Override
	public IGuiListEntry getListEntry(int index) {
		return this.padListEntries[index];
	}
	@Override
	protected int getSize() {
		return this.padListEntries.length;
	}
	public class PadListEntry implements GuiListExtended.IGuiListEntry {
		private final BlockPos sourcePos;
		private final BlockPos padPos;
		private final WarpPadDataEntry padData;
		private final GuiButton padButton;
		PadListEntry(BlockPos sourcePos, BlockPos pos, WarpPadDataEntry data) {
			this.sourcePos = sourcePos;
			this.padPos = pos;
			this.padData = data;
			this.padButton = new GuiButton(0, 0, 0, 200, 20, this.padData.name);
		}
		@Override
		public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected, float partialTicks) {
			this.padButton.x = GuiWarpPadList.this.mc.currentScreen.width / 2 - this.padButton.width / 2;
			this.padButton.y = y + 10;
			if (!this.padData.valid) {
				this.padButton.displayString = TextFormatting.RED + this.padData.name;
				this.padButton.enabled = false;
			}
			else if (!this.padData.clear) {
				this.padButton.displayString = TextFormatting.YELLOW + this.padData.name;
				this.padButton.enabled = false;
			}
			else {
				this.padButton.displayString = TextFormatting.AQUA + this.padData.name;
			}
			this.padButton.drawButton(GuiWarpPadList.this.mc, mouseX, mouseY, partialTicks);
		}
		@Override
		public boolean mousePressed(int slotIndex, int mouseX, int mouseY, int mouseEvent, int relativeX, int relativeY) {
			if (this.padButton.mousePressed(GuiWarpPadList.this.mc, mouseX, mouseY)) {
				Ke2Packets.INSTANCE.sendToServer(new PacketWarpPadSignal(this.sourcePos, this.padPos));
				Minecraft.getMinecraft().player.closeScreen();
				return true;
			}
			return false;
		}
		@Override
		public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {
			this.padButton.mouseReleased(x, y);
		}
		@Override
		public void updatePosition(int slotIndex, int x, int y, float partialTicks) {
			
		}	
	}
}
