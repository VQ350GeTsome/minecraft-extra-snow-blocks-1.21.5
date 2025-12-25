package vq350.getsome.init;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.util.Identifier;

import vq350.getsome.ExtraSnowBlocks;

public class snowBlocks {

    // If not specificed, we will assume we must register the item too.
    private static Block register(String name, java.util.function.Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        return snowBlocks.register(name, blockFactory, settings, true);
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

    private static final AbstractBlock.Settings REINFORCED_SNOW_BLOCK_SETTINGS = AbstractBlock.Settings.copy(Blocks.STONE_BRICKS);

    public static final Block COBBLED_REINFORCED_SNOW = snowBlocks.register(
            "cobbled_reinforced_snow",
            Block::new,
            REINFORCED_SNOW_BLOCK_SETTINGS
        );

    public static void initSnowBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.add(snowBlocks.COBBLED_REINFORCED_SNOW));
    }
}
