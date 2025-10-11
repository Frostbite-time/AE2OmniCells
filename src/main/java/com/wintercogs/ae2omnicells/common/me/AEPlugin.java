package com.wintercogs.ae2omnicells.common.me;

import appeng.api.storage.StorageCells;
import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import com.wintercogs.ae2omnicells.common.me.biginteger.AEBigIntegerCellHandler;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class AEPlugin
{
    private static final String CELL_GROUP_NAME = "ae2omnicells.cell.upgrades.group";
    private static final String PORTABLE_CELL_GROUP_NAME = "ae2omnicells.cell.portable.upgrades.group";

    public static void register()
    {
        StorageCells.addCellHandler(AEUniversalCellHandler.INSTANCE);
        StorageCells.addCellHandler(AEBigIntegerCellHandler.INSTANCE);

        for(RegistryObject<AEUniversalCellItem> registryItem : OCItems.getCells())
        {
            Upgrades.add(AEItems.FUZZY_CARD, registryItem.get(), 1, CELL_GROUP_NAME);
            Upgrades.add(AEItems.VOID_CARD, registryItem.get(), 1, CELL_GROUP_NAME);
            Upgrades.add(AEItems.INVERTER_CARD, registryItem.get(), 1, CELL_GROUP_NAME);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, registryItem.get(), 1, CELL_GROUP_NAME);
        }
        for(RegistryObject<AEPortableUniversalCellItem> registryItem : OCItems.getPortableCells())
        {
            Upgrades.add(AEItems.FUZZY_CARD, registryItem.get(), 1, PORTABLE_CELL_GROUP_NAME);
            Upgrades.add(AEItems.VOID_CARD, registryItem.get(), 1, PORTABLE_CELL_GROUP_NAME);
            Upgrades.add(AEItems.INVERTER_CARD, registryItem.get(), 1, PORTABLE_CELL_GROUP_NAME);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, registryItem.get(), 1, PORTABLE_CELL_GROUP_NAME);
            Upgrades.add(AEItems.ENERGY_CARD, registryItem.get(), 2, PORTABLE_CELL_GROUP_NAME);
        }
        // 为两个创造元件添加升级卡，再单独为long级别添加溢出销毁和均分卡
        for(RegistryObject<Item> registryItem : OCItems.getCreativeCells())
        {
            Upgrades.add(AEItems.FUZZY_CARD, registryItem.get(), 1, CELL_GROUP_NAME);
            Upgrades.add(AEItems.INVERTER_CARD, registryItem.get(), 1, CELL_GROUP_NAME);
        }
        Upgrades.add(AEItems.VOID_CARD, OCItems.CREATIVE_AE_CELL_LONG.get(), 1, CELL_GROUP_NAME);
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, OCItems.CREATIVE_AE_CELL_LONG.get(), 1, CELL_GROUP_NAME);
    }
}
