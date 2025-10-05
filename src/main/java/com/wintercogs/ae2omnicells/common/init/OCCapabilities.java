package com.wintercogs.ae2omnicells.common.init;

import appeng.items.tools.powered.powersink.PoweredItemCapabilities;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredItem;

@EventBusSubscriber(modid = AE2OmniCells.MODID, bus = EventBusSubscriber.Bus.MOD)
public class OCCapabilities
{
    @SubscribeEvent
    public static void onRegisterCaps(RegisterCapabilitiesEvent event)
    {
        for(DeferredItem<AEPortableUniversalCellItem> item : OCItems.getPortableCells())
        {
            event.registerItem(Capabilities.EnergyStorage.ITEM,
                    (o, unused) -> new PoweredItemCapabilities(o, item.get()),
                    item);
        }
    }
}
