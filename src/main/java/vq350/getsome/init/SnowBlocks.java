package vq350.getsome.init;

import net.minecraft.block.*;
import net.minecraft.item.*;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import vq350.getsome.MyEnhanced;

public class SnowBlocks {

    //<editor-fold defaultstate="collapsed" desc=" Blocks ">

    public static final Block
            COMPACTED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "compacted_reinforced_snow",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.GRAVEL)
            ),

            REINFORCED_SNOW_BRICKS = MyEnhanced.registerBlock(
              "reinforced_snow_bricks",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).requiresTool()
            ),
            REINFORCED_SNOW_BRICKS_SLAB = MyEnhanced.registerBlock(
              "reinforced_snow_bricks_slab",
                    SlabBlock::new,
                    AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).requiresTool()
            ),
            REINFORCED_SNOW_BRICKS_STAIRS = MyEnhanced.registerBlock(
              "reinforced_snow_bricks_stairs",
            settings ->  new StairsBlock(
                        SnowBlocks.REINFORCED_SNOW_BRICKS.getDefaultState(),
                        settings
                    ),
                    AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).requiresTool()
            ),

            REINFORCED_SNOW_TILES = MyEnhanced.registerBlock(
                    "reinforced_snow_tiles",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILES).requiresTool()
            ),
            REINFORCED_SNOW_TILES_SLAB = MyEnhanced.registerBlock(
                    "reinforced_snow_tiles_slab",
                    SlabBlock::new,
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILES).requiresTool()
            ),
            REINFORCED_SNOW_TILES_STAIRS = MyEnhanced.registerBlock(
                    "reinforced_snow_tiles_stairs",
                    settings ->  new StairsBlock(
                            SnowBlocks.REINFORCED_SNOW_TILES.getDefaultState(),
                            settings
                    ),
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILES).requiresTool()
            ),


            OAK_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "oak_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            BIRCH_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "birch_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            SPRUCE_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "spruce_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            ACACIA_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "acacia_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            JUNGLE_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "jungle_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            DARK_OAK_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "dark_oak_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            CHERRY_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "cherry_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            MANGROVE_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "mangrove_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            WARPED_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "warped_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),
            CRIMSON_DOWELED_REINFORCED_SNOW = MyEnhanced.registerBlock(
                    "crimson_doweled_reinforced_snow",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG)
            ),



            PERMAFROST = MyEnhanced.registerBlock(
                    "permafrost",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()
            ),

            FROSTED_LOG = MyEnhanced.registerBlock(
                    "frosted_log",
                    PillarBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_LOG).requiresTool()
            ),
            FROSTED_PLANKS = MyEnhanced.registerBlock(
                    "frosted_planks",
                    Block::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).requiresTool()
            ),
            FROSTED_PLANK_SLAB = MyEnhanced.registerBlock(
                    "frosted_plank_slab",
                    SlabBlock::new,
                    AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).requiresTool()
            ),
            FROSTED_PLANK_STAIRS = MyEnhanced.registerBlock(
                    "frosted_plank_stairs",
            settings -> new StairsBlock(
                        SnowBlocks.FROSTED_PLANKS.getDefaultState(),
                        settings
                    ),
                    AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).requiresTool()
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_BRICKS_STAIRS));

        // Tiles
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_TILES));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_TILES_SLAB));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.REINFORCED_SNOW_TILES_STAIRS));

        // Planks
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.FROSTED_PLANKS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.FROSTED_PLANK_SLAB));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(SnowBlocks.FROSTED_PLANK_STAIRS));


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
