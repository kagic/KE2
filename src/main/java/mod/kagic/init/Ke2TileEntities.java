package mod.kagic.init;

import mod.kagic.tileentity.TileEntityCarbonite;
import mod.kagic.tileentity.TileEntityGemSeed;
import mod.kagic.tileentity.TileEntityWailingStone;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2TileEntities {
	public static void register() {
		registerTileEntity(TileEntityGemSeed.class, new ResourceLocation("kagic:gem_seed"));
		registerTileEntity(TileEntityWailingStone.class, new ResourceLocation("kagic:wailing_stone"));
		registerTileEntity(TileEntityCarbonite.class, new ResourceLocation("kagic:carbonite"));
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
