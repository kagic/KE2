package mod.ke2.entity.gem.ai;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.Vec3d;

public class EntityAIFollowTheLeader extends EntityAIBase {
	protected final double speed;
	protected final EntityGem follower;
	protected EntityLivingBase leader;
	protected Path pathToLeader;
	protected boolean transitToBlock;
	public EntityAIFollowTheLeader(EntityGem follower, double speed) {
		super();
		this.setMutexBits(3);
		this.follower = follower;
		this.speed = speed;
	}
	@Override
	public boolean shouldExecute() {
		EntityLivingBase leader = this.follower.getLeader();
		if (leader != null && !this.follower.equals(leader)) {
			float distance = this.follower.getDistance(leader);
			if (distance > 3.0F) {
				if (distance > 144.0F) {
					this.transitToBlock = true;
				}
				this.leader = leader;
				return true;
			}
		}
		return false;
	}
	@Override
	public void startExecuting() {
		if (this.transitToBlock) {
			Vec3d step = RandomPositionGenerator.findRandomTargetBlockTowards(this.follower, 8, 8, this.leader.getPositionVector());
			if (step != null) {
				this.pathToLeader = this.follower.getNavigator().getPathToXYZ(step.x, step.y, step.z);
			}
			else {
				return;
			}
		} else {
			this.pathToLeader = this.follower.getNavigator().getPathToEntityLiving(this.leader);
		}
		this.follower.getNavigator().setPath(this.pathToLeader, this.speed);
	}
	@Override
	public boolean shouldContinueExecuting() {
		return this.follower.hasPath() && (!this.transitToBlock && this.follower.getDistance(this.leader) > 3.0F);
	}
	@Override
	public void resetTask() {
		this.follower.getNavigator().clearPath();
		this.transitToBlock = false;
		this.pathToLeader = null;
		this.leader = null;
	}
}
