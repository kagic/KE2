package mod.kagic.handles;

import com.google.common.base.Predicate;

import mod.kagic.entity.EntityGemQuartz;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleGuarding {
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent e) {
		if (e.getEntity() instanceof EntityMob) {
			EntityMob mob = (EntityMob)(e.getEntity());
			double height = mob.height;
			mob.tasks.addTask(0, new EntityAIAvoidEntity<EntityGemQuartz>(mob, EntityGemQuartz.class, new Predicate<EntityGemQuartz>() {
				@Override
				public boolean apply(EntityGemQuartz applicant) {
					return applicant.chargedByTakingDamageNotDelivering && height < applicant.height;
				}
			}, 16, 0.2D, 0.8D));
		}
	}
}
