package vq350.getsome;

import vq350.getsome.init.SnowBlocks;
import vq350.getsome.init.SnowItems;

public class ExtraSnowBlocks implements net.fabricmc.api.ModInitializer {

	public static final String MOD_ID = "extra-snow-blocks";

	public static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Extra Snow Items");

		// Initialize extra snow items
		SnowItems.initSnowItems();
		// Initialize extra snow blocks
		SnowBlocks.initSnowBlocks();

	}
}