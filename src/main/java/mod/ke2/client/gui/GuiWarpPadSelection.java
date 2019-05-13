package mod.ke2.client.gui;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.lwjgl.input.Keyboard;

import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import mod.ke2.world.data.WorldDataWarpPad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;

public class GuiWarpPadSelection extends GuiScreen {
	private SortedMap<Double, BlockPos> positions = new TreeMap<Double, BlockPos>();
	private Map<BlockPos, WarpPadDataEntry> data = null;
	private final TileEntityWarpPadCore pad;
	protected String screenTitle = "Select Destination";
	private GuiWarpPadList padList;
	private GuiButton buttonDone; 
	
	public GuiWarpPadSelection(LinkedHashMap<BlockPos, WarpPadDataEntry> data, int x, int y, int z) {
		this.pad = (TileEntityWarpPadCore)(Minecraft.getMinecraft().world.getTileEntity(new BlockPos(x, y, z)));
		this.positions = WorldDataWarpPad.getSortedPositions(data, this.pad.getPos());
		this.data = data;
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
	public void initGui() {
		this.padList = new GuiWarpPadList(this, this.pad.getPos(), this.positions, this.mc, this.width, this.height, 0, this.height, 50);
		this.buttonDone = this.addButton(new GuiButton(618, this.width / 2 - 75, this.height - 25, 150, 20, I18n.format("gui.cancel", new Object[0])));
	}
	public void onGuiClosed() {
		
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 618:
			Minecraft.getMinecraft().player.closeScreen();
			break;
		default:
			this.padList.actionPerformed(button);
			super.actionPerformed(button);
		}
	}
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == Keyboard.KEY_ESCAPE) {
			Minecraft.getMinecraft().player.closeScreen();
		}
	}
	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		this.padList.handleMouseInput();
	}
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (!this.padList.mouseClicked(mouseX, mouseY, mouseButton)) {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if (!this.padList.mouseReleased(mouseX, mouseY, state)) {
			super.mouseReleased(mouseX, mouseY, state);
		}
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.padList.drawScreen(mouseX, mouseY, partialTicks);
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 10, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
