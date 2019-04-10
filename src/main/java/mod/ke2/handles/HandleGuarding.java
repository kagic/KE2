package mod.ke2.handles;

import com.google.common.base.Predicate;

import mod.ke2.entity.gem.AbstractQuartz;
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
			mob.tasks.addTask(0, new EntityAIAvoidEntity<AbstractQuartz>(mob, AbstractQuartz.class, new Predicate<AbstractQuartz>() {
				@Override
				public boolean apply(AbstractQuartz applicant) {
					return applicant.chargedByTakingDamageNotDelivering && height < applicant.height;
				}
			}, 16, 0.2D, 0.8D));
		}
	}
}
