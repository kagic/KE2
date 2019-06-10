package mod.ke2.tileentity;

import mod.ke2.block.BlockCarbonite;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityCarbonite extends TileEntity implements ITickable {
	private boolean isPoweredByRedstone = false;
	private boolean isAttachedToPoweredBlock = false;
	public int ticksExisted = 0;
	@Override
	public void update() {
		++this.ticksExisted;
		if (!this.world.isRemote) {
			if (this.world.isBlockPowered(this.pos)) {
				this.isPoweredByRedstone = true;
				this.turnOn();
				return;
			}
			else if (this.isPoweredByRedstone) {
				this.turnOff();
				return;
			}
			else {
				for (int i = 0; i < EnumFacing.VALUES.length; ++i) {
					EnumFacing face = EnumFacing.VALUES[i]; BlockPos check = this.pos.offset(face);
					Block block = this.world.getBlockState(check).getBlock();
					if (block instanceof BlockCarbonite) {
						TileEntityCarbonite entity = (TileEntityCarbonite)(this.world.getTileEntity(check));
						if (entity.isPowered()) {
							if (entity.isAttachedToPoweredBlock()) {
								this.isAttachedToPoweredBlock = entity.isPoweredByRedstone();
								this.turnOn();
								return;
							}
							else if (entity.isPoweredByRedstone()) {
								this.isAttachedToPoweredBlock = true;
								this.turnOn();
								return;
							}
						}
						this.isAttachedToPoweredBlock = false;
					}
				}
			}
			this.turnOff();
		}
	}
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState original, IBlockState state) {
        return state.getBlock() instanceof BlockCarbonite;
    }
	public void turnOff() {
		this.ticksExisted = 0;
		Block block = this.world.getBlockState(this.pos).getBlock();
		if (block instanceof BlockCarbonite) {
			BlockCarbonite carbonite = (BlockCarbonite)(block);
			if (carbonite.isPowered() && carbonite.canBePowered()) {
				this.world.setBlockState(this.pos, carbonite.getReverseState());
			}
		}
	}
	public void turnOn() {
		this.ticksExisted = 0;
		Block block = this.world.getBlockState(this.pos).getBlock();
		if (block instanceof BlockCarbonite) {
			BlockCarbonite carbonite = (BlockCarbonite)(block);
			if (!carbonite.isPowered() && carbonite.canBePowered()) {
				this.world.setBlockState(this.pos, carbonite.getReverseState());
			}
		}
	}
	public boolean isPowered() {
		Block block = this.world.getBlockState(this.pos).getBlock();
		if (block instanceof BlockCarbonite) {
			BlockCarbonite carbonite = (BlockCarbonite)(block);
			return carbonite.isPowered() && carbonite.canBePowered();
		}
		return false;
	}
	public boolean isAttachedToPoweredBlock() {
		return this.isAttachedToPoweredBlock;
	}
	public boolean isPoweredByRedstone() {
		return this.isPoweredByRedstone;
	}
}
