package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.api.variants.types.TagType;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
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

public class EntityTopaz extends EntityGem {
	public static final ArrayList<TagType> TOPAZ_COLORS = new ArrayList<TagType>();
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/topaz/index"), EntityTopaz.class);
		EntityTopaz.TOPAZ_COLORS.add(new TagType(20, "ke2:topaz.color.yellow"));
		EntityTopaz.TOPAZ_COLORS.add(new TagType(5, "ke2:topaz.color.blue"));
		EntityTopaz.TOPAZ_COLORS.add(new TagType(2, "ke2:topaz.color.pink"));
		EntityTopaz.TOPAZ_COLORS.add(new TagType(1, "ke2:topaz.color.white"));
	}
	protected static final DataParameter<String> TOPAZ_COLOR = EntityDataManager.<String>createKey(EntityTopaz.class, DataSerializers.STRING);
	
	public EntityTopaz(World world) {
		super(world);
		this.dataManager.register(EntityTopaz.TOPAZ_COLOR, "ke2:topaz.color.yellow");
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setTopazColor(this.generateTopazColor());
		return super.onInitialSpawn(difficulty, data);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setTopazColor(compound.getString("TopazColor"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("TopazColor", this.getTopazColor());
	}
	
	@Override
	public int generateSkinColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.skin", this.getTopazColor());
	}
	
	@Override
	public int generateHairColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.hair", this.getTopazColor());
	}
	
	@Override
	public int generateOutfitColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.outfit", this.getTopazColor());
	}
	
	@Override
	public int generateVisorColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.visor", this.getTopazColor());
	}
	
	@Override
	public int generateGemstoneColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.gemstone", this.getTopazColor());
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	
	public void setTopazColor(String color) {
		this.dataManager.set(EntityTopaz.TOPAZ_COLOR, color);
	}
	
	public String getTopazColor() {
		return this.dataManager.get(EntityTopaz.TOPAZ_COLOR);
	}
	
	public String generateTopazColor() {
		return TagType.weigh(EntityTopaz.TOPAZ_COLORS).getTag();
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_TOPAZ;
	}
}
