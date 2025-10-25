package com.wintercogs.ae2omnicells.common.blocks;

import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import org.jetbrains.annotations.NotNull;

public interface IOmniCraftingBlock
{
    @NotNull OmniCraftingUnitType getOmniCraftingUnitType();
}
