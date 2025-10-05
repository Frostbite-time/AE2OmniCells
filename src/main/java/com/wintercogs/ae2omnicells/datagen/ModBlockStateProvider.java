package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider
{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, AE2OmniCells.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(OCBlocks.ENDER_INGOT_BLOCK);
        blockWithItem(OCBlocks.NETHERITE_SCRAP_BLOCK);
        blockWithItem(OCBlocks.SINGULARITY_BLOCK);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
