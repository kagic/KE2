package mod.ke2.client.gui;

import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.init.Ke2Messages;
import mod.ke2.networking.PacketWarpPadSignal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

public class GuiWarpPadListEntry implements GuiListExtended.IGuiListEntry {
	private final GuiWarpPadList parent;
	private final BlockPos source;
	private final WarpPadDataEntry pad;
	private final GuiButton button;
	
	public GuiWarpPadListEntry(GuiWarpPadList parent, BlockPos source, WarpPadDataEntry pad) {
		this.parent = parent;
		this.source = source;
		this.pad = pad;
		this.button = new GuiButton(0, 0, 0, 200, 20, this.pad.getName());
	}
	
	@Override
	public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected, float partialTicks) {
		this.button.x = this.parent.getInstance().currentScreen.width / 2 - this.button.width / 2;
		this.button.y = y + 10;
		if (!this.pad.isValid()) {
			this.button.displayString = TextFormatting.RED + this.pad.getName();
			this.button.enabled = false;
		} else if (!this.pad.isClear()) {
			this.button.displayString = TextFormatting.YELLOW + this.pad.getName();
			this.button.enabled = false;
		} else {
			this.button.displayString = TextFormatting.AQUA + this.pad.getName();
		}
		this.button.drawButton(this.parent.getInstance(), mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean mousePressed(int slotIndex, int mouseX, int mouseY, int mouseEvent, int relativeX, int relativeY) {
		if (this.button.mousePressed(this.parent.getInstance(), mouseX, mouseY)) {
			Ke2Messages.INSTANCE.sendToServer(new PacketWarpPadSignal(this.source, this.pad.getPos()));
			Minecraft.getMinecraft().player.closeScreen();
			return true;
		}
		return false;
	}
	
	@Override
	public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {
		this.button.mouseReleased(x, y);
	}
	
	@Override
	public void updatePosition(int x, int y, int z, float partialTicks) {
		
	}
}