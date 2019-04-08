package mod.ke2.init;

import mod.ke2.handles.HandleBubbling;
import mod.ke2.handles.HandleCapturing;
import mod.ke2.handles.HandleGuarding;
import mod.ke2.handles.HandleShattering;
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
