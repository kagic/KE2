package mod.ke2.client.gui;

import java.io.IOException;

import mod.ke2.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiManual extends GuiScreen {

	final ResourceLocation texture = new ResourceLocation(KAGIC.MODID, "textures/gui/dictionary.png");
	int guiWidth = 146;
	int guiHeight = 180;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
		int centreX = this.width / 2 - this.guiWidth / 2;
		int centreY = this.height / 2 - this.guiHeight / 2;
		this.drawTexturedModalRect(centreX, centreY, 0, 0, this.guiWidth, this.guiHeight);
		this.drawString(this.mc.fontRenderer, "Test!", centreX + 15, centreY + 15, 0xffffff);
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
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

}
