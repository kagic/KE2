package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityEmerald;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEmerald<T extends EntityEmerald> extends RenderGem<T> {
	public RenderEmerald(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
