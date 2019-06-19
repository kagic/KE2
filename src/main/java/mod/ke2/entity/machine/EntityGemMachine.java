package mod.ke2.entity.machine;

import java.util.UUID;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityGemMachine extends EntityCreature {
	private EntityPlayer playerBeingFollowed;

	public EntityGemMachine(World world) {
		super(world);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		if (this.getPlayerUUIDBeingFollowed() != null) {
			compound.setUniqueId("PlayerBeingFollowed", this.getPlayerUUIDBeingFollowed());
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setPlayerUUIDBeingFollowed(compound.getUniqueId("PlayerBeingFollowed"));
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		return;
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() != null || source == DamageSource.CRAMMING || source == DamageSource.OUT_OF_WORLD || source == DamageSource.DROWN || source == DamageSource.MAGIC || source == DamageSource.WITHER) {
			return super.attackEntityFrom(source, amount);
		}
		return false;
	}

	public void setPlayerUUIDBeingFollowed(UUID uuid) {
		this.playerBeingFollowed = this.world.getPlayerEntityByUUID(uuid);
	}

	public UUID getPlayerUUIDBeingFollowed() {
		if (this.playerBeingFollowed != null) {
			return this.playerBeingFollowed.getUniqueID();
		} else {
			return null;
		}
	}

	public void setPlayerBeingFollowed(EntityPlayer player) {
		this.playerBeingFollowed = player;
	}

	public EntityPlayer getPlayerBeingFollowed() {
		return this.playerBeingFollowed;
	}

	public void say(EntityPlayer player, String line) {
		player.sendMessage(new TextComponentString("<" + this.getName() + "> " + line));
	}
}
