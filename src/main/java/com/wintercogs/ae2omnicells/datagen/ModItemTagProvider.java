package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider
{


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider, AE2OmniCells.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        tag(Tags.Items.INGOTS)
                .add(OCItems.ENDER_INGOT.key())
                .add(OCItems.CHARGED_ENDER_INGOT.key());

        tag(Tags.Items.NUGGETS)
                .add(OCItems.ENDER_NUGGET.key());

        tag(Tags.Items.STORAGE_BLOCKS)
                .add(OCBlocks.ENDER_INGOT_BLOCK.asItem().builtInRegistryHolder().key())
                .add(OCBlocks.NETHERITE_SCRAP_BLOCK.asItem().builtInRegistryHolder().key())
                .add(OCBlocks.SINGULARITY_BLOCK.asItem().builtInRegistryHolder().key());
    }
}
