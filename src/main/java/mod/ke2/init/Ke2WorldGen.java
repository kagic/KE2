package mod.ke2.init;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2WorldGen implements IWorldGenerator {
	public final static WorldGenMinable TUNGSTEN_ORE = new WorldGenMinable(Ke2Blocks.TUNGSTEN_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE).getBlock()));
	public enum Type {
		ORES, STRUCTURES, OTHER
	}

	public Type type;

	public static final void register() {
		GameRegistry.registerWorldGenerator(new Ke2WorldGen(Type.ORES), 2);
	}

	public Ke2WorldGen(Type type) {
		this.type = type;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		BlockPos base = new BlockPos(chunkX * 16, 0, chunkZ * 16);
		switch (world.provider.getDimensionType()) {
			case NETHER :
				for (int i = 0; i < 40; i++) {
					BlockPos pos = base.add(random.nextInt(16), random.nextInt(255), random.nextInt(16));
					switch (this.type) {
						case ORES :
							break;
						case STRUCTURES :
							break;
						case OTHER :
							break;
					}
				}
				break;
			case OVERWORLD :
				for (int i = 0; i < 40; i++) {
					BlockPos pos = base.add(random.nextInt(16), random.nextInt(255), random.nextInt(16));
					switch (this.type) {
						case ORES :
							if (pos.getY() < 56) {
								Ke2WorldGen.TUNGSTEN_ORE.generate(world, random, pos);
							}
							break;
						case STRUCTURES :
							break;
						case OTHER :
							break;
					}
				}
				break;
			case THE_END :
				for (int i = 0; i < 40; i++) {
					BlockPos pos = base.add(random.nextInt(16), random.nextInt(255), random.nextInt(16));
					switch (this.type) {
						case ORES :
							break;
						case STRUCTURES :
							break;
						case OTHER :
							break;
					}
				}
				break;
		}
	}
}