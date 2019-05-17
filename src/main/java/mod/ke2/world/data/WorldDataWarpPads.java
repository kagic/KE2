package mod.ke2.world.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import mod.ke2.api.warping.WarpPadDataEntry;
import mod.ke2.api.warping.WarpPadPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class WorldDataWarpPads extends WorldSavedData {
	private static final String NAMESPACE = "ke2_warp_pads";
	public static WorldDataWarpPads get(World world) {
		if (!world.isRemote) {
			MapStorage storage = world.getPerWorldStorage();
			WorldDataWarpPads instance = (WorldDataWarpPads) storage.getOrLoadData(WorldDataWarpPads.class, WorldDataWarpPads.NAMESPACE);
			if (instance == null) {
				instance = new WorldDataWarpPads();
				storage.setData(WorldDataWarpPads.NAMESPACE, instance);
			}
			return instance;
		}
		return null;
	}
	private final HashMap<WarpPadPos, WarpPadDataEntry> entries = new HashMap<WarpPadPos, WarpPadDataEntry>();
	public WorldDataWarpPads() {
		super(WorldDataWarpPads.NAMESPACE);
	}
	public WorldDataWarpPads(String identifier) {
		super(identifier);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		NBTTagList list = new NBTTagList();
		Iterator<WarpPadDataEntry> it = this.entries.values().iterator();
		while (it.hasNext()) {
			list.appendTag(it.next().writeToNBT(new NBTTagCompound()));
		}
		compound.setTag("WarpPads", list);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList list = compound.getTagList("WarpPads", 10);
		for (int i = 0; i < list.tagCount(); ++i) {
			WarpPadDataEntry entry = WarpPadDataEntry.readFromNBT(list.getCompoundTagAt(i));
			this.entries.put(entry.getPos(), entry);
		}
	}
	public void addWarpPadEntry(String name, boolean valid, boolean clear, WarpPadPos pos) {
		this.entries.put(pos, new WarpPadDataEntry(name, valid, clear, pos));
		this.markDirty();
	}
	public void removeWarpPadEntry(WarpPadPos pos) {
		if (this.entries.containsKey(pos)) {
			this.entries.remove(pos);
			this.markDirty();
		}
	}
	public WarpPadDataEntry getWarpPadEntry(WarpPadPos pos) {
		return this.entries.get(pos);
	}
	public HashMap<WarpPadPos, WarpPadDataEntry> getWarpPadData() {
		return this.entries;
	}
	public static SortedMap<Double, WarpPadDataEntry> getSortedPositions(HashMap<WarpPadPos, WarpPadDataEntry> data, BlockPos pos) {
		SortedMap<Double, WarpPadDataEntry> sortedWarpPads = new TreeMap<Double, WarpPadDataEntry>();
		Set<Entry<WarpPadPos, WarpPadDataEntry>> set = data.entrySet();
		Iterator<Entry<WarpPadPos, WarpPadDataEntry>> it = set.iterator();
		while (it.hasNext()) {
			WarpPadDataEntry entry = it.next().getValue();
			WarpPadPos party = it.next().getKey();
			double distance = pos.distanceSq(party.getX(), party.getY(), party.getZ());
			sortedWarpPads.put(distance, entry);
		}
		return sortedWarpPads;
	}
}