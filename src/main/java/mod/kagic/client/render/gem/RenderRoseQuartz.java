package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityRoseQuartz;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRoseQuartz<T extends EntityRoseQuartz> extends RenderGem<T> {
	public RenderRoseQuartz(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
