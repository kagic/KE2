package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityTopaz;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderTopaz<T extends EntityTopaz> extends RenderGem<T> {
	public RenderTopaz(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
