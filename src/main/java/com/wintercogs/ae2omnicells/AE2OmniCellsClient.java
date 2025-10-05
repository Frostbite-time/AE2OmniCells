package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.client.me.AE2ClientPlugin;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = AE2OmniCells.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = AE2OmniCells.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class AE2OmniCellsClient
{

    public AE2OmniCellsClient(IEventBus modEventBus, ModContainer container)
    {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        AE2ClientPlugin.registerStorageLED(modEventBus);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event)
    {
        AE2ClientPlugin.register();
    }
}
