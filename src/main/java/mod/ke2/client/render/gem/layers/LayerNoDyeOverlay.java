package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

public class LayerNoDyeOverlay implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> renderer;
	
	public LayerNoDyeOverlay(RenderLivingBase<?> renderer) {
		this.renderer = renderer;
	}
	
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getOutfitVariant() != null) {
			ResourceLocation texture = new ResourceLocation(gem.getOutfitVariant() + "_nodye.png");
			if (this.renderer.getRenderManager().renderEngine.getTexture(texture) != TextureUtil.MISSING_TEXTURE) {
				GlStateManager.color(1.0F, 1.0F, 1.0F);
				GlStateManager.scale(1.01F, 1.01F, 1.01F);
				GlStateManager.translate(0.0F, -0.005F, 0.0F);
				this.renderer.bindTexture(texture);
				this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
				GlStateManager.disableBlend();
			}
		}
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
