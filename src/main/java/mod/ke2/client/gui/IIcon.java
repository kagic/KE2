package mod.ke2.client.gui;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IIcon
{
	@SideOnly(Side.CLIENT)
	int getIconWidth();

	@SideOnly(Side.CLIENT)
	int getIconHeight();

	@SideOnly(Side.CLIENT)
	float getMinU();

	@SideOnly(Side.CLIENT)
	float getMaxU();

	@SideOnly(Side.CLIENT)
	float getInterpolatedU(double p_94214_1_);

	@SideOnly(Side.CLIENT)
	float getMinV();

	@SideOnly(Side.CLIENT)
	float getMaxV();

	@SideOnly(Side.CLIENT)
	float getInterpolatedV(double p_94207_1_);

	@SideOnly(Side.CLIENT)
	String getIconName();
}
