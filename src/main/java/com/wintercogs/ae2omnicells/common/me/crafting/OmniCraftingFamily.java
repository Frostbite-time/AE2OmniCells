package com.wintercogs.ae2omnicells.common.me.crafting;

import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public enum OmniCraftingFamily
{
    OMNI,
    COMPLEX,
    QUANTUM;

    public Block getUnitBaseBlock()
    {
        RegistryObject<? extends Block> deferredBlock = switch (this)
        {
            case OMNI -> OCBlocks.OMNI_CRAFTING_UNIT_BLOCK;
            case COMPLEX -> OCBlocks.COMPLEX_CRAFTING_UNIT_BLOCK;
            case QUANTUM -> OCBlocks.QUANTUM_CRAFTING_UNIT_BLOCK;
        };
        return deferredBlock.get();
    }

    public Block getMonitorBlock()
    {
        RegistryObject<? extends Block> deferredBlock = switch (this)
        {
            case OMNI -> OCBlocks.OMNI_CRAFTING_MONITOR_BLOCK;
            case COMPLEX -> OCBlocks.COMPLEX_CRAFTING_MONITOR_BLOCK;
            case QUANTUM -> OCBlocks.QUANTUM_CRAFTING_MONITOR_BLOCK;
        };
        return deferredBlock.get();
    }
}
