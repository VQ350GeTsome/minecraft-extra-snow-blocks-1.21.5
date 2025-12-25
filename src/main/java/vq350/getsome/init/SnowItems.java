package vq350.getsome.init;

import net.minecraft.item.*;
import net.minecraft.registry.*;

public class SnowItems {

    public static Item register(String name, java.util.function.Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, net.minecraft.util.Identifier.of(vq350.getsome.ExtraSnowBlocks.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item REINFORCED_SNOW = SnowItems.register("reinforced_snow", Item::new, new Item.Settings());

    public static void initSnowItems() {
        // Add reinforced snow to the ingredients group.
        net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(SnowItems.REINFORCED_SNOW));
    }

}
