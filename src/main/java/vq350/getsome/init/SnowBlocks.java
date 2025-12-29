package vq350.getsome.init;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.util.Identifier;

import vq350.getsome.ExtraSnowBlocks;

public class SnowBlocks {

    // If not specified, we will assume we must register the item too.
    private static Block register(String name, java.util.function.Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        return SnowBlocks.register(name, blockFactory, settings, true);
    }

    private static Block register(String name, java.util.function.Function<AbstractBlock.Settings, Block> blockFactory,
                                  AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExtraSnowBlocks.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExtraSnowBlocks.MOD_ID, name));
    }

    //<editor-fold defaultstate="collapsed" desc=" Blocks ">

    public static final Block
            COMPACTED_REINFORCED_SNOW = SnowBlocks.register(
                    "compacted_reinforced_snow",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.GRAVEL)
            ),

            REINFORCED_SNOW_BRICKS = SnowBlocks.register(
              "reinforced_snow_bricks",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).requiresTool()
            ),
            REINFORCED_SNOW_BRICKS_SLAB = SnowBlocks.register(
              "reinforced_snow_bricks_slab",
                    SlabBlock::new,
                    AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).requiresTool()
            ),

            REINFORCED_SNOW_TILES = SnowBlocks.register(
                    "reinforced_snow_tiles",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILES).requiresTool()
            ),
            REINFORCED_SNOW_TILES_SLAB = SnowBlocks.register(
                    "reinforced_snow_tiles_slab",
                    SlabBlock::new,
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILES).requiresTool()
            ),


            OAK_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "oak_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            BIRCH_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "birch_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            SPRUCE_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "spruce_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            ACACIA_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "acacia_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            JUNGLE_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "jungle_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            DARK_OAK_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "dark_oak_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            CHERRY_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "cherry_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            MANGROVE_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "mangrove_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            WARPED_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "warped_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            CRIMSON_DOWELED_REINFORCED_SNOW = SnowBlocks.register(
                    "crimson_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),



            PERMAFROST = SnowBlocks.register(
                    "permafrost",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()
            ),

            FROSTED_LOG = SnowBlocks.register(
                    "frosted_log",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            FROSTED_PLANKS = SnowBlocks.register(
                    "frosted_planks",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
            );

    //</editor-fold>

    public static void initSnowBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.COMPACTED_REINFORCED_SNOW));

        // Bricks
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_BRICKS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_BRICKS_SLAB));

        // Tiles
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_TILES));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_TILES_SLAB));

        // Planks
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.FROSTED_PLANKS));


        // Doweled Snow
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.OAK_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.BIRCH_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.SPRUCE_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.ACACIA_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.JUNGLE_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.DARK_OAK_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.CHERRY_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.MANGROVE_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.WARPED_DOWELED_REINFORCED_SNOW));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.CRIMSON_DOWELED_REINFORCED_SNOW));


        // Natural
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.PERMAFROST));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.FROSTED_LOG));
    }
}
