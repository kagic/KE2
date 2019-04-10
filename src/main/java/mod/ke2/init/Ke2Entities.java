package mod.ke2.init;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.api.injection.CruxEntry;
import mod.ke2.client.render.RenderGemShard;
import mod.ke2.client.render.gem.RenderAgate;
import mod.ke2.client.render.gem.RenderAmethyst;
import mod.ke2.client.render.gem.RenderAquaAuraQuartz;
import mod.ke2.client.render.gem.RenderAquamarine;
import mod.ke2.client.render.gem.RenderBismuth;
import mod.ke2.client.render.gem.RenderCarnelian;
import mod.ke2.client.render.gem.RenderCitrine;
import mod.ke2.client.render.gem.RenderCoral;
import mod.ke2.client.render.gem.RenderDemantoid;
import mod.ke2.client.render.gem.RenderDesertGlass;
import mod.ke2.client.render.gem.RenderEmerald;
import mod.ke2.client.render.gem.RenderEnderPearl;
import mod.ke2.client.render.gem.RenderHessonite;
import mod.ke2.client.render.gem.RenderHiddenite;
import mod.ke2.client.render.gem.RenderJade;
import mod.ke2.client.render.gem.RenderJasper;
import mod.ke2.client.render.gem.RenderKunzite;
import mod.ke2.client.render.gem.RenderLapisLazuli;
import mod.ke2.client.render.gem.RenderLarimar;
import mod.ke2.client.render.gem.RenderMelanite;
import mod.ke2.client.render.gem.RenderMotherOfPearl;
import mod.ke2.client.render.gem.RenderNephrite;
import mod.ke2.client.render.gem.RenderPearl;
import mod.ke2.client.render.gem.RenderPeridot;
import mod.ke2.client.render.gem.RenderPyrope;
import mod.ke2.client.render.gem.RenderRoseQuartz;
import mod.ke2.client.render.gem.RenderRuby;
import mod.ke2.client.render.gem.RenderRutile;
import mod.ke2.client.render.gem.RenderSapphire;
import mod.ke2.client.render.gem.RenderSnowflakeObsidian;
import mod.ke2.client.render.gem.RenderTopaz;
import mod.ke2.client.render.gem.RenderWatermelonTourmaline;
import mod.ke2.client.render.gem.RenderZircon;
import mod.ke2.client.render.machine.RenderBubble;
import mod.ke2.client.render.machine.RenderInjector;
import mod.ke2.client.render.vehicle.RenderHandShip;
import mod.ke2.client.render.vehicle.RenderPalanquin;
import mod.ke2.entity.EntityGemShard;
import mod.ke2.entity.gem.EntityAgate;
import mod.ke2.entity.gem.EntityAmethyst;
import mod.ke2.entity.gem.EntityAquaAuraQuartz;
import mod.ke2.entity.gem.EntityAquamarine;
import mod.ke2.entity.gem.EntityBismuth;
import mod.ke2.entity.gem.EntityCarnelian;
import mod.ke2.entity.gem.EntityCitrine;
import mod.ke2.entity.gem.EntityCoral;
import mod.ke2.entity.gem.EntityDemantoid;
import mod.ke2.entity.gem.EntityDesertGlass;
import mod.ke2.entity.gem.EntityEmerald;
import mod.ke2.entity.gem.EntityEnderPearl;
import mod.ke2.entity.gem.EntityHessonite;
import mod.ke2.entity.gem.EntityHiddenite;
import mod.ke2.entity.gem.EntityJade;
import mod.ke2.entity.gem.EntityJasper;
import mod.ke2.entity.gem.EntityKunzite;
import mod.ke2.entity.gem.EntityLapisLazuli;
import mod.ke2.entity.gem.EntityLarimar;
import mod.ke2.entity.gem.EntityMelanite;
import mod.ke2.entity.gem.EntityMotherOfPearl;
import mod.ke2.entity.gem.EntityNephrite;
import mod.ke2.entity.gem.EntityPearl;
import mod.ke2.entity.gem.EntityPeridot;
import mod.ke2.entity.gem.EntityPyrope;
import mod.ke2.entity.gem.EntityRoseQuartz;
import mod.ke2.entity.gem.EntityRuby;
import mod.ke2.entity.gem.EntityRutile;
import mod.ke2.entity.gem.EntitySapphire;
import mod.ke2.entity.gem.EntitySnowflakeObsidian;
import mod.ke2.entity.gem.EntityTopaz;
import mod.ke2.entity.gem.EntityWatermelonTourmaline;
import mod.ke2.entity.gem.EntityZircon;
import mod.ke2.entity.machine.EntityBubble;
import mod.ke2.entity.machine.EntityInjector;
import mod.ke2.entity.vehicle.EntityHandShip;
import mod.ke2.entity.vehicle.EntityPalanquin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Ke2Entities {
	private static int currentID = 0;
	public static void register(int pass) {
		registerEntity("bubble", EntityBubble.class, RenderBubble::new, pass);
		registerEntity("gem_shard", EntityGemShard.class, RenderGemShard::new, pass);
		registerEntity("hand_ship", EntityHandShip.class, RenderHandShip::new, pass);
		registerEntity("injector", EntityInjector.class, RenderInjector::new, pass);
		registerEntity("palanquin", EntityPalanquin.class, RenderPalanquin::new, pass);
		registerGem("agate", EntityAgate.class, RenderAgate::new, 0x000000, 0xFFFFFF, Ke2Cruxes.AGATE, pass);
		registerGem("amethyst", EntityAmethyst.class, RenderAmethyst::new, 0x000000, 0xFFFFFF, Ke2Cruxes.AMETHYST, pass);
		registerGem("aqua_aura_quartz", EntityAquaAuraQuartz.class, RenderAquaAuraQuartz::new, 0x000000, 0xFFFFFF, Ke2Cruxes.AQUA_AURA_QUARTZ, pass);
		registerGem("aquamarine", EntityAquamarine.class, RenderAquamarine::new, 0x000000, 0xFFFFFF, Ke2Cruxes.AQUAMARINE, pass);
		registerGem("bismuth", EntityBismuth.class, RenderBismuth::new, 0x000000, 0xFFFFFF, Ke2Cruxes.BISMUTH, pass);
		registerGem("carnelian", EntityCarnelian.class, RenderCarnelian::new, 0x000000, 0xFFFFFF, Ke2Cruxes.CARNELIAN, pass);
		registerGem("citrine", EntityCitrine.class, RenderCitrine::new, 0x000000, 0xFFFFFF, Ke2Cruxes.CITRINE, pass);
		registerGem("coral", EntityCoral.class, RenderCoral::new, 0x000000, 0xFFFFFF, Ke2Cruxes.CORAL, pass);
		registerGem("demantoid", EntityDemantoid.class, RenderDemantoid::new, 0x000000, 0xFFFFFF, Ke2Cruxes.DEMANTOID, pass);
		registerGem("desert_glass", EntityDesertGlass.class, RenderDesertGlass::new, 0x000000, 0xFFFFFF, Ke2Cruxes.DESERT_GLASS, pass);
		registerGem("emerald", EntityEmerald.class, RenderEmerald::new, 0x000000, 0xFFFFFF, Ke2Cruxes.EMERALD, pass);
		registerGem("ender_pearl", EntityEnderPearl.class, RenderEnderPearl::new, 0x000000, 0xFFFFFF, Ke2Cruxes.ENDER_PEARL, pass);
		registerGem("hessonite", EntityHessonite.class, RenderHessonite::new, 0x000000, 0xFFFFFF, Ke2Cruxes.HESSONITE, pass);
		registerGem("hiddenite", EntityHiddenite.class, RenderHiddenite::new, 0x000000, 0xFFFFFF, Ke2Cruxes.HIDDENITE, pass);
		registerGem("jade", EntityJade.class, RenderJade::new, 0x000000, 0xFFFFFF, Ke2Cruxes.JADE, pass);
		registerGem("jasper", EntityJasper.class, RenderJasper::new, 0x000000, 0xFFFFFF, Ke2Cruxes.JASPER, pass);
		registerGem("kunzite", EntityKunzite.class, RenderKunzite::new, 0x000000, 0xFFFFFF, Ke2Cruxes.KUNZITE, pass);
		registerGem("lapis_lazuli", EntityLapisLazuli.class, RenderLapisLazuli::new, 0x000000, 0xFFFFFF, Ke2Cruxes.LAPIS_LAZULI, pass);
		registerGem("larimar", EntityLarimar.class, RenderLarimar::new, 0x000000, 0xFFFFFF, Ke2Cruxes.LARIMAR, pass);
		registerGem("melanite", EntityMelanite.class, RenderMelanite::new, 0x000000, 0xFFFFFF, Ke2Cruxes.MELANITE, pass);
		registerGem("mother_of_pearl", EntityMotherOfPearl.class, RenderMotherOfPearl::new, 0x000000, 0xFFFFFF, Ke2Cruxes.MOTHER_OF_PEARL, pass);
		registerGem("nephrite", EntityNephrite.class, RenderNephrite::new, 0x000000, 0xFFFFFF, Ke2Cruxes.NEPHRITE, pass);
		registerGem("pearl", EntityPearl.class, RenderPearl::new, 0x000000, 0xFFFFFF, Ke2Cruxes.PEARL, pass);
		registerGem("peridot", EntityPeridot.class, RenderPeridot::new, 0x000000, 0xFFFFFF, Ke2Cruxes.PERIDOT, pass);
		registerGem("pyrope", EntityPyrope.class, RenderPyrope::new, 0x000000, 0xFFFFFF, Ke2Cruxes.PYROPE, pass);
		registerGem("rose_quartz", EntityRoseQuartz.class, RenderRoseQuartz::new, 0x000000, 0xFFFFFF, Ke2Cruxes.ROSE_QUARTZ, pass);
		registerGem("ruby", EntityRuby.class, RenderRuby::new, 0x000000, 0xFFFFFF, Ke2Cruxes.RUBY, pass);
		registerGem("rutile", EntityRutile.class, RenderRutile::new, 0x000000, 0xFFFFFF, Ke2Cruxes.RUTILE, pass);
		registerGem("sapphire", EntitySapphire.class, RenderSapphire::new, 0x000000, 0xFFFFFF, Ke2Cruxes.SAPPHIRE, pass);
		registerGem("snowflake_obsidian", EntitySnowflakeObsidian.class, RenderSnowflakeObsidian::new, 0x000000, 0xFFFFFF, Ke2Cruxes.SNOWFLAKE_OBSIDIAN, pass);
		registerGem("topaz", EntityTopaz.class, RenderTopaz::new, 0x000000, 0xFFFFFF, Ke2Cruxes.TOPAZ, pass);
		registerGem("watermelon_tourmaline", EntityWatermelonTourmaline.class, RenderWatermelonTourmaline::new, 0x000000, 0xFFFFFF, Ke2Cruxes.WATERMELON_TOURMALINE, pass);
		registerGem("zircon", EntityZircon.class, RenderZircon::new, 0x000000, 0xFFFFFF, Ke2Cruxes.ZIRCON, pass);
	}
	public static <T extends EntityGem> void registerGem(String name, Class<T> entity, IRenderFactory<T> renderer, int back, int fore, ArrayList<CruxEntry> cruxes, int pass) {
		Ke2Entities.registerMob(name, entity, renderer, back, fore, pass);
		if (pass > 0) {
			Ke2Gems.registerGemEntity(new ResourceLocation("ke2:" + name), entity, cruxes);
		}
	}
	public static <T extends EntityGem> void registerGem(String name, Class<T> entity, IRenderFactory<T> renderer, int pass) {
		Ke2Entities.registerEntity(name, entity, renderer, pass);
	}
	public static <T extends EntityLiving> void registerMob(String name, Class<T> entity, IRenderFactory<T> renderer, int back, int fore, int pass) {
		Ke2Entities.registerEntity(name, entity, renderer, pass);
		if (pass > 0) {
			EntityRegistry.registerEgg(new ResourceLocation("ke2:" + name), back, fore);
		}
	}
	public static <T extends Entity> void registerEntity(String name, Class<T> entity, IRenderFactory<T> renderer, int pass) {
		if (pass > 0) {
			EntityRegistry.registerModEntity(new ResourceLocation("ke2:" + name), entity, name, currentID, KAGIC.instance, 256, 1, true);
			++Ke2Entities.currentID;
		}
		else if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderer);
		}
	}
}
