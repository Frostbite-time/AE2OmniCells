package com.wintercogs.ae2omnicells.common.blocks;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.blocks.entities.OmniCraftingBlockEntity;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;

public class OmniCraftingUnitBlock extends AbstractCraftingUnitBlock<OmniCraftingBlockEntity>
{
    public OmniCraftingUnitBlock(Properties props, OmniCraftingUnitType type)
    {
        super(props, type);
    }
}
