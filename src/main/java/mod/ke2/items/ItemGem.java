package mod.ke2.items;

import java.util.List;

import mod.ke2.api.EntityGem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGem extends Item {
	private final Class<? extends EntityGem> entity;
	private final String name;
	private final boolean isCracked;
	public ItemGem(Class<? extends EntityGem> gem, String name, boolean cracked) {
		this.setUnlocalizedName((cracked ? "cracked_" : "") + name + "_gem");
		this.setMaxStackSize(1);
		this.setMaxDamage(60);
		this.entity = gem;
		this.name = name;
		this.isCracked = cracked;
	}
	public ItemGem(Class<? extends EntityGem> gem, String name) {
		this(gem, name, false);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		try {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag.hasKey("Name")) {
				String name = tag.getString("Name");
				if (!name.isEmpty()) {
					tooltip.add(name);
				}
			}
			if (tag.hasKey("Descriptor")) {
				String name = tag.getString("Descriptor");
				if (!name.isEmpty()) {
					tooltip.add(name);
				}
			}
		}
		catch (NullPointerException e) {
			tooltip.add(this.name);
		}
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			ItemStack stack = player.getHeldItem(hand);
			if (stack.getItemDamage() == 0) {
				if (!this.isCracked) {
					RayTraceResult raytraceresult = this.rayTrace(world, player, true);
			        if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
			            BlockPos blockpos = raytraceresult.getBlockPos();
			            if (world.isBlockModifiable(player, blockpos) && player.canPlayerEdit(blockpos, raytraceresult.sideHit, stack)) {
			            	boolean spawned = spawnGem(world, player, blockpos, stack);
							if (!player.capabilities.isCreativeMode && spawned) {
								stack.shrink(1);
							}
		            	}
		            }
		        }
			}
	       	return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}
	@Override
	public boolean onEntityItemUpdate(EntityItem entity) {
		entity.extinguish();
		if (!this.isCracked()) {
			if (!entity.world.isRemote && entity.ticksExisted > 600) {
				ItemStack stack = entity.getItem();
				if (entity.getEntityWorld().getWorldTime() % 20 == 0 && stack.getItemDamage() > 0) {
					stack.setItemDamage(Math.max(stack.getItemDamage() - 2, 0));
				}
				if (stack.getItemDamage() == 0) {
					ItemGem gem = (ItemGem)(stack.getItem());
					boolean spawned = gem.spawnGem(entity.world, null, entity.getPosition(), entity.getItem());
					if (spawned) {
						entity.setDead();
					}
				}
			}
			entity.setEntityInvulnerable(true);
			entity.isDead = false;
			if (entity.ticksExisted > 600) {
				entity.setNoDespawn();
			}
		}
        return false;
    }
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected) {
		if (world.getWorldTime() % 20 == 0 && stack.getItemDamage() > 0) {
			stack.setItemDamage(Math.max(stack.getItemDamage() - (1 * (isSelected ? 2 : 1)), 0));
		}
	}
	public boolean spawnGem(World world, EntityPlayer player, BlockPos pos, ItemStack stack) {
		if (!world.isRemote) {
			if (this.isCracked) {
				return false;
			}
			else {
				try {
					EntityGem gem = (EntityGem)(this.entity.getConstructors()[0].newInstance(world));
					gem.onInitialSpawn(world.getDifficultyForLocation(pos), null);
					gem.readFromNBT(stack.getTagCompound());
					gem.setUniqueId(MathHelper.getRandomUUID(world.rand));
					gem.setPosition(pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5);
					gem.setAttackTarget(null);
					gem.extinguish();
					gem.clearActivePotions();
					world.spawnEntity(gem);
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error creating gem: " + e.getMessage());
				}
			}
		}
		return false;
	}
	public boolean isCracked() {
		return this.isCracked;
	}
	public String getName() {
		return this.name;
	}
	public void setData(EntityGem gem, ItemStack stack) {
		stack.setTagCompound(gem.writeToNBT(new NBTTagCompound()));
		stack.getTagCompound().setString("Name", gem.getName());
	}
}
