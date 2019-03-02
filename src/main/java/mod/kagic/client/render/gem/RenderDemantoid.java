package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityDemantoid;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDemantoid<T extends EntityDemantoid> extends RenderGem<T> {
	public RenderDemantoid(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
