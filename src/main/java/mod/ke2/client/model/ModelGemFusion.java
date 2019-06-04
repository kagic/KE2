package mod.ke2.client.model;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGemFusion extends ModelGem {
	public ModelGemFusion(float modelSize, float offset, int width, int height) {
		super(modelSize, offset, width, height);
    }
}