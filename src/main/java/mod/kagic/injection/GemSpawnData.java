package mod.kagic.injection;

import java.util.UUID;

import net.minecraft.entity.IEntityLivingData;

public class GemSpawnData implements IEntityLivingData {
	protected final UUID owner;
	protected final int color;
	protected final boolean defective;
	protected final boolean perfect;
	public GemSpawnData(UUID owner, int color, boolean defective, boolean perfect) {
		this.owner = owner;
		this.color = color;
		this.defective = defective;
		this.perfect = perfect;
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
	public boolean isPerfect() {
		return this.perfect;
	}
}
