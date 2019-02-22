package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityPeridot;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPeridot<T extends EntityPeridot> extends RenderGem<T> {
	public RenderPeridot(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
