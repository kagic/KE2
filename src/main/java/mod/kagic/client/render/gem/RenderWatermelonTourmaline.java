package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityWatermelonTourmaline;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderWatermelonTourmaline<T extends EntityWatermelonTourmaline> extends RenderGem<T> {
	public RenderWatermelonTourmaline(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
