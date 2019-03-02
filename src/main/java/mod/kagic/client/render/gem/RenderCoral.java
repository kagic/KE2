package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCoral;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCoral<T extends EntityCoral> extends RenderGem<T> {
	public RenderCoral(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
