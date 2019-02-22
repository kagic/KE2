package mod.kagic.init;

import mod.kagic.tileentity.TileEntityWailingStone;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2TileEntities {
	public static void register() {
		registerTileEntity(TileEntityWailingStone.class, new ResourceLocation("kagic:wailing_stone"));
	}
	public static void registerTileEntity(Class<? extends TileEntity> tileentity, ResourceLocation location) {
		try { GameRegistry.registerTileEntity(tileentity, location); }
		catch (NoSuchMethodError e) {
			GameRegistry.registerTileEntity(tileentity, location.toString());
		}
	}
}
