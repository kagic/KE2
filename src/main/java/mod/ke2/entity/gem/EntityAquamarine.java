package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAquamarine extends EntityGem {
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/aquamarine/index"), EntityAquamarine.class);
	}
	protected static final DataParameter<Boolean> WINGED = EntityDataManager.<Boolean>createKey(EntityAquamarine.class, DataSerializers.BOOLEAN);

	public EntityAquamarine(World world) {
		super(world);
		this.dataManager.register(EntityAquamarine.WINGED, false);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setWinged(compound.getBoolean("Winged"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Winged", this.isWinged());
	}

	@Override
	public void onInventoryChanged(IInventory inventory) {

	}

	@Override
	public int generateGemstoneCut() {
		return 0;
	}

	public void setWinged(boolean winged) {
		this.dataManager.set(EntityAquamarine.WINGED, winged);
	}

	public boolean isWinged() {
		return this.dataManager.get(EntityAquamarine.WINGED);
	}
	
	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_AQUAMARINE;
	}
}
