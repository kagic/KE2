package mod.ke2.entity.gem;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityRuby extends EntityGem {
	public static final ArrayList<ResourceLocation> INSIGNIAS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> JACKETS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> UNIFORMS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> HAIRSTYLES = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> GEMSTONES = new ArrayList<ResourceLocation>();
	static {
		INSIGNIAS.add(new ResourceLocation("ke2:textures/entities/ruby/outfit/insignia.png"));
		UNIFORMS.add(new ResourceLocation("ke2:textures/entities/ruby/outfit/uniform.png"));
		HAIRSTYLES.add(new ResourceLocation("ke2:textures/entities/ruby/hair/hair.png"));
		GEMSTONES.add(new ResourceLocation("ke2:textures/items/red_gem_dust.png"));
	}
	public EntityRuby(World world) {
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
	public int generateOutfitColor() {
		return 0;
	}
	@Override
	public int generateVisorColor() {
		return 0;
	}
	@Override
	public int generateGemstoneColor() {
		return 0;
	}
	@Override
	public int generateGemstonePosition() {
		return Ke2Gems.GEMSTONE_CHEST;
	}
	@Override
	public String generateGemstoneCut() {
		return "ke2:textures/entities/none/null";
	}
	@Override
	public String generateOutfitVariant() {
		return "ke2:textures/entities/none/null";
	}
	@Override
	public String generateHairVariant() {
		return "ke2:textures/entities/none/null";
	}
	@Override
	public String generateSkinVariant() {
		return "ke2:textures/entities/none/null";
	}
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
}
