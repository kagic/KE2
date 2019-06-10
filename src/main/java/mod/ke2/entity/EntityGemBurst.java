package mod.ke2.entity;

import java.util.List;

import mod.ke2.KAGIC;
import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Items;
import mod.ke2.init.Ke2Particles;
import mod.ke2.init.Ke2Sounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
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
		int color = this.getInsigniaColor() == -1 ? this.rand.nextInt(16) : this.getInsigniaColor();
		List<EntityLivingBase> entities = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().grow(6.0, 2.0, 6.0));
		for (EntityLivingBase entity : entities) {
			if (!entity.equals(this) && !entity.isImmuneToFire() && entity.canEntityBeSeen(this)) {
				entity.setFire(5);
			}
			if (entity instanceof EntitySheep) {
				entity.setCustomNameTag("jeb_");
			}
		}
		if (!this.hasNoGravity()) {
			this.world.newExplosion(this, this.posX, this.posY, this.posZ, 6.0F, true, false);
			this.playSound(Ke2Sounds.GEM_BURST, 3.0F, 1.0F);
			this.setNoGravity(true);
		}
		if (this.ticksExisted > 200) {
			if (!this.world.isRemote) {
				this.dropItem(Ke2Items.GEM_DUST, 1);
			}
			this.setDead();
		}
		else {
			for (int i = 0; i < 48; ++i) {
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
	@Override
	public int generateGemstoneCut() {
		return -1;
	}
}
