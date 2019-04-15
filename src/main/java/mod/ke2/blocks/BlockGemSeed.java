package mod.ke2.blocks;

import mod.ke2.init.Ke2CreativeTabs;
import mod.ke2.tileentity.TileEntityGemSeed;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGemSeed extends BlockFalling implements ITileEntityProvider {
	public BlockGemSeed() {
		super(Material.ROCK);
		this.setUnlocalizedName("gem_seed");
		this.setLightLevel(4.0F);
		this.setResistance(1000);
		this.setHardness(100);
		this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(Ke2CreativeTabs.MISCELLANEOUS);
	}
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.DIAMOND;
    }
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGemSeed();
	}
	public TileEntityGemSeed getGemSeed(World world, BlockPos pos) {
		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TileEntityGemSeed) {
			return (TileEntityGemSeed)(tileentity);
		}
		return null;
	}
}