package mod.ke2.client.render.vehicle;

import mod.ke2.client.model.vehicle.ModelPalanquin;
import mod.ke2.client.render.vehicle.layers.LayerPalanquinColor;
import mod.ke2.client.render.vehicle.layers.LayerPalanquinHighlights;
import mod.ke2.client.render.vehicle.layers.LayerPalanquinVeil;
import mod.ke2.entity.vehicle.EntityPalanquin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPalanquin extends RenderLiving<EntityPalanquin> {
	public RenderPalanquin(RenderManager manager) {
		super(manager, new ModelPalanquin(), 0.5F);
		this.layerRenderers.add(new LayerPalanquinColor(this));
		this.layerRenderers.add(new LayerPalanquinHighlights(this));
		this.layerRenderers.add(new LayerPalanquinVeil(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPalanquin entity) {
		return new ResourceLocation("ke2:textures/entities/none/null.png");
	}
}
