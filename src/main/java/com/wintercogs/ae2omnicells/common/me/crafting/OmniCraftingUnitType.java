package com.wintercogs.ae2omnicells.common.me.crafting;

import appeng.block.crafting.ICraftingUnitType;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;

public enum OmniCraftingUnitType implements ICraftingUnitType
{
    /** 三系存储均给予对应合成存储器 */
    OMNI_UNIT(0, 0, OmniCraftingFamily.OMNI, OmniCraftingStorageType.UNIT),
    OMNI_STORAGE_1K(1, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_1K),
    OMNI_STORAGE_4K(4, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_4K),
    OMNI_STORAGE_16K(16, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_16K),
    OMNI_STORAGE_64K(64, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_64K),
    OMNI_STORAGE_256K(256, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_256K),
    OMNI_STORAGE_1M(1024, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_1M),
    OMNI_STORAGE_4M(4096, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_4M),
    OMNI_STORAGE_16M(16384, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_16M),
    OMNI_STORAGE_64M(65536, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_64M),
    OMNI_STORAGE_256M(262144, 4, OmniCraftingFamily.OMNI, OmniCraftingStorageType.STORAGE_256M),
    
    COMPLEX_UNIT(0, 0, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.UNIT),
    COMPLEX_STORAGE_1K(1, 0, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_1K),
    COMPLEX_STORAGE_4K(4, 1, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_4K),
    COMPLEX_STORAGE_16K(16, 2, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_16K),
    COMPLEX_STORAGE_64K(64, 4, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_64K),
    COMPLEX_STORAGE_256K(256, 8, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_256K),
    COMPLEX_STORAGE_1M(1024, 16, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_1M),
    COMPLEX_STORAGE_4M(4096, 32, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_4M),
    COMPLEX_STORAGE_16M(16384, 64, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_16M),
    COMPLEX_STORAGE_64M(65536, 128, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_64M),
    COMPLEX_STORAGE_256M(262144, 256, OmniCraftingFamily.COMPLEX, OmniCraftingStorageType.STORAGE_256M),

    QUANTUM_UNIT(0, 0, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.UNIT),
    QUANTUM_STORAGE_1K(1, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_1K),
    QUANTUM_STORAGE_4K(4, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_4K),
    QUANTUM_STORAGE_16K(16, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_16K),
    QUANTUM_STORAGE_64K(64, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_64K),
    QUANTUM_STORAGE_256K(256, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_256K),
    QUANTUM_STORAGE_1M(1024, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_1M),
    QUANTUM_STORAGE_4M(4096, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_4M),
    QUANTUM_STORAGE_16M(16384, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_16M),
    QUANTUM_STORAGE_64M(65536, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_64M),
    QUANTUM_STORAGE_256M(262144, 8192, OmniCraftingFamily.QUANTUM, OmniCraftingStorageType.STORAGE_256M);

    /** 千字节 */
    private final long storageKb;

    /** 处理器数量 */
    private final int processors;

    // 这两个额外定义，用于写自定义模型时少写两行代码~
    /** 元件系列 */
    public final OmniCraftingFamily family;
    /** 存储类型 */
    public final OmniCraftingStorageType storageType;

    OmniCraftingUnitType(long storageKb, int processors, OmniCraftingFamily family, OmniCraftingStorageType storageType)
    {
        this.storageKb = storageKb;
        this.processors = processors;
        this.family = family;
        this.storageType = storageType;
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
