package mod.ke2.block;

import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCluster extends Block{
	public BlockCluster() {
		super(Material.ROCK);
        this.setCreativeTab(Ke2CreativeTabs.GEM_CREATION);
		this.setUnlocalizedName("cluster");
    	this.setResistance(35);
    	this.setHardness(2);
		this.setHarvestLevel("pickaxe", 1);
        this.setSoundType(SoundType.METAL);        
        this.setLightLevel(5f);
        
	}
	
	
}
