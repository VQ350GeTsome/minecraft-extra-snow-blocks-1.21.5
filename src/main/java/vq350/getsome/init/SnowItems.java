package vq350.getsome.init;

import net.minecraft.item.*;
import vq350.getsome.MyEnhanced;

public class SnowItems {

    public static final Item REINFORCED_SNOW = MyEnhanced.registerItem("reinforced_snow", Item::new, new Item.Settings());

    public static void initSnowItems() {
        // Add reinforced snow to the ingredients group.
        net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(SnowItems.REINFORCED_SNOW));
    }

}
