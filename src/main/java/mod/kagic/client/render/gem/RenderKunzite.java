package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityKunzite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderKunzite<T extends EntityKunzite> extends RenderGem<T> {
	public RenderKunzite(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
