package mod.ke2.init;

import mod.ke2.handles.HandleBubbleEnchant;
import mod.ke2.handles.HandleBubbling;
import mod.ke2.handles.HandleFactions;
import mod.ke2.handles.HandleGuarding;
import mod.ke2.handles.HandleShattering;
import net.minecraftforge.common.MinecraftForge;

public class Ke2Handles {
	public static void register() {
		Ke2Handles.registerHandle(new HandleBubbleEnchant());
		Ke2Handles.registerHandle(new HandleBubbling());
		Ke2Handles.registerHandle(new HandleFactions());
		Ke2Handles.registerHandle(new HandleShattering());
		Ke2Handles.registerHandle(new HandleGuarding());
	}
	
	public static void registerHandle(Object handler) {
		MinecraftForge.EVENT_BUS.register(handler);
	}
}
