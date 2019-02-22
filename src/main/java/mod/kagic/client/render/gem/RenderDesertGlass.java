package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityDesertGlass;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDesertGlass<T extends EntityDesertGlass> extends RenderGem<T> {
	public RenderDesertGlass(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
