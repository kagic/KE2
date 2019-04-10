package mod.ke2.client.render.gem.layers;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerGemstone implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;
	private final ArrayList<ResourceLocation> placements;
	public LayerGemstone(RenderGem<?> renderer, ArrayList<ResourceLocation> placements) {
		this.renderer = renderer;
		this.placements = placements;
	}
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		int max = gem.canGemstoneGlow() ? 2 : 1;	// Render twice IF GLOWING to create an backwhite
		for (int i = 0; max < i; ++i) {				// that highlights the gem and decreases gamma
			if (i == 2) {							// caused by underlying layers.
				GlStateManager.enableBlend();
		        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
		        GlStateManager.disableLighting();
		        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
		        GlStateManager.enableLighting();
			}
			this.renderer.bindTexture(this.placements.get(gem.getGemstoneCut()));
			int color = gem.getGemstoneColor();
			float r = ((color & 16711680) >> 16) / 255f;
	        float g = ((color & 65280) >> 8) / 255f;
	        float b = ((color & 255) >> 0) / 255f;
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
