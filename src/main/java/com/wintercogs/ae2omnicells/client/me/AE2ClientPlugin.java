package com.wintercogs.ae2omnicells.client.me;

import net.minecraftforge.eventbus.api.IEventBus;

public class AE2ClientPlugin
{
    public static void register()
    {
        AE2StorageModels.registerStorageModels();
    }

    public static void registerStorageLED(IEventBus modEventBus)
    {
        modEventBus.addListener(AE2StorageModels::registerItemColors);
    }
}
