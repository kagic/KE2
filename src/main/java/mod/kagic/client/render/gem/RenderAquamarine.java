package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityAquamarine;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAquamarine<T extends EntityAquamarine> extends RenderGem<T> {
	public RenderAquamarine(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
