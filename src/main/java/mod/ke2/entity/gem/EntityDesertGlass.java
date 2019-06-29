package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
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

public class EntityDesertGlass extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/hair_default"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/outfit_default"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/skin_default"), VariantPath.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_gemstone"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_hair"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_outfit"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_skin"), VariantColor.class), EntityDesertGlass.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/desert_glass/color_visor"), VariantColor.class), EntityDesertGlass.class);
	}
	protected static final DataParameter<Boolean> HAS_JAR = EntityDataManager.<Boolean>createKey(EntityDesertGlass.class, DataSerializers.BOOLEAN);
	
	public EntityDesertGlass(World world) {
		super(world);
		this.dataManager.register(EntityDesertGlass.HAS_JAR, false);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setHasJar(compound.getBoolean("HasJar"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("HasJar", this.hasJar());
	}
	
	public void setHasJar(boolean hasJar) {
		this.dataManager.set(EntityDesertGlass.HAS_JAR, hasJar);
	}
	
	public boolean hasJar() {
		return this.dataManager.get(EntityDesertGlass.HAS_JAR);
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
		return Ke2Sounds.GEM_DESERT_GLASS;
	}
}
