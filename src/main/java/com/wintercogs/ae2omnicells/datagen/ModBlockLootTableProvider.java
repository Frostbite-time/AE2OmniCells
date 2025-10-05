package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

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
        dropSelf(OCBlocks.ENDER_INGOT_BLOCK.get());
        dropSelf(OCBlocks.NETHERITE_SCRAP_BLOCK.get());
        dropSelf(OCBlocks.SINGULARITY_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return OCBlocks.BLOCKS.getEntries().stream().flatMap(RegistryObject::stream)::iterator;
    }
}
