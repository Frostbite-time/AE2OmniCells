package com.wintercogs.ae2omnicells.common.init;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OCCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AE2OmniCells.MODID);

    public static final Supplier<CreativeModeTab> AE2_OMNI_CELLS_CREATIVE_TAB = CREATIVE_MODE_TAB.register(
            "ae2_omni_cells_creative_tab",
            ()->CreativeModeTab.builder()
                    .icon(() -> new ItemStack(OCItems.QUANTUM_OMNI_CELL_256M.get()))
                    .title(Component.translatable("creativetab.ae2omnicells.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for(RegistryObject<? extends Item> registryItems : OCItems.getAllItems())
                        {
                            output.accept(registryItems.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
