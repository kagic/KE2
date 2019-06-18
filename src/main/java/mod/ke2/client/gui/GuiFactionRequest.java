package mod.ke2.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuiFactionRequest extends GuiScreen {
	private final EntityPlayer player;
	protected GuiButton buttonYes;
	protected GuiButton buttonNo;
	public GuiFactionRequest(EntityPlayer player) {
		this.player = player;
		this.buttonYes = new GuiButton(2, 6, 7, 40, 20, "Yes");
		this.buttonNo = new GuiButton(2, 6, 7, 40, 20, "No");
	}
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, player.getName() + " would like you to join their faction.", this.width / 2, this.height / 2 - 30, 0xFFFFF);
        this.drawCenteredString(this.fontRenderer, "Do you accept?", this.width / 2, this.height / 2 - 30, 0xFFFFF);
        this.buttonYes.drawButton(this.mc, mouseX, mouseY, partialTicks);
        this.buttonNo.drawButton(this.mc, mouseX, mouseY, partialTicks);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	public void initGui() {
		super.initGui();
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
	}
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	
}
