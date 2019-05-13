package mod.ke2.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import mod.ke2.init.Ke2Packets;
import mod.ke2.networking.PacketWarpPadName;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;

public class GuiWarpPad extends GuiScreen {
	private final TileEntityWarpPadCore tilePad;
	private GuiTextField nameTextField;
	private GuiButton doneButton;
	GuiWarpPad(TileEntityWarpPadCore tePad){
		this.tilePad = tePad;
	}
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	@Override
	public void updateScreen() {
		this.nameTextField.updateCursorCounter();
	}
	public void initGui() {
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);
		this.nameTextField = new GuiTextField(2, this.fontRenderer, this.width / 2 - 100, this.height / 2 - 10, 200, 20);
		this.nameTextField.setMaxStringLength(256);
		this.nameTextField.setText(this.tilePad.name);
		this.nameTextField.setFocused(true);
		this.doneButton = this.addButton(new GuiButton(0, this.width / 2 - 100, this.height / 2 + 30, I18n.format("gui.done", new Object[0])));
	}
	public void onGuiClosed() {
		Ke2Packets.INSTANCE.sendToServer(new PacketWarpPadName(nameTextField.getText(), tilePad.getPos().getX(), tilePad.getPos().getY(), tilePad.getPos().getZ()));
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
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		switch (keyCode) {
		case Keyboard.KEY_ESCAPE:
			Minecraft.getMinecraft().player.closeScreen();
			break;
		default:
			this.nameTextField.textboxKeyTyped(typedChar, keyCode);
		}
	}
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.nameTextField.mouseClicked(mouseX, mouseY, mouseButton);
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Enter Warp Pad Name", this.width / 2, this.height / 2 - 30, 0xFFFFF);
		this.nameTextField.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
