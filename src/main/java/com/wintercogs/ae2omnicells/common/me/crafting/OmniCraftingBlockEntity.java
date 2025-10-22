package com.wintercogs.ae2omnicells.common.me.crafting;

import appeng.blockentity.crafting.CraftingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OmniCraftingBlockEntity extends CraftingBlockEntity implements IAcceleratorThreadsProvider
{
    public OmniCraftingBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState)
    {
        super(blockEntityType, pos, blockState);
    }

    @Override
    public int getAcceleratorThreads()
    {
        return 0;
    }

    @Override
    public int getOmniCustomAcceleratorThreads()
    {
        return 0;
    }
}
