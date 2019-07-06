package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;

public class LayerFlower implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;

	public LayerFlower(RenderGem<?> renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getOutfitVariant() != null) {
			BlockRendererDispatcher block = Minecraft.getMinecraft().getBlockRendererDispatcher();
			this.renderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			GlStateManager.enableCull();
			GlStateManager.cullFace(GlStateManager.CullFace.FRONT);
			GlStateManager.pushMatrix();
			this.renderer.getModel().bipedHead.postRender(0.0625F);
			GlStateManager.scale(1.0F, -1.0F, 1.0F);
			GlStateManager.translate(-0.45F, 0.2F, -0.25F);
			GlStateManager.rotate(-80.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(20.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.pushMatrix();
			GlStateManager.translate(-0.5F, -0.5F, 0.5F);
			block.renderBlockBrightness(Block.getStateById(gem.getFlowerInHair()), 1.0F);
			GlStateManager.popMatrix();
			GlStateManager.popMatrix();
			GlStateManager.cullFace(GlStateManager.CullFace.BACK);
			GlStateManager.disableCull();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
