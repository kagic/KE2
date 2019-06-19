package mod.ke2.init;

import java.util.ArrayList;
import java.util.HashMap;

import mod.ke2.KAGIC;
import mod.ke2.api.EntityGem;
import mod.ke2.api.injection.CruxEntry;
import mod.ke2.item.ItemGemstone;
import net.minecraft.util.ResourceLocation;

public class Ke2Gems {
	public static final HashMap<ResourceLocation, Class<? extends EntityGem>> REGISTRY = new HashMap<ResourceLocation, Class<? extends EntityGem>>();
	public static final HashMap<Class<? extends EntityGem>, ResourceLocation> REGISTRY_REVERSE = new HashMap<Class<? extends EntityGem>, ResourceLocation>();
	public static final ArrayList<ItemGemstone> GEMSTONES = new ArrayList<ItemGemstone>();
	public static final HashMap<ItemGemstone, ItemGemstone> NORMAL_TO_CRACKED = new HashMap<ItemGemstone, ItemGemstone>();
	public static final HashMap<ItemGemstone, ItemGemstone> CRACKED_TO_NORMAL = new HashMap<ItemGemstone, ItemGemstone>();

	/** Gem isn't aligned yet, lost/emerged. */
	public static final int ALIGNED_WITH_NOBODY = 0;
	/** Gem is aligned to one or more players. */
	public static final int ALIGNED_WITH_PLAYERS = 1;
	/** Gem is aligned with Yellow/Blue. */
	public static final int ALIGNED_WITH_DIAMONDS = 2;
	/** Gem is aligned with Pink/Rose/Steven. */
	public static final int ALIGNED_WITH_REBELS = 3;
	/** Gem is aligned with itself. */
	public static final int ALIGNED_WITH_ITSELF = 4;
	/** Gem is controlled and owned by White. */
	public static final int CONTROLLED_BY_WHITE = 5;
	/**
	 * Gem is controlled by White but reverts to player
	 * ownership.
	 */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_PLAYERS = 6;
	/**
	 * Gem is controlled by White but reverts to
	 * Yellow/Blue's ownership.
	 */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_DIAMONDS = 7;
	/**
	 * Gem is controlled by White but reverts to
	 * Pink/Rose/Steven's ownership.
	 */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_REBELS = 8;
	/**
	 * Gem is controlled by White but reverts to self
	 * ownership.
	 */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_ITSELF = 9;

	/** Forehead placement; analogous to Aquarius. */
	public static final int GEMSTONE_FOREHEAD = 0;
	/** Back of head placement; analogous to Taurus. */
	public static final int GEMSTONE_BACK_OF_HEAD = 1;
	/** Eye placement; analogous to Scorpio. */
	public static final int GEMSTONE_RIGHT_EYE = 2;
	/** Eye placement; analogous to Scorpio. */
	public static final int GEMSTONE_LEFT_EYE = 3;
	/** Nose placement; analogous to Aries. */
	public static final int GEMSTONE_NOSE = 4;
	/** Shoulder placement; analogous to Libra. */
	public static final int GEMSTONE_RIGHT_SHOULDER = 5;
	/** Shoulder placement; analogous to Libra. */
	public static final int GEMSTONE_LEFT_SHOULDER = 6;
	/** Hand placement; analogous to Gemini. */
	public static final int GEMSTONE_RIGHT_HAND = 7;
	/** Hand placement; analogous to Gemini. */
	public static final int GEMSTONE_LEFT_HAND = 8;
	/** Chest placement; analogous to Cancer. */
	public static final int GEMSTONE_CHEST = 9;
	/** Back placement; analogous to Virgo. */
	public static final int GEMSTONE_BACK = 10;
	/** Navel placement; analogous to Leo. */
	public static final int GEMSTONE_NAVEL = 11;
	/** Thigh placement; analogous to Sagittarius. */
	public static final int GEMSTONE_RIGHT_THIGH = 12;
	/** Thigh placement; analogous to Sagittarius. */
	public static final int GEMSTONE_LEFT_THIGH = 13;
	/** Knee placement; analogous to Capricorn. */
	public static final int GEMSTONE_RIGHT_KNEE = 14;
	/** Knee placement; analogous to Capricorn. */
	public static final int GEMSTONE_LEFT_KNEE = 15;
	/** Foot placement; analogous to Pisces. */
	public static final int GEMSTONE_RIGHT_FOOT = 16;
	/** Foot placement; analogous to Pisces. */
	public static final int GEMSTONE_LEFT_FOOT = 17;
	
	/** 
	 * Emotional phase at which attachments
	 * (typically romantic) occur. */
	public static final float EMOPHASE_ROMANCE = 405.0F;
	/** 
	 * Emotional phase at which the gem has
	 * everything it needs and is most efficient. */
	public static final float EMOPHASE_PLEASED = 470.0F;
	/** 
	 * Natural emotional phase for most gems;
	 * often accompanies positive bias. */
	public static final float EMOPHASE_RELAXED = 530.0F;
	/** 
	 * Natural emotional phase for most gems;
	 * often accompanies negative bias. */
	public static final float EMOPHASE_NERVOUS = 600.0F;
	/** 
	 * Emotional phase at which the gem has lost
	 * something it needs and is least efficient. */
	public static final float EMOPHASE_SADNESS = 660.0F;
	/** 
	 * Emotional phase at which surrender and fights
	 * occur based on the gem's personality. */
	public static final float EMOPHASE_FEARFUL = 725.0F;
	
	/** Hearts appear in this emotional state. */
	public static final int EMOTION_ROMANCE = 0;
	/** Stars appear in this emotional state. */
	public static final int EMOTION_PLEASED = 1;
	/** No particles appear in this emotional state. */
	public static final int EMOTION_RELAXED = 2;
	/** No particles appear in this emotional state. */
	public static final int EMOTION_NERVOUS = 3;
	/** Tear drops appear in this emotional state. */
	public static final int EMOTION_SADNESS = 4;
	/** Portals appear in this emotional state */
	public static final int EMOTION_FEARFUL = 5;

	/** Dye damage is 0, block meta is 15. */
	public static final int BASIC_WHITE = 0;
	/** Dye damage is 1, block meta is 14. */
	public static final int BASIC_ORANGE = 1;
	/** Dye damage is 2, block meta is 13. */
	public static final int BASIC_MAGENTA = 2;
	/** Dye damage is 3, block meta is 12. */
	public static final int BASIC_LIGHTBLUE = 3;
	/** Dye damage is 4, block meta is 11. */
	public static final int BASIC_YELLOW = 4;
	/** Dye damage is 5, block meta is 10. */
	public static final int BASIC_LIME = 5;
	/** Dye damage is 6, block meta is 9. */
	public static final int BASIC_PINK = 6;
	/** Dye damage is 7, block meta is 8. */
	public static final int BASIC_GRAY = 7;
	/** Dye damage is 8, block meta is 7. */
	public static final int BASIC_SILVER = 8;
	/** Dye damage is 9, block meta is 6. */
	public static final int BASIC_CYAN = 9;
	/** Dye damage is 10, block meta is 5. */
	public static final int BASIC_PURPLE = 10;
	/** Dye damage is 11, block meta is 4. */
	public static final int BASIC_BLUE = 11;
	/** Dye damage is 12, block meta is 3. */
	public static final int BASIC_BROWN = 12;
	/** Dye damage is 13, block meta is 2. */
	public static final int BASIC_GREEN = 13;
	/** Dye damage is 14, block meta is 1. */
	public static final int BASIC_RED = 14;
	/** Dye damage is 15, block meta is 0. */
	public static final int BASIC_BLACK = 15;

	/** Dye damage is 0, block meta is 15. */
	public static final int BLOCK_WHITE = 15;
	/** Dye damage is 1, block meta is 14. */
	public static final int BLOCK_ORANGE = 14;
	/** Dye damage is 2, block meta is 13. */
	public static final int BLOCK_MAGENTA = 13;
	/** Dye damage is 3, block meta is 12. */
	public static final int BLOCK_LIGHTBLUE = 12;
	/** Dye damage is 4, block meta is 11. */
	public static final int BLOCK_YELLOW = 11;
	/** Dye damage is 5, block meta is 10. */
	public static final int BLOCK_LIME = 10;
	/** Dye damage is 6, block meta is 9. */
	public static final int BLOCK_PINK = 9;
	/** Dye damage is 7, block meta is 8. */
	public static final int BLOCK_GRAY = 8;
	/** Dye damage is 8, block meta is 7. */
	public static final int BLOCK_SILVER = 7;
	/** Dye damage is 9, block meta is 6. */
	public static final int BLOCK_CYAN = 6;
	/** Dye damage is 10, block meta is 5. */
	public static final int BLOCK_PURPLE = 5;
	/** Dye damage is 11, block meta is 4. */
	public static final int BLOCK_BLUE = 4;
	/** Dye damage is 12, block meta is 3. */
	public static final int BLOCK_BROWN = 3;
	/** Dye damage is 13, block meta is 2. */
	public static final int BLOCK_GREEN = 2;
	/** Dye damage is 14, block meta is 1. */
	public static final int BLOCK_RED = 1;
	/** Dye damage is 15, block meta is 0. */
	public static final int BLOCK_BLACK = 0;

	public static void registerGemEntity(ResourceLocation loc, Class<? extends EntityGem> entity) {
		if (!Ke2Gems.REGISTRY.containsKey(loc)) {
			Ke2Gems.REGISTRY.put(loc, entity);
			Ke2Gems.REGISTRY_REVERSE.put(entity, loc);
			Ke2Variants.TABLE.put(loc, new ArrayList<ResourceLocation>());
			Ke2Cruxes.TABLE.put(loc, new ArrayList<CruxEntry>());
		} else {
			KAGIC.LOGGER.warn("Gem '{}' already exists! Skipping!", loc.toString());
			KAGIC.LOGGER.warn("Report this to addon or mod author!");
		}
	}
}
