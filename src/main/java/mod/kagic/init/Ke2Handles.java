package mod.kagic.init;

import mod.kagic.handles.HandleBubbling;
import mod.kagic.handles.HandleCapturing;
import mod.kagic.handles.HandleGuarding;
import mod.kagic.handles.HandleShattering;
import net.minecraftforge.common.MinecraftForge;

public class Ke2Handles {
	public static void register() {
		registerHandle(new HandleBubbling());
		registerHandle(new HandleCapturing());
		registerHandle(new HandleShattering());
		registerHandle(new HandleGuarding());
	}
	public static void registerHandle(Object handler) {
		MinecraftForge.EVENT_BUS.register(handler);
	}
}
