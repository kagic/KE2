package mod.ke2.handles;

import mod.ke2.entity.vehicle.EntityPalanquin;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandlePalanquin {
	@SubscribeEvent
	public void onBlockPlace(BlockEvent.PlaceEvent e) {
		IBlockState state = e.getPlacedBlock();
		boolean failed = false;
		int seatColor = -1;
		int bodyColor = -1;
		int veilColor = -1;
		if (state.getBlock() == Blocks.WOOL) {
			seatColor = state.getValue(BlockColored.COLOR).getDyeDamage();
			state = e.getWorld().getBlockState(e.getPos().down(1));
			if (state.getBlock() == Blocks.CONCRETE) {
				bodyColor = state.getValue(BlockColored.COLOR).getDyeDamage();
				for (int x = -1; x <= 1; ++x) {
					for (int z = -1; z <= 1; ++z) {
						state = e.getWorld().getBlockState(e.getPos().add(x, -1, z));
						if (state.getBlock() == Blocks.CONCRETE && state.getValue(BlockColored.COLOR).getDyeDamage() == bodyColor) { }
						else {
							failed = true;
							break;
						}
					}
					if (failed) {
						break;
					}
				}
				if (!failed) {
					int airX = 0; int airZ = 0;
					for (int y = 0; y <= 3; ++y) {
						for (int x = -1; x <= 1; ++x) {
							for (int z = -1; z <= 1; ++z) {
								state = e.getWorld().getBlockState(e.getPos().add(x, y, z));
								if (x == 0 && z == 0) {
									if (y == 0) {
										if (state.getBlock() != Blocks.WOOL) {
											failed = true;
											break;
										}
									}
									else {
										if (state.getBlock() != Blocks.AIR) {
											failed = true;
											break;
										}
									}
								}
								else {
									System.out.println(state);
									if (state.getBlock() == Blocks.AIR) {
										if (y == 0) {
											airX = x; airZ = z;
										}
										else if (airX == x && airZ == z) {
											continue;
										}
										else {
											failed = true;
											break;
										}
									}
									else {
										if (airX == x && airZ == z) {
											failed = true;
											break;
										}
										else {
											if (state.getBlock() == Blocks.STAINED_GLASS) {
												if (veilColor == -1) {
													veilColor = state.getValue(BlockStainedGlass.COLOR).getDyeDamage();
												}
												else if (state.getValue(BlockStainedGlass.COLOR).getDyeDamage() == veilColor) {
													continue;
												}
												else {
													failed = true;
													break;
												}
											}
											else {
												failed = true;
												break;
											}
										}
									}
								}
							}
							if (failed) {
								break;
							}
						}
						if (failed) {
							break;
						}
					}
				}
				if (!failed) {
					for (int x = -1; x <= 1; ++x) {
						for (int z = -1; z <= 1; ++z) {
							state = e.getWorld().getBlockState(e.getPos().add(x, 4, z));
							if (state.getBlock() == Blocks.CONCRETE && state.getValue(BlockColored.COLOR).getDyeDamage() == bodyColor) { }
							else {
								failed = true;
								break;
							}
						}
						if (failed) {
							break;
						}
					}
				}
				if (!failed) {
					e.getItemInHand().shrink(1);
					for (int y = -1; y <= 5; ++y) {
						for (int x = -1; x <= 1; ++x) {
							for (int z = -1; z <= 1; ++z) {
								e.getWorld().destroyBlock(e.getPos().add(x, y, z), false);
							}
						}
					}
					e.setCanceled(true);
					if (!e.getWorld().isRemote) {
						EntityPalanquin palanquin = new EntityPalanquin(e.getWorld());
						palanquin.setPosition(e.getPos().getX() + 0.5F, e.getPos().getY() - 1, e.getPos().getZ() + 0.5F);
						palanquin.setHighlightColor(seatColor);
						palanquin.setBodyColor(bodyColor);
						palanquin.setVeilColor(veilColor);
						palanquin.setHealth(20.0F);
						e.getWorld().spawnEntity(palanquin);
					}
				}
			}
		}
	}
}
