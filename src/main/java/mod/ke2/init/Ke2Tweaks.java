package mod.ke2.init;

public class Ke2Tweaks {

	/*
	 * public static void applyGemTweaks(EntityGem gem) { if
	 * (gem instanceof EntityGem) {
	 * System.out.println(gem.getName() +
	 * " is already overwritten."); } else { EntityGem
	 * overwrite = null; if (gem instanceof
	 * EntityAquamarine) { mod.ke2.gem.EntityAquamarine conv
	 * = new mod.ke2.gem.EntityAquamarine(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityBismuth) { mod.ke2.gem.EntityBismuth
	 * conv = new mod.ke2.gem.EntityBismuth(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityHessonite) {
	 * mod.ke2.gem.EntityHessonite conv = new
	 * mod.ke2.gem.EntityHessonite(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityLapisLazuli) {
	 * mod.ke2.gem.EntityLapisLazuli conv = new
	 * mod.ke2.gem.EntityLapisLazuli(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityPearl) { mod.ke2.gem.EntityPearl
	 * conv = new mod.ke2.gem.EntityPearl(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityPeridot) { mod.ke2.gem.EntityPeridot
	 * conv = new mod.ke2.gem.EntityPeridot(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityQuartzSoldier) { if (gem instanceof
	 * EntityAgate) { mod.ke2.gem.EntityAgate conv = new
	 * mod.ke2.gem.EntityAgate(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityAmethyst) {
	 * mod.ke2.gem.EntityAmethyst conv = new
	 * mod.ke2.gem.EntityAmethyst(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityCarnelian) {
	 * mod.ke2.gem.EntityCarnelian conv = new
	 * mod.ke2.gem.EntityCarnelian(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityJasper) { mod.ke2.gem.EntityJasper
	 * conv = new mod.ke2.gem.EntityJasper(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityRoseQuartz) {
	 * mod.ke2.gem.EntityRoseQuartz conv = new
	 * mod.ke2.gem.EntityRoseQuartz(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } } if (gem
	 * instanceof EntityRuby) { mod.ke2.gem.EntityRuby conv
	 * = new mod.ke2.gem.EntityRuby(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityRutile) { mod.ke2.gem.EntityRutile
	 * conv = new mod.ke2.gem.EntityRutile(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntitySapphire) {
	 * mod.ke2.gem.EntitySapphire conv = new
	 * mod.ke2.gem.EntitySapphire(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityTopaz) { mod.ke2.gem.EntityTopaz
	 * conv = new mod.ke2.gem.EntityTopaz(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (gem
	 * instanceof EntityZircon) { mod.ke2.gem.EntityZircon
	 * conv = new mod.ke2.gem.EntityZircon(gem.world);
	 * conv.readFromNBT(gem.writeToNBT(new
	 * NBTTagCompound())); overwrite = conv; } if (overwrite
	 * != null) { gem.world.spawnEntity(overwrite);
	 * gem.setDead(); } else {
	 * System.out.println(gem.getName() +
	 * " can not be overwritten."); } } } public static
	 * class Aquamarine extends Gem<EntityAquamarine> {
	 * private static final AttributeModifier NERF_HEALTH =
	 * new AttributeModifier(UUID.fromString(
	 * "c61d7b46-3f22-48cc-8838-5c69724f622f"),
	 * "amNerfHealth", -30, 0); protected static void
	 * tweak(EntityAquamarine gem) { apply(gem); } protected
	 * static void apply(EntityAquamarine gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityAquamarine.AQUAMARINE_YIELDS.clear();
	 * EntityAquamarine.AQUAMARINE_YIELDS.put(Blocks.
	 * PACKED_ICE.getDefaultState(), 0.75);
	 * EntityAquamarine.AQUAMARINE_YIELDS.put(Blocks.ICE.
	 * getDefaultState(), 0.50);
	 * EntityAquamarine.AQUAMARINE_YIELDS.put(Blocks.WATER.
	 * getDefaultState(), 0.10);
	 * ModEntities.registerOreDictValue(EntityAquamarine.
	 * AQUAMARINE_YIELDS, 4.50, "oreAquamarine");
	 * ModEntities.registerOreDictValue(EntityAquamarine.
	 * AQUAMARINE_YIELDS, 9.00, "blockAquamarine");
	 * ModEntities.registerOreDictValue(EntityAquamarine.
	 * AQUAMARINE_YIELDS, 1.00, "blockPrismarine"); } }
	 * public static class Bismuth extends
	 * Gem<EntityBismuth> { private static final
	 * AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "f8f7e3b1-8bff-4b86-9f79-90b165da0c66"),
	 * "amNerfHealth", -140, 0); protected static void
	 * tweak(EntityBismuth gem) { gem.tasks.addTask(4, new
	 * EntityAIFixPalanquins(gem, 0.6D));
	 * gem.tasks.addTask(4, new EntityAIFixAnvils(gem,
	 * 0.6D)); apply(gem); } protected static void
	 * apply(EntityBismuth gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityBismuth.BISMUTH_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityBismuth.
	 * BISMUTH_YIELDS, 4.50, "oreBismuth");
	 * ModEntities.registerOreDictValue(EntityBismuth.
	 * BISMUTH_YIELDS, 9.00, "blockBismuth");
	 * ModEntities.registerOreDictValue(EntityBismuth.
	 * BISMUTH_YIELDS, 0.50, "oreLead");
	 * ModEntities.registerOreDictValue(EntityBismuth.
	 * BISMUTH_YIELDS, 1.00, "blockLead");
	 * ModEntities.registerOreDictValue(EntityBismuth.
	 * BISMUTH_YIELDS, 1.00, "endstone"); } } public static
	 * class Hessonite extends Gem<EntityHessonite> {
	 * private static final AttributeModifier BUFF_DAMAGE =
	 * new AttributeModifier(UUID.fromString(
	 * "e69af949-93de-4b6d-be97-fd6c3f7aafba"),
	 * "amBuffDamage", 12, 0); private static final
	 * AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "91f0a1cb-5445-4679-8027-837e3f667e9d"),
	 * "amNerfHealth", -20, 0); protected static void
	 * tweak(EntityHessonite gem) {
	 * gem.targetTasks.addTask(4, new
	 * EntityAINearestAttackableTarget<EntityGem>(gem,
	 * EntityGem.class, 10, true, false, new
	 * Predicate<EntityGem>() {
	 * @Override public boolean apply(EntityGem input) {
	 * return input != null && (input.isDefective() ||
	 * input.isTraitor()); } })); apply(gem); } protected
	 * static void apply(EntityHessonite gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * ATTACK_DAMAGE).applyModifier( BUFF_DAMAGE);
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityHessonite.HESSONITE_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 9.00, "blockHessonite");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 4.50, "oreHessonite");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 2.00, "blockGarnet");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 1.00, "oreGarnet");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.50, "blockAluminum");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.20, "oreAluminium");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.50, "blockCalcium");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.20, "oreCalcium");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.30, "blockIron");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.10, "oreIron");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 0.05, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityHessonite.
	 * HESSONITE_YIELDS, 1.00, "endstone"); } } public
	 * static class LapisLazuli extends
	 * Gem<EntityLapisLazuli> { private static final
	 * AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "b03e2fa4-fdf7-44c4-b58a-f88eedcb4d01"),
	 * "amNerfHealth", -60, 0); protected static void
	 * tweak(EntityLapisLazuli gem) { apply(gem); }
	 * protected static void apply(EntityLapisLazuli gem) {
	 * try { gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityLapisLazuli.LAPIS_LAZULI_YIELDS.clear();
	 * EntityLapisLazuli.LAPIS_LAZULI_YIELDS.put(Blocks.
	 * WATER.getDefaultState(), 0.50);
	 * ModEntities.registerOreDictValue(EntityLapisLazuli.
	 * LAPIS_LAZULI_YIELDS, 9.00, "blockLapisLazuli");
	 * ModEntities.registerOreDictValue(EntityLapisLazuli.
	 * LAPIS_LAZULI_YIELDS, 9.00, "blockLapis");
	 * ModEntities.registerOreDictValue(EntityLapisLazuli.
	 * LAPIS_LAZULI_YIELDS, 4.50, "oreLapisLazuli");
	 * ModEntities.registerOreDictValue(EntityLapisLazuli.
	 * LAPIS_LAZULI_YIELDS, 4.50, "oreLapis");
	 * ModEntities.registerOreDictValue(EntityLapisLazuli.
	 * LAPIS_LAZULI_YIELDS, 0.50, "blockPrismarine"); } }
	 * public static class Pearl extends Gem<EntityPearl> {
	 * private static final AttributeModifier BUFF_HEALTH =
	 * new AttributeModifier(UUID.fromString(
	 * "dfeb118c-16b3-4766-adb5-d4208acb661f"),
	 * "amBuffHealth", 20, 0); private static final
	 * AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "0edfaca3-8517-4543-9523-faa88d576380"),
	 * "amNerfHealth", -30, 0); protected static void
	 * tweak(EntityPearl gem) { apply(gem); } protected
	 * static void apply(EntityPearl gem) { try { if
	 * (gem.isDefective()) {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( BUFF_HEALTH); } else {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } } protected static
	 * void alterCruxes() {
	 * EntityPearl.PEARL_YIELDS.clear(); if
	 * (AmConfigs.enableNacre) {
	 * ModEntities.MINERALS.remove(EntityPearl.class); }
	 * else { EntityPearl.PEARL_YIELDS.put(Blocks.SOUL_SAND.
	 * getDefaultState(), 0.50);
	 * EntityPearl.PEARL_YIELDS.put(Blocks.CLAY.
	 * getDefaultState(), 1.00);
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 1.00, "sand");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 1.00, "blockCoal");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.50, "oreCoal");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.50, "blockSalt");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.50, "blockHalite");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.20, "oreSalt");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.20, "oreHalite");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.50, "blockCalcite");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.20, "oreCalcite");
	 * ModEntities.registerOreDictValue(EntityPearl.
	 * PEARL_YIELDS, 0.40, "stoneLimestone"); } } } public
	 * static class Peridot extends Gem<EntityPeridot> {
	 * private static final AttributeModifier NERF_HEALTH =
	 * new AttributeModifier(UUID.fromString(
	 * "ca9e0ad5-50df-4f7d-8765-8b86350ef726"),
	 * "amNerfHealth", -100, 0); protected static void
	 * tweak(EntityPeridot gem) {
	 * Iterator<EntityAITaskEntry> tasks =
	 * gem.tasks.taskEntries.iterator(); while
	 * (tasks.hasNext()) { EntityAIBase ai =
	 * tasks.next().action; if (ai instanceof
	 * EntityAIAlignGems) { tasks.remove(); } }
	 * gem.tasks.addTask(4, new EntityAIPeriAlignGems(gem,
	 * 0.9D)); gem.tasks.addTask(4, new
	 * EntityAIFixInjectors(gem, 0.6D));
	 * gem.tasks.addTask(6, new
	 * EntityAIPeriPartyBurnStuff(gem, 0.6D));
	 * gem.tasks.addTask(6, new
	 * EntityAIPeriPartyDance(gem)); gem.tasks.addTask(6,
	 * new EntityAIPeriPartyFireworks(gem)); apply(gem); }
	 * protected static void apply(EntityPeridot gem) { try
	 * { gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityPeridot.PERIDOT_YIELDS.clear();
	 * EntityPeridot.PERIDOT_YIELDS.put(Blocks.MAGMA.
	 * getDefaultState(), 1.00);
	 * EntityPeridot.PERIDOT_YIELDS.put(Blocks.LAVA.
	 * getDefaultState(), 0.50);
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 2.00, "blockPeridot");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 1.00, "orePeridot");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 1.00, "blockIron");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.50, "oreIron");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.50, "netherrack");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 1.00, "endstone");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.50, "oreRedstone");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.25, "blockCopper");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.10, "oreCopper");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.40, "stoneLimestone");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.50, "stoneBasalt");
	 * ModEntities.registerOreDictValue(EntityPeridot.
	 * PERIDOT_YIELDS, 0.10, "stoneDiorite"); } } public
	 * static class Quartz extends Gem<EntityQuartzSoldier>
	 * { private static final AttributeModifier NERF_DAMAGE
	 * = new AttributeModifier(UUID.fromString(
	 * "a936d8ae-5c3d-4334-ba0e-84b9f8e23bd3"),
	 * "amNerfDamage", -4, 0); private static final
	 * AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "5635dcf0-500b-42fe-abc4-6c97582fed94"),
	 * "amNerfHealth", -90, 0); protected static void
	 * tweak(EntityQuartzSoldier gem) { apply(gem); }
	 * protected static void apply(EntityQuartzSoldier gem)
	 * { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * ATTACK_DAMAGE).applyModifier( NERF_DAMAGE);
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityRoseQuartz.ROSE_QUARTZ_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 0.20, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 0.30, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 0.40, "stoneBasalt");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 0.20, "oreIron");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 1.00, "oreQuartz");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 4.50, "oreRoseQuartz");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 9.00, "blockRoseQuartz");
	 * ModEntities.registerOreDictValue(EntityRoseQuartz.
	 * ROSE_QUARTZ_YIELDS, 1.00, "endstone");
	 * EntityAmethyst.AMETHYST_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 0.20, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 0.30, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 0.40, "stoneBasalt");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 0.40, "oreIron");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 1.00, "oreQuartz");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 4.50, "oreAmethyst");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 9.00, "blockAmethyst");
	 * ModEntities.registerOreDictValue(EntityAmethyst.
	 * AMETHYST_YIELDS, 1.00, "endstone");
	 * EntityCarnelian.CARNELIAN_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 0.20, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 0.30, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 0.40, "stoneLimestone");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 0.20, "oreIron");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 1.00, "oreQuartz");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 4.50, "oreCarnelian");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 9.00, "blockCarnelian");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 1.00, "endstone");
	 * ModEntities.registerOreDictValue(EntityCarnelian.
	 * CARNELIAN_YIELDS, 1.00, "sandstone");
	 * EntityCarnelian.CARNELIAN_YIELDS.put(Blocks.
	 * HARDENED_CLAY.getDefaultState(), 1.00);
	 * EntityCarnelian.CARNELIAN_YIELDS.put(Blocks.
	 * STAINED_HARDENED_CLAY. getDefaultState(), 1.00);
	 * EntityAgate.AGATE_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 0.20, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 0.30, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 0.40, "stoneLimestone");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 1.00, "oreQuartz");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 4.50, "oreAgate");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 9.00, "blockAgate");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 1.00, "endstone");
	 * ModEntities.registerOreDictValue(EntityAgate.
	 * AGATE_YIELDS, 1.00, "sandstone");
	 * EntityAgate.AGATE_YIELDS.put(Blocks.HARDENED_CLAY.
	 * getDefaultState(), 1.00);
	 * EntityAgate.AGATE_YIELDS.put(Blocks.
	 * STAINED_HARDENED_CLAY.getDefaultState(), 1.00);
	 * EntityJasper.JASPER_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 0.20, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 0.30, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 0.40, "stoneLimestone");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 1.00, "oreQuartz");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 4.50, "oreJasper");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 9.00, "blockJasper");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 1.00, "endstone");
	 * ModEntities.registerOreDictValue(EntityJasper.
	 * JASPER_YIELDS, 1.00, "sandstone");
	 * EntityJasper.JASPER_YIELDS.put(Blocks.HARDENED_CLAY.
	 * getDefaultState(), 1.00);
	 * EntityJasper.JASPER_YIELDS.put(Blocks.
	 * STAINED_HARDENED_CLAY.getDefaultState() , 1.00); } }
	 * public static class Ruby extends Gem<EntityRuby> {
	 * private static final AttributeModifier NERF_HEALTH =
	 * new AttributeModifier(UUID.fromString(
	 * "13c28c04-36d0-48ae-b269-46d008707b31"),
	 * "amNerfHealth", -60, 0); protected static void
	 * tweak(EntityRuby gem) { gem.tasks.addTask(4, new
	 * EntityAIFollowLeaderGem(gem, 0.8D,
	 * GemPlacements.NOSE, EntityJasper.class));
	 * gem.tasks.addTask(4, new EntityAIFollowLeaderGem(gem,
	 * 0.8D, GemPlacements.CHEST, EntityPyrite.class));
	 * gem.tasks.addTask(4, new EntityAIFollowLeaderGem(gem,
	 * 0.8D, GemPlacements.CHEST, EntityRuby.class));
	 * gem.tasks.addTask(4, new EntityAIFollowOtherGem(gem,
	 * 0.8D, EntityBabyPearl.class)); gem.tasks.addTask(4,
	 * new EntityAIFollowOtherGem(gem, 0.8D,
	 * EntityFusedRuby.class)); gem.tasks.addTask(4, new
	 * EntityAIFollowOtherGem(gem, 0.8D,
	 * EntityFusedPyrite.class)); gem.targetTasks.addTask(2,
	 * new EntityAICallForBackup(gem, EntityRuby.class));
	 * apply(gem); } protected static void apply(EntityRuby
	 * gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityRuby.RUBY_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.50, "oreRedstone");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 1.00, "blockRedstone");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.50, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.25, "stoneMarble");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.20, "netherrack");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.50, "oreBauxite");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.50, "oreAluminum");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 0.50, "oreAluminium");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 2.25, "oreCorundum");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 4.50, "blockCorundum");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 4.50, "oreRuby");
	 * ModEntities.registerOreDictValue(EntityRuby.
	 * RUBY_YIELDS, 9.00, "blockRuby");
	 * EntityRuby.RUBY_YIELDS.put(Blocks.MAGMA.
	 * getDefaultState(), 0.75);
	 * EntityRuby.RUBY_YIELDS.put(Blocks.LAVA.
	 * getDefaultState(), 0.50); } } public static class
	 * Rutile extends Gem<EntityRutile> { private static
	 * final AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "f3341645-9ac4-4861-a035-c1b49840237a"),
	 * "amNerfHealth", -30, 0); protected static void
	 * tweak(EntityRutile gem) { apply(gem); } protected
	 * static void apply(EntityRutile gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityRutile.RUTILE_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 0.10, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 1.00, "oreTitanium");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 1.00, "oreApatite");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 0.25, "oreRedstone");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 1.00, "glowstone");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 4.50, "oreRutile");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 9.00, "blockRutile");
	 * ModEntities.registerOreDictValue(EntityRutile.
	 * RUTILE_YIELDS, 1.00, "endstone"); } } public static
	 * class Sapphire extends Gem<EntitySapphire> { private
	 * static final AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "c2ca3f40-e98f-4208-8e11-ffcd8bd7c35d"),
	 * "amNerfHealth", -30, 0); protected static void
	 * tweak(EntitySapphire gem) { apply(gem); } protected
	 * static void apply(EntitySapphire gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntitySapphire.SAPPHIRE_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 0.10, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 0.10, "stoneMarble");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 0.05, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 0.25, "oreBauxite");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 0.25, "oreAluminum");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 0.25, "oreAluminium");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 2.25, "oreCorundum");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 4.50, "blockCorundum");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 4.50, "oreSapphire");
	 * ModEntities.registerOreDictValue(EntitySapphire.
	 * SAPPHIRE_YIELDS, 9.00, "blockSapphire");
	 * EntitySapphire.SAPPHIRE_YIELDS.put(Blocks.ICE.
	 * getDefaultState(), 0.75);
	 * EntitySapphire.SAPPHIRE_YIELDS.put(Blocks.PACKED_ICE.
	 * getDefaultState(), 0.50); } } public static class
	 * Topaz extends Gem<EntityTopaz> { private static final
	 * AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "b6895006-fffa-48c7-a784-bb77f7df4f71"),
	 * "amNerfHealth", -60, 0); protected static void
	 * tweak(EntityTopaz gem) { apply(gem); } protected
	 * static void apply(EntityTopaz gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityTopaz.TOPAZ_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityTopaz.
	 * TOPAZ_YIELDS, 0.20, "stoneGranite");
	 * ModEntities.registerOreDictValue(EntityTopaz.
	 * TOPAZ_YIELDS, 1.00, "oreAluminum");
	 * ModEntities.registerOreDictValue(EntityTopaz.
	 * TOPAZ_YIELDS, 1.00, "oreAluminium");
	 * ModEntities.registerOreDictValue(EntityTopaz.
	 * TOPAZ_YIELDS, 4.50, "oreTopaz");
	 * ModEntities.registerOreDictValue(EntityTopaz.
	 * TOPAZ_YIELDS, 9.00, "blockTopaz");
	 * ModEntities.registerOreDictValue(EntityTopaz.
	 * TOPAZ_YIELDS, 1.00, "endstone"); } } public static
	 * class Zircon extends Gem<EntityZircon> { private
	 * static final AttributeModifier NERF_HEALTH = new
	 * AttributeModifier(UUID.fromString(
	 * "4c4bd2cd-ff33-4bb1-8b1b-e829322d3b38"),
	 * "amNerfHealth", -30, 0); protected static void
	 * tweak(EntityZircon gem) { gem.tasks.addTask(1, new
	 * EntityAIBubbleItems(gem, 0.6D)); apply(gem); }
	 * protected static void apply(EntityZircon gem) { try {
	 * gem.getEntityAttribute(SharedMonsterAttributes.
	 * MAX_HEALTH).applyModifier( NERF_HEALTH); } catch
	 * (IllegalArgumentException e) {
	 * System.out.println(gem.getName() +
	 * " has already been tweaked!"); } if (gem.getHealth()
	 * > gem.getMaxHealth()) {
	 * gem.setHealth(gem.getMaxHealth()); } } protected
	 * static void alterCruxes() {
	 * EntityZircon.ZIRCON_YIELDS.clear();
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 0.10, "stoneDiorite");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 0.10, "stoneAndesite");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 1.00, "oreUranium");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 4.50, "oreZircon");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 4.50, "oreDiamond");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 9.00, "blockZircon");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 9.00, "blockDiamond");
	 * ModEntities.registerOreDictValue(EntityZircon.
	 * ZIRCON_YIELDS, 1.00, "endstone"); } } public static
	 * class Gem<T extends EntityGem> { public static void
	 * applyWailingStoneTweaks(EntityGem gem) {
	 * gem.tasks.addTask(1, new
	 * EntityAIStayWithinRadius(gem, 0.8D)); } public static
	 * void applyRenameTweaks(EntityGem gem) { boolean tweak
	 * = gem.getGemCut() == GemCuts.CABOCHON; if (!tweak) {
	 * if (gem instanceof EntityLapisLazuli || gem
	 * instanceof EntityAquamarine) { tweak = true; } else
	 * if (gem instanceof EntityJasper && !gem.isPrimary()
	 * && gem.getSpecial() == 0) { tweak = true; } } if
	 * (tweak) {
	 * gem.setSpecificName(gem.getSpecificName().replace(
	 * "Cut", "Cabochon")); } } public static void
	 * applyFusionTweaks(EntityGem gem) { if (gem instanceof
	 * EntityAmethyst || gem instanceof EntityJasper || gem
	 * instanceof EntityRuby || gem instanceof EntityTopaz)
	 * { Iterator<EntityAITaskEntry> tasks =
	 * gem.tasks.taskEntries.iterator(); while
	 * (tasks.hasNext()) { EntityAIBase ai =
	 * tasks.next().action; if (ai instanceof
	 * EntityAIProtectionFuse || ai instanceof
	 * EntityAITopazFuse || ai instanceof EntityAIRubyFuse)
	 * { tasks.remove(); } } if (gem instanceof
	 * EntityAmethyst) { gem.tasks.addTask(3, new
	 * EntityAICrossFuse<EntityPearl, EntityOpal>(gem,
	 * EntityPearl.class, EntityOpal.class, 16)); } else if
	 * (gem instanceof EntityJasper) { gem.tasks.addTask(3,
	 * new EntityAICrossFuse<EntityLapisLazuli,
	 * EntityMalachite>(gem, EntityLapisLazuli.class,
	 * EntityMalachite.class, 16)); } else if (gem
	 * instanceof EntityRuby) { gem.tasks.addTask(3, new
	 * EntityAICrossFuse<EntityPearl, EntityRhodonite>(gem,
	 * EntityPearl.class, EntityRhodonite.class, 16));
	 * gem.tasks.addTask(3, new
	 * EntityAICrossFuse<EntitySapphire, EntityGarnet>(gem,
	 * EntitySapphire.class, EntityGarnet.class, 16));
	 * gem.tasks.addTask(3, new
	 * EntityAICrossFuse<EntityRuby, EntityFusedRuby>(gem,
	 * EntityRuby.class, EntityFusedRuby.class, 16)); } else
	 * if (gem instanceof EntityTopaz) {
	 * gem.tasks.addTask(3, new
	 * EntityAICrossFuse<EntityTopaz, EntityFusedTopaz>(gem,
	 * EntityTopaz.class, EntityFusedTopaz.class, 16)); } }
	 * } }
	 */
}
