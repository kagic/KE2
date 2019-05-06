package mod.ke2.init;

import mod.ke2.KAGIC;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = KAGIC.MODID)
@Config.LangKey("ke2.config.title")
@Mod.EventBusSubscriber
public class Ke2Configs {
	@Config.Name("Grow Agates?")
	public static boolean enableAgate = true;
	@Config.Name("Grow Amethysts?")
	public static boolean enableAmethyst = true;
	@Config.Name("Grow Aqua Aura Quartzes? (By Azura)")
	public static boolean enableAquaAuraQuartz = false;
	@Config.Name("Grow Aquamarines?")
	public static boolean enableAquamarine = true;
	@Config.Name("Grow Bismuths?")
	public static boolean enableBismuth = true;
	@Config.Name("Grow Carnelians?")
	public static boolean enableCarnelian = true;
	@Config.Name("Grow Citrines?")
	public static boolean enableCitrine = true;
	@Config.Name("Grow Coral?")
	public static boolean enableCoral = true;
	@Config.Name("Grow Demantoid?")
	public static boolean enableDemantoid = true;
	@Config.Name("Grow Emeralds?")
	public static boolean enableEmerald = true;
	@Config.Name("Grow Ender Pearls?")
	public static boolean enableEnderPearl = true;
	@Config.Name("Grow Hessonites?")
	public static boolean enableHessonite = true;
	@Config.Name("Grow Hiddenite?")
	public static boolean enableHiddenite = true;
	@Config.Name("Grow Jades?")
	public static boolean enableJade = true;
	@Config.Name("Grow Jaspers?")
	public static boolean enableJasper = true;
	@Config.Name("Grow Kunzite?")
	public static boolean enableKunzite = true;
	@Config.Name("Grow Lapis Lazulis?")
	public static boolean enableLapisLazuli = true;
	@Config.Name("Grow Larimar?")
	public static boolean enableLarimar = true;
	@Config.Name("Grow Melanites?")
	public static boolean enableMelanite = false;
	@Config.Name("Grow Mother of Pearls?")
	public static boolean enableNacre = true;
	@Config.Name("Grow Nephrites?")
	public static boolean enableNephrite = true;
	@Config.Name("Grow Obsidian?")
	public static boolean enableObsidian = true;
	@Config.Name("Grow Pearls?")
	public static boolean enablePearl = true;
	@Config.Name("Grow Peridots?")
	public static boolean enablePeridot = true;
	@Config.Name("Grow Pyrope?")
	public static boolean enablePyrope = true;
	@Config.Name("Grow Rose Quartzes?")
	public static boolean enableRoseQuartz = true;
	@Config.Name("Grow Rubies?")
	public static boolean enableRuby = true;
	@Config.Name("Grow Rutiles?")
	public static boolean enableRutile = true;
	@Config.Name("Grow Sapphires?")
	public static boolean enableSapphire = true;
	@Config.Name("Grow Topazes?")
	public static boolean enableTopaz = true;
	@Config.Name("Grow Watermelon Tourmalines?")
	public static boolean enableWatermelonTourmaline = true;
	@Config.Name("Grow Zircons?")
	public static boolean enableZircon = true;
	
	@Config.Name("Spawn Meteor Gems?")
	public static boolean enableMeteorGems = true;
	@Config.Name("Spawn Crystal Gems?")
	public static boolean enableCrystalGems = true;
	@Config.Name("Spawn Beach City?")
	public static boolean enableBeachCity = true;
	@Config.Name("Spawn Rebellions?")
	public static boolean enableRebellions = true;
	
	@Config.Name("Show descriptors?")
	public static boolean showDescriptors = true;
	
	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(KAGIC.MODID)) {
			ConfigManager.sync(KAGIC.MODID, Config.Type.INSTANCE);
			Ke2Configs.register();
		}
	}
	public static void register() {
    	
	}
}
