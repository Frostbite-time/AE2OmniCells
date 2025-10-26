package com.wintercogs.ae2omnicells.common.blocks;

import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import org.jetbrains.annotations.NotNull;

// 保留这个类，便于移植与后续维护的更改比对
public interface IOmniCraftingBlock
{
    @NotNull OmniCraftingUnitType getOmniCraftingUnitType();
}