package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.entity.EntityGem;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityEnderPearl extends EntityGem {
	public static final ArrayList<ResourceLocation> INSIGNIAS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> JACKETS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> UNIFORMS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> HAIRSTYLES = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> GEMSTONES = new ArrayList<ResourceLocation>();
	static {
		
	}
	public EntityEnderPearl(World world) {
		super(world);
	}
	@Override
	public int generateSkinColor() {
		return 0;
	}
	@Override
	public int generateHairColor() {
		return 0;
	}
	@Override
	public int generateGemstoneColor() {
		return 0;
	}
	@Override
	public int generateInsigniaVariant() {
		return 0;
	}
	@Override
	public int generateJacketVariant() {
		return 0;
	}
	@Override
	public int generateUniformVariant() {
		return 0;
	}
	@Override
	public int generateHairVariant() {
		return 0;
	}
	@Override
	public int generateSkinVariant() {
		return 0;
	}
	@Override
	public int generateGemstonePosition() {
		return 0;
	}
	@Override
	public int generateGemstoneCut() {
		return 0;
	}
	@Override
	public boolean generateVisor() {
		return false;
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
