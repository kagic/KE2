package mod.kagic.init;

import java.util.ArrayList;
import java.util.HashMap;

import mod.kagic.entity.EntityGem;
import mod.kagic.injection.CruxEntry;
import mod.kagic.items.ItemGem;
import net.minecraft.util.ResourceLocation;

public class AmGems {
	public static final HashMap<ResourceLocation, Class<? extends EntityGem>> GEM_REGISTRY = new HashMap<ResourceLocation, Class<? extends EntityGem>>();
	public static final HashMap<Class<? extends EntityGem>, ResourceLocation> GEM_TABLE = new HashMap<Class<? extends EntityGem>, ResourceLocation>();
	public static final HashMap<ResourceLocation, ArrayList<CruxEntry>> CRUXES = new HashMap<ResourceLocation, ArrayList<CruxEntry>>();
	public static final ArrayList<ItemGem> GEM_ITEMS = new ArrayList<ItemGem>();
	public static final HashMap<ItemGem, ItemGem> NORMAL_TO_CRACKED = new HashMap<ItemGem, ItemGem>();
	public static final HashMap<ItemGem, ItemGem> CRACKED_TO_NORMAL = new HashMap<ItemGem, ItemGem>();
	
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
	/** Gem is controlled by White but reverts to player ownership. */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_PLAYERS = 6;
	/** Gem is controlled by White but reverts to Yellow/Blue's ownership. */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_DIAMONDS = 7;
	/** Gem is controlled by White but reverts to Pink/Rose/Steven's ownership. */
	public static final int CONTROLLED_BY_WHITE_BUT_ALIGNED_WITH_REBELS = 8;
	/** Gem is controlled by White but reverts to self ownership. */
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
	/** Hand placement; analogous to Gemini.  */
	public static final int GEMSTONE_RIGHT_HAND = 7;
	/** Hand placement; analogous to Gemini.  */
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
	
	/** The pure terror that causes those to flee. Rubies don't experience this. */
	public static final float EMOTION_DREAD = 1.0F / 8.0F * 0.0F;	// RED
	/** The feeling of having lost something. Jaspers don't experience this. */
	public static final float EMOTION_GRIEF = 1.0F / 8.0F * 1.0F;	// ORANGE
	/** When your brain is deciding to fight or flee. Topazes don't experience this. */
	public static final float EMOTION_DOUBT = 1.0F / 8.0F * 2.0F;	// YELLOW
	/** Self-deprecation that lowers attack potency. Peridots don't experience this. */ 
	public static final float EMOTION_SHAME = 1.0F / 8.0F * 3.0F;	// GREEN
	/** Sudden barrage of input that speeds up a gem. Sapphires don't experience this. */
	public static final float EMOTION_HYPED = 1.0F / 8.0F * 4.0F;	// CYAN
	/** The feeling of being content and satisfied. Lapises don't experience this. */ 
	public static final float EMOTION_HAPPY = 1.0F / 8.0F * 5.0F;	// BLUE
	/** Self-justification that increases attack potency. Amethysts don't experience this. */
	public static final float EMOTION_PRIDE = 1.0F / 8.0F * 6.0F;	// VIOLET
	/** The pure power that causes those to fight. Rose Quartzes don't experience this. */
	public static final float EMOTION_ANGER = 1.0F / 8.0F * 7.0F;	// PINK
	/** Used to reset the emotional spectrum. */
	public static final float EMOTION_LIMIT = 1.0F;					// RESET
	/** Used for colormatching to emotional deficiencies. */
	public static final int[] EMOTIONAL_WAVELENGTHS = new int[] {
		0xFF0000,
		0xFF8800,
		0xFFFF00,
		0x00FF00,
		0x00FFFF,
		0x0000FF,
		0xFF0088,
		0xFF00FF
	};
	
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
	
	public static void registerGemEntity(ResourceLocation loc, Class<? extends EntityGem> entity, ArrayList<CruxEntry> cruxes) {
		GEM_REGISTRY.put(loc, entity);
		GEM_TABLE.put(entity, loc);
		CRUXES.put(loc, cruxes);
	}
	public static ItemGem setGemItem(Class<? extends EntityGem> entity, String name) {
		ItemGem normal = new ItemGem(entity, name, false);
		ItemGem cracked = new ItemGem(entity, name, true);
		AmGems.GEM_ITEMS.add(normal); AmGems.GEM_ITEMS.add(cracked);
		AmGems.NORMAL_TO_CRACKED.put(normal, cracked);
		return normal;
	}
}
