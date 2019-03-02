package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityJade;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderJade<T extends EntityJade> extends RenderGem<T> {
	public RenderJade(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
