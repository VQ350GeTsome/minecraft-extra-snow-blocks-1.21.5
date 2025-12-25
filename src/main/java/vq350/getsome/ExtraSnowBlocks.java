package vq350.getsome;

public class ExtraSnowBlocks implements net.fabricmc.api.ModInitializer {

	public static final String MOD_ID = "extra-snow-blocks";

	public static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Extra Snow Items");

		// Initialize extra snow items
		vq350.getsome.init.snowItems.initSnowItems();
		// Initialize extra snow blocks
		vq350.getsome.init.snowBlocks.initSnowBlocks();
	}
}