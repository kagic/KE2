package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityRutile;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRutile<T extends EntityRutile> extends RenderGem<T> {
	public RenderRutile(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
