package mod.ke2.client.gui;

import java.io.IOException;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import org.lwjgl.input.Keyboard;

import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.api.warping.WarpPadPos;
import mod.ke2.world.data.WorldDataWarps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;

public class GuiWarpPadSelection extends GuiScreen {
	private SortedMap<Double, WarpPadDataEntry> positions = new TreeMap<Double, WarpPadDataEntry>();
	private HashMap<WarpPadPos, WarpPadDataEntry> data = null;
	private final WarpPadDataEntry pad;
	protected String title = "Select a destination to warp to.";
	protected GuiWarpPadList list;
	
	public GuiWarpPadSelection(HashMap<WarpPadPos, WarpPadDataEntry> data, WarpPadDataEntry pad) {
		this.positions = WorldDataWarps.getSortedPositions(data, pad.getPos());
		this.data = data;
		this.pad = pad;
	}
	public WarpPadDataEntry getPadDataEntry(BlockPos pos) {
		if (this.data.containsKey(pos)) {
			return this.data.get(pos);
		}
		else {
			return null;
		}
	}
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	@Override
	public void updateScreen() {
		
	}
	@Override
	public void initGui() {
		this.list = new GuiWarpPadList(this.pad.getPos(), this.positions, this.mc, this.width, this.height, 0, this.height, 50);
		this.addButton(new GuiButton(0, this.width / 2 - 75, this.height - 25, 150, 20, I18n.format("gui.cancel", new Object[0])));
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 0:
			Minecraft.getMinecraft().player.closeScreen();
			break;
		default:
			this.list.actionPerformed(button);
			super.actionPerformed(button);
		}
	}
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == Keyboard.KEY_ESCAPE) {
			Minecraft.getMinecraft().player.closeScreen();
		}
	}
	@Override
	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		this.list.handleMouseInput();
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (!this.list.mouseClicked(mouseX, mouseY, mouseButton)) {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if (!this.list.mouseReleased(mouseX, mouseY, state)) {
			super.mouseReleased(mouseX, mouseY, state);
		}
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 10, 0xFFFFF);
		this.list.drawScreen(mouseX, mouseY, partialTicks);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
