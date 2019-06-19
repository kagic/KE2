package mod.ke2.init;

import mod.ke2.KAGIC;
import mod.ke2.tileentity.TileEntityCarbonite;
import mod.ke2.tileentity.TileEntityGemSeed;
import mod.ke2.tileentity.TileEntityWailingStone;
import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2TileEntities {
	public static void register() {
		Ke2TileEntities.registerTileEntity(TileEntityWarpPadCore.class, new ResourceLocation("ke2:warp_pad_core"));
		Ke2TileEntities.registerTileEntity(TileEntityGemSeed.class, new ResourceLocation("ke2:gem_seed"));
		Ke2TileEntities.registerTileEntity(TileEntityWailingStone.class, new ResourceLocation("ke2:wailing_stone"));
		Ke2TileEntities.registerTileEntity(TileEntityCarbonite.class, new ResourceLocation("ke2:carbonite"));
	}
	
	@SuppressWarnings("deprecation")
	public static void registerTileEntity(Class<? extends TileEntity> tileentity, ResourceLocation location) {
		try {
			GameRegistry.registerTileEntity(tileentity, location);
		} catch (NoSuchMethodError e) {
			// This is why you don't roll out API changes in
			// the middle of a stable release
			// cycle.
			KAGIC.LOGGER.warn("Using deprecated fallback code for tile entity registration. Update Forge!!!");
			GameRegistry.registerTileEntity(tileentity, location.toString());
		}
	}
}
