package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityPeridot;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPeridot<T extends EntityPeridot> extends RenderGem<T> {
	public RenderPeridot(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
