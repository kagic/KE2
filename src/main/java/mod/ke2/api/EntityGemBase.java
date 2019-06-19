package mod.ke2.api;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityGemBase extends EntityCreature {
	public EntityGemBase(World world) {
		super(world);
		this.experienceValue = 5;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	}

	@Override
	public void onLivingUpdate() {
		this.updateArmSwingProgress();
		super.onLivingUpdate();
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return this.isEntityInvulnerable(source) ? false : super.attackEntityFrom(source, amount);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		double damage = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int knockback = 0;
		if (entity instanceof EntityLivingBase) {
			damage += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entity).getCreatureAttribute());
			knockback += EnchantmentHelper.getKnockbackModifier(this);
		}
		boolean causingDamage = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) damage);
		if (causingDamage) {
			if (knockback > 0 && entity instanceof EntityLivingBase) {
				((EntityLivingBase) entity).knockBack(this, knockback * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), -MathHelper.cos(this.rotationYaw * 0.017453292F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			int fire = EnchantmentHelper.getFireAspectModifier(this);
			if (fire > 0) {
				entity.setFire(fire * 4);
			}
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				ItemStack mainStack = this.getHeldItemMainhand();
				ItemStack offStack = player.isHandActive() ? player.getActiveItemStack() : ItemStack.EMPTY;
				if (!mainStack.isEmpty() && !offStack.isEmpty() && mainStack.getItem().canDisableShield(mainStack, offStack, player, this) && offStack.getItem().isShield(offStack, player)) {
					float modifier = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
					if (this.rand.nextFloat() < modifier) {
						player.getCooldownTracker().setCooldown(offStack.getItem(), 100);
						this.world.setEntityState(player, (byte) 30);
					}
				}
			}
			this.applyEnchantments(this, entity);
		}
		return causingDamage;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_HOSTILE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_HOSTILE_DEATH;
	}

	@Override
	protected SoundEvent getFallSound(int height) {
		return height > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
	}

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_HOSTILE_SWIM;
	}

	@Override
	protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_HOSTILE_SPLASH;
	}

	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.PLAYERS;
	}
}
