package mod.ke2.client.render.gem.layers;

import mod.ke2.entity.gem.AbstractQuartz;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerEyes implements LayerRenderer<AbstractQuartz> {
	private final RenderLivingBase<?> renderer;

	public LayerEyes(RenderLivingBase<?> renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(AbstractQuartz quartz, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (quartz.getEyesVariant() != null) {
			ResourceLocation texture = new ResourceLocation(quartz.getEyesVariant() + ".png");
			this.renderer.bindTexture(texture);
			int color = quartz.getEyesColor();
			float r = ((color & 16711680) >> 16) / 255.0F;
			float g = ((color & 65280) >> 8) / 255.0F;
			float b = ((color & 255) >> 0) / 255.0F;
			GlStateManager.color(r, g, b);
			this.renderer.getMainModel().render(quartz, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
