package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.api.variants.types.TagType;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySapphire extends EntityGem {
	public static final ArrayList<TagType> SAPPHIRE_COLORS = new ArrayList<TagType>();
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/sapphire/index"), EntitySapphire.class);
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(80, "ke2:sapphire.color.blue"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(10, "ke2:sapphire.color.purple"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(5, "ke2:sapphire.color.pink"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(5, "ke2:sapphire.color.green"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(2, "ke2:sapphire.color.peach"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(2, "ke2:sapphire.color.yellow"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(1, "ke2:sapphire.color.white"));
		EntitySapphire.SAPPHIRE_COLORS.add(new TagType(1, "ke2:sapphire.color.black"));
	}
	protected static final DataParameter<String> SAPPHIRE_COLOR = EntityDataManager.<String>createKey(EntitySapphire.class, DataSerializers.STRING);
	
	public EntitySapphire(World world) {
		super(world);
		this.dataManager.register(EntitySapphire.SAPPHIRE_COLOR, "ke2:sapphire.color.blue");
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setSapphireColor(this.generateSapphireColor());
		return super.onInitialSpawn(difficulty, data);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setSapphireColor(compound.getString("SapphireColor"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("SapphireColor", this.getSapphireColor());
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		// Sapphires have no legs and are thus completely
		// silent.
	}
	
	@Override
	public int generateSkinColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.skin", this.getSapphireColor());
	}
	
	@Override
	public int generateHairColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.hair", this.getSapphireColor());
	}
	
	@Override
	public int generateOutfitColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.outfit", this.getSapphireColor());
	}
	
	@Override
	public int generateVisorColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.visor", this.getSapphireColor());
	}
	
	@Override
	public int generateGemstoneColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.gemstone", this.getSapphireColor());
	}
	
	@Override
	public String generateNameVariant() {
		return VariantHelper.loadVariantName(this, "ke2:name", this.getSapphireColor());
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	
	public void setSapphireColor(String color) {
		this.dataManager.set(EntitySapphire.SAPPHIRE_COLOR, color);
	}
	
	public String getSapphireColor() {
		return this.dataManager.get(EntitySapphire.SAPPHIRE_COLOR);
	}
	
	public String generateSapphireColor() {
		return TagType.weigh(EntitySapphire.SAPPHIRE_COLORS).getTag();
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_SAPPHIRE;
	}
}
