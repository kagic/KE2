package mod.kagic.entity.gem;

import java.util.ArrayList;

import mod.kagic.entity.EntityGem;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityPearl extends EntityGem {
	//public static final Map<>
	public static final int[] PEARL_BASE_COLORS = new int[] { 
		0xfff2f2,	// White
		0xffd1d1,	// Red
		0xffe6c9,	// Orange
		0xfcffdb,	// Cream
		0xefffc9,	// Yellow
		0xccffb5,	// Green
		0xc1ffe5,	// Cyan
		0xc1fffb,	// Blue
		0xc1e9ff,	// Indigo
		0xd6d1ff,	// Purple
		0xfbd1ff,	// Pink
		0x6d7c75	// Black
	};
	public static final int PEARL_WHITE = 0;
	public static final int PEARL_RED = 1;
	public static final int PEARL_ORANGE = 2;
	public static final int PEARL_CREAM = 3;
	public static final int PEARL_YELLOW = 4;
	public static final int PEARL_GREEN = 5;
	public static final int PEARL_CYAN = 6;
	public static final int PEARL_BLUE = 7;
	public static final int PEARL_INDIGO = 8;
	public static final int PEARL_PURPLE = 9;
	public static final int PEARL_PINK = 10;
	public static final int PEARL_BLACK = 11;
	public static final ArrayList<ResourceLocation> INSIGNIAS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> JACKETS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> UNIFORMS = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> HAIRSTYLES = new ArrayList<ResourceLocation>();
	public static final ArrayList<ResourceLocation> GEMSTONES = new ArrayList<ResourceLocation>();
	static {
		
	}
	public EntityPearl(World world) {
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
		return this.rand.nextInt(PEARL_BASE_COLORS.length);
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
