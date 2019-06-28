package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

public class LayerVisor implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;

	public LayerVisor(RenderGem<?> renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getOutfitVariant() != null) {
			ResourceLocation texture = new ResourceLocation(gem.getOutfitVariant() + "_visor.png");
			if (this.renderer.getRenderManager().renderEngine.getTexture(texture) != TextureUtil.MISSING_TEXTURE) {
				this.renderer.bindTexture(texture);
				GlStateManager.enableNormalize();
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				int color = gem.getVisorColor();
				float r = ((color & 16711680) >> 16) / 255.0F;
				float g = ((color & 65280) >> 8) / 255.0F;
				float b = ((color & 255) >> 0) / 255.0F;
				GlStateManager.color(r, g, b);
				this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
				GlStateManager.disableBlend();
				GlStateManager.disableNormalize();
			}
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}