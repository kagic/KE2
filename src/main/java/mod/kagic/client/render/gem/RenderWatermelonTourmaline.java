package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityWatermelonTourmaline;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderWatermelonTourmaline<T extends EntityWatermelonTourmaline> extends RenderGem<T> {
	public RenderWatermelonTourmaline(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
