package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityNephrite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderNephrite<T extends EntityNephrite> extends RenderGem<T> {
	public RenderNephrite(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
