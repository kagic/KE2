package mod.ke2.api;

import java.util.Iterator;

import mod.ke2.init.Ke2Gems;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class EntityGemFusion extends EntityGem {
	protected static final DataParameter<NBTTagCompound> FUSION_COMPONENTS = EntityDataManager.<NBTTagCompound>createKey(EntityGemFusion.class, DataSerializers.COMPOUND_TAG);
	protected static final DataParameter<Integer> FUSION_GEM_COUNT = EntityDataManager.<Integer>createKey(EntityGemFusion.class, DataSerializers.VARINT);
	public EntityGemFusion(World world) {
		super(world);
		this.dataManager.register(FUSION_COMPONENTS, new NBTTagCompound());
		this.dataManager.register(FUSION_GEM_COUNT, 0);
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setFusionComponents(compound.getCompoundTag("FusionComponents"));
		this.setFusionGemCount(compound.getInteger("FusionGemCount"));
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setTag("FusionComponents", this.getFusionComponents());
		compound.setInteger("FusionGemCount", this.getFusionGemCount());
	}
	public void setFusionComponents(NBTTagCompound compound) {
		this.dataManager.set(FUSION_COMPONENTS, compound);
	}
	public NBTTagCompound getFusionComponents() {
		return this.dataManager.get(FUSION_COMPONENTS);
	}
	public void setFusionGemCount(int count) {
		this.dataManager.set(FUSION_GEM_COUNT, count);
	}
	public int getFusionGemCount() {
		return this.dataManager.get(FUSION_GEM_COUNT);
	}
	public EnumFacing getGemstoneDirection(int i) {
		Iterator<String> it = this.getFusionComponents().getKeySet().iterator();
		int index = 0;
		while (it.hasNext()) {
			if (index == i) {
				return EnumFacing.byName(this.getFusionComponents().getCompoundTag(it.next()).getString("GemDirection"));
			}
			++index;
		}
		return EnumFacing.NORTH;
	}
	public int getGemstonePosition(int i) {
		Iterator<String> it = this.getFusionComponents().getKeySet().iterator();
		int index = 0;
		while (it.hasNext()) {
			if (index == i) {
				return this.getFusionComponents().getCompoundTag(it.next()).getInteger("GemPosition");
			}
			++index;
		}
		return 0;
	}
	public float getScaleFactor() {
		float scale = this.getFusionGemCount();
		if (this.changesScaleBasedOnCondition) {
			Iterator<String> it = this.getFusionComponents().getKeySet().iterator();
			while (it.hasNext()) {
				NBTTagCompound compound = this.getFusionComponents().getCompoundTag(it.next());
				if (compound.getBoolean("Defective")) {
					scale -= 1;
				}
				if (compound.getBoolean("Perfective")) {
					scale += 1;
				}
			}
		}
		scale /= this.getFusionGemCount();
		return scale;
	}
	public boolean fuse(EntityGem gem) {
		NBTTagCompound compound = new NBTTagCompound();
		gem.writeEntityToNBT(compound);
		this.getFusionComponents().setTag(gem.getGemGlobalID().toString(), compound);
		this.setGemAlignment(gem.getGemAlignment());
		this.setGemOwnerID(gem.getGemOwnerID());
		this.setGemLeaderID(gem.getGemLeaderID());
		if (this.getFusionGemCount() > 0) {
			this.setLocationAndAngles((this.posX + gem.posX) / 2, (this.posY + gem.posY) / 2, (this.posZ + gem.posZ) / 2, (this.rotationYaw + gem.rotationYaw) / 2, (this.rotationPitch + gem.rotationPitch) / 2);
			this.setInsigniaColor((this.getInsigniaColor() / gem.getInsigniaColor()) / 2);
			this.setOutfitColor((this.getOutfitColor() / gem.getOutfitColor()) / 2);
		}
		else {
			this.setLocationAndAngles(gem.posX, gem.posY, gem.posZ, gem.rotationYaw, gem.rotationPitch);
			this.setInsigniaColor(gem.getInsigniaColor());
			this.setOutfitColor(gem.getOutfitColor());
		}
		if (this.getHeldItem(EnumHand.MAIN_HAND).isEmpty()) {
			this.setHeldItem(EnumHand.MAIN_HAND, gem.getHeldItem(EnumHand.MAIN_HAND).copy());
		}
		else {
			this.setHeldItem(EnumHand.OFF_HAND, gem.getHeldItem(EnumHand.MAIN_HAND).copy());
		}
		this.setFusionGemCount(this.getFusionGemCount() + 1);
		return true;
	}
	public void unfuse() {
		Iterator<String> it = this.getFusionComponents().getKeySet().iterator();
		while (it.hasNext()) {
			NBTTagCompound compound = this.getFusionComponents().getCompoundTag(it.next());
			try {
				EntityGem gem = Ke2Gems.GEM_REGISTRY.get(new ResourceLocation(compound.getString("Species"))).getDeclaredConstructor(World.class).newInstance(this.world);
				gem.readFromNBT(compound);
				gem.setPosition(this.posX, this.posY, this.posZ);
				gem.setHealth(gem.getMaxHealth());
				this.world.spawnEntity(gem);
			} catch (Exception e) {
				System.out.println("An error occured unfusing " + this.getName() + ".");
			}
		}
		this.world.removeEntity(this);
	}
}