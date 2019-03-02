package mod.kagic.init;

import java.util.ArrayList;

import mod.kagic.client.render.RenderBubble;
import mod.kagic.client.render.RenderGemShard;
import mod.kagic.client.render.RenderHandShip;
import mod.kagic.client.render.RenderInjector;
import mod.kagic.client.render.RenderPalanquin;
import mod.kagic.client.render.gem.RenderAgate;
import mod.kagic.client.render.gem.RenderAmethyst;
import mod.kagic.client.render.gem.RenderAquamarine;
import mod.kagic.client.render.gem.RenderBismuth;
import mod.kagic.client.render.gem.RenderCarnelian;
import mod.kagic.client.render.gem.RenderCitrine;
import mod.kagic.client.render.gem.RenderCoral;
import mod.kagic.client.render.gem.RenderDemantoid;
import mod.kagic.client.render.gem.RenderDesertGlass;
import mod.kagic.client.render.gem.RenderEmerald;
import mod.kagic.client.render.gem.RenderEnderPearl;
import mod.kagic.client.render.gem.RenderHessonite;
import mod.kagic.client.render.gem.RenderHiddenite;
import mod.kagic.client.render.gem.RenderJade;
import mod.kagic.client.render.gem.RenderJasper;
import mod.kagic.client.render.gem.RenderKunzite;
import mod.kagic.client.render.gem.RenderLapisLazuli;
import mod.kagic.client.render.gem.RenderLarimar;
import mod.kagic.client.render.gem.RenderMelanite;
import mod.kagic.client.render.gem.RenderMotherOfPearl;
import mod.kagic.client.render.gem.RenderNephrite;
import mod.kagic.client.render.gem.RenderPearl;
import mod.kagic.client.render.gem.RenderPeridot;
import mod.kagic.client.render.gem.RenderPyrope;
import mod.kagic.client.render.gem.RenderRoseQuartz;
import mod.kagic.client.render.gem.RenderRuby;
import mod.kagic.client.render.gem.RenderRutile;
import mod.kagic.client.render.gem.RenderSapphire;
import mod.kagic.client.render.gem.RenderSnowflakeObsidian;
import mod.kagic.client.render.gem.RenderTopaz;
import mod.kagic.client.render.gem.RenderWatermelonTourmaline;
import mod.kagic.client.render.gem.RenderZircon;
import mod.kagic.entity.EntityGem;
import mod.kagic.entity.EntityGemShard;
import mod.kagic.entity.gem.EntityAgate;
import mod.kagic.entity.gem.EntityAmethyst;
import mod.kagic.entity.gem.EntityAquamarine;
import mod.kagic.entity.gem.EntityBismuth;
import mod.kagic.entity.gem.EntityCarnelian;
import mod.kagic.entity.gem.EntityCitrine;
import mod.kagic.entity.gem.EntityCoral;
import mod.kagic.entity.gem.EntityDemantoid;
import mod.kagic.entity.gem.EntityDesertGlass;
import mod.kagic.entity.gem.EntityEmerald;
import mod.kagic.entity.gem.EntityEnderPearl;
import mod.kagic.entity.gem.EntityHessonite;
import mod.kagic.entity.gem.EntityHiddenite;
import mod.kagic.entity.gem.EntityJade;
import mod.kagic.entity.gem.EntityJasper;
import mod.kagic.entity.gem.EntityKunzite;
import mod.kagic.entity.gem.EntityLapisLazuli;
import mod.kagic.entity.gem.EntityLarimar;
import mod.kagic.entity.gem.EntityMelanite;
import mod.kagic.entity.gem.EntityMotherOfPearl;
import mod.kagic.entity.gem.EntityNephrite;
import mod.kagic.entity.gem.EntityPearl;
import mod.kagic.entity.gem.EntityPeridot;
import mod.kagic.entity.gem.EntityPyrope;
import mod.kagic.entity.gem.EntityRoseQuartz;
import mod.kagic.entity.gem.EntityRuby;
import mod.kagic.entity.gem.EntityRutile;
import mod.kagic.entity.gem.EntitySapphire;
import mod.kagic.entity.gem.EntitySnowflakeObsidian;
import mod.kagic.entity.gem.EntityTopaz;
import mod.kagic.entity.gem.EntityWatermelonTourmaline;
import mod.kagic.entity.gem.EntityZircon;
import mod.kagic.entity.machine.EntityBubble;
import mod.kagic.entity.machine.EntityInjector;
import mod.kagic.entity.vehicle.EntityHandShip;
import mod.kagic.entity.vehicle.EntityPalanquin;
import mod.kagic.injection.CruxEntry;
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
		registerGem("agate", EntityAgate.class, RenderAgate::new, pass);
		registerGem("amethyst", EntityAmethyst.class, RenderAmethyst::new, pass);
		registerGem("aquamarine", EntityAquamarine.class, RenderAquamarine::new, pass);
		registerGem("bismuth", EntityBismuth.class, RenderBismuth::new, pass);
		registerGem("carnelian", EntityCarnelian.class, RenderCarnelian::new, pass);
		registerGem("citrine", EntityCitrine.class, RenderCitrine::new, pass);
		registerGem("coral", EntityCoral.class, RenderCoral::new, pass);
		registerGem("demantoid", EntityDemantoid.class, RenderDemantoid::new, pass);
		registerGem("desert_glass", EntityDesertGlass.class, RenderDesertGlass::new, pass);
		registerGem("emerald", EntityEmerald.class, RenderEmerald::new, pass);
		registerGem("ender_pearl", EntityEnderPearl.class, RenderEnderPearl::new, pass);
		registerGem("hessonite", EntityHessonite.class, RenderHessonite::new, pass);
		registerGem("hiddenite", EntityHiddenite.class, RenderHiddenite::new, pass);
		registerGem("jade", EntityJade.class, RenderJade::new, pass);
		registerGem("jasper", EntityJasper.class, RenderJasper::new, pass);
		registerGem("kunzite", EntityKunzite.class, RenderKunzite::new, pass);
		registerGem("lapis_lazuli", EntityLapisLazuli.class, RenderLapisLazuli::new, pass);
		registerGem("larimar", EntityLarimar.class, RenderLarimar::new, pass);
		registerGem("melanite", EntityMelanite.class, RenderMelanite::new, pass);
		registerGem("mother_of_pearl", EntityMotherOfPearl.class, RenderMotherOfPearl::new, pass);
		registerGem("nephrite", EntityNephrite.class, RenderNephrite::new, pass);
		registerGem("pearl", EntityPearl.class, RenderPearl::new, pass);
		registerGem("peridot", EntityPeridot.class, RenderPeridot::new, pass);
		registerGem("pyrope", EntityPyrope.class, RenderPyrope::new, pass);
		registerGem("rose_quartz", EntityRoseQuartz.class, RenderRoseQuartz::new, pass);
		registerGem("ruby", EntityRuby.class, RenderRuby::new, pass);
		registerGem("rutile", EntityRutile.class, RenderRutile::new, pass);
		registerGem("sapphire", EntitySapphire.class, RenderSapphire::new, pass);
		registerGem("snowflake_obsidian", EntitySnowflakeObsidian.class, RenderSnowflakeObsidian::new, pass);
		registerGem("topaz", EntityTopaz.class, RenderTopaz::new, pass);
		registerGem("watermelon_tourmaline", EntityWatermelonTourmaline.class, RenderWatermelonTourmaline::new, pass);
		registerGem("zircon", EntityZircon.class, RenderZircon::new, pass);
	}
	public static <T extends EntityGem> void registerGem(String name, Class<T> entity, IRenderFactory<T> renderer, int back, int fore, ArrayList<CruxEntry> cruxes, int pass) {
		Ke2Entities.registerMob(name, entity, renderer, back, fore, pass);
		if (pass > 0) {
			Ke2Gems.registerGemEntity(new ResourceLocation("kagic:" + name), entity, cruxes);
		}
	}
	public static <T extends EntityGem> void registerGem(String name, Class<T> entity, IRenderFactory<T> renderer, int pass) {
		Ke2Entities.registerEntity(name, entity, renderer, pass);
	}
	public static <T extends EntityLiving> void registerMob(String name, Class<T> entity, IRenderFactory<T> renderer, int back, int fore, int pass) {
		Ke2Entities.registerEntity(name, entity, renderer, pass);
		if (pass > 0) {
			EntityRegistry.registerEgg(new ResourceLocation("kagic:" + name), back, fore);
		}
	}
	public static <T extends Entity> void registerEntity(String name, Class<T> entity, IRenderFactory<T> renderer, int pass) {
		if (pass > 0) {
			EntityRegistry.registerModEntity(new ResourceLocation("kagic:" + name), entity, name, currentID, KAGIC.instance, 256, 1, true);
			++Ke2Entities.currentID;
		}
		else if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderer);
		}
	}
}
