package mod.ke2.world.data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import mod.ke2.KAGIC;
import mod.ke2.api.warping.GalaxyWarpPadLocation;
import mod.ke2.api.warping.WarpPadDataEntry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants;

public class WorldDataGalaxyWarpPad extends WorldSavedData {
	private static final String DATA_NAME = KAGIC.MODID + "_galaxypads";
	private final Map<GalaxyWarpPadLocation, WarpPadDataEntry> galaxyPadData = new LinkedHashMap<GalaxyWarpPadLocation, WarpPadDataEntry>();
	
	public WorldDataGalaxyWarpPad() {
		super(DATA_NAME);
	}
	
	public WorldDataGalaxyWarpPad(String identifier) {
		super(identifier);
	}
	
	public static WorldDataGalaxyWarpPad get(World world) {
		if (!world.isRemote) {
			MapStorage storage = world.getMapStorage();
			WorldDataGalaxyWarpPad instance = (WorldDataGalaxyWarpPad) storage.getOrLoadData(WorldDataGalaxyWarpPad.class, DATA_NAME);
			if (instance == null) {
				//KAGICTech.instance.chatInfoMessage("Data on server was null");
				instance = new WorldDataGalaxyWarpPad();
				storage.setData(DATA_NAME, instance);
			}
			return instance;
		}
		else {
			return null;
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		NBTTagList list = new NBTTagList();
		Iterator<Entry<GalaxyWarpPadLocation, WarpPadDataEntry>> it = this.galaxyPadData.entrySet().iterator();
		while (it.hasNext()) {
			NBTTagCompound tc = new NBTTagCompound();
			Entry<GalaxyWarpPadLocation, WarpPadDataEntry> pair = it.next();
			tc.setString("name", ((WarpPadDataEntry)(pair.getValue())).name);
			tc.setBoolean("valid", ((WarpPadDataEntry)(pair.getValue())).valid);
			tc.setBoolean("clear", ((WarpPadDataEntry)(pair.getValue())).clear);
			tc.setInteger("dim", ((GalaxyWarpPadLocation) pair.getKey()).getDimension());
			tc.setInteger("x", ((GalaxyWarpPadLocation) pair.getKey()).getPos().getX());
			tc.setInteger("y", ((GalaxyWarpPadLocation) pair.getKey()).getPos().getY());
			tc.setInteger("z", ((GalaxyWarpPadLocation) pair.getKey()).getPos().getZ());
			list.appendTag(tc);
		}
		compound.setTag("pads", list);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList list = compound.getTagList("pads", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound tc = list.getCompoundTagAt(i);
			int dim = tc.getInteger("dim");
			BlockPos pos = new BlockPos(tc.getInteger("x"), tc.getInteger("y"), tc.getInteger("z"));
			String name = tc.getString("name");
			boolean valid = tc.getBoolean("valid");
			boolean clear = tc.getBoolean("clear");
			this.galaxyPadData.put(new GalaxyWarpPadLocation(dim, pos), new WarpPadDataEntry(name, valid, clear));
		}
	}
	
	public void addGalaxyPadEntry(String name, boolean valid, boolean clear, GalaxyWarpPadLocation gLoc) {
		this.galaxyPadData.put(gLoc, new WarpPadDataEntry(name, valid, clear));
		this.markDirty();
	}
	public void removeGalaxyPadEntry(GalaxyWarpPadLocation gpLoc) {
		if (this.galaxyPadData.containsKey(gpLoc)) {
			this.galaxyPadData.remove(gpLoc);
			this.markDirty();
		}
	}
	public String getNameFromPos(GalaxyWarpPadLocation gpLoc) {
		if (this.galaxyPadData.containsKey(gpLoc)) {
			return this.galaxyPadData.get(gpLoc).name;			
		}
		else {
			return null;
		}
	}
	public Map<GalaxyWarpPadLocation, WarpPadDataEntry> getGalaxyPadData() {
		return this.galaxyPadData;
	}
	public static SortedMap<Double, GalaxyWarpPadLocation> getSortedPositions(Map<GalaxyWarpPadLocation, WarpPadDataEntry> data, BlockPos pos) {
		SortedMap<Double, GalaxyWarpPadLocation> sortedPoses = new TreeMap<Double, GalaxyWarpPadLocation>();
		Set<Entry<GalaxyWarpPadLocation, WarpPadDataEntry>> entrySet = data.entrySet();
		Iterator<Entry<GalaxyWarpPadLocation, WarpPadDataEntry>> it = entrySet.iterator();
		while (it.hasNext()) {
			GalaxyWarpPadLocation gLoc = ((GalaxyWarpPadLocation)it.next().getKey());
			BlockPos otherPos = gLoc.getPos();
			if (otherPos.equals(pos)) {
				continue;
			}
			double dist = pos.distanceSq(otherPos.getX(), otherPos.getY(), otherPos.getZ());
			sortedPoses.put(dist, gLoc);
		}
		return sortedPoses;
	}
}
