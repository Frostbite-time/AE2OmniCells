package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider
{
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, provider, AE2OmniCells.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
    }

    @Override
    public @NotNull String getName()
    {
        return "AE2OMNI CELLS Fluid Tags";
    }
}
