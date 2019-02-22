package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityZircon;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderZircon<T extends EntityZircon> extends RenderGem<T> {
	public RenderZircon(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
