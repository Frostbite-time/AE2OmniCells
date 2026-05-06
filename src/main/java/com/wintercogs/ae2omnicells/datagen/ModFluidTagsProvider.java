package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider
{


    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider, AE2OmniCells.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
    }

    @Override
    public @NotNull String getName()
    {
        return "AE2OMNI CELLS Fluid Tags";
    }
}
