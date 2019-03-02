package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntitySapphire;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSapphire<T extends EntitySapphire> extends RenderGem<T> {
	public RenderSapphire(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
