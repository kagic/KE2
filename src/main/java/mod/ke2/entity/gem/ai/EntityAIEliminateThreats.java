package mod.ke2.entity.gem.ai;

import mod.ke2.api.EntityGem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAIEliminateThreats extends EntityAITarget {
	private EntityGem gem;
    private EntityLivingBase attacker;
    private int timestamp;
    
    public EntityAIEliminateThreats(EntityGem gem) {
        super(gem, false);
        this.gem = gem;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase leader = this.gem.getLeader();
        if (leader != null) {
            this.attacker = leader.getLastAttackedEntity();
            int i = leader.getLastAttackedEntityTime();
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
            this.timestamp = leader.getLastAttackedEntityTime();
        }
        super.startExecuting();
    }
}
