package mod.ke2.client.render.vehicle;

import mod.ke2.client.model.vehicle.ModelVan;
import mod.ke2.client.render.RenderGem;
import mod.ke2.entity.vehicle.EntityVan;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVan extends RenderLiving<EntityVan> {
	public RenderVan(RenderManager manager) {
		super(manager, new ModelVan(), 0.0F);
	}

	@Override
	protected void preRenderCallback(EntityVan entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		GlStateManager.translate(0.0F, 1.0625F, 0.0F);
		GlStateManager.scale(1.7F, 1.7F, 1.7F);
		try {
			if (RenderGem.updateModelsDespiteTheFactItCausesMemoryLeaks && partialTickTime > 0.9F) {
				this.mainModel = this.mainModel.getClass().newInstance();
			}
		} catch (Exception e) {
			RenderGem.updateModelsDespiteTheFactItCausesMemoryLeaks = false;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityVan entity) {
		return new ResourceLocation("ke2:textures/entities/van.png");
	}
}
