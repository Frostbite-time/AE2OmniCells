package com.wintercogs.ae2omnicells.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider()
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return Collections.emptySet();
    }
}
