package com.wintercogs.ae2omnicells.common.me;

import appeng.api.storage.StorageCells;
import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.neoforged.neoforge.registries.DeferredItem;

public class AEPlugin
{
    public static void register()
    {
        StorageCells.addCellHandler(AEUniversalCellHandler.INSTANCE);

        for(DeferredItem<AEUniversalCellItem> registryItem : OCItems.getCells())
        {
            Upgrades.add(AEItems.FUZZY_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.VOID_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.INVERTER_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, registryItem.get(), 1);
        }
        for(DeferredItem<AEPortableUniversalCellItem> registryItem : OCItems.getPortableCells())
        {
            Upgrades.add(AEItems.FUZZY_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.VOID_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.INVERTER_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, registryItem.get(), 1);
            Upgrades.add(AEItems.ENERGY_CARD, registryItem.get(), 2);
        }
    }
}
