package mod.ke2.client.render.gem.layers;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerJacket implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> renderer;
	private final ArrayList<ResourceLocation> jackets;
	public LayerJacket(RenderLivingBase<?> renderer, ArrayList<ResourceLocation> jackets) {
		this.renderer = renderer;
		this.jackets = jackets;
	}
	
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (!this.jackets.isEmpty() && gem.getJacketVariant() > -1) {
			this.renderer.bindTexture(this.jackets.get(gem.getJacketVariant()));
			int jacket = gem.getUniformColor();
			float r = ((jacket & 16711680) >> 16) / 255f;
			float g = ((jacket & 65280) >> 8) / 255f;
			float b = ((jacket & 255) >> 0) / 255f;
			GlStateManager.color(r, g, b);
	        this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
