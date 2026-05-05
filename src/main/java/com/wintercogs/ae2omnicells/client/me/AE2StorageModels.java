package com.wintercogs.ae2omnicells.client.me;

import appeng.api.client.StorageCellModels;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.wintercogs.ae2omnicells.common.init.OCItems.*;

public class AE2StorageModels
{
    private static final String OMNI_MODEL_PREFIX = AE2OmniCells.makeId("drive/cells/omni/cell_").toString();
    private static final String COMPLEX_MODEL_PREFIX = AE2OmniCells.makeId("drive/cells/complex/cell_").toString();
    private static final String QUANTUM_MODEL_PREFIX = AE2OmniCells.makeId("drive/cells/quantum/cell_").toString();

    private static final Identifier MODEL_CELL_CREATIVE = Identifier.parse(
            "ae2:block/drive/cells/creative_cell");

    private static final Identifier MODEL_SPENT_NUCLEAR_WASTE_CELL = AE2OmniCells.makeId("drive/cells/spent_nuclear_waste_cell");

    // 统一的 Tier 后缀顺序
    private static final String[] SUFFIXES = {
            "1k", "4k", "16k", "64k", "256k",
            "1m", "4m", "16m", "64m", "256m"
    };

    public static void registerStorageModels()
    {
        // 创造元件 直接借用AE原版的模型
        StorageCellModels.registerModel(CREATIVE_AE_CELL_LONG, MODEL_CELL_CREATIVE);
        StorageCellModels.registerModel(CREATIVE_AE_CELL_BIGINTEGER, MODEL_CELL_CREATIVE);

        // 废核元件
        StorageCellModels.registerModel(SPENT_NUCLEAR_WASTE_CELL, MODEL_SPENT_NUCLEAR_WASTE_CELL);

        // 普通（非便携 + 便携）
        registerSeries(
                OMNI_MODEL_PREFIX,
                new DeferredItem[]{OMNI_CELL_1K, OMNI_CELL_4K, OMNI_CELL_16K, OMNI_CELL_64K, OMNI_CELL_256K,
                        OMNI_CELL_1M, OMNI_CELL_4M, OMNI_CELL_16M, OMNI_CELL_64M, OMNI_CELL_256M},
                new DeferredItem[]{PORTABLE_OMNI_CELL_1K, PORTABLE_OMNI_CELL_4K, PORTABLE_OMNI_CELL_16K, PORTABLE_OMNI_CELL_64K, PORTABLE_OMNI_CELL_256K,
                        PORTABLE_OMNI_CELL_1M, PORTABLE_OMNI_CELL_4M, PORTABLE_OMNI_CELL_16M, PORTABLE_OMNI_CELL_64M, PORTABLE_OMNI_CELL_256M}
        );

        // 复杂（非便携 + 便携）
        registerSeries(
                COMPLEX_MODEL_PREFIX,
                new DeferredItem[]{COMPLEX_OMNI_CELL_1K, COMPLEX_OMNI_CELL_4K, COMPLEX_OMNI_CELL_16K, COMPLEX_OMNI_CELL_64K, COMPLEX_OMNI_CELL_256K,
                        COMPLEX_OMNI_CELL_1M, COMPLEX_OMNI_CELL_4M, COMPLEX_OMNI_CELL_16M, COMPLEX_OMNI_CELL_64M, COMPLEX_OMNI_CELL_256M},
                new DeferredItem[]{PORTABLE_COMPLEX_OMNI_CELL_1K, PORTABLE_COMPLEX_OMNI_CELL_4K, PORTABLE_COMPLEX_OMNI_CELL_16K, PORTABLE_COMPLEX_OMNI_CELL_64K, PORTABLE_COMPLEX_OMNI_CELL_256K,
                        PORTABLE_COMPLEX_OMNI_CELL_1M, PORTABLE_COMPLEX_OMNI_CELL_4M, PORTABLE_COMPLEX_OMNI_CELL_16M, PORTABLE_COMPLEX_OMNI_CELL_64M, PORTABLE_COMPLEX_OMNI_CELL_256M}
        );

        // 量子（非便携 + 便携）
        registerSeries(
                QUANTUM_MODEL_PREFIX,
                new DeferredItem[]{QUANTUM_OMNI_CELL_1K, QUANTUM_OMNI_CELL_4K, QUANTUM_OMNI_CELL_16K, QUANTUM_OMNI_CELL_64K, QUANTUM_OMNI_CELL_256K,
                        QUANTUM_OMNI_CELL_1M, QUANTUM_OMNI_CELL_4M, QUANTUM_OMNI_CELL_16M, QUANTUM_OMNI_CELL_64M, QUANTUM_OMNI_CELL_256M},
                new DeferredItem[]{PORTABLE_QUANTUM_OMNI_CELL_1K, PORTABLE_QUANTUM_OMNI_CELL_4K, PORTABLE_QUANTUM_OMNI_CELL_16K, PORTABLE_QUANTUM_OMNI_CELL_64K, PORTABLE_QUANTUM_OMNI_CELL_256K,
                        PORTABLE_QUANTUM_OMNI_CELL_1M, PORTABLE_QUANTUM_OMNI_CELL_4M, PORTABLE_QUANTUM_OMNI_CELL_16M, PORTABLE_QUANTUM_OMNI_CELL_64M, PORTABLE_QUANTUM_OMNI_CELL_256M}
        );
    }

    public static void registerItemColors(RegisterColorHandlersEvent.Item event)
    {
        event.register((itemStack, idx) -> FastColor.ARGB32.opaque(AEUniversalCellItem.getColor(itemStack, idx)),
                // 普通
                OMNI_CELL_1K.get(),
                OMNI_CELL_4K.get(),
                OMNI_CELL_16K.get(),
                OMNI_CELL_64K.get(),
                OMNI_CELL_256K.get(),
                OMNI_CELL_1M.get(),
                OMNI_CELL_4M.get(),
                OMNI_CELL_16M.get(),
                OMNI_CELL_64M.get(),
                OMNI_CELL_256M.get(),
                // 复杂
                COMPLEX_OMNI_CELL_1K.get(),
                COMPLEX_OMNI_CELL_4K.get(),
                COMPLEX_OMNI_CELL_16K.get(),
                COMPLEX_OMNI_CELL_64K.get(),
                COMPLEX_OMNI_CELL_256K.get(),
                COMPLEX_OMNI_CELL_1M.get(),
                COMPLEX_OMNI_CELL_4M.get(),
                COMPLEX_OMNI_CELL_16M.get(),
                COMPLEX_OMNI_CELL_64M.get(),
                COMPLEX_OMNI_CELL_256M.get(),
                // 量子
                QUANTUM_OMNI_CELL_1K.get(),
                QUANTUM_OMNI_CELL_4K.get(),
                QUANTUM_OMNI_CELL_16K.get(),
                QUANTUM_OMNI_CELL_64K.get(),
                QUANTUM_OMNI_CELL_256K.get(),
                QUANTUM_OMNI_CELL_1M.get(),
                QUANTUM_OMNI_CELL_4M.get(),
                QUANTUM_OMNI_CELL_16M.get(),
                QUANTUM_OMNI_CELL_64M.get(),
                QUANTUM_OMNI_CELL_256M.get(),
                // 创造
                CREATIVE_AE_CELL_LONG.get(),
                CREATIVE_AE_CELL_BIGINTEGER.get(),
                // 废核
                SPENT_NUCLEAR_WASTE_CELL.get()
        );

        event.register((itemStack, idx) -> FastColor.ARGB32.opaque(AEPortableUniversalCellItem.getColor(itemStack, idx)),
                // 便携系列
                PORTABLE_OMNI_CELL_1K.get(),
                PORTABLE_OMNI_CELL_4K.get(),
                PORTABLE_OMNI_CELL_16K.get(),
                PORTABLE_OMNI_CELL_64K.get(),
                PORTABLE_OMNI_CELL_256K.get(),
                PORTABLE_OMNI_CELL_1M.get(),
                PORTABLE_OMNI_CELL_4M.get(),
                PORTABLE_OMNI_CELL_16M.get(),
                PORTABLE_OMNI_CELL_64M.get(),
                PORTABLE_OMNI_CELL_256M.get(),
                PORTABLE_COMPLEX_OMNI_CELL_1K.get(),
                PORTABLE_COMPLEX_OMNI_CELL_4K.get(),
                PORTABLE_COMPLEX_OMNI_CELL_16K.get(),
                PORTABLE_COMPLEX_OMNI_CELL_64K.get(),
                PORTABLE_COMPLEX_OMNI_CELL_256K.get(),
                PORTABLE_COMPLEX_OMNI_CELL_1M.get(),
                PORTABLE_COMPLEX_OMNI_CELL_4M.get(),
                PORTABLE_COMPLEX_OMNI_CELL_16M.get(),
                PORTABLE_COMPLEX_OMNI_CELL_64M.get(),
                PORTABLE_COMPLEX_OMNI_CELL_256M.get(),
                PORTABLE_QUANTUM_OMNI_CELL_1K.get(),
                PORTABLE_QUANTUM_OMNI_CELL_4K.get(),
                PORTABLE_QUANTUM_OMNI_CELL_16K.get(),
                PORTABLE_QUANTUM_OMNI_CELL_64K.get(),
                PORTABLE_QUANTUM_OMNI_CELL_256K.get(),
                PORTABLE_QUANTUM_OMNI_CELL_1M.get(),
                PORTABLE_QUANTUM_OMNI_CELL_4M.get(),
                PORTABLE_QUANTUM_OMNI_CELL_16M.get(),
                PORTABLE_QUANTUM_OMNI_CELL_64M.get(),
                PORTABLE_QUANTUM_OMNI_CELL_256M.get()
        );
    }

    // ===== 新：按系列（非便携+便携）循环注册 =====
    private static void registerSeries(
            String prefix,
            DeferredItem<? extends Item>[] nonPortable,
            DeferredItem<? extends Item>[] portable
    )
    {
        if (nonPortable.length != SUFFIXES.length || portable.length != SUFFIXES.length)
        {
            throw new IllegalArgumentException("Tier arrays must match SUFFIXES length: " + SUFFIXES.length);
        }
        for (int i = 0; i < SUFFIXES.length; i++)
        {
            registerModel(prefix, SUFFIXES[i], nonPortable[i].get());
            registerModel(prefix, SUFFIXES[i], portable[i].get());
        }
    }

    private static void registerModel(String prefix, String cap, ItemLike item)
    {
        StorageCellModels.registerModel(item, Identifier.parse(prefix + cap));
    }
}
