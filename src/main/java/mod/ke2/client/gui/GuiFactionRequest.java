package mod.ke2.client.gui;

import java.io.IOException;

import mod.ke2.init.Ke2Messages;
import mod.ke2.networking.MessageFactionResponse;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuiFactionRequest extends GuiScreen {
	private final EntityPlayer requester;
	private final EntityPlayer responder;

	public GuiFactionRequest(EntityPlayer requester, EntityPlayer responder) {
		this.requester = requester;
		this.responder = responder;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if (this.buttonList.size() == 2) {
			this.drawDefaultBackground();
			this.drawCenteredString(this.fontRenderer, this.requester.getName() + " would like you to join their faction.", this.width / 2, this.height / 2 - 60, 0xFFFFFF);
			this.drawCenteredString(this.fontRenderer, "Do you accept?", this.width / 2, this.height / 2 - 30, 0xFFFFFF);
			this.buttonList.get(0).x = this.width / 2 - 55;
			this.buttonList.get(0).y = this.height / 2;
			this.buttonList.get(1).x = this.width / 2 + 10;
			this.buttonList.get(1).y = this.height / 2;
			super.drawScreen(mouseX, mouseY, partialTicks);
		} else {
			this.addButton(new GuiButton(0, 0, 0, 50, 20, "Yes"));
			this.addButton(new GuiButton(1, 0, 0, 50, 20, "No"));
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		Minecraft.getMinecraft().player.closeScreen();
		if (button.id == 0) {
			Ke2Messages.INSTANCE.sendToServer(new MessageFactionResponse(this.requester.getUniqueID(), this.responder.getUniqueID(), false));
		} else {
			Ke2Messages.INSTANCE.sendToServer(new MessageFactionResponse(this.requester.getUniqueID(), this.responder.getUniqueID(), true));
		}
	}
}
