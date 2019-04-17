package mod.ke2.api.injection;

import java.util.UUID;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GemSpawnData implements IEntityLivingData {
	protected final UUID owner;
	protected final int color;
	protected final boolean defective;
	protected final boolean perfective;
	protected World world;
	protected BlockPos pos;
	public GemSpawnData(UUID owner, int color, boolean defective, boolean perfective) {
		this.owner = owner;
		this.color = color;
		this.defective = defective;
		this.perfective = perfective;
	}
	public GemSpawnData(UUID owner, int color) {
		this(owner, color, false, false);
	}
	public GemSpawnData() {
		this(new UUID(0, 0), -1);
	}
	public UUID getOwner() {
		return this.owner;
	}
	public int getColor() {
		return this.color;
	}
	public boolean isDefective() {
		return this.defective;
	}
	public boolean isPerfective() {
		return this.perfective;
	}
	public void setSpawn(World world, BlockPos pos) {
		this.world = world;
		this.pos = pos;
	}
	public boolean hasSpawn() {
		return world != null && pos != null;
	}
	public World getWorld() {
		return this.world;
	}
	public BlockPos getPosition() {
		return this.pos;
	}
}
