package mod.ke2.items;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import mod.ke2.api.EntityGem;
import mod.ke2.entity.EntityGemShard;
import mod.ke2.entity.machine.EntityBubble;
import mod.ke2.init.Ke2Damage;
import mod.ke2.init.Ke2Items;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemDestabilizer extends ItemSword {
	public final int color;

	public ItemGemDestabilizer(int index) {
		super(Ke2Items.DESTABILIZER_MATERIAL);
		this.setUnlocalizedName(EnumDyeColor.byMetadata(index).toString().toLowerCase() + "_gem_destabilizer");
		this.setMaxStackSize(1);
		this.setMaxDamage(24);
		this.color = index;
	}
	@Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4, 0));
        }
        return multimap;
    }

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		player.swingArm(hand);
		if (!world.isRemote) {
			List<EntityItem> items = world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos).grow(1, 1, 1));
			for (EntityItem item : items) {
				EntityBubble bubble = new EntityBubble(world);
				bubble.setColor(EntityGemShard.PARTICLE_COLORS[this.color]);
				bubble.setItem(item.getItem().copy());
				bubble.setPosition(item.posX, item.posY, item.posZ);
				bubble.setHealth(0.5F);
				bubble.motionY = world.rand.nextDouble() / 2;
				bubble.playBubbleSound();
				item.setDead();
				world.spawnEntity(bubble);
			}
			return EnumActionResult.SUCCESS;
		}
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
		
	}
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if(!worldIn.isRemote) {
			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			if (i > 60){
				if(!stack.hasTagCompound()) {
					stack.setTagCompound(new NBTTagCompound());
				}
				stack.getTagCompound().setBoolean("primed", true);
			}
			else {
				entityLiving.sendMessage(new TextComponentTranslation("Charge longer!"));
			}
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("primed")){
			tooltip.add("Destabilizer Primed!");
		}
	}
	
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		player.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
    
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target instanceof EntityGem) {
			if(!stack.hasTagCompound()) {
				stack.setTagCompound(new NBTTagCompound());
			}
        	if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("primed")) {
		        target.attackEntityFrom(Ke2Damage.POOF, target.getMaxHealth());
		        stack.getTagCompound().setBoolean("primed", false);
	        }
        }
        return super.hitEntity(stack, target, attacker);
    }

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() instanceof ItemGemShard ? this.color == ((ItemGemShard) repair.getItem()).color : false;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return stack.hasTagCompound() ? stack.getTagCompound().getBoolean("primed") : super.hasEffect(stack);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return false;
	}
	
	@Override
	public float getAttackDamage() {
		return 1;
	}
}