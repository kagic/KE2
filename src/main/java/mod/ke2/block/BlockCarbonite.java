package mod.ke2.block;

import java.util.HashMap;
import java.util.Random;

import mod.ke2.init.Ke2Blocks;
import mod.ke2.tileentity.TileEntityCarbonite;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarbonite extends Block implements ITileEntityProvider {
	public static final HashMap<BlockCarbonite, BlockCarbonite> CONVERSION_TABLE = new HashMap<BlockCarbonite, BlockCarbonite>();

	public static void registerConversionTables() {
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLACK_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.BLACK_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLUE_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.BLUE_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BROWN_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.BROWN_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.CYAN_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.CYAN_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GRAY_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.GRAY_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GREEN_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.GREEN_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIGHTBLUE_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.LIGHTBLUE_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIME_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.LIME_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.MAGENTA_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.MAGENTA_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.ORANGE_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.ORANGE_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PINK_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.PINK_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PURPLE_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.PURPLE_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.RED_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.RED_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.SILVER_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.SILVER_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.YELLOW_HOLOGRAPHIC_CARBONITE_OFF, Ke2Blocks.YELLOW_HOLOGRAPHIC_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLACK_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.BLACK_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLUE_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.BLUE_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BROWN_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.BROWN_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.CYAN_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.CYAN_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GRAY_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.GRAY_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GREEN_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.GREEN_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIGHTBLUE_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.LIGHTBLUE_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIME_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.LIME_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.MAGENTA_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.MAGENTA_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.ORANGE_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.ORANGE_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PINK_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.PINK_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PURPLE_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.PURPLE_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.RED_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.RED_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.SILVER_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.SILVER_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.WHITE_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.YELLOW_HOLOGRAPHIC_CARBONITE_ON, Ke2Blocks.YELLOW_HOLOGRAPHIC_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLACK_CARBONITE_OFF, Ke2Blocks.BLACK_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLUE_CARBONITE_OFF, Ke2Blocks.BLUE_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BROWN_CARBONITE_OFF, Ke2Blocks.BROWN_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.CYAN_CARBONITE_OFF, Ke2Blocks.CYAN_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GRAY_CARBONITE_OFF, Ke2Blocks.GRAY_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GREEN_CARBONITE_OFF, Ke2Blocks.GREEN_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIGHTBLUE_CARBONITE_OFF, Ke2Blocks.LIGHTBLUE_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIME_CARBONITE_OFF, Ke2Blocks.LIME_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.MAGENTA_CARBONITE_OFF, Ke2Blocks.MAGENTA_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.ORANGE_CARBONITE_OFF, Ke2Blocks.ORANGE_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PINK_CARBONITE_OFF, Ke2Blocks.PINK_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PURPLE_CARBONITE_OFF, Ke2Blocks.PURPLE_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.RED_CARBONITE_OFF, Ke2Blocks.RED_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.SILVER_CARBONITE_OFF, Ke2Blocks.SILVER_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.WHITE_CARBONITE_OFF, Ke2Blocks.WHITE_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.YELLOW_CARBONITE_OFF, Ke2Blocks.YELLOW_CARBONITE_ON);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLACK_CARBONITE_ON, Ke2Blocks.BLACK_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BLUE_CARBONITE_ON, Ke2Blocks.BLUE_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.BROWN_CARBONITE_ON, Ke2Blocks.BROWN_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.CYAN_CARBONITE_ON, Ke2Blocks.CYAN_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GRAY_CARBONITE_ON, Ke2Blocks.GRAY_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.GREEN_CARBONITE_ON, Ke2Blocks.GREEN_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIGHTBLUE_CARBONITE_ON, Ke2Blocks.LIGHTBLUE_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.LIME_CARBONITE_ON, Ke2Blocks.LIME_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.MAGENTA_CARBONITE_ON, Ke2Blocks.MAGENTA_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.ORANGE_CARBONITE_ON, Ke2Blocks.ORANGE_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PINK_CARBONITE_ON, Ke2Blocks.PINK_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.PURPLE_CARBONITE_ON, Ke2Blocks.PURPLE_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.RED_CARBONITE_ON, Ke2Blocks.RED_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.SILVER_CARBONITE_ON, Ke2Blocks.SILVER_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.WHITE_CARBONITE_ON, Ke2Blocks.WHITE_CARBONITE_OFF);
		BlockCarbonite.CONVERSION_TABLE.put(Ke2Blocks.YELLOW_CARBONITE_ON, Ke2Blocks.YELLOW_CARBONITE_OFF);
	}

	public enum Variety {
		INERT(false, "$_carbonite"), ACTIVE(true, "$_carbonite"), DECORATIVE(false, "$_decorative_carbonite"), HOLOGRAPHIC(true, "$_holographic_carbonite");
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
		this.variety = variety;
		this.powered = powered;
		this.color = color;
		if (this.powered) {
			this.setUnlocalizedName(variety.getName().replaceAll("\\$", name) + "_on");
			this.setResistance(6000000);
			this.setHardness(-1);
		} else {
			if (this.canBePowered) {
				this.setUnlocalizedName(variety.getName().replaceAll("\\$", name) + "_off");
			} else {
				this.setUnlocalizedName(variety.getName().replaceAll("\\$", name));
			}
			this.setResistance(30);
			this.setHardness(2);
		}
	}

	public BlockCarbonite(Variety variety, int color) {
		this(variety, color, false);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCarbonite();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (this.is(Variety.HOLOGRAPHIC) && this.isPowered()) {
			return Block.NULL_AABB;
		} else {
			return Block.FULL_BLOCK_AABB;
		}
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		if (this.is(Variety.HOLOGRAPHIC) && this.isPowered()) {
			return BlockRenderLayer.TRANSLUCENT;
		} else {
			return BlockRenderLayer.SOLID;
		}
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
		return !(this.is(Variety.HOLOGRAPHIC) && this.isPowered());
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return !(this.is(Variety.HOLOGRAPHIC) && this.isPowered());
	}

	@Override
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		IBlockState offset = world.getBlockState(pos.offset(side));
		Block block = offset.getBlock();
		if (this.is(Variety.HOLOGRAPHIC) && this.isPowered()) {
			if (state != offset) {
				return true;
			}
		}
		if (block == this) {
			return false;
		}
		return super.shouldSideBeRendered(state, world, pos, side);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}

	public boolean is(Variety variety) {
		return this.variety == variety;
	}

	public boolean isPowered() {
		return this.powered;
	}

	public boolean canBePowered() {
		return this.canBePowered;
	}

	public IBlockState getReverseState() {
		if (this.canBePowered) {
			return BlockCarbonite.CONVERSION_TABLE.get(this).getDefaultState();
		}
		return this.getDefaultState();
	}
}
