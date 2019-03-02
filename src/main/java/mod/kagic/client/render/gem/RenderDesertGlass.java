package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityDesertGlass;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDesertGlass<T extends EntityDesertGlass> extends RenderGem<T> {
	public RenderDesertGlass(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
