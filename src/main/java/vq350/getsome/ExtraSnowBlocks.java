package vq350.getsome;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vq350.getsome.init.snowItems;

public class ExtraSnowBlocks implements ModInitializer {
	public static final String MOD_ID = "extra-snow-blocks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Extra Snow Items");

		// Initialize snow items
		snowItems.initSnowItems();
	}
}