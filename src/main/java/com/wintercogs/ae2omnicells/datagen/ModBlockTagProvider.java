package com.wintercogs.ae2omnicells.datagen;

import appeng.api.ids.AETags;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, AE2OmniCells.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        // 标记以下方块使用镐子挖掘更快
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(OCBlocks.ENDER_INGOT_BLOCK.get())
                .add(OCBlocks.NETHERITE_SCRAP_BLOCK.get())
                .add(OCBlocks.SINGULARITY_BLOCK.get());

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(OCBlocks.ENDER_INGOT_BLOCK.get())
                .add(OCBlocks.NETHERITE_SCRAP_BLOCK.get())
                .add(OCBlocks.SINGULARITY_BLOCK.get());

        // 与AE保持一致行为，将其添加到此tag
        tag(AETags.FACADE_BLOCK_WHITELIST)
                .add(OCBlocks.CRAFTING_STORAGES.stream().map(DeferredBlock::get).toArray(Block[]::new))
                .add(OCBlocks.CRAFTING_MONITORS.stream().map(DeferredBlock::get).toArray(Block[]::new));
    }
}
