package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntitySapphire;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSapphire<T extends EntitySapphire> extends RenderGem<T> {
	public RenderSapphire(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
