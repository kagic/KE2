package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityEmerald;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEmerald<T extends EntityEmerald> extends RenderGem<T> {
	public RenderEmerald(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
