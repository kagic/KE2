package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityLapisLazuli;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderLapisLazuli<T extends EntityLapisLazuli> extends RenderGem<T> {
	public RenderLapisLazuli(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
