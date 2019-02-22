package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCarnelian;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCarnelian<T extends EntityCarnelian> extends RenderGem<T> {
	public RenderCarnelian(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
