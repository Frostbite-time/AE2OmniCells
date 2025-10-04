package com.wintercogs.ae2omnicells.common.me;

import appeng.api.storage.StorageCells;

public class AEPlugin
{
    public static void register()
    {
        StorageCells.addCellHandler(AEUniversalCellHandler.INSTANCE);
    }
}
