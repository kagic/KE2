package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityJade;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderJade<T extends EntityJade> extends RenderGem<T> {
	public RenderJade(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
