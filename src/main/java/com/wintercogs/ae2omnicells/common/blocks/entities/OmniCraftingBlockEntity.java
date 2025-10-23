package com.wintercogs.ae2omnicells.common.blocks.entities;

import appeng.api.AECapabilities;
import appeng.blockentity.crafting.CraftingBlockEntity;
import com.wintercogs.ae2omnicells.common.init.OCBlockEntities;
import com.wintercogs.ae2omnicells.common.me.crafting.IAcceleratorThreadsProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class OmniCraftingBlockEntity extends CraftingBlockEntity implements IAcceleratorThreadsProvider
{
    public OmniCraftingBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState)
    {
        super(blockEntityType, pos, blockState);
    }

    public static void onRegisterCaps(RegisterCapabilitiesEvent event)
    {
        event.registerBlockEntity(
                AECapabilities.IN_WORLD_GRID_NODE_HOST,
                OCBlockEntities.OMNI_CRAFTING_BLOCK_ENTITY.get(),
                (be, unused) -> be
        );
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
