package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySnowflakeObsidian extends EntityGem {
	static {
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/hair_default"), VariantPath.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/outfit_default"), VariantPath.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/skin_default"), VariantPath.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/color_gemstone"), VariantColor.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/color_hair"), VariantColor.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/color_outfit"), VariantColor.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/color_skin"), VariantColor.class), EntitySnowflakeObsidian.class);
		Ke2Variants.addVariantToGem(Ke2Variants.registerVariant(new ResourceLocation("ke2:variants/snowflake_obsidian/color_visor"), VariantColor.class), EntitySnowflakeObsidian.class);
	}
	
	public EntitySnowflakeObsidian(World world) {
		super(world);
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
		return Ke2Sounds.GEM_SNOWFLAKE_OBSIDIAN;
	}
}
