package mod.ke2.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class GuiWarpPadContainer extends Container {
	public GuiWarpPadContainer() {
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
}
