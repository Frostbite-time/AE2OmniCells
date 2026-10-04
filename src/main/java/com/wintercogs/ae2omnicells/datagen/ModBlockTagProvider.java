package com.wintercogs.ae2omnicells.datagen;

import appeng.api.ids.AETags;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider, AE2OmniCells.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        // 标记以下方块使用镐子挖掘更快
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(OCBlocks.ENDER_INGOT_BLOCK.getKey())
                .add(OCBlocks.NETHERITE_SCRAP_BLOCK.getKey())
                .add(OCBlocks.SINGULARITY_BLOCK.getKey());

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(OCBlocks.ENDER_INGOT_BLOCK.getKey())
                .add(OCBlocks.NETHERITE_SCRAP_BLOCK.getKey())
                .add(OCBlocks.SINGULARITY_BLOCK.getKey());

        // 与AE保持一致行为，将其添加到此tag
        var facadeBlocks = tag(AETags.FACADE_BLOCK_WHITELIST);
        OCBlocks.CRAFTING_STORAGES.forEach(block -> facadeBlocks.add(block.getKey()));
        OCBlocks.CRAFTING_MONITORS.forEach(block -> facadeBlocks.add(block.getKey()));
    }
}
