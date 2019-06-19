package mod.ke2.client.render.vehicle;

import mod.ke2.client.model.vehicle.ModelHandShip;
import mod.ke2.entity.vehicle.EntityHandShip;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHandShip extends RenderLiving<EntityHandShip> {
	public RenderHandShip(RenderManager manager) {
		super(manager, new ModelHandShip(), 0.0F);
	}

	@Override
	protected void preRenderCallback(EntityHandShip entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		GlStateManager.scale(32.0D, 32.0D, 32.0D);
		GlStateManager.translate(0, -0.5, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityHandShip entity) {
		return new ResourceLocation("ke2:textures/entities/gem_warship.png");
	}
}
