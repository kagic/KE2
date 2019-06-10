package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerGemstone implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;
	public LayerGemstone(RenderGem<?> renderer) {
		this.renderer = renderer;
	}
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getGemstoneCut() > -1) {
            this.renderer.getModel().renderGemOnBody(gem.getGemstonePosition(), scale);
			int color = gem.getGemstoneColor();
			float r = ((color & 16711680) >> 16) / 255.0F;
	        float g = ((color & 65280) >> 8) / 255.0F;
	        float b = ((color & 255) >> 0) / 255.0F;
			GlStateManager.color(r, g, b);
            GlStateManager.pushMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translate(0, 0, -0.25);
			GlStateManager.scale(0.25, 0.25, 0.25);
            Minecraft.getMinecraft().getItemRenderer().renderItemSide(gem, gem.getGemstoneItem(), TransformType.FIXED, false);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
	        GlStateManager.disableBlend();
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
