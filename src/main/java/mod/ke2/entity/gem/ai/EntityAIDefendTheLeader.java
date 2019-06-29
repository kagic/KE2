package mod.ke2.entity.gem.ai;

import mod.ke2.api.EntityGem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAIDefendTheLeader extends EntityAITarget {
	private EntityGem gem;
	private EntityLivingBase attacker;
	private int timestamp;
	
	public EntityAIDefendTheLeader(EntityGem gem) {
		super(gem, false);
		this.gem = gem;
		this.setMutexBits(1);
	}
	
	@Override
	public boolean shouldExecute() {
		EntityLivingBase leader = this.gem.getLeader();
		if (leader != null) {
			this.attacker = leader.getRevengeTarget();
			int i = leader.getRevengeTimer();
			if (i != this.timestamp) {
				return this.isSuitableTarget(this.attacker, false);
			}
		}
		return false;
	}
	
	@Override
	public void startExecuting() {
		this.taskOwner.setAttackTarget(this.attacker);
		EntityLivingBase leader = this.gem.getLeader();
		if (leader != null) {
			this.timestamp = leader.getRevengeTimer();
		}
		super.startExecuting();
	}
}
