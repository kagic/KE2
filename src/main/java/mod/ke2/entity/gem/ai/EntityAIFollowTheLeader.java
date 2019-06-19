package mod.ke2.entity.gem.ai;

import mod.ke2.api.EntityGem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;

public class EntityAIFollowTheLeader extends EntityAIBase {
	protected final double speed;
	protected final EntityGem follower;
	protected EntityLivingBase leader;
	protected Path pathToLeader;
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
			this.leader = leader;
			return true;
		}
		return false;
	}
	@Override
	public void startExecuting() {
		this.pathToLeader = this.follower.getNavigator().getPathToEntityLiving(this.leader);
		this.follower.getNavigator().setPath(this.pathToLeader, this.speed);
	}
	@Override
	public boolean shouldContinueExecuting() {
		return this.follower.hasPath();
	}
	@Override
	public void resetTask() {
		this.follower.getNavigator().clearPath();
		this.pathToLeader = null;
		this.leader = null;
	}
}
