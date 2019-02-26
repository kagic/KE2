package mod.kagic.tileentity;

import mod.kagic.blocks.BlockCarbonite;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityCarbonite extends TileEntity {
	private long updateTime = -1;
	@Override
	public void setWorld(World world) {
		super.setWorld(world);
		this.updateTime = this.world.getWorldTime();
		this.markDirty();
    }
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setLong("UpdateTime", this.updateTime);
		return compound;
    }
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.updateTime = compound.getLong("UpdateTime");
    }
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return false;
    }
	public void activate(BlockCarbonite block, IBlockState from, BlockPos fromPos) {
		if (block.canBePowered()) {
			boolean activated = false;
			if (this.world.getTileEntity(fromPos) instanceof TileEntityCarbonite) {
				TileEntityCarbonite carbonite = (TileEntityCarbonite)(this.world.getTileEntity(fromPos));
				BlockCarbonite fromBlock = (BlockCarbonite)(from.getBlock());
				/*
				 * If the adjacent carbonite block IS powered, power WILL transfer to the
				 * current carbonite block ASSUMING the adjacent block is younger, and
				 * has a larger age in ticks.
				 * 
				 * If the adjacent carbonite block IS NOT powered, power on the current
				 * carbonite block WILL deplete ASSUMING the adjacent block is younger.
				 */
				if (fromBlock.isPowered()) {
					activated = carbonite.getUpdateTime() > this.updateTime;
				}
				else if (carbonite.getUpdateTime() > this.updateTime) {
					activated = false;
				}
			}
			if (this.world.isBlockPowered(this.pos)) {
				activated = true;
			}
			/*
			 * If activated and the block is not powered, power it.
			 * ~~OR~~
			 * If NOT activated and block is powered, unpower it.
			 */
			if ((activated && !block.isPowered()) || (!activated && block.isPowered())) {
				this.world.setBlockState(this.pos, block.getReverseState());
				this.updateTime = this.world.getWorldTime();
				this.markDirty();
			}
		}
	}
	public long getUpdateTime() {
		return this.updateTime;
	}
}
