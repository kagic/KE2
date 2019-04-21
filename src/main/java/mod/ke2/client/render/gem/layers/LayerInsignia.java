package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerInsignia implements LayerRenderer<EntityGem> {
	private final RenderGem<?> renderer;
	public LayerInsignia(RenderGem<?> renderer) {
		this.renderer = renderer;
	}
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getOutfitVariant() != null && gem.getInsigniaColor() > -1) {
			this.renderer.bindTexture(new ResourceLocation(gem.getOutfitVariant() + "_insignia.png"));
			float[] color = EnumDyeColor.byDyeDamage(gem.getInsigniaColor()).getColorComponentValues();
			GlStateManager.color(color[0], color[1], color[2]);
	        this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
