package mod.ke2.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionLove extends Potion {
	public PotionLove() {
		super(true, 0xe2a5e4);
		this.setPotionName("effect.love");
		this.setIconIndex(-1, -1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(PotionEffect effect, Gui gui, int x, int y, float z) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("ke2:textures/potions/love.png"));
		Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUDEffect(PotionEffect effect, Gui gui, int x, int y, float z, float alpha) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("ke2:textures/potions/love.png"));
		Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
	}
}
