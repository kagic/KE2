package mod.ke2.world.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class WorldDataFactions extends WorldSavedData {
	private static final String NAMESPACE = "ke2_factions";
	public static WorldDataFactions get(World world) {
		if (!world.isRemote) {
			MapStorage storage = world.getMapStorage();
			WorldDataFactions instance = (WorldDataFactions)(storage.getOrLoadData(WorldDataFactions.class, WorldDataFactions.NAMESPACE));
			if (instance == null) {
				storage.setData(WorldDataFactions.NAMESPACE, new WorldDataFactions());
				return WorldDataFactions.get(world);
			}
			else {
				return instance;
			}
		}
		return null;
	}
	private final HashMap<UUID, UUID> factions = new HashMap<UUID, UUID>();
	public WorldDataFactions(String name) {
		super(name);
	}
	public WorldDataFactions() {
		this(WorldDataFactions.NAMESPACE);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		Iterator<String> it = compound.getKeySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); 
			this.factions.put(UUID.fromString(key), compound.getUniqueId(key));
		}
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		Iterator<UUID> it = this.factions.keySet().iterator();
		while (it.hasNext()) {
			UUID key = it.next();
			compound.setUniqueId(key.toString(), this.factions.get(key));
		}
		return compound;
	}
	public void addFaction(UUID id) {
		if (!this.factions.containsKey(id)) {
			this.factions.put(id, id);
			this.markDirty();
		}
	}
	public void setFaction(UUID id, UUID faction) {
		if (this.factions.containsKey(id)) {
			this.factions.put(id, faction);
			this.markDirty();
		}
	}
	public UUID getFaction(UUID id) {
		return this.factions.get(id);
	}
	public boolean isAuthorized(UUID foreign, UUID target) {
		UUID foreignFaction = this.getFaction(foreign); UUID targetFaction = this.getFaction(target);
		if (foreignFaction.equals(targetFaction) || targetFaction.equals(foreignFaction)) {
			return true;
		}
		return false;
	}
}
