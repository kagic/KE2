package mod.ke2.world.gen;

import mod.ke2.init.Ke2Blocks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreWorldGenerator implements IWorldGenerator {
    public WorldGenerator TUNGSTEN_ORE;

    public OreWorldGenerator(){
        TUNGSTEN_ORE = new WorldGenMinable(Ke2Blocks.TUNGSTEN_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE).getBlock()));
    }

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        runGenerator(TUNGSTEN_ORE, world, rand, chunkX, chunkZ, 0, 56, 15);
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int minHeight, int maxHeight, int chance){
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 265) {
            throw new IllegalArgumentException("Ore generated where it shouldn't");
        }
        int heightDifference = maxHeight - minHeight + 1;
        for(int i = 0; i < chance; i++){
            int x = (chunk_X * 16) + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDifference);
            int z = (chunk_Z * 16) + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
