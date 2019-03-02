package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityMotherOfPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMotherOfPearl<T extends EntityMotherOfPearl> extends RenderGem<T> {
	public RenderMotherOfPearl(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
