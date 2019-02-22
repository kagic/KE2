package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCitrine;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCitrine<T extends EntityCitrine> extends RenderGem<T> {
	public RenderCitrine(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
