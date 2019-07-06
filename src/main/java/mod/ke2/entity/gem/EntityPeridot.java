package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPeridot extends EntityGem {
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/peridot/index"), EntityPeridot.class);
	}
	protected static final DataParameter<Boolean> SQUARE_HAIR = EntityDataManager.<Boolean>createKey(EntityPeridot.class, DataSerializers.BOOLEAN);

	public EntityPeridot(World world) {
		super(world);
		this.dataManager.register(EntityPeridot.SQUARE_HAIR, false);
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setSquareHair(this.rand.nextBoolean());
		return super.onInitialSpawn(difficulty, data);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setSquareHair(compound.getBoolean("SquareHair"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("SquareHair", this.hasSquareHair());
	}

	public void setSquareHair(boolean square) {
		this.dataManager.set(EntityPeridot.SQUARE_HAIR, square);
	}

	public boolean hasSquareHair() {
		return this.dataManager.get(EntityPeridot.SQUARE_HAIR);
	}

	@Override
	public String generateHairVariant() {
		return VariantHelper.loadVariantPath(this, "ke2:texture.hair", this.hasSquareHair() ? "ke2:peridot.hair.square" : "ke2:peridot.hair.triangle");
	}

	@Override
	public void onInventoryChanged(IInventory inventory) {

	}

	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	
	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_PERIDOT;
	}
}
