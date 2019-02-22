package mod.kagic.init;

import java.util.ArrayList;

import mod.kagic.client.render.RenderBubble;
import mod.kagic.client.render.RenderGemShard;
import mod.kagic.client.render.RenderHandShip;
import mod.kagic.client.render.RenderInjector;
import mod.kagic.client.render.RenderPalanquin;
import mod.kagic.entity.EntityGem;
import mod.kagic.entity.EntityGemShard;
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
		registerEntity("injector", EntityInjector.class, RenderInjector::new, pass);
		registerEntity("gem_shard", EntityGemShard.class, RenderGemShard::new, pass);
		registerEntity("bubble", EntityBubble.class, RenderBubble::new, pass);
		registerEntity("palanquin", EntityPalanquin.class, RenderPalanquin::new, pass);
		registerEntity("hand_ship", EntityHandShip.class, RenderHandShip::new, pass);
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
