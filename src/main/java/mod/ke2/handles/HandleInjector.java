package mod.ke2.handles;

import mod.ke2.entity.machine.EntityInjector;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleInjector {
	@SubscribeEvent
	public void onBlockPlace(BlockEvent.PlaceEvent e) {
		IBlockState state = e.getPlacedBlock();
		int metadata = 0;
		if (state.getBlock() == Blocks.STAINED_GLASS) {
			metadata = state.getValue(BlockStainedGlass.COLOR).getDyeDamage();
			state = e.getWorld().getBlockState(e.getPos().down(1));
			if (state.getBlock() == Blocks.STAINED_GLASS
			&&  state.getValue(BlockStainedGlass.COLOR).getDyeDamage() == metadata) {
				state = e.getWorld().getBlockState(e.getPos().down(2));
				if (state.getBlock() == Blocks.ANVIL) {
					state = e.getWorld().getBlockState(e.getPos().down(3));
					if (state.getBlock() == Blocks.DISPENSER
					&&  state.getValue(BlockDispenser.FACING) == EnumFacing.DOWN) {
						IBlockState north = e.getWorld().getBlockState(e.getPos().down(3).north());
						IBlockState south = e.getWorld().getBlockState(e.getPos().down(3).south());
						IBlockState east  = e.getWorld().getBlockState(e.getPos().down(3).east());
						IBlockState west  = e.getWorld().getBlockState(e.getPos().down(3).west());
						if (north.getBlock() == Blocks.IRON_BARS && south.getBlock() == Blocks.IRON_BARS
						&& east.getBlock() == Blocks.IRON_BARS && west.getBlock() == Blocks.IRON_BARS) {
							state = e.getWorld().getBlockState(e.getPos().down(4));
							if (state.getBlock() == Blocks.HOPPER) {
								north = e.getWorld().getBlockState(e.getPos().down(4).north());
								south = e.getWorld().getBlockState(e.getPos().down(4).south());
								east  = e.getWorld().getBlockState(e.getPos().down(4).east());
								west  = e.getWorld().getBlockState(e.getPos().down(4).west());
								if (north.getBlock() == Blocks.IRON_BARS && south.getBlock() == Blocks.IRON_BARS
								&& east.getBlock() == Blocks.IRON_BARS && west.getBlock() == Blocks.IRON_BARS) {
									e.getItemInHand().shrink(1);
									e.getWorld().destroyBlock(e.getPos().down(1), false);
									e.getWorld().destroyBlock(e.getPos().down(2), false);
									e.getWorld().destroyBlock(e.getPos().down(3), false);
									e.getWorld().destroyBlock(e.getPos().down(3).north(), false);
									e.getWorld().destroyBlock(e.getPos().down(3).south(), false);
									e.getWorld().destroyBlock(e.getPos().down(3).east(), false);
									e.getWorld().destroyBlock(e.getPos().down(3).west(), false);
									e.getWorld().destroyBlock(e.getPos().down(4), false);
									e.getWorld().destroyBlock(e.getPos().down(4).north(), false);
									e.getWorld().destroyBlock(e.getPos().down(4).south(), false);
									e.getWorld().destroyBlock(e.getPos().down(4).east(), false);
									e.getWorld().destroyBlock(e.getPos().down(4).west(), false);
									e.setCanceled(true);
									if (!e.getWorld().isRemote) {
										EntityInjector injector = new EntityInjector(e.getWorld());
										injector.setPosition(e.getPos().getX() + 0.5F, e.getPos().getY() - 4, e.getPos().getZ() + 0.5F);
										injector.setColor(metadata);
										injector.setHealth(20.0F);
										e.getWorld().spawnEntity(injector);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
