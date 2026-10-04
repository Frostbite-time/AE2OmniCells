package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider(LootTableSubProvider.Context context)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), context);
    }

    @Override
    protected void generate()
    {
        for (DeferredBlock<? extends Block> block : OCBlocks.ALL)
        {
            dropSelf(block.get());
        }
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return OCBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
