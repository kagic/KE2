package mod.ke2.client.gui;

import java.io.IOException;

import mod.ke2.init.Ke2Messages;
import mod.ke2.networking.MessageFactionResponse;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class GuiFactionRequest extends GuiScreen {
	private final EntityPlayer requester;
	private final EntityPlayer responder;
	protected GuiButton buttonYes;
	protected GuiButton buttonNo;
	public GuiFactionRequest(EntityPlayer requester, EntityPlayer responder) {
		this.requester = requester;
		this.responder = responder;
		this.addButton(this.buttonYes = new GuiButton(0, 0, 0, 40, 20, "Yes"));
		this.addButton(this.buttonNo = new GuiButton(1, 0, 0, 40, 20, "No"));
	}
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, requester.getName() + " would like you to join their faction.", this.width / 2, this.height / 2 - 60, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Do you accept?", this.width / 2, this.height / 2 - 30, 0xFFFFFF);
        this.buttonYes.x = this.width / 2 + 5; this.buttonYes.y = this.height / 2;
        this.buttonYes.drawButton(this.mc, mouseX, mouseY, partialTicks);
        this.buttonNo.x = this.width / 2 - 45; this.buttonNo.y = this.height / 2;
        this.buttonNo.drawButton(this.mc, mouseX, mouseY, partialTicks);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.enabled) {
			switch (button.id) {
			case 1:
				Ke2Messages.INSTANCE.sendTo(new MessageFactionResponse(this.requester.getUniqueID(), this.responder.getUniqueID(), false), (EntityPlayerMP)(this.requester));
				break;
			case 0:
				Ke2Messages.INSTANCE.sendTo(new MessageFactionResponse(this.requester.getUniqueID(), this.responder.getUniqueID(), true), (EntityPlayerMP)(this.requester));
				break;
			}
			Minecraft.getMinecraft().player.closeScreen();
		}
	}
}
