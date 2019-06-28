package mod.ke2.entity.gem.ai;

import mod.ke2.api.EntityGem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;

import java.util.List;

public class EntityAIDefendPlayer extends EntityAIBase {
	protected final double speed;
	protected final EntityGem follower;
	protected EntityLivingBase leader;
	protected Path pathToTarget;
	protected List<EntityLivingBase> mobs;
	protected EntityLivingBase target;

	public EntityAIDefendPlayer(EntityGem follower, double speed) {
		super();
		this.setMutexBits(3);
		this.follower = follower;
		this.speed = speed;
	}
	@Override
	public boolean shouldExecute() {
		if(this.follower.isDefender()) {
			List<EntityPlayer> players = this.follower.world.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, this.follower.getEntityBoundingBox().grow(24, 10, 24));
			EntityLivingBase leader = null;
			for (EntityPlayer player : players) {
				if (this.follower.isOwnedBy(player)) {
					leader = player;
					break;
				} else {
					leader = null;
				}
			}
			if (leader != null && this.follower.isDefender()) {
				this.leader = leader;
				List<EntityLivingBase> mobs = this.leader.world.<EntityLivingBase>getEntitiesWithinAABB(EntityMob.class, this.leader.getEntityBoundingBox().grow(5, 2, 5));
				this.mobs = mobs;
				if (!mobs.isEmpty()) {
					return true;
				}
			}
		}
		else{
			return false;
		}
		return false;
	}
	@Override
	public void startExecuting() {
		if(this.target == null) {
			for (EntityLivingBase base : this.mobs) {
				this.target = base; //Goes to bottom of list, probably not the most efficient way of doing things but it works pretty well.
			}
			this.pathToTarget = this.follower.getNavigator().getPathToEntityLiving(this.target);
		}
		else{
			this.pathToTarget = this.follower.getNavigator().getPathToEntityLiving(this.target);
		}
		this.follower.getNavigator().setPath(this.pathToTarget, this.speed);
	}
	@Override
	public boolean shouldContinueExecuting() {
		return this.follower.hasPath() && !this.mobs.isEmpty();
	}
	@Override
	public void resetTask() {
		this.follower.getNavigator().clearPath();
		this.pathToTarget = null;
		this.leader = null;
		this.mobs = null;
		this.target = null;
	}
}
