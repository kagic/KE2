package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntitySerandite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSerandite<T extends EntitySerandite> extends RenderGem<T> {
	public RenderSerandite(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
