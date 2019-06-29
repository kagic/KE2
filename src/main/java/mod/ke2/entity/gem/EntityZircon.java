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

public class EntityZircon extends EntityGem {
	public static final ArrayList<TagType> ZIRCON_COLORS = new ArrayList<TagType>();
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/hair_default"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/outfit_default"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/skin_default"), VariantPath.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_gemstone"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_hair"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_outfit"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_skin"), VariantColor.class), EntityZircon.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/zircon/color_visor"), VariantColor.class), EntityZircon.class);
		EntityZircon.ZIRCON_COLORS.add(new TagType(10, "ke2:zircon.color.blue"));
		EntityZircon.ZIRCON_COLORS.add(new TagType(5, "ke2:zircon.color.white"));
		EntityZircon.ZIRCON_COLORS.add(new TagType(1, "ke2:zircon.color.brown"));
		EntityZircon.ZIRCON_COLORS.add(new TagType(1, "ke2:zircon.color.green"));
	}
	protected static final DataParameter<String> ZIRCON_COLOR = EntityDataManager.<String>createKey(EntityZircon.class, DataSerializers.STRING);
	
	public EntityZircon(World world) {
		super(world);
		this.dataManager.register(EntityZircon.ZIRCON_COLOR, "ke2:zircon.color.blue");
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setZirconColor(this.generateZirconColor());
		return super.onInitialSpawn(difficulty, data);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setZirconColor(compound.getString("ZirconColor"));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("ZirconColor", this.getZirconColor());
	}
	
	@Override
	public int generateSkinColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.skin", this.getZirconColor());
	}
	
	@Override
	public int generateHairColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.hair", this.getZirconColor());
	}
	
	@Override
	public int generateOutfitColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.outfit", this.getZirconColor());
	}
	
	@Override
	public int generateVisorColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.visor", this.getZirconColor());
	}
	
	@Override
	public int generateGemstoneColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.gemstone", this.getZirconColor());
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	
	public void setZirconColor(String color) {
		this.dataManager.set(EntityZircon.ZIRCON_COLOR, color);
	}
	
	public String getZirconColor() {
		return this.dataManager.get(EntityZircon.ZIRCON_COLOR);
	}
	
	public String generateZirconColor() {
		return TagType.weigh(EntityZircon.ZIRCON_COLORS).getTag();
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_ZIRCON;
	}
}
