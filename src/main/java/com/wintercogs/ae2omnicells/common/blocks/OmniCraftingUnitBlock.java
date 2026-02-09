package com.wintercogs.ae2omnicells.common.blocks;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.blocks.entities.OmniCraftingBlockEntity;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import org.jetbrains.annotations.NotNull;

// 不需要像1.21.1一样重写很多方法，但是我们保留这个类，便于移植与后续维护的更改比对
public class OmniCraftingUnitBlock extends AbstractCraftingUnitBlock<OmniCraftingBlockEntity> implements IOmniCraftingBlock
{
    /**
     * 与type变量一致，但是这里保留了更多类型信息
     */
    public final OmniCraftingUnitType omniCraftingType;

    public OmniCraftingUnitBlock(Properties props, OmniCraftingUnitType type)
    {
        super(props, type);
        this.omniCraftingType = type;
    }

    @Override
    public @NotNull OmniCraftingUnitType getOmniCraftingUnitType()
    {
        return this.omniCraftingType;
    }
}
