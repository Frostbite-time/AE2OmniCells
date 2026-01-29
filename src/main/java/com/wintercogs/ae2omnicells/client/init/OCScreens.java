package com.wintercogs.ae2omnicells.client.init;

import appeng.client.gui.me.common.MEStorageScreen;
import appeng.init.client.InitScreens;
import appeng.menu.me.common.MEStorageMenu;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCMenus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = AE2OmniCells.MODID, value = Dist.CLIENT)
public class OCScreens
{
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event)
    {
        InitScreens.<MEStorageMenu, MEStorageScreen<MEStorageMenu>>register(event,
                OCMenus.PORTABLE_UNIVERSAL_CELL_MENU,
                MEStorageScreen::new,
                "/screens/terminals/portable_universal_cell.json"
        );
    }
}
