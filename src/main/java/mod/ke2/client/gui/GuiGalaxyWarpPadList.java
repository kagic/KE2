package mod.ke2.client.gui;

import java.util.Iterator;
import java.util.SortedMap;

import mod.kagic.worlddata.GalaxyPadLocation;
import mod.kagic.worlddata.WarpPadDataEntry;
import mod.ke2.init.Ke2Packets;
import mod.ke2.networking.PacketGalaxyWarpPadSignal;
import mod.ke2.networking.PacketWarpPadSignal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

public class GuiGalaxyWarpPadList extends GuiListExtended {
	private final Minecraft mc;
	private final GuiGalaxyWarpPadSelection selectionScreen;
	private final GuiListExtended.IGuiListEntry[] padListEntries;

	public GuiGalaxyWarpPadList(GuiGalaxyWarpPadSelection parent, BlockPos sourcePos, SortedMap<Double, GalaxyWarpPadPos> positions, Minecraft mcIn, int widthIn, int heightIn, int topIn, int bottomIn, int slotHeightIn) {
		super(mcIn, widthIn, heightIn, topIn + 30, bottomIn - 30, slotHeightIn);
		this.mc = mcIn;
		this.selectionScreen = parent;
		this.padListEntries = new GuiListExtended.IGuiListEntry[positions.size()];

		Iterator it = positions.values().iterator();
		int i = 0;
		while (it.hasNext()) {
			GalaxyWarpPadPos gLoc = (GalaxyWarpPadPos) it.next();
			WarpPadDataEntry data = this.selectionScreen.getPadDataEntry(gLoc);
			padListEntries[i] = new PadListEntry(sourcePos, gLoc, data);
			++i;
		}
	}

	@Override
	public IGuiListEntry getListEntry(int index) {
		return this.padListEntries[index];
	}

	@Override
	protected int getSize() {
		return this.padListEntries.length;
	}

	
	
	public class PadListEntry implements GuiListExtended.IGuiListEntry {
		private final BlockPos sourcePos;
		private final GalaxyWarpPadPos padPos;
		private final WarpPadDataEntry padData;
		private final GuiButton padButton;

		PadListEntry(BlockPos sourcePos, GalaxyWarpPadPos gLoc, WarpPadDataEntry data) {
			this.sourcePos = sourcePos;
			this.padPos = gLoc;
			this.padData = data;
			this.padButton = new GuiButton(0, 0, 0, 200, 20, this.padData.name);
		}

		@Override
		public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected, float partialTicks) {
			this.padButton.x = GuiGalaxyWarpPadList.this.mc.currentScreen.width / 2 - this.padButton.width / 2;
			this.padButton.y = y + 10;
			if (!this.padData.valid) {
				this.padButton.displayString = TextFormatting.RED + this.padData.name;
				this.padButton.enabled = false;
			} else if (!this.padData.clear) {
				this.padButton.displayString = TextFormatting.YELLOW + this.padData.name;
				this.padButton.enabled = false;
			} else {
				this.padButton.displayString = TextFormatting.AQUA + this.padData.name;
			}
			this.padButton.drawButton(GuiGalaxyWarpPadList.this.mc, mouseX, mouseY, partialTicks);
		}

		@Override
		public boolean mousePressed(int slotIndex, int mouseX, int mouseY, int mouseEvent, int relativeX, int relativeY) {
			if (this.padButton.mousePressed(GuiGalaxyWarpPadList.this.mc, mouseX, mouseY)) {
				Ke2Packets.INSTANCE.sendToServer(new PacketGalaxyWarpPadSignal(this.sourcePos, this.padPos));
				Minecraft.getMinecraft().player.closeScreen();
				return true;
			}
			return false;
		}

		@Override
		public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {
			this.padButton.mouseReleased(x, y);
		}

		@Override
		public void updatePosition(int p_192633_1_, int p_192633_2_, int p_192633_3_, float p_192633_4_) {
			// TODO Auto-generated method stub
			
		}	
	}
}
