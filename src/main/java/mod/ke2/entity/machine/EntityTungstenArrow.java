package mod.ke2.entity.machine;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTungstenArrow extends EntityTippedArrow {
	public EntityTungstenArrow(World world) {
		super(world);
	}
	
	public EntityTungstenArrow(World world, double x, double y, double z) {
		super(world, x, y, z);
	}
	
	public EntityTungstenArrow(World world, EntityLivingBase shooter) {
		super(world, shooter);
	}
	@Override
	protected void onHit(RayTraceResult raytraceResult) {
		super.onHit(raytraceResult);
		if (this.isDead) { 
			this.isDead = false;
		}
	}
}
