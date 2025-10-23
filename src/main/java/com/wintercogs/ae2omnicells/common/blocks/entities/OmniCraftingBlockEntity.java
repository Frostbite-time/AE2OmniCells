package com.wintercogs.ae2omnicells.common.blocks.entities;

import appeng.blockentity.crafting.CraftingBlockEntity;
import com.wintercogs.ae2omnicells.common.me.crafting.IAcceleratorThreadsProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OmniCraftingBlockEntity extends CraftingBlockEntity implements IAcceleratorThreadsProvider
{
    public OmniCraftingBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState)
    {
        super(blockEntityType, pos, blockState);
    }

    /** 始终返回0，躲开AE的线程检查 */
    @Override
    public int getAcceleratorThreads()
    {
        return 0;
    }

    /** 返回真实线程数，随后用mixin仅作加法逻辑的注入，最大化兼容 */
    @Override
    public int getOmniCustomAcceleratorThreads()
    {
        return getUnitBlock().type.getAcceleratorThreads();
    }
}
