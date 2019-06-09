package mod.ke2.potion;

import mod.ke2.init.Ke2Potions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionTempermental extends Potion {
	public static final PotionType TEMPERMENT      = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.TEMPERMENTAL, 7200, 1) });
	public PotionTempermental() {
		super(true, 0x438197);
		this.setPotionName("effect.tempermental");
		this.setIconIndex(-1, -1);
		this.setBeneficial();
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(PotionEffect effect, Gui gui, int x, int y, float z) {
	    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("ke2:textures/effects/tempermental.png"));
		Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
	}
}
