package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityCitrine;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCitrine<T extends EntityCitrine> extends RenderGem<T> {
	public RenderCitrine(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
