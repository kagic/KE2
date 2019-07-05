package mod.ke2.entity.gem;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.entity.gem.ai.EntityAIDefendTheLeader;
import mod.ke2.entity.gem.ai.EntityAIFightForLeader;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.init.Ke2Variants;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRuby extends EntityGem {
	static {
		Ke2Variants.addVariantIndexFile(new ResourceLocation("ke2:variants/ruby/index"), EntityRuby.class);
	}
	
	public EntityRuby(World world) {
		super(world);
		this.targetTasks.addTask(1, new EntityAIDefendTheLeader(this));
		this.targetTasks.addTask(2, new EntityAIFightForLeader(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	public void onInventoryChanged(IInventory inventory) {
		
	}
	
	@Override
	public int generateGemstoneCut() {
		return 1;
	}

	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_RUBY;
	}
}
