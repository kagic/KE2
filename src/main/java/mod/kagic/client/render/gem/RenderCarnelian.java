package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCarnelian;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCarnelian<T extends EntityCarnelian> extends RenderGem<T> {
	public RenderCarnelian(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
