package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCoral;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCoral<T extends EntityCoral> extends RenderGem<T> {
	public RenderCoral(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
