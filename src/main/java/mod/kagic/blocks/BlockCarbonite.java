package mod.kagic.blocks;

import java.util.Random;

import mod.kagic.init.AmBlocks;
import mod.kagic.init.AmGems;
import mod.kagic.init.KAGIC;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarbonite extends Block {
	private boolean canBePowered = true;
	private boolean powered;
	private int color;
	public BlockCarbonite(boolean powered, int color) {
		super(Material.ROCK);
        this.color = color;
		String name = EnumDyeColor.byMetadata(color).toString().toLowerCase();
        this.powered = powered;
        if (this.powered) {
    		this.setUnlocalizedName(name + "_carbonite_on");
        	this.setResistance(6000000);
        	this.setHardness(-1);
        }
        else {
    		this.setUnlocalizedName(name + "_carbonite_off");
        	this.setCreativeTab(KAGIC.CREATIVE_TAB);
        	this.setResistance(30);
        	this.setHardness(2);
        }
	}
	public BlockCarbonite(int color) {
		super(Material.ROCK);
		this.canBePowered = false;
        this.color = color;
		String name = EnumDyeColor.byMetadata(color).toString().toLowerCase();
	    this.setUnlocalizedName(name + "_carbonite");
    	this.setCreativeTab(KAGIC.CREATIVE_TAB);
    	this.setResistance(30);
    	this.setHardness(2);
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		this.activate(world, pos, null);
    }
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		super.neighborChanged(state, world, pos, block, fromPos);
		this.activate(world, pos, fromPos);
    }
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);
		this.activate(world, pos, null);
    }
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.getBlockColor(EnumDyeColor.byDyeDamage(this.color));
    }
	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.BLOCK;
	}
    @Override
	public Item getItemDropped(IBlockState state, Random random, int fortune){
		return Item.getItemFromBlock(this);
	}
    private void activate(World world, BlockPos pos, BlockPos fromPos) {
		if (this.canBePowered) {
	    	boolean powered = world.isBlockPowered(pos);
			if (fromPos != null) {
		    	IBlockState from = world.getBlockState(fromPos);
				if (from.getBlock() instanceof BlockCarbonite) {
					BlockCarbonite carbonite = (BlockCarbonite)(from.getBlock());
					if (carbonite.powered) {
						powered = true;
					}
					else if (powered) {
						world.setBlockState(fromPos, carbonite.getPoweredState());
					}
				}
			}
			if (!this.powered && powered) {
				world.setBlockState(pos, this.getPoweredState());
			}
			if (!powered && this.powered) {
				world.setBlockState(pos, this.getUnpoweredState());
			}
		}
    }
    public boolean isPowered() {
    	return this.powered;
    }
    public IBlockState getUnpoweredState() {
    	switch (this.color) {
    	case AmGems.BASIC_WHITE:
        	return AmBlocks.WHITE_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_ORANGE:
        	return AmBlocks.ORANGE_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_MAGENTA:
        	return AmBlocks.MAGENTA_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_LIGHTBLUE:
        	return AmBlocks.LIGHTBLUE_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_YELLOW:
        	return AmBlocks.YELLOW_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_LIME:
        	return AmBlocks.LIME_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_PINK:
        	return AmBlocks.PINK_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_GRAY:
        	return AmBlocks.GRAY_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_SILVER:
        	return AmBlocks.SILVER_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_CYAN:
        	return AmBlocks.CYAN_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_PURPLE:
        	return AmBlocks.PURPLE_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_BLUE:
        	return AmBlocks.BLUE_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_BROWN:
        	return AmBlocks.BROWN_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_GREEN:
        	return AmBlocks.GREEN_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_RED:
        	return AmBlocks.RED_CARBONITE_OFF.getDefaultState();
    	case AmGems.BASIC_BLACK:
        	return AmBlocks.BLACK_CARBONITE_OFF.getDefaultState();
        default:
        	return AmBlocks.WHITE_CARBONITE_OFF.getDefaultState();
    	}
    }
    public IBlockState getPoweredState() {
    	switch (this.color) {
    	case AmGems.BASIC_WHITE:
        	return AmBlocks.WHITE_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_ORANGE:
        	return AmBlocks.ORANGE_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_MAGENTA:
        	return AmBlocks.MAGENTA_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_LIGHTBLUE:
        	return AmBlocks.LIGHTBLUE_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_YELLOW:
        	return AmBlocks.YELLOW_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_LIME:
        	return AmBlocks.LIME_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_PINK:
        	return AmBlocks.PINK_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_GRAY:
        	return AmBlocks.GRAY_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_SILVER:
        	return AmBlocks.SILVER_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_CYAN:
        	return AmBlocks.CYAN_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_PURPLE:
        	return AmBlocks.PURPLE_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_BLUE:
        	return AmBlocks.BLUE_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_BROWN:
        	return AmBlocks.BROWN_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_GREEN:
        	return AmBlocks.GREEN_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_RED:
        	return AmBlocks.RED_CARBONITE_ON.getDefaultState();
    	case AmGems.BASIC_BLACK:
        	return AmBlocks.BLACK_CARBONITE_ON.getDefaultState();
        default:
        	return AmBlocks.WHITE_CARBONITE_ON.getDefaultState();
    	}
    }
}
