package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCancrinite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCancrinite<T extends EntityCancrinite> extends RenderGem<T> {
	public RenderCancrinite(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
