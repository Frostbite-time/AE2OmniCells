package com.wintercogs.ae2omnicells.client.me;

import appeng.api.client.StorageCellModels;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.wintercogs.ae2omnicells.common.init.OCItems.*;

public class AE2StorageModels
{
    private static final ResourceLocation OMNI_MODEL = AE2OmniCells.makeId("block/drive/omni_drive_cell");
    private static final ResourceLocation COMPLEX_OMNI_MODEL = AE2OmniCells.makeId("block/drive/complex_omni_drive_cell");
    private static final ResourceLocation QUANTUM_OMNI_MODEL = AE2OmniCells.makeId("block/drive/quantum_omni_drive_cell");

    public static void registerStorageModels()
    {
        // 普通（非便携 + 便携）
        registerModels(OMNI_MODEL,
                OMNI_CELL_1K, OMNI_CELL_4K, OMNI_CELL_16K, OMNI_CELL_64K, OMNI_CELL_256K,
                OMNI_CELL_1M, OMNI_CELL_4M, OMNI_CELL_16M, OMNI_CELL_64M, OMNI_CELL_256M,
                PORTABLE_OMNI_CELL_1K, PORTABLE_OMNI_CELL_4K, PORTABLE_OMNI_CELL_16K, PORTABLE_OMNI_CELL_64K, PORTABLE_OMNI_CELL_256K,
                PORTABLE_OMNI_CELL_1M, PORTABLE_OMNI_CELL_4M, PORTABLE_OMNI_CELL_16M, PORTABLE_OMNI_CELL_64M, PORTABLE_OMNI_CELL_256M
        );

        // 复杂（非便携 + 便携）
        registerModels(COMPLEX_OMNI_MODEL,
                COMPLEX_OMNI_CELL_1K, COMPLEX_OMNI_CELL_4K, COMPLEX_OMNI_CELL_16K, COMPLEX_OMNI_CELL_64K, COMPLEX_OMNI_CELL_256K,
                COMPLEX_OMNI_CELL_1M, COMPLEX_OMNI_CELL_4M, COMPLEX_OMNI_CELL_16M, COMPLEX_OMNI_CELL_64M, COMPLEX_OMNI_CELL_256M,
                PORTABLE_COMPLEX_OMNI_CELL_1K, PORTABLE_COMPLEX_OMNI_CELL_4K, PORTABLE_COMPLEX_OMNI_CELL_16K, PORTABLE_COMPLEX_OMNI_CELL_64K, PORTABLE_COMPLEX_OMNI_CELL_256K,
                PORTABLE_COMPLEX_OMNI_CELL_1M, PORTABLE_COMPLEX_OMNI_CELL_4M, PORTABLE_COMPLEX_OMNI_CELL_16M, PORTABLE_COMPLEX_OMNI_CELL_64M, PORTABLE_COMPLEX_OMNI_CELL_256M
        );

        // 量子（非便携 + 便携）
        registerModels(QUANTUM_OMNI_MODEL,
                QUANTUM_OMNI_CELL_1K, QUANTUM_OMNI_CELL_4K, QUANTUM_OMNI_CELL_16K, QUANTUM_OMNI_CELL_64K, QUANTUM_OMNI_CELL_256K,
                QUANTUM_OMNI_CELL_1M, QUANTUM_OMNI_CELL_4M, QUANTUM_OMNI_CELL_16M, QUANTUM_OMNI_CELL_64M, QUANTUM_OMNI_CELL_256M,
                PORTABLE_QUANTUM_OMNI_CELL_1K, PORTABLE_QUANTUM_OMNI_CELL_4K, PORTABLE_QUANTUM_OMNI_CELL_16K, PORTABLE_QUANTUM_OMNI_CELL_64K, PORTABLE_QUANTUM_OMNI_CELL_256K,
                PORTABLE_QUANTUM_OMNI_CELL_1M, PORTABLE_QUANTUM_OMNI_CELL_4M, PORTABLE_QUANTUM_OMNI_CELL_16M, PORTABLE_QUANTUM_OMNI_CELL_64M, PORTABLE_QUANTUM_OMNI_CELL_256M
        );
    }

    public static void registerItemColors(RegisterColorHandlersEvent.Item event)
    {
        event.register(AEUniversalCellItem::getColor,
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

    @SafeVarargs
    private static void registerModels(ResourceLocation model, RegistryObject<? extends Item>... items)
    {
        for (var ro : items)
        {
            StorageCellModels.registerModel(ro.get(), model);
        }
    }
}
