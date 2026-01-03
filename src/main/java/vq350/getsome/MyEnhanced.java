package vq350.getsome;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import vq350.getsome.init.MechanicalBoats;
import vq350.getsome.init.SnowBlocks;
import vq350.getsome.init.SnowItems;

public class MyEnhanced implements net.fabricmc.api.ModInitializer {

	public static final String MOD_ID = "my-enhanced";

	public static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Extra Snow Items");

		// Initialize extra snow items
		SnowItems.initSnowItems();
		// Initialize extra snow blocks
		SnowBlocks.initSnowBlocks();

		// Initialize the mechanical boats
		MechanicalBoats.initMechanicalBoats();

	}

	// If not specified, we will assume we must register the item too.
	public static Block registerBlock(String name, java.util.function.Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
		return MyEnhanced.registerBlock(name, blockFactory, settings, true);
	}

	public static Block registerBlock(String name, java.util.function.Function<AbstractBlock.Settings, Block> blockFactory,
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
		return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MyEnhanced.MOD_ID, name));
	}

	private static RegistryKey<Item> keyOfItem(String name) {
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyEnhanced.MOD_ID, name));
	}

	public static Item registerItem(String name, java.util.function.Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, net.minecraft.util.Identifier.of(MyEnhanced.MOD_ID, name));

		// Create the item instance.
		Item item = itemFactory.apply(settings.registryKey(itemKey));

		// Register the item.
		Registry.register(Registries.ITEM, itemKey, item);

		return item;
	}
}