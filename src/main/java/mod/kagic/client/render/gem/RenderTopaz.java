package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityTopaz;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderTopaz<T extends EntityTopaz> extends RenderGem<T> {
	public RenderTopaz(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
