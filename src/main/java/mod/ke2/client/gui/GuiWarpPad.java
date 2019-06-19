package mod.ke2.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import mod.ke2.init.Ke2Messages;
import mod.ke2.networking.PacketWarpPadName;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;

public class GuiWarpPad extends GuiScreen {
	private final TileEntityWarpPadCore pad;
	protected String title = "Enter a new warp pad name.";
	protected GuiTextField textName;
	
	public GuiWarpPad(TileEntityWarpPadCore pad) {
		this.pad = pad;
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() {
		this.textName.updateCursorCounter();
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);
		this.textName = new GuiTextField(2, this.fontRenderer, this.width / 2 - 100, this.height / 2 - 10, 200, 20);
		this.textName.setMaxStringLength(256);
		this.textName.setText(this.pad.name);
		this.textName.setFocused(true);
		this.addButton(new GuiButton(0, this.width / 2 - 100, this.height / 2 + 30, I18n.format("gui.done", new Object[0])));
	}
	
	@Override
	public void onGuiClosed() {
		Ke2Messages.INSTANCE.sendToServer(new PacketWarpPadName(this.textName.getText(), this.pad.getPos().getX(), this.pad.getPos().getY(), this.pad.getPos().getZ()));
		Keyboard.enableRepeatEvents(false);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.enabled) {
			if (button.id == 0) {
				Minecraft.getMinecraft().player.closeScreen();
			}
		}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		switch (keyCode) {
			case Keyboard.KEY_ESCAPE :
				Minecraft.getMinecraft().player.closeScreen();
				break;
			default :
				this.textName.textboxKeyTyped(typedChar, keyCode);
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.textName.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, this.height / 2 - 30, 0xFFFFF);
		this.textName.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
