package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityAgate;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAgate<T extends EntityAgate> extends RenderGem<T> {
	public RenderAgate(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
