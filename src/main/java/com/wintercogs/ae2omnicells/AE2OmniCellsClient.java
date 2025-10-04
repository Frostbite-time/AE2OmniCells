package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.client.me.AE2ClientPlugin;
import net.minecraftforge.eventbus.api.IEventBus;

public class AE2OmniCellsClient
{
    public static void clientInit()
    {

    }

    public static void clientCommonSetup()
    {
        AE2ClientPlugin.register();
    }

    public static void clientRegister(IEventBus modBus, IEventBus gameBus)
    {
        AE2ClientPlugin.registerStorageLED(modBus);
    }
}
