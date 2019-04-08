package mod.ke2.init;

import mod.ke2.tileentity.TileEntityCarbonite;
import mod.ke2.tileentity.TileEntityGemSeed;
import mod.ke2.tileentity.TileEntityWailingStone;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2TileEntities {
	public static void register() {
		registerTileEntity(TileEntityGemSeed.class, new ResourceLocation("ke2:gem_seed"));
		registerTileEntity(TileEntityWailingStone.class, new ResourceLocation("ke2:wailing_stone"));
		registerTileEntity(TileEntityCarbonite.class, new ResourceLocation("ke2:carbonite"));
	}
	@SuppressWarnings("deprecation")
	public static void registerTileEntity(Class<? extends TileEntity> tileentity, ResourceLocation location) {
		try {
			GameRegistry.registerTileEntity(tileentity, location);
		}
		catch (NoSuchMethodError e) {
			// this is why you don't roll out API changes in the middle of a stable release cycle.
			GameRegistry.registerTileEntity(tileentity, location.toString());
		}
	}
}
