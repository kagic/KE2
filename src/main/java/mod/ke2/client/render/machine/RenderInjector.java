package mod.ke2.client.render.machine;

import mod.ke2.client.model.machine.ModelInjector;
import mod.ke2.entity.machine.EntityInjector;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class RenderInjector extends RenderLiving<EntityInjector> {
	public RenderInjector(RenderManager manager) {
		super(manager, new ModelInjector(), 0.25F);
		this.addLayer(new LayerInjectorGlass(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityInjector entity) {
		return new ResourceLocation("ke2:textures/entities/injector/injector.png");
	}
	
	public static class LayerInjectorGlass implements LayerRenderer<EntityInjector> {
		private final RenderInjector renderer;
		
		public LayerInjectorGlass(RenderInjector renderer) {
			this.renderer = renderer;
		}
		
		@Override
		public void doRenderLayer(EntityInjector entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
			float[] rgb = EnumDyeColor.byDyeDamage(entity.getColor()).getColorComponentValues();
			if (!entity.isInvisible()) {
				this.renderer.bindTexture(new ResourceLocation("ke2:textures/entities/injector/glass.png"));
				GlStateManager.color(rgb[0], rgb[1], rgb[2], 0.5F);
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
				this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			}
		}
		
		@Override
		public boolean shouldCombineTextures() {
			return false;
		}
	}
}
