package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityLarimar;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderLarimar<T extends EntityLarimar> extends RenderGem<T> {
	public RenderLarimar(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
