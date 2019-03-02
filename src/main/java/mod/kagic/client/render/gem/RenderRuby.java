package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityRuby;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRuby<T extends EntityRuby> extends RenderGem<T> {
	public RenderRuby(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
