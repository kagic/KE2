package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerUniform implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;

	public LayerUniform(RenderGem<?> renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getOutfitVariant() != null) {
			this.renderer.bindTexture(new ResourceLocation(gem.getOutfitVariant() + "_uniform.png"));
			int color = gem.getOutfitColor();
			float r = ((color & 16711680) >> 16) / 255.0F;
			float g = ((color & 65280) >> 8) / 255.0F;
			float b = ((color & 255) >> 0) / 255.0F;
			GlStateManager.color(r, g, b);
			this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
