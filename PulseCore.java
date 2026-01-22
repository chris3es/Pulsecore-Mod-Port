package com.chris.pulsecore;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;

public class PulseCore implements ModInitializer {

    public static final String MODID = "pulsecore";

    public static final Item DENSE_SHARD = new Item(new Item.Settings());
    public static final Block DENSE_BLOCK = new Block(AbstractBlock.Settings.create().strength(4.0f));

    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM, id("dense_shard"), DENSE_SHARD);
        Registry.register(Registries.BLOCK, id("dense_block"), DENSE_BLOCK);
        Registry.register(Registries.ITEM, id("dense_block"),
                new BlockItem(DENSE_BLOCK, new Item.Settings()));

        System.out.println("PulseCore initialized.");
    }

    public static Identifier id(String name) {
        return Identifier.of(MODID, name);
    }
}

ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
    entries.add(DENSE_SHARD);
    entries.add(DENSE_BLOCK);
});
