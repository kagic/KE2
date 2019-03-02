package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityPyrope;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPyrope<T extends EntityPyrope> extends RenderGem<T> {
	public RenderPyrope(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
