package com.wintercogs.ae2omnicells.client.me;

import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

import static com.wintercogs.ae2omnicells.common.init.OCItems.*;

public class AE2StorageModels
{

    public static void registerStorageModels()
    {
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
                QUANTUM_OMNI_CELL_256M.get()
        );
    }
}
