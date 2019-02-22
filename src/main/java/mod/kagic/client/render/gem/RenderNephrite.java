package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityNephrite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderNephrite<T extends EntityNephrite> extends RenderGem<T> {
	public RenderNephrite(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
