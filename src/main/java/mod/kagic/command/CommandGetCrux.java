package mod.kagic.command;

import java.util.ArrayList;

import mod.kagic.init.Ke2Gems;
import mod.kagic.injection.CruxEntry;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

public class CommandGetCrux extends CommandBase {
	@Override
	public String getName() {
		return "getcrux";
	}
	@Override
	public String getUsage(ICommandSender sender) {
		return "/getcrux [gem]";
	}
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 0) {
			try {
				ArrayList<CruxEntry> cruxes = Ke2Gems.CRUXES.get(new ResourceLocation(args[0]));
				ArrayList<String> entries = new ArrayList<String>();
				String message = "";
				for (CruxEntry crux : cruxes) {
					IBlockState state = crux.getState();
					if (state.getBlock() instanceof BlockLiquid) {
						if (state.getBlock() == Blocks.FLOWING_WATER) {
							message += "\n- " + "Flowing Water" + ": " + crux.getYield() + " (below y=" + crux.getLimit() + ")";
						}
						else if (state.getBlock() == Blocks.WATER) {
							message += "\n- " + "Water" + ": " + crux.getYield() + " (below y=" + crux.getLimit() + ")";
						}
						else if (state.getBlock() == Blocks.FLOWING_LAVA) {
							message += "\n- " + "Flowing Lava" + ": " + crux.getYield() + " (below y=" + crux.getLimit() + ")";
						}
						else if (state.getBlock() == Blocks.LAVA){
							message += "\n- " + "Lava" + ": " + crux.getYield() + " (below y=" + crux.getLimit() + ")";
						}
						else {
							message += "\n- " + "Unknown Liquid" + ": " + crux.getYield() + " (below y=" + crux.getLimit() + ")";
						}
					}
					else {
						String name = new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state)).getDisplayName();
						if (!entries.contains(name)) {
							message += "\n- " + name + ": " + crux.getYield() + " (below y=" + crux.getLimit() + ")";
							entries.add(name);
						}
					}
				}
				sender.sendMessage(new TextComponentString(message + "\n"));
			}
			catch (Exception e) {
				throw new CommandException("Crux check failed.");
			}
		}
	}
}