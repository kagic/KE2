package mod.ke2.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

public class Ke2Sounds {
	public static final SoundEvent BUBBLE_CREATE = new SoundEvent(new ResourceLocation("ke2:misc.bubble.create"));
	public static final SoundEvent BUBBLE_POP = new SoundEvent(new ResourceLocation("ke2:misc.bubble.pop"));
	public static final SoundEvent BUBBLE_SEND = new SoundEvent(new ResourceLocation("ke2:misc.bubble.send"));
	public static final SoundEvent GEM_BURST = new SoundEvent(new ResourceLocation("ke2:misc.burst"));
	public static final SoundEvent WAILING_STONE = new SoundEvent(new ResourceLocation("ke2:block.wailing_stone"));
	public static final SoundEvent DESTABILIZER = new SoundEvent(new ResourceLocation("ke2:item.destabilizer"));

	public static void register(RegistryEvent.Register<SoundEvent> event) {
		Ke2Sounds.registerSound(Ke2Sounds.BUBBLE_CREATE, new ResourceLocation("ke2:misc.bubble.create"), event);
		Ke2Sounds.registerSound(Ke2Sounds.BUBBLE_POP, new ResourceLocation("ke2:misc.bubble.pop"), event);
		Ke2Sounds.registerSound(Ke2Sounds.BUBBLE_SEND, new ResourceLocation("ke2:misc.bubble.send"), event);
		Ke2Sounds.registerSound(Ke2Sounds.GEM_BURST, new ResourceLocation("ke2:misc.burst"), event);
		Ke2Sounds.registerSound(Ke2Sounds.WAILING_STONE, new ResourceLocation("ke2:block.wailing_stone"), event);
		Ke2Sounds.registerSound(Ke2Sounds.DESTABILIZER, new ResourceLocation("ke2:item.destabilizer"), event);
	}

	private static void registerSound(SoundEvent sound, ResourceLocation location, RegistryEvent.Register<SoundEvent> event) {
		sound.setRegistryName(location);
		event.getRegistry().register(sound);
	}
}
