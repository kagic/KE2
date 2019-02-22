package mod.kagic.client.render;

import mod.kagic.client.model.ModelHandShip;
import mod.kagic.entity.vehicle.EntityHandShip;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHandShip extends RenderLiving<EntityHandShip> {
	public RenderHandShip(RenderManager manager) {
		super(manager, new ModelHandShip(), 0.0F);
	}
	@Override
	protected void preRenderCallback(EntityHandShip ship, float partialTickTime) {
		super.preRenderCallback(ship, partialTickTime);
		GlStateManager.scale(32.0D, 32.0D, 32.0D);
		GlStateManager.translate(0, -0.5, 0);
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityHandShip entity) {
		return new ResourceLocation("kagic:textures/entities/gem_warship.png");
	}
}
