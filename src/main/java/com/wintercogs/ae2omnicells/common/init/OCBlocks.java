package com.wintercogs.ae2omnicells.common.init;

import appeng.block.AEBaseBlock;
import appeng.block.crafting.CraftingMonitorBlock;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingMonitorBlock;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.items.OmniCraftingBlockItem;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OCBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AE2OmniCells.MODID);

    public static final List<DeferredBlock<? extends Block>> ALL = new ArrayList<>();
    public static final List<DeferredBlock<? extends OmniCraftingUnitBlock>> CRAFTING_STORAGES = new ArrayList<>();
    public static final List<DeferredBlock<? extends CraftingMonitorBlock>> CRAFTING_MONITORS = new ArrayList<>();

    // 末影钢块
    public static final DeferredBlock<Block> ENDER_INGOT_BLOCK = registerBlock("ender_ingot_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    // 下界合金碎片块
    public static final DeferredBlock<Block> NETHERITE_SCRAP_BLOCK = registerBlock("netherite_scrap_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    // 奇点块
    public static final DeferredBlock<Block> SINGULARITY_BLOCK = registerBlock("singularity_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));
    
    // 三系合成存储器
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_UNIT_BLOCK = registerCraftingStorageBlock("omni_crafting_unit_block", OmniCraftingUnitType.OMNI_UNIT);
    public static final DeferredBlock<OmniCraftingMonitorBlock> OMNI_CRAFTING_MONITOR_BLOCK = registerCraftingMonitorBlock("omni_crafting_monitor_block", OmniCraftingUnitType.OMNI_MONITOR);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_1K_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_1k_block", OmniCraftingUnitType.OMNI_STORAGE_1K);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_4K_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_4k_block", OmniCraftingUnitType.OMNI_STORAGE_4K);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_16K_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_16k_block", OmniCraftingUnitType.OMNI_STORAGE_16K);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_64K_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_64k_block", OmniCraftingUnitType.OMNI_STORAGE_64K);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_256K_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_256k_block", OmniCraftingUnitType.OMNI_STORAGE_256K);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_1M_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_1m_block", OmniCraftingUnitType.OMNI_STORAGE_1M);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_4M_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_4m_block", OmniCraftingUnitType.OMNI_STORAGE_4M);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_16M_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_16m_block", OmniCraftingUnitType.OMNI_STORAGE_16M);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_64M_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_64m_block", OmniCraftingUnitType.OMNI_STORAGE_64M);
    public static final DeferredBlock<OmniCraftingUnitBlock> OMNI_CRAFTING_STORAGE_256M_BLOCK = registerCraftingStorageBlock("omni_crafting_storage_256m_block", OmniCraftingUnitType.OMNI_STORAGE_256M);

    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_UNIT_BLOCK = registerCraftingStorageBlock("complex_crafting_unit_block", OmniCraftingUnitType.COMPLEX_UNIT);
    public static final DeferredBlock<OmniCraftingMonitorBlock> COMPLEX_CRAFTING_MONITOR_BLOCK = registerCraftingMonitorBlock("complex_crafting_monitor_block", OmniCraftingUnitType.COMPLEX_MONITOR);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_1K_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_1k_block", OmniCraftingUnitType.COMPLEX_STORAGE_1K);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_4K_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_4k_block", OmniCraftingUnitType.COMPLEX_STORAGE_4K);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_16K_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_16k_block", OmniCraftingUnitType.COMPLEX_STORAGE_16K);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_64K_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_64k_block", OmniCraftingUnitType.COMPLEX_STORAGE_64K);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_256K_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_256k_block", OmniCraftingUnitType.COMPLEX_STORAGE_256K);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_1M_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_1m_block", OmniCraftingUnitType.COMPLEX_STORAGE_1M);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_4M_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_4m_block", OmniCraftingUnitType.COMPLEX_STORAGE_4M);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_16M_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_16m_block", OmniCraftingUnitType.COMPLEX_STORAGE_16M);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_64M_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_64m_block", OmniCraftingUnitType.COMPLEX_STORAGE_64M);
    public static final DeferredBlock<OmniCraftingUnitBlock> COMPLEX_CRAFTING_STORAGE_256M_BLOCK = registerCraftingStorageBlock("complex_crafting_storage_256m_block", OmniCraftingUnitType.COMPLEX_STORAGE_256M);

    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_UNIT_BLOCK = registerCraftingStorageBlock("quantum_crafting_unit_block", OmniCraftingUnitType.QUANTUM_UNIT);
    public static final DeferredBlock<OmniCraftingMonitorBlock> QUANTUM_CRAFTING_MONITOR_BLOCK = registerCraftingMonitorBlock("quantum_crafting_monitor_block", OmniCraftingUnitType.QUANTUM_MONITOR);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_1K_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_1k_block", OmniCraftingUnitType.QUANTUM_STORAGE_1K);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_4K_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_4k_block", OmniCraftingUnitType.QUANTUM_STORAGE_4K);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_16K_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_16k_block", OmniCraftingUnitType.QUANTUM_STORAGE_16K);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_64K_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_64k_block", OmniCraftingUnitType.QUANTUM_STORAGE_64K);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_256K_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_256k_block", OmniCraftingUnitType.QUANTUM_STORAGE_256K);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_1M_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_1m_block", OmniCraftingUnitType.QUANTUM_STORAGE_1M);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_4M_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_4m_block", OmniCraftingUnitType.QUANTUM_STORAGE_4M);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_16M_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_16m_block", OmniCraftingUnitType.QUANTUM_STORAGE_16M);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_64M_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_64m_block", OmniCraftingUnitType.QUANTUM_STORAGE_64M);
    public static final DeferredBlock<OmniCraftingUnitBlock> QUANTUM_CRAFTING_STORAGE_256M_BLOCK = registerCraftingStorageBlock("quantum_crafting_storage_256m_block", OmniCraftingUnitType.QUANTUM_STORAGE_256M);

    private static DeferredBlock<OmniCraftingMonitorBlock> registerCraftingMonitorBlock(String name, OmniCraftingUnitType type)
    {
        DeferredBlock<OmniCraftingMonitorBlock> toReturn = registerOnlyBlock(name, () -> new OmniCraftingMonitorBlock(type));
        OCItems.ITEMS.register(name, () -> new OmniCraftingBlockItem(toReturn.get(), new Item.Properties(), type.family));

        CRAFTING_MONITORS.add(toReturn);
        return toReturn;
    }

    private static DeferredBlock<OmniCraftingUnitBlock> registerCraftingStorageBlock(String name, OmniCraftingUnitType type)
    {
        DeferredBlock<OmniCraftingUnitBlock> toReturn = registerOnlyBlock(name, () -> new OmniCraftingUnitBlock(AEBaseBlock.metalProps(), type));
        OCItems.ITEMS.register(name, () -> new OmniCraftingBlockItem(toReturn.get(), new Item.Properties(), type.family));
        
        CRAFTING_STORAGES.add(toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = registerOnlyBlock(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerOnlyBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        ALL.add(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        OCItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}