package com.wintercogs.ae2omnicells.common.me.crafting;

import appeng.block.crafting.ICraftingUnitType;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;

public enum OmniCraftingUnitType implements ICraftingUnitType
{
    /** 三系存储均给予对应合成存储器 */
    OMNI_UNIT(0, 0),
    OMNI_STORAGE_1K(1, 4),
    OMNI_STORAGE_4K(4, 4),
    OMNI_STORAGE_16K(16, 4),
    OMNI_STORAGE_64K(64, 4),
    OMNI_STORAGE_256K(256, 4),
    OMNI_STORAGE_1M(1024, 4),
    OMNI_STORAGE_4M(4096, 4),
    OMNI_STORAGE_16M(16384, 4),
    OMNI_STORAGE_64M(65536, 4),
    OMNI_STORAGE_256M(262144, 4),
    
    COMPLEX_UNIT(0, 0),
    COMPLEX_STORAGE_1K(1, 0),
    COMPLEX_STORAGE_4K(4, 1),
    COMPLEX_STORAGE_16K(16, 2),
    COMPLEX_STORAGE_64K(64, 4),
    COMPLEX_STORAGE_256K(256, 8),
    COMPLEX_STORAGE_1M(1024, 16),
    COMPLEX_STORAGE_4M(4096, 32),
    COMPLEX_STORAGE_16M(16384, 64),
    COMPLEX_STORAGE_64M(65536, 128),
    COMPLEX_STORAGE_256M(262144, 256),

    QUANTUM_UNIT(0, 0),
    QUANTUM_STORAGE_1K(1, 8192),
    QUANTUM_STORAGE_4K(4, 8192),
    QUANTUM_STORAGE_16K(16, 8192),
    QUANTUM_STORAGE_64K(64, 8192),
    QUANTUM_STORAGE_256K(256, 8192),
    QUANTUM_STORAGE_1M(1024, 8192),
    QUANTUM_STORAGE_4M(4096, 8192),
    QUANTUM_STORAGE_16M(16384, 8192),
    QUANTUM_STORAGE_64M(65536, 8192),
    QUANTUM_STORAGE_256M(262144, 8192);

    /** 千字节 */
    private final long storageKb;

    /** 处理器数量 */
    private final int processors;

    OmniCraftingUnitType(long storageKb, int processors)
    {
        this.storageKb = storageKb;
        this.processors = processors;
    }

    @Override
    public long getStorageBytes()
    {
        return 1024L * this.storageKb;
    }

    @Override
    public int getAcceleratorThreads()
    {
        return this.processors;
    }

    @Override
    public Item getItemFromType()
    {
        DeferredBlock<OmniCraftingUnitBlock> definition = switch(this)
        {
            case OMNI_UNIT -> OCBlocks.OMNI_CRAFTING_UNIT_BLOCK;
            case OMNI_STORAGE_1K -> OCBlocks.OMNI_CRAFTING_STORAGE_1K_BLOCK;
            case OMNI_STORAGE_4K -> OCBlocks.OMNI_CRAFTING_STORAGE_4K_BLOCK;
            case OMNI_STORAGE_16K -> OCBlocks.OMNI_CRAFTING_STORAGE_16K_BLOCK;
            case OMNI_STORAGE_64K -> OCBlocks.OMNI_CRAFTING_STORAGE_64K_BLOCK;
            case OMNI_STORAGE_256K -> OCBlocks.OMNI_CRAFTING_STORAGE_256K_BLOCK;
            case OMNI_STORAGE_1M -> OCBlocks.OMNI_CRAFTING_STORAGE_1M_BLOCK;
            case OMNI_STORAGE_4M -> OCBlocks.OMNI_CRAFTING_STORAGE_4M_BLOCK;
            case OMNI_STORAGE_16M -> OCBlocks.OMNI_CRAFTING_STORAGE_16M_BLOCK;
            case OMNI_STORAGE_64M -> OCBlocks.OMNI_CRAFTING_STORAGE_64M_BLOCK;
            case OMNI_STORAGE_256M -> OCBlocks.OMNI_CRAFTING_STORAGE_256M_BLOCK;

            case COMPLEX_UNIT -> OCBlocks.COMPLEX_CRAFTING_UNIT_BLOCK;
            case COMPLEX_STORAGE_1K -> OCBlocks.COMPLEX_CRAFTING_STORAGE_1K_BLOCK;
            case COMPLEX_STORAGE_4K -> OCBlocks.COMPLEX_CRAFTING_STORAGE_4K_BLOCK;
            case COMPLEX_STORAGE_16K -> OCBlocks.COMPLEX_CRAFTING_STORAGE_16K_BLOCK;
            case COMPLEX_STORAGE_64K -> OCBlocks.COMPLEX_CRAFTING_STORAGE_64K_BLOCK;
            case COMPLEX_STORAGE_256K -> OCBlocks.COMPLEX_CRAFTING_STORAGE_256K_BLOCK;
            case COMPLEX_STORAGE_1M -> OCBlocks.COMPLEX_CRAFTING_STORAGE_1M_BLOCK;
            case COMPLEX_STORAGE_4M -> OCBlocks.COMPLEX_CRAFTING_STORAGE_4M_BLOCK;
            case COMPLEX_STORAGE_16M -> OCBlocks.COMPLEX_CRAFTING_STORAGE_16M_BLOCK;
            case COMPLEX_STORAGE_64M -> OCBlocks.COMPLEX_CRAFTING_STORAGE_64M_BLOCK;
            case COMPLEX_STORAGE_256M -> OCBlocks.COMPLEX_CRAFTING_STORAGE_256M_BLOCK;

            case QUANTUM_UNIT -> OCBlocks.QUANTUM_CRAFTING_UNIT_BLOCK;
            case QUANTUM_STORAGE_1K -> OCBlocks.QUANTUM_CRAFTING_STORAGE_1K_BLOCK;
            case QUANTUM_STORAGE_4K -> OCBlocks.QUANTUM_CRAFTING_STORAGE_4K_BLOCK;
            case QUANTUM_STORAGE_16K -> OCBlocks.QUANTUM_CRAFTING_STORAGE_16K_BLOCK;
            case QUANTUM_STORAGE_64K -> OCBlocks.QUANTUM_CRAFTING_STORAGE_64K_BLOCK;
            case QUANTUM_STORAGE_256K -> OCBlocks.QUANTUM_CRAFTING_STORAGE_256K_BLOCK;
            case QUANTUM_STORAGE_1M -> OCBlocks.QUANTUM_CRAFTING_STORAGE_1M_BLOCK;
            case QUANTUM_STORAGE_4M -> OCBlocks.QUANTUM_CRAFTING_STORAGE_4M_BLOCK;
            case QUANTUM_STORAGE_16M -> OCBlocks.QUANTUM_CRAFTING_STORAGE_16M_BLOCK;
            case QUANTUM_STORAGE_64M -> OCBlocks.QUANTUM_CRAFTING_STORAGE_64M_BLOCK;
            case QUANTUM_STORAGE_256M -> OCBlocks.QUANTUM_CRAFTING_STORAGE_256M_BLOCK;
        };
        return definition.asItem();
    }
}
