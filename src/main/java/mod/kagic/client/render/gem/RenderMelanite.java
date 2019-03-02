package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityMelanite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMelanite<T extends EntityMelanite> extends RenderGem<T> {
	public RenderMelanite(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
