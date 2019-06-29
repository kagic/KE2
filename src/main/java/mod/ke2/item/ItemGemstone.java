package mod.ke2.item;

import java.util.List;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemstone extends Item {
	public ItemGemstone(String name) {
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(60);
		this.addPropertyOverride(new ResourceLocation("cut"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, World world, EntityLivingBase entity) {
				if (stack.hasTagCompound()) {
					return stack.getTagCompound().getInteger("GemstoneCut") / 10000.0F;
				}
				return 0.0F;
			}
		});
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
		} catch (NullPointerException e) {
			tooltip.add("No information available.");
		}
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			ItemStack stack = player.getHeldItem(hand);
			if (stack.getItemDamage() == 0) {
				RayTraceResult raytraceresult = this.rayTrace(world, player, true);
				if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
					BlockPos blockpos = raytraceresult.getBlockPos();
					if (world.isBlockModifiable(player, blockpos) && player.canPlayerEdit(blockpos, raytraceresult.sideHit, stack)) {
						boolean spawned = this.spawnGem(world, player, blockpos, stack);
						if (!player.capabilities.isCreativeMode && spawned) {
							stack.shrink(1);
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
		boolean spawned = false;
		entity.extinguish();
		if (!entity.world.isRemote && entity.ticksExisted > 600) {
			ItemGemstone gem = (ItemGemstone) entity.getItem().getItem();
			ItemStack stack = entity.getItem();
			if (stack.getItemDamage() == 0) {
				spawned = gem.spawnGem(entity.world, null, entity.getPosition(), entity.getItem());
			} else if (entity.getEntityWorld().getWorldTime() % 20 == 0 && stack.getItemDamage() > 0) {
				stack.setItemDamage(Math.max(stack.getItemDamage() - 2, 0));
			}
		}
		if (spawned) {
			entity.setDead();
		} else {
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
			stack.setItemDamage(Math.max(stack.getItemDamage() - 1 * (isSelected ? 2 : 1), 0));
		}
	}
	
	public boolean spawnGem(World world, EntityPlayer player, BlockPos pos, ItemStack stack) {
		if (!world.isRemote) {
			try {
				NBTTagCompound tag = stack.getTagCompound();
				EntityGem gem = (EntityGem) Ke2Gems.REGISTRY.get(new ResourceLocation(tag.getString("Species"))).getConstructors()[0].newInstance(world);
				gem.onInitialSpawn(world.getDifficultyForLocation(pos), null);
				gem.readFromNBT(stack.getTagCompound());
				gem.setUniqueId(MathHelper.getRandomUUID(world.rand));
				gem.setPosition(pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5);
				gem.setAttackTarget(null);
				gem.extinguish();
				gem.clearActivePotions();
				return world.spawnEntity(gem);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error creating gem: " + e.getMessage());
			}
		}
		return false;
	}
	
	public void setData(EntityGem gem, ItemStack stack) {
		stack.setTagCompound(gem.writeToNBT(new NBTTagCompound()));
		stack.getTagCompound().setString("Name", gem.getName());
	}
}