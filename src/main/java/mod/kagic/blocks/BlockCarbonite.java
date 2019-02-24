package mod.kagic.blocks;

import java.util.Random;

import mod.kagic.init.KAGIC;
import mod.kagic.init.Ke2Blocks;
import mod.kagic.init.Ke2Gems;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarbonite extends Block {
	public enum Variety {
		INERT(false, "$_carbonite"), ACTIVE(true, "$_carbonite"),
		DECORATIVE(false, "$_decorative_carbonite"),
		HOLOGRAPHIC(true, "$_holographic_carbonite");
		private final boolean canBePowered;
		private final String localName;
		Variety(boolean canBePowered, String localName) {
			this.canBePowered = canBePowered;
			this.localName = localName;
		}
		public boolean canBePowered() {
			return this.canBePowered;
		}
		public String getName() {
			return this.localName;
		}
	}
	private Variety variety = Variety.INERT;
	private boolean canBePowered = true;
	private boolean powered;
	private int color;
	public BlockCarbonite(Variety variety, int color, boolean powered) {
		super(Material.ROCK);
		String name = EnumDyeColor.byMetadata(color).toString().toLowerCase();
		this.canBePowered = variety.canBePowered();
        this.powered = powered; this.color = color;
    	if (this.powered) {
    		this.setUnlocalizedName(variety.getName().replaceAll("\\$", name) + "_on");
        	this.setResistance(6000000);
        	this.setHardness(-1);
    	}
    	else {
            if (this.canBePowered) {
            	this.setUnlocalizedName(variety.getName().replaceAll("\\$", name) + "_off");
            }
            else {
            	this.setUnlocalizedName(variety.getName().replaceAll("\\$", name));
            }
        	this.setResistance(30);
        	this.setHardness(2);
        	this.setCreativeTab(KAGIC.CREATIVE_TAB);
    	}
	}
	public BlockCarbonite(Variety variety, int color) {
		this(variety, color, false);
	}
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (this.variety == Variety.HOLOGRAPHIC && this.powered) {
			return Block.NULL_AABB;
		}
		else {
			return Block.FULL_BLOCK_AABB;
		}
    }
	@Override
    public BlockRenderLayer getBlockLayer() {
		if (this.variety == Variety.HOLOGRAPHIC && this.powered) {
			return BlockRenderLayer.CUTOUT;
		}
		else {
			return BlockRenderLayer.SOLID;
		}
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
    public boolean isFullCube(IBlockState state) {
        return false;
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
						world.setBlockState(fromPos, carbonite.getReverseState());
					}
				}
			}
			if ((!this.powered && powered) || (!powered && this.powered)) {
				world.setBlockState(pos, this.getReverseState());
			}
		}
    }
    public boolean isPowered() {
    	return this.powered;
    }
    public IBlockState getReverseState() {
    	switch (this.color) {
    	case Ke2Gems.BASIC_WHITE:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.WHITE_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.WHITE_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.WHITE_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_ORANGE:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.ORANGE_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.ORANGE_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.ORANGE_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.ORANGE_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.ORANGE_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_MAGENTA:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.MAGENTA_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.MAGENTA_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.MAGENTA_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.MAGENTA_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.MAGENTA_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_LIGHTBLUE:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.LIGHTBLUE_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.LIGHTBLUE_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.LIGHTBLUE_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.LIGHTBLUE_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.LIGHTBLUE_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_YELLOW:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.YELLOW_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.YELLOW_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.YELLOW_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.YELLOW_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.YELLOW_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_LIME:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.LIME_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.LIME_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.LIME_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.LIME_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.LIME_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_PINK:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.PINK_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.PINK_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.PINK_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.PINK_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.PINK_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_GRAY:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.GRAY_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.GRAY_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.GRAY_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.GRAY_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.GRAY_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_SILVER:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.SILVER_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.SILVER_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.SILVER_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.SILVER_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.SILVER_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_CYAN:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.CYAN_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.CYAN_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.CYAN_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.CYAN_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.CYAN_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_PURPLE:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.PURPLE_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.PURPLE_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.PURPLE_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.PURPLE_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.PURPLE_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_BLUE:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.BLUE_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.BLUE_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.BLUE_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.BLUE_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.BLUE_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_BROWN:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.BROWN_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.BROWN_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.BROWN_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.BROWN_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.BROWN_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_GREEN:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.GREEN_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.GREEN_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.GREEN_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.GREEN_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.GREEN_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_RED:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.RED_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.RED_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.RED_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.RED_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.RED_CARBONITE.getDefaultState();
    		}
    	case Ke2Gems.BASIC_BLACK:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.BLACK_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.BLACK_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.BLACK_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.BLACK_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.BLACK_CARBONITE.getDefaultState();
    		}
        default:
    		switch (this.variety) {
    		case ACTIVE:
    			if (this.powered) {
    	        	return Ke2Blocks.WHITE_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.WHITE_CARBONITE_ON.getDefaultState();
    			}
    		case HOLOGRAPHIC:
    			if (this.powered) {
    	        	return Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_OFF.getDefaultState();
    			}
    			else {
    	        	return Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_ON.getDefaultState();
    			}
    		default:
    			return Ke2Blocks.WHITE_CARBONITE.getDefaultState();
    		}
    	}
    }
}
