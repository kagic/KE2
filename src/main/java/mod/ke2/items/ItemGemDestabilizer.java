package mod.ke2.items;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Damage;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemDestabilizer extends Item {
	public ItemGemDestabilizer() {
		super();
		this.setUnlocalizedName("gem_destabilizer");
		this.setMaxStackSize(1);
        this.addPropertyOverride(new ResourceLocation("primed"), new IItemPropertyGetter() {
        	@SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, World world, EntityLivingBase entity) {
                if (stack.hasTagCompound()) {
                	return stack.getTagCompound().getBoolean("Primed") ? 1.0F : 0.0F;
                }
                return 0.0F;
            }
        });
	}
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
        return 40;
    }
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int timeLeft) {
		if (!world.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)(entity);
			player.getCooldownTracker().setCooldown(this, 0);
		}
	}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
		NBTTagCompound compound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
		compound.setBoolean("Primed", true);
		stack.setTagCompound(compound);
		return stack;
	}
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand); player.setActiveHand(hand);
		if (!stack.hasTagCompound() || !stack.getTagCompound().getBoolean("Primed")) {
			player.getCooldownTracker().setCooldown(this, 60);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		System.out.println("test");
		if (stack.hasTagCompound()) {
			System.out.println("test 1");
			if (target instanceof EntityGem) {
	        	if (stack.getTagCompound().getBoolean("Primed")) {
	        		System.out.println("test 2");
			        target.attackEntityFrom(Ke2Damage.POOF, target.getMaxHealth());
			        stack.getTagCompound().setBoolean("Primed", false);
		        }
			}
			return true;
        }
		return false;
    }
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return false;
	}
    @Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return stack.hasTagCompound() ? stack.getTagCompound().getBoolean("Primed") : super.hasEffect(stack);
	}
    @Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
}