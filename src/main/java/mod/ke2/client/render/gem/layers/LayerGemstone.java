package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerGemstone implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;

	public LayerGemstone(RenderGem<?> renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getGemstoneCut() > -1) {
			GlStateManager.pushMatrix();
			this.renderer.getModel().renderGemOnBody(gem.getGemstonePosition(), renderer.getModel().getGemRenderScale(gem.getGemstonePosition()));
			Minecraft.getMinecraft().getItemRenderer().renderItemSide(gem, gem.getGemstoneItem(), ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, false);
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
