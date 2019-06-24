package mod.ke2.init;

import java.util.Iterator;

import mod.ke2.entity.machine.EntityTungstenArrow;
import mod.ke2.item.ItemEssence;
import mod.ke2.item.ItemGemDestabilizer;
import mod.ke2.item.ItemGemDust;
import mod.ke2.item.ItemGemShard;
import mod.ke2.item.ItemGemStaff;
import mod.ke2.item.ItemGemstone;
import mod.ke2.item.ItemManual;
import mod.ke2.item.ItemTemperplasm;
import mod.ke2.item.ItemWarpWhistle;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

public class Ke2Items {
	public static final ArmorMaterial TUNGSTEN_ARMOR = EnumHelper.addArmorMaterial("TUNGSTEN_ARMOR", "ke2:tungsten", 24, new int[]{4, 8, 8, 4}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F).setRepairItem(new ItemStack(Ke2Items.TUNGSTEN_INGOT));
	public static final ToolMaterial TUNGSTEN_TOOLS = EnumHelper.addToolMaterial("TUNGSTEN", 3, 909, 7.0F, 2.0F, 9);
	public static class TungArrow extends ItemArrow {
		@Override
		public EntityArrow createArrow(World world, ItemStack stack, EntityLivingBase shooter) {
	        return new EntityTungstenArrow(world, shooter);
	    }
	}
	public static class TungPickaxe extends ItemPickaxe {
		protected TungPickaxe() {
			super(Ke2Items.TUNGSTEN_TOOLS);
		}
	}
	public static class TungAxe extends ItemAxe {
		protected TungAxe() {
			super(Ke2Items.TUNGSTEN_TOOLS, 8.0F, -3.0F);
		}
	}

	public static final ItemEssence ANXIOUS_ESSENCE = new ItemEssence(ItemEssence.Color.WHITE);
	public static final ItemEssence AWKWARD_ESSENCE = new ItemEssence(ItemEssence.Color.RED);
	public static final ItemEssence PRIDEFUL_ESSENCE = new ItemEssence(ItemEssence.Color.ORANGE);
	public static final ItemEssence IMPULSIVE_ESSENCE = new ItemEssence(ItemEssence.Color.YELLOW);
	public static final ItemEssence JEALOUS_ESSENCE = new ItemEssence(ItemEssence.Color.GREEN);
	public static final ItemEssence OBSESSIVE_ESSENCE = new ItemEssence(ItemEssence.Color.BLUE);
	public static final ItemEssence DEPENDENT_ESSENCE = new ItemEssence(ItemEssence.Color.VIOLET);
	public static final ItemEssence CARELESS_ESSENCE = new ItemEssence(ItemEssence.Color.PINK);
	public static final ItemTemperplasm TEMPERPLASM = new ItemTemperplasm();
	public static final Item TUNGSTEN_INGOT = new Item().setUnlocalizedName("tungsten_ingot");
	public static final Item TUNGSTEN_HELMET = new ItemArmor(Ke2Items.TUNGSTEN_ARMOR, 1, EntityEquipmentSlot.HEAD).setUnlocalizedName("tungsten_helmet");
	public static final Item TUNGSTEN_CHESTPLATE = new ItemArmor(Ke2Items.TUNGSTEN_ARMOR, 1, EntityEquipmentSlot.CHEST).setUnlocalizedName("tungsten_chestplate");
	public static final Item TUNGSTEN_LEGGINGS = new ItemArmor(Ke2Items.TUNGSTEN_ARMOR, 2, EntityEquipmentSlot.LEGS).setUnlocalizedName("tungsten_leggings");
	public static final Item TUNGSTEN_BOOTS = new ItemArmor(Ke2Items.TUNGSTEN_ARMOR, 2, EntityEquipmentSlot.FEET).setUnlocalizedName("tungsten_boots");
	public static final Item TUNGSTEN_SWORD = new ItemSword(Ke2Items.TUNGSTEN_TOOLS).setUnlocalizedName("tungsten_sword");
	public static final Item TUNGSTEN_HOE = new ItemHoe(Ke2Items.TUNGSTEN_TOOLS).setUnlocalizedName("tungsten_hoe");
	public static final Item TUNGSTEN_SPADE = new ItemSpade(Ke2Items.TUNGSTEN_TOOLS).setUnlocalizedName("tungsten_spade");
	public static final Item TUNGSTEN_PICKAXE = new TungPickaxe().setUnlocalizedName("tungsten_pickaxe");
	public static final Item TUNGSTEN_AXE = new TungAxe().setUnlocalizedName("tungsten_axe");
	public static final Item TUNGSTEN_ARROW = new TungArrow().setUnlocalizedName("tungsten_arrow");
	public static final ItemGemStaff GEM_STAFF = new ItemGemStaff();
	public static final ItemWarpWhistle WARP_WHISTLE = new ItemWarpWhistle();
	public static final ItemGemDestabilizer GEM_DESTABILIZER = new ItemGemDestabilizer();
	public static final ItemGemstone COLORED_GEMSTONE = new ItemGemstone("colored_gemstone");
	public static final ItemGemShard GEM_SHARD = new ItemGemShard();
	public static final ItemGemDust GEM_DUST = new ItemGemDust();
	public static final ItemManual MANUAL = new ItemManual();

	public static void register(RegistryEvent.Register<Item> event) {
		Ke2Items.registerItem(Ke2Items.ANXIOUS_ESSENCE, new ResourceLocation("ke2:anxious_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.AWKWARD_ESSENCE, new ResourceLocation("ke2:awkward_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.PRIDEFUL_ESSENCE, new ResourceLocation("ke2:prideful_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.IMPULSIVE_ESSENCE, new ResourceLocation("ke2:impulsive_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.JEALOUS_ESSENCE, new ResourceLocation("ke2:jealous_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.OBSESSIVE_ESSENCE, new ResourceLocation("ke2:obsessive_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.DEPENDENT_ESSENCE, new ResourceLocation("ke2:dependent_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.CARELESS_ESSENCE, new ResourceLocation("ke2:careless_essence"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.TEMPERPLASM, new ResourceLocation("ke2:temperplasm"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.GEM_STAFF, new ResourceLocation("ke2:gem_staff"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.WARP_WHISTLE, new ResourceLocation("ke2:warp_whistle"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.GEM_DESTABILIZER, new ResourceLocation("ke2:gem_destabilizer"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.COLORED_GEMSTONE, new ResourceLocation("ke2:colored_gemstone"), event, Ke2CreativeTabs.GEM_STONES);
		Ke2Items.registerItem(Ke2Items.GEM_SHARD, new ResourceLocation("ke2:gem_shard"), event, Ke2CreativeTabs.GEM_STONES);
		Ke2Items.registerItem(Ke2Items.GEM_DUST, new ResourceLocation("ke2:gem_dust"), event, Ke2CreativeTabs.GEM_CREATION);
		Ke2Items.registerItem(Ke2Items.MANUAL, new ResourceLocation("ke2:manual"), event, Ke2CreativeTabs.GEM_TECH);
		
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_HELMET, new ResourceLocation("ke2:tungsten_helmet"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_CHESTPLATE, new ResourceLocation("ke2:tungsten_chestplate"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_LEGGINGS, new ResourceLocation("ke2:tungsten_leggings"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_BOOTS, new ResourceLocation("ke2:tungsten_boots"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_SWORD, new ResourceLocation("ke2:tungsten_sword"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_HOE, new ResourceLocation("ke2:tungsten_hoe"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_SPADE, new ResourceLocation("ke2:tungsten_spade"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_PICKAXE, new ResourceLocation("ke2:tungsten_pickaxe"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_AXE, new ResourceLocation("ke2:tungsten_axe"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_ARROW, new ResourceLocation("ke2:tungsten_arrow"), event, Ke2CreativeTabs.GEM_TECH);
		Ke2Items.registerItem(Ke2Items.TUNGSTEN_INGOT, new ResourceLocation("ke2:tungsten_ingot"), event, Ke2CreativeTabs.GEM_TECH);
		
		Iterator<Block> blocks = Ke2Blocks.ITEMS.keySet().iterator();
		while (blocks.hasNext()) {
			Ke2Items.registerItem(Ke2Blocks.ITEMS.get(blocks.next()), null, event, Ke2CreativeTabs.GEM_BLOCKS);
		}
	}

	public static void registerItem(Item item, ResourceLocation name, RegistryEvent.Register<Item> event, CreativeTabs tab) {
		event.getRegistry().register(item.getRegistryName() == null ? item.setCreativeTab(tab).setRegistryName(name) : item.setCreativeTab(tab));
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}