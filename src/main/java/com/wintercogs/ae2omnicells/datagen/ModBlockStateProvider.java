package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider
{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, AE2OmniCells.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
    }

    private void blockWithItem(RegistryObject<Block> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
