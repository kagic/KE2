package mod.ke2.api.injection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import mod.ke2.api.EntityGem;
import mod.ke2.entity.EntityGemBurst;
import mod.ke2.init.Ke2Blocks;
import mod.ke2.init.Ke2Cruxes;
import mod.ke2.init.Ke2Gems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InjectorResult {
	public static final Block[] RED_DRAIN_BLOCKS = new Block[] { Ke2Blocks.LIGHT_RED_DRAIN_BLOCK, Ke2Blocks.BANDED_RED_DRAIN_BLOCK, Ke2Blocks.DARK_RED_DRAIN_BLOCK, Ke2Blocks.ERODED_RED_DRAIN_BLOCK };
	public static final Block[] ORANGE_DRAIN_BLOCKS = new Block[] { Ke2Blocks.LIGHT_ORANGE_DRAIN_BLOCK, Ke2Blocks.BANDED_ORANGE_DRAIN_BLOCK, Ke2Blocks.DARK_ORANGE_DRAIN_BLOCK, Ke2Blocks.ERODED_ORANGE_DRAIN_BLOCK };
	public static final Block[] PURPLE_DRAIN_BLOCKS = new Block[] { Ke2Blocks.LIGHT_PURPLE_DRAIN_BLOCK, Ke2Blocks.BANDED_PURPLE_DRAIN_BLOCK, Ke2Blocks.DARK_PURPLE_DRAIN_BLOCK, Ke2Blocks.ERODED_PURPLE_DRAIN_BLOCK };
	public static final Block[] BLUE_DRAIN_BLOCKS = new Block[] { Ke2Blocks.LIGHT_BLUE_DRAIN_BLOCK, Ke2Blocks.BANDED_BLUE_DRAIN_BLOCK, Ke2Blocks.DARK_BLUE_DRAIN_BLOCK, Ke2Blocks.ERODED_BLUE_DRAIN_BLOCK };
	public static final double CRUX_MARGIN = 1.0D;
	private final EntityGem gem;
	private final BlockPos position;
	private final ExitHole exitHole;
	private final GemSpawnData data;
	public InjectorResult(EntityGem gem, BlockPos position, ExitHole exitHole, GemSpawnData data) {
		this.gem = gem;
		this.position = position;
		this.exitHole = exitHole;
		this.data = data; 
	}
	public EntityGem getGem() {
		return this.gem;
	}
	public String getName() {
		return this.gem.getName();
	}
	public BlockPos getPosition() {
		return this.position;
	}
	public GemSpawnData getData() {
		return this.data;
	}
	public ExitHole getExitHole() {
		return this.exitHole;
	}
	public void generate(World world) {
		this.exitHole.emerge(world);
		this.gem.onInitialSpawn(world.getDifficultyForLocation(this.getPosition()), this.data);
		if (!world.isRemote) {
			world.spawnEntity(this.gem);
		}
	}
	public static InjectorResult create(World world, BlockPos pos, boolean generate) {
		return InjectorResult.create(world, pos, generate, new UUID(0, 0), -1);
	}
	public static InjectorResult create(World world, BlockPos pos, boolean generate, UUID owner, int color) {
		HashMap<ResourceLocation, ArrayList<CruxEntry>> cruxes = Ke2Cruxes.TABLE;
		ArrayList<CruxCandidate> image = new ArrayList<CruxCandidate>();
		for (int y = -2; y < 2; ++y) {
			for (int x = -2; x < 2; ++x) {
				for (int z = -2; z < 2; ++z) {
					image.add(new CruxCandidate(world.getBlockState(pos.add(x, y, z)), world, pos.add(x, y, z)));
				}
			}
		}
		double volume = 0.0;
		HashMap<ResourceLocation, Double> yields = new HashMap<ResourceLocation, Double>();
		Iterator<ResourceLocation> gits = cruxes.keySet().iterator();
		while (gits.hasNext()) {
			ResourceLocation gem = gits.next();
			Iterator<CruxEntry> crits = cruxes.get(gem).iterator();
			yields.put(gem, 0.0);
			while (crits.hasNext()) {
				CruxEntry crit = crits.next();
				Iterator<CruxCandidate> bits = image.iterator();
				while (bits.hasNext()) {
					double former = yields.get(gem);
					yields.put(gem, yields.get(gem) + crit.getYield(bits.next()));
					if (yields.get(gem) - former > 0.0) {
						volume += 1.0;
					}
				}
			}
		}
		double random = Math.random() * volume * CRUX_MARGIN;
		ResourceLocation key = null;
		ArrayList<ResourceLocation> table = new ArrayList<ResourceLocation>(yields.keySet());
		Collections.shuffle(table);
		for (ResourceLocation gem : table) {
			double yield = yields.get(gem);
			random -= yield;
			if (random <= 0.0) {
				random = yield;
				key = gem;
				break;
			}
		}
		EntityGem gem = new EntityGemBurst(world);
		if (key != null) {
			try {
				gem = (EntityGem)(Ke2Gems.REGISTRY.get(key).getConstructors()[0].newInstance(world));
			} catch (Exception e) {
				System.out.println("Gem called '" + key + "' failed to load!");
				return null;
			}
		}
		ExitHole exit = null; float angle = world.rand.nextFloat();
		if (generate) {
			exit = ExitHole.create(world, pos, gem.height, gem.width, random > (volume * 0.8));
			exit.emerge(world); angle = exit.getAngle();
			for (int y = -2 - (int)(gem.width); y <= 2 + (int)(gem.width); ++y) {
				for (int x = -2 - (int)(gem.width); x <= 2 + (int)(gem.width); ++x) {
					for (int z = -2 - (int)(gem.width); z <= 2 + (int)(gem.width); ++z) {
						if (Math.random() * (Math.abs((y + x + z) / 3) + 1) < 1.0D) {
							InjectorResult.drain(world, pos.add(x, y, z));
						}
					}
				}
			}
			for (int y = -2 - (int)(gem.width / 2.0F); y < 2 + (int)(gem.width / 2.0F); ++y) {
				for (int x = -2 - (int)(gem.width / 2.0F); x < 2 + (int)(gem.width / 2.0F); ++x) {
					for (int z = -2 - (int)(gem.width / 2.0F); z < 2 + (int)(gem.width / 2.0F); ++z) {
						InjectorResult.drain(world, pos.add(x, y, z));
					}
				}
			}
		}
		gem.setPositionAndRotation(pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, angle, 0.0F);
		GemSpawnData data = new GemSpawnData(owner, color, random < (volume * 0.1), random > (volume * 0.8));
		return new InjectorResult(gem, pos, exit, data);
	}
	public static void drain(World world, BlockPos pos, Block[] blocks) {
		if (blocks == null) {
			blocks = PURPLE_DRAIN_BLOCKS;
			if (world.provider.isNether()) {
				blocks = RED_DRAIN_BLOCKS;
			}
			else {
				float temp = world.getBiome(pos).getTemperature(pos);
				if (world.canSnowAt(pos, false)) {
					blocks = BLUE_DRAIN_BLOCKS;
				}
				else if (temp > 0.95) {
					blocks = ORANGE_DRAIN_BLOCKS;
				}
				else {
					blocks = PURPLE_DRAIN_BLOCKS;
				}
			}
		}
		IBlockState state = world.getBlockState(pos);
		Material material = state.getMaterial();
		if (state.getBlockHardness(world, pos) >= 0) {
			if (material == Material.ROCK || state.isFullCube()) {
				if (pos.getY() % 6 == 0 || pos.getY() % 6 == 1) {
					world.setBlockState(pos, blocks[0].getDefaultState());
				}
				else if (pos.getY() % 5 == 0) {
					world.setBlockState(pos, blocks[1].getDefaultState());
				}
				else {
					world.setBlockState(pos, blocks[2].getDefaultState());
				}
			}
			if (material == Material.SAND) {
				world.setBlockState(pos, blocks[3].getDefaultState());
			}
			if (material == Material.PLANTS) {
				if (world.getBlockState(pos).getBlock() == Blocks.WATERLILY) {
					world.setBlockState(pos, Ke2Blocks.MOSS_ROSE.getDefaultState());
					for (int x = -1; x <= 1; ++x) {
						for (int z = -1; z <= 1; ++z) {
							if (world.rand.nextBoolean()) {
								BlockPos check = pos.add(x, -1, z);
								if (world.getBlockState(check).getMaterial() == Material.WATER) {
									world.setBlockState(check, Ke2Blocks.MAGIC_MOSS.getDefaultState());
								}
							}
						}
					}
				}
				else {
					world.setBlockState(pos, InjectorResult.getDrainLily(world, pos));
				}
			}
		}
	}
	public static void drain(World world, BlockPos pos) {
		InjectorResult.drain(world, pos, null);
	}
	public static IBlockState getDrainLily(World world, BlockPos pos) {
		if (world.provider.isNether()) {
			return Ke2Blocks.NETHER_DRAIN_LILY.getDefaultState();
		}
		else {
			float temp = world.getBiome(pos).getTemperature(pos);
			if (world.canSnowAt(pos, false)) {
				return Ke2Blocks.ALPINE_DRAIN_LILY.getDefaultState();
			}
			else if (temp > 0.95) {
				return Ke2Blocks.DESERT_DRAIN_LILY.getDefaultState();
			}
		}
		return Ke2Blocks.VALLEY_DRAIN_LILY.getDefaultState();
	}
}