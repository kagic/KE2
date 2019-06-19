package mod.ke2.init;

import java.util.ArrayList;
import java.util.HashMap;

import mod.ke2.api.EntityGem;
import mod.ke2.api.injection.CruxEntry;
import mod.ke2.entity.gem.EntityRuby;
import net.minecraft.util.ResourceLocation;

public class Ke2Cruxes {
	public static final HashMap<ResourceLocation, ArrayList<CruxEntry>> TABLE = new HashMap<ResourceLocation, ArrayList<CruxEntry>>();

	public static void register() {
		if (Ke2Configs.enableAgate) {

		}
		if (Ke2Configs.enableAmethyst) {

		}
		if (Ke2Configs.enableAquaAuraQuartz) {

		}
		if (Ke2Configs.enableBismuth) {

		}
		if (Ke2Configs.enableCarnelian) {

		}
		if (Ke2Configs.enableCitrine) {

		}
		if (Ke2Configs.enableEmerald) {

		}
		if (Ke2Configs.enableEnderPearl) {

		}
		if (Ke2Configs.enableHessonite) {

		}
		if (Ke2Configs.enableHiddenite) {

		}
		if (Ke2Configs.enableJasper) {

		}
		if (Ke2Configs.enableKunzite) {

		}
		if (Ke2Configs.enableLapisLazuli) {

		}
		if (Ke2Configs.enableMelanite) {

		}
		if (Ke2Configs.enableNacre) {

		}
		if (Ke2Configs.enableNephrite) {

		}
		if (Ke2Configs.enablePearl) {

		}
		if (Ke2Configs.enablePeridot) {

		}
		if (Ke2Configs.enableRoseQuartz) {

		}
		if (Ke2Configs.enableRuby) {
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_TRACE, "netherrack");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_PARTIAL, "oreRedstone");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_AVERAGE, "blockRedstone");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_AVERAGE, "stoneGranite");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_COMMON, "oreAluminium");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_COMMON, "oreAluminum");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_TOTAL, "blockAluminium");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_TOTAL, "blockAluminum");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_BLOCK, "blockRuby");
			CruxEntry.fromOreDict(EntityRuby.class, CruxEntry.CRUX_TOTAL, "oreRuby");
		}
		if (Ke2Configs.enableRutile) {

		}
		if (Ke2Configs.enableSapphire) {

		}
		if (Ke2Configs.enableTopaz) {

		}
		if (Ke2Configs.enableWatermelonTourmaline) {

		}
		if (Ke2Configs.enableZircon) {

		}
	}

	public static void addCrux(Class<? extends EntityGem> gem, CruxEntry entry) {
		Ke2Cruxes.addCrux(Ke2Gems.REGISTRY_REVERSE.get(gem), entry);
	}

	public static void addCrux(ResourceLocation gem, CruxEntry entry) {
		Ke2Cruxes.TABLE.get(gem).add(entry);
	}
}
