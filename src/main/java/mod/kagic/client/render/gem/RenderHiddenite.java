package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityHiddenite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderHiddenite<T extends EntityHiddenite> extends RenderGem<T> {
	public RenderHiddenite(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
