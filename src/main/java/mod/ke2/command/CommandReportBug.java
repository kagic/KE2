package mod.ke2.command;

import mod.ke2.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.text.TextComponentString;

public class CommandReportBug extends CommandBase {
	@Override
	public String getName() {
		return "ke2bug";
	}
	@Override
	public String getUsage(ICommandSender sender) {
		return "/ke2bug [description]";
	}
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayerSP) {
			try {
				ScreenShotHelper.saveScreenshot(Minecraft.getMinecraft().mcDataDir, "latest.png", Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().getFramebuffer());
				sender.sendMessage(new TextComponentString(KAGIC.submitReport(sender.getName(), String.join(" ", args), "screenshots/latest.png", "logs/latest.log")));
			} catch (Exception e) {
				sender.sendMessage(new TextComponentString("Command failed; " + e.getMessage()));
			}
		}
	}
}