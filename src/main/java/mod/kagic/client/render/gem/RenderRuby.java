package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityRuby;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRuby<T extends EntityRuby> extends RenderGem<T> {
	public RenderRuby(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
