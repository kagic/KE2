package mod.ke2.entity.machine.ai;

import mod.ke2.api.injection.GemSpawnData;
import mod.ke2.entity.machine.EntityInjector;
import mod.ke2.init.Ke2Blocks;
import mod.ke2.tileentity.TileEntityGemSeed;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIFindInjectionPoint extends EntityAIMoveToBlock {
	private final EntityInjector injector;
	public EntityAIFindInjectionPoint(EntityInjector injector, double speed) {
		super(injector, speed, 16);
		this.injector = injector;
	}
	@Override
	public boolean shouldExecute() {
		if (this.injector.canInject()) {
			if (this.runDelay < 0) {
				boolean shouldExecute = super.shouldExecute();
	            this.runDelay = 100 + this.injector.getRNG().nextInt(100);
	            return shouldExecute;
			}
	        else {
	            --this.runDelay;
	            return false;
	        }
		}
		return false;
	}
	@Override
	public boolean shouldContinueExecuting() {
		return super.shouldContinueExecuting() && !this.injector.getNavigator().noPath();
	}
	@Override
	public void startExecuting() {
		super.startExecuting();
	}
	@Override
	public void resetTask() {
		super.resetTask();
	}
	@Override
	public void updateTask() {
		super.updateTask();
		this.injector.getLookHelper().setLookPosition(this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY() + 1, this.destinationBlock.getZ() + 0.5D, 10.0F, this.injector.getVerticalFaceSpeed());
		if (this.getIsAboveDestination()) {
			BlockPos point = new BlockPos(this.destinationBlock.getX(), this.getRelativeY(this.injector.world, this.destinationBlock), this.destinationBlock.getZ());
			this.injector.world.setBlockState(point, Ke2Blocks.GEM_SEED.getDefaultState());
			if (Ke2Blocks.GEM_SEED.getGemSeed(this.injector.world, point) != null) {
				TileEntityGemSeed seed = Ke2Blocks.GEM_SEED.getGemSeed(this.injector.world, point);
				seed.setData(new GemSpawnData(this.injector.getLatestOwnerID(true), this.injector.getColor()));
				this.injector.setSeedCount(this.injector.getSeedCount() - 1);
			}
		}
	}
	@Override
	protected boolean shouldMoveTo(World world, BlockPos pos) {
		return this.getRelativeY(world, pos) > 0;
	}
	public int getRelativeY(World world, BlockPos pos) {
		if (!world.isAirBlock(pos)) {
			int maxalt = pos.getY() - 4;
			for (int y = 5; y < maxalt; ++y) {
				BlockPos check = new BlockPos(pos.getX(), y, pos.getZ());
				if (!this.isBlockValidAt(world, check)) {
					y += 4;
					if (y > maxalt) {
						return -1;
					}
				}
				else {
					for (int j = -4; j <= 4; ++j) {
						for (int x = -1; x <= 1; ++x) {
							for (int z = -1; z <= 1; ++z) {
								if (!this.isBlockValidAt(world, check.add(x, j, z))) {
									return -1;
								}
							}
						}
					}
					boolean aired = false;
					if (!aired) {
						for (int i = 2; i <= 4; ++i) {
							if (i == 4 && (!this.isBlockValidAt(world, check.add(-i, 0, 0)) || !this.isBlockValidAt(world, check.add( i, 0, 0)))) {
								boolean canSeeUp = true;
								for (int j = 0; j <= 16; ++j) {
									if (!this.isBlockValidAt(world, check.add(-i, j, 0)) || !this.isBlockValidAt(world, check.add( i, j, 0))) {
										canSeeUp = false;
									}
									else if (!canSeeUp) {
										canSeeUp = true;
										break;
									}
								}
								aired = canSeeUp;
								if (aired) {
									break;
								}
							}
						}
					}
					if (!aired) {
						for (int i = 2; i <= 4; ++i) {
							if (i == 4 && (!this.isBlockValidAt(world, check.add(0, 0, -i)) || !this.isBlockValidAt(world, check.add(0, 0,  i)))) {
								boolean canSeeUp = true;
								for (int j = 0; j <= 16; ++j) {
									if (!this.isBlockValidAt(world, check.add(0, j, -i)) || !this.isBlockValidAt(world, check.add(0, j,  i))) {
										canSeeUp = false;
									}
									else if (!canSeeUp) {
										canSeeUp = true;
										break;
									}
								}
								aired = canSeeUp;
								if (aired) {
									break;
								}
							}
						}
					}
					if (!aired) {
						return -1;
					}
					return y;
				}
			}
		}
		return -1;
	}
	public boolean isBlockValidAt(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		return this.isBlockValid(block);
	}
	public boolean isBlockValid(Block block) {
		if (block == Ke2Blocks.GEM_SEED || block == Blocks.AIR || block instanceof BlockLiquid) {
			return false;
		}
		return true;
	}
}