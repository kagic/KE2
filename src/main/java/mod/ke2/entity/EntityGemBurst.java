package mod.ke2.entity;

import java.util.List;

import mod.ke2.api.EntityGem;
import mod.ke2.init.KAGIC;
import mod.ke2.init.Ke2Particles;
import mod.ke2.init.Ke2Sounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;

public class EntityGemBurst extends EntityGem {
	public EntityGemBurst(World world) {
		super(world);
		this.setSize(1.0F, 2.0F);
	}
	@Override
	public void onUpdate() {
		List<EntityLivingBase> entities = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().grow(6.0, 2.0, 6.0));
		for (EntityLivingBase entity : entities) {
			if (!entity.equals(this) && !entity.isImmuneToFire()) {
				entity.setFire(5);
			}
		}
		if (!this.hasNoGravity()) {
			this.world.newExplosion(this, this.posX, this.posY, this.posZ, 6.0F, true, false);
			this.playSound(Ke2Sounds.GEM_BURST, 16.0F, 1.0F);
			this.setNoGravity(true);
		}
		if (this.ticksExisted > 200) {
			this.setDead();
		}
		else {
			int color = this.getInsigniaColor() == -1 ? this.rand.nextInt(16) : this.getInsigniaColor();
			for (int i = 0; i < 128; ++i) {
				KAGIC.proxy.addParticle(Ke2Particles.SHARD, this.world,
					this.posX + this.rand.nextDouble() - 0.5, this.posY + this.rand.nextDouble() - 0.5, this.posZ + this.rand.nextDouble() - 0.5,
					this.rand.nextDouble() * 1.5 - 0.5, this.rand.nextDouble() * 1.5 - 0.5, this.rand.nextDouble() * 1.5 - 0.5,
					EnumDyeColor.values()[color].getColorValue()
				);
			}
		}
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
