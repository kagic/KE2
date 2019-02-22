package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityAgate;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAgate<T extends EntityAgate> extends RenderGem<T> {
	public RenderAgate(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
