package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityLarimar;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderLarimar<T extends EntityLarimar> extends RenderGem<T> {
	public RenderLarimar(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
