# KAGIC
*The Steven Universe mod that adamantly denies it is a Steven Universe mod.* KAGIC adds machines that inject an essence into the ground that engenders magical beings called "gems" by transmuting the blocks around. These gems appear in a variety of ways and can be commanded to do a variety of tasks based on these blocks, called "cruxes."

## Features
* Injectors, machines that inject essence into the ground, which turns into a gem.
* Drained Blocks, blocks that are left behind after a gem is created and emerges from the ground.
    * Comes in up to 4 colors based on biome temperature.
    * Drained blocks spread across wood, killing trees.
* Drain Lilies, flowers that drain the world around them and spread.
* Magic Moss, toxic sludge that expands in water and has pink blossoms.
* Wailing Stone, block that attracts nearby gems when activated.
* Carbonite, multipurpose block that comes in 16 colors.
    * Powered Carbonite becomes indestructible when powered.
    * Holographic Carbonite becomes intangible when powered.
    * Decorative Carbonite features various designs.
* Gem Shards, harvested from Drain Lilies and Moss Blooms to enchant items.
* Gem Dust, created from shards, used as dye.

## Plans
* Tape Path, used to arrange Injectors and follow a specific path.
* Entry Stele, used to pinpoint an exact spot an Injector should inject.
* Exit Flag, used to pinpoint the level a gem seed should inject and emerge from.
* Base Loader, block that loads Injectors with gem seeds.
* Remote Activator, block that activates or deactivates nearby Injectors.
* Wailing Rail, specialized rail that attracts gems for easier transportation.
* Warp Pad, teleportation system for interconnecting far-apart colonies.
* Color Sensor, block that releases a redstone signal when around a certain color gem.
* Facet Scanner, block that releases a redstone signal when around a specific gem.
* Storage Unloader, block that removes items from gem inventories.
* Storage Loader, block that adds items to gem inventories.
* Gem Sorter, block that sorts gems into different chests by color.
    * 5 chests - Red/Orange, Yellow/Green, Blue/Violet, Black/White, Non-Gems
    * 4 chests - Red/Orange, Yellow/Green, Blue/Violet, Black/White, drops Non-Gems
    * 3 chests - Red/Orange/Yellow, Green/Blue/Violet, Black/White, drops Non-Gems
    * 2 chests - Red/Orange/Yellow/White, Green/Blue/Violet/Black, drops Non-Gems
    * 1 chests - Red/Orange/Yellow/White/Green/Blue/Violet/Black, drops Non-Gems
* Gem Dispatcher, block that poofs nearby gems for easier transportation.
* Gem Grinder, block that cracks, shatters, and powderizes gems.
* Gem Reactors, block that slowly destroys gems and converts them into energy.
* Ruby, small, pyrokinetic soldier gem that attack in groups and can combine into one large entity.
* Peridot, studious gem with a diverse range of interests ranging from agriculture to geology.
* Sapphire, prophetic gem with the ability to see forward in the future and tell you what will happen.
* Quartzes, a family of tall, barrelling, and intimidating warrior gems:
    * Amethyst, Carnelian, and Jasper are normal warrior gems with no special powers.
    * Citrines are born with power and tenacity, but slowly lose it with age.
    * Rose Quartzes are able to "give up health" to heal their peers.
    * Agates are colorful gems that have an impending stare that turn mobs away.
* Topaz, powerful gem that comes in yellow, pink, and blue, and can transport entities in its arms.
* Nephrite, inspector gem designed to scout out and neutralize hazards in unknown areas.
* Mother of Pearl, caring gem that has a craving for sand, which it uses to produce Pearls.
* Pearl, multicolored gem that acts as a second inventory and picks up dropped items.
    * Ender Pearl, a mysterious gem variety that can teleport players and items.
* Lapis Lazuli, flying gem that can water your crops and transport you across far distances.
* Bismuth, bustling blacksmith gem that arms gems and players and fixes armor and tools.
* Rutiles, red gem that explores caves and places torches where ores should be.
* Garnets, a family of taller, stout commander gems that disarm opponents and claim trophies:
    * Hessonite and Pyrope can teleport to dodge attacks.
    * Demantoids and Melanite apply poison and blindness to disable opponents.
* Zircon, colorful booksmart gem that can enchant items and books.
* Aquamarine, flying blue gem that goes off on hunting expeditions and bring back loot.
* Emerald, tall green gem that goes off on trading expeditions and bring back loot.
* Jade, colorful dancer gems that relish nearby players and gems with buffs when music plays.
* Watermelon Tourmaline, tall green and pink gem that can blow massive blasts of air at enemies.
* Snowflake Obsidian, large black and white gem that harvests resources and ores.
* Larimar, short blue gem that gives enemies a bad time with snowmen and snowballs.
* Serandite, redstone powered gem that shoots lasers out of its eye and is immune to arrows.
* Kunzite, purple gem that is immune to arrows and helps animals breed and grow faster.
* Hiddenite, green gem that is immune to arrows and makes nearby plants grow faster.
* Cancrinite, crab-like gem that hunts, farms, and forages for food, shears sheep.
* Desert Glass, green tiny gem that erects sand pillars around herself and enemies.

## Downloads
Check our [releases page](https://github.com/kagic/KAGIC/releases) for downloads.

## Issues
1. Collect any helpful logs, screenshots, or snippets.
2. Report issues to our [issue tracker.](https://github.com/kagic/KAGIC/issues)
3. Ask for help in our [Discord.](https://discord.gg/C982t9a)

## Discord
The Discord server is a place to collaborate, learn, showcase, and discuss the development of KAGIC, download the latest releases, communicate with the community, report bugs and ask for and provide help and support.
Click [here](https://discord.gg/Entz7q2) to join.

## Development
### Prerequisites
2. JDK 8 - [Download.](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
3. Git - [Download.](https://git-scm.com/downloads)

### Setup
1. Install the above prerequisites.
2. Run command: `git clone https://github.com/kagic/KAGIC.git`
3.  repository folder, run: `.\gradlew setupDecompWorkspace`
4. Run `.\gradlew eclipse` or `.\gradlew idea` depending on your IDE.
5. KAGIC is now installed.

### Build
1. Go to the directory of your repository.
2. Run command: `.\gradlew build`
3. Find `KAGIC-19.x.x.jar` in the `build/lib` folder.
4. KAGIC has been built for distribution.

### Testing
1. Go to the directory of your repository.
2. Run `.\gradlew runClient` to play on the modded client.
3. Run `.\gradlew runServer` to start a modded server.

### Contribute
1. Fork, install, and setup KAGIC on your machine.
2. Write code with comments for increased legibility.
3. Summarize any changes for future pull requests.

## Legal Disclaimer
"KAGIC" source code and its derivatives, including bytecode and executables, are licensed under an MIT License by "The KAGIC Team" ("akrivus", "HeimrArnadalr", "Judacraz", "Lattie", "obsidian29", "Seartisian", "taaffeite", "Tourmaline-Iris"). For more information about the MIT License, please look [here.](./LICENSE)

"Steven Universe" and all related characters and elements are trademarks of Cartoon Network.