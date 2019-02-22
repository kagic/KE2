package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityPyrope;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPyrope<T extends EntityPyrope> extends RenderGem<T> {
	public RenderPyrope(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
