package com.wintercogs.ae2omnicells.common.init;

import appeng.api.implementations.menuobjects.IPortableTerminal;
import appeng.menu.implementations.MenuTypeBuilder;
import appeng.menu.me.common.MEStorageMenu;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;


public class OCMenus
{
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, AE2OmniCells.MODID);


    public static final MenuType<MEStorageMenu> PORTABLE_UNIVERSAL_CELL_MENU = MenuTypeBuilder
            .<MEStorageMenu, IPortableTerminal>create(MEStorageMenu::new, IPortableTerminal.class)
            .build("portable_universal_cell");

    public static void registerMenus(IEventBus eventBus)
    {
        MENU_TYPES.register(eventBus);
    }
}
