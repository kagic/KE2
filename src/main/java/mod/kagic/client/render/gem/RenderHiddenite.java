package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityHiddenite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderHiddenite<T extends EntityHiddenite> extends RenderGem<T> {
	public RenderHiddenite(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
