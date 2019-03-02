package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityZircon;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderZircon<T extends EntityZircon> extends RenderGem<T> {
	public RenderZircon(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
