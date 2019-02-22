package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityRoseQuartz;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRoseQuartz<T extends EntityRoseQuartz> extends RenderGem<T> {
	public RenderRoseQuartz(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
