package com.wintercogs.ae2omnicells.client.init;

import appeng.client.gui.me.common.MEStorageScreen;
import appeng.init.client.InitScreens;
import appeng.menu.me.common.MEStorageMenu;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCMenus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AE2OmniCells.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OCScreens
{
    @SubscribeEvent
    public static void registerScreens(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            InitScreens.<MEStorageMenu, MEStorageScreen<MEStorageMenu>>register(
                    OCMenus.PORTABLE_UNIVERSAL_CELL_MENU,
                    MEStorageScreen::new,
                    "/screens/terminals/portable_universal_cell.json"
            );
        });
    }
}
