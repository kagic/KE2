package mod.kagic.handles;

import mod.kagic.entity.EntityGem;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper.UnableToAccessFieldException;

@SuppressWarnings("deprecation")
public class HandleLoot {
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		Entity source = event.getSource().getTrueSource();
		if (source instanceof EntityGem) {
			try {
				ReflectionHelper.<EntityLivingBase, Integer>setPrivateValue(EntityLivingBase.class, event.getEntityLiving(), 100, "recentlyHit", "field_70718_bc", "aT");
			} catch (UnableToAccessFieldException e) {
				CrashReport.makeCrashReport(e, "Deprecated code on LINE 19 has failed, please report to @akrivus#1337.");
			}
		}
	}
}
