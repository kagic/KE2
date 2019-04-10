package mod.ke2.tileentity;

import mod.ke2.api.injection.GemSpawnData;
import mod.ke2.api.injection.InjectorResult;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityGemSeed extends TileEntity implements ITickable {
	private GemSpawnData data;
	private InjectorResult preResult;
	private int ticksExisted = 0;
	@Override
	public void update() {
		if (this.ticksExisted > 5000) {
			InjectorResult result = InjectorResult.create(this.world, this.pos, true, this.data.getOwner(), this.data.getColor());
			result.generate(this.world);
		}
		else if (this.hasPreResult()) {
			++this.ticksExisted;
		}
		else if (!this.hasData()) {
			this.data = new GemSpawnData();
		}
		else {
			this.preResult = InjectorResult.create(this.world, this.pos, false);
		}
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("TicksExisted", this.ticksExisted);
		if (this.hasData()) {
			compound.setUniqueId("Owner", this.data.getOwner());
			compound.setInteger("Color", this.data.getColor());
			compound.setBoolean("Defective", this.data.isDefective());
			compound.setBoolean("Perfect", this.data.isPerfect());
		}
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.ticksExisted = compound.getInteger("TicksExisted");
		try {
			this.data = new GemSpawnData(compound.getUniqueId("Owner"),
				compound.getInteger("Color"),
				compound.getBoolean("Defective"),
				compound.getBoolean("Perfect"));
		} catch (Exception e) {
			this.data = null;
		}
	}
	public GemSpawnData getData() {
		return this.data;
	}
	public void setData(GemSpawnData data) {
		this.data = data;
	}
	public boolean hasData() {
		return this.data != null;
	}
	public InjectorResult getPreResult() {
		return this.preResult;
	}
	public boolean hasPreResult() {
		return this.preResult != null;
	}
}
