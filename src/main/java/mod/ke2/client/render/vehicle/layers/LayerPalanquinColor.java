package mod.ke2.client.render.vehicle.layers;

import mod.ke2.client.render.vehicle.RenderPalanquin;
import mod.ke2.entity.vehicle.EntityPalanquin;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerPalanquinColor implements LayerRenderer<EntityPalanquin> {
	private final RenderPalanquin renderer;
	
	public LayerPalanquinColor(RenderPalanquin renderer) {
		this.renderer = renderer;
	}
	
	@Override
	public void doRenderLayer(EntityPalanquin entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		float[] rgb = EnumDyeColor.byDyeDamage(entity.getBodyColor()).getColorComponentValues();
		if (!entity.isInvisible()) {
			this.renderer.bindTexture(new ResourceLocation("ke2:textures/entities/palanquin/palanquin.png"));
			GlStateManager.color(rgb[0], rgb[1], rgb[2], 1.0F);
			this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}