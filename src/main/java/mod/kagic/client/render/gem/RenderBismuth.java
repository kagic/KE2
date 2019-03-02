package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityBismuth;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBismuth<T extends EntityBismuth> extends RenderGem<T> {
	public RenderBismuth(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
	}
}
