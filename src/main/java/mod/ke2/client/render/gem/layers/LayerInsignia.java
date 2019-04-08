package mod.ke2.client.render.gem.layers;

import java.util.ArrayList;

import mod.ke2.entity.EntityGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerInsignia implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> renderer;
	private final ArrayList<ResourceLocation> insignias;
	public LayerInsignia(RenderLivingBase<?> renderer, ArrayList<ResourceLocation> insignias) {
		this.renderer = renderer;
		this.insignias = insignias;
	}
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (!this.insignias.isEmpty() && gem.getInsigniaVariant() > -1) {
			this.renderer.bindTexture(this.insignias.get(gem.getInsigniaVariant()));
			float[] color = EnumDyeColor.byDyeDamage(gem.getInsigniaColor()).getColorComponentValues();
			GlStateManager.color(color[0], color[1], color[2]);
	        this.renderer.getMainModel().render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
