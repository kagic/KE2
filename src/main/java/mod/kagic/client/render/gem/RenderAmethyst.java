package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityAmethyst;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAmethyst<T extends EntityAmethyst> extends RenderGem<T> {
	public RenderAmethyst(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
