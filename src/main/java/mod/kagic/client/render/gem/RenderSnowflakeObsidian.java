package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntitySnowflakeObsidian;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSnowflakeObsidian<T extends EntitySnowflakeObsidian> extends RenderGem<T> {
	public RenderSnowflakeObsidian(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
