package mod.ke2.items;

import java.util.List;

import mod.ke2.api.EntityGem;
import mod.ke2.entity.EntityGemShard;
import mod.ke2.entity.machine.EntityBubble;
import mod.ke2.init.Ke2Damage;
import mod.ke2.init.Ke2Items;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemGemDestabilizer extends ItemSword {
	public int color;
	public boolean primed;

	public ItemGemDestabilizer(int index) {
		super(ToolMaterial.GOLD);
		String name = EnumDyeColor.byMetadata(index).toString().toLowerCase();
		this.setUnlocalizedName(name + "_gem_destabilizer");
		this.setMaxStackSize(1);
		this.setMaxDamage(24);
		this.color = index;
		/*this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				if (entityIn == null)
				{
					return 0.0F;
				}
				else
				{
					return !(entityIn.getActiveItemStack().getItem() instanceof ItemGemDestabilizer) ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
				}
			}
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});*/
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		player.swingArm(hand);
		if (!world.isRemote) {
			List<EntityItem> items = world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos).grow(1, 1, 1));
			for (EntityItem item : items) {
				EntityBubble bubble = new EntityBubble(world);
				bubble.setColor(EntityGemShard.PARTICLE_COLORS[this.color]);
				bubble.setItem(item.getItem());
				bubble.setPosition(item.posX, item.posY, item.posZ);
				bubble.setHealth(0.5F);
				bubble.motionY = world.rand.nextDouble() / 2;
				bubble.playBubbleSound();
				item.setDead();
				world.spawnEntity(bubble);
			}
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}

	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer && !this.primed) {
			EntityPlayer entityplayer = (EntityPlayer)entityLiving;
			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			if (i < 0) return;
			if(i < 100){
				NBTTagCompound comp = new NBTTagCompound();
				comp.setBoolean("primed", true);
				stack.setTagCompound(comp);
			}
		}
	}
	
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    /**
     * Called when the equipped item is right clicked.
     */

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target instanceof EntityGem) {
        	target.attackEntityFrom(Ke2Damage.POOF, target.getMaxHealth());
        }
        NBTTagCompound comp = stack.getTagCompound();
        comp.setBoolean("primed", false);
        return true;
    }

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entity) {
        if (state.getBlockHardness(world, pos) != 0.0F) {
            stack.damageItem(2, entity);
        }
        return true;
    }

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (repair.getItem() instanceof ItemGemShard) {
			ItemGemShard shard = (ItemGemShard)(repair.getItem());
			return this.color == shard.color;
		}
		return false;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if (stack.getTagCompound() != null) {
			NBTTagCompound tag = stack.getTagCompound();
			return tag.getBoolean("primed");
		}
		return false;
	}
}
