package mod.ke2.world.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class WorldDataAuthorities extends WorldSavedData {
	private static final String DATA_NAME = "ke2_authorities";
	public static WorldDataAuthorities get(World world) {
		if (!world.isRemote) {
			MapStorage storage = world.getMapStorage();
			WorldDataAuthorities instance = (WorldDataAuthorities)(storage.getOrLoadData(WorldDataAuthorities.class, WorldDataAuthorities.DATA_NAME));
			if (instance == null) {
				storage.setData(WorldDataAuthorities.DATA_NAME, new WorldDataAuthorities());
			}
			return instance;
		}
		return null;
	}
	private final HashMap<UUID, UUID> authorities = new HashMap<UUID, UUID>();
	public WorldDataAuthorities(String name) {
		super(name);
	}
	public WorldDataAuthorities() {
		this(DATA_NAME);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		Iterator<String> it = compound.getKeySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); 
			this.authorities.put(UUID.fromString(key), compound.getUniqueId(key));
		}
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		Iterator<UUID> it = this.authorities.keySet().iterator();
		while (it.hasNext()) {
			UUID key = it.next();
			compound.setUniqueId(key.toString(), this.authorities.get(key));
		}
		return compound;
	}
	public void getAuthority(UUID id, UUID auth) {
		this.authorities.put(id, auth);
		this.markDirty();
	}
	public UUID getAuthority(UUID id) {
		return this.authorities.get(id);
	}
	public boolean isAuthorized(UUID foreign, UUID target) {
		UUID auth = this.getAuthority(foreign);
		if (auth != null) {
			Iterator<Entry<UUID, UUID>> it = this.authorities.entrySet().iterator();
			while (it.hasNext()) {
				Entry<UUID, UUID> entry = it.next();
				if (entry.getKey() == target) {
					return entry.getValue() == auth;
				}
			}
		}
		return false;
	}
}
