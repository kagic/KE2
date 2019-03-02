package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityKunzite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderKunzite<T extends EntityKunzite> extends RenderGem<T> {
	public RenderKunzite(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
