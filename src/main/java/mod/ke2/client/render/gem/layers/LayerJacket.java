package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

public class LayerJacket implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> renderer;
	public LayerJacket(RenderLivingBase<?> renderer) {
		this.renderer = renderer;
	}
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getOutfitVariant() != null) {
			ResourceLocation texture = new ResourceLocation(gem.getOutfitVariant() + "_jacket.png");
			if (this.renderer.getRenderManager().renderEngine.getTexture(texture) != TextureUtil.MISSING_TEXTURE) {
				this.renderer.bindTexture(texture);
				int color = gem.getOutfitColor();
				float r = ((color & 16711680) >> 16) / 255.0F;
				float g = ((color & 65280) >> 8) / 255.0F;
				float b = ((color & 255) >> 0) / 255.0F;
				GlStateManager.color(r, g, b);
				GlStateManager.scale(1.0F, 1.1F, 1.1F);
				GlStateManager.translate(0.0F, -0.05F, 0.0F);
		        this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		        GlStateManager.disableBlend();
			}
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
