package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPearl<T extends EntityPearl> extends RenderGem<T> {
	public RenderPearl(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
