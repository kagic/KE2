package mod.ke2.command;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
				sender.sendMessage(new TextComponentString("Creating bug report..."));
				ScreenShotHelper.saveScreenshot(Minecraft.getMinecraft().mcDataDir, "./logs/screen.png", Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().getFramebuffer());
				FileOutputStream f = new FileOutputStream("./report.zip"); ZipOutputStream zip = new ZipOutputStream(f);
				String[] files = new String[] { "./logs/screen.png", "./logs/latest.log" };
				for (int i = 0; i < files.length; ++i) {
					zip.putNextEntry(new ZipEntry(files[i]));
					FileInputStream input = new FileInputStream(files[i]);
		            byte[] buffer = new byte[1024]; int offset;
		            while ((offset = input.read(buffer)) > 0) {
		                zip.write(buffer, 0, offset);
		            }
		            zip.closeEntry();
		            input.close();
				}
	            zip.close();
	            f.close();
				sender.sendMessage(new TextComponentString("Sending bug report..."));
			} catch (IOException e) {
				sender.sendMessage(new TextComponentString("Command failed; " + e.getMessage()));
			}
		}
	}
}