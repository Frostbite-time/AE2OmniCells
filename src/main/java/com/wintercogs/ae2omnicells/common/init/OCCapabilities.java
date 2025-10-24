package com.wintercogs.ae2omnicells.common.init;

import appeng.api.AECapabilities;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.blocks.entities.OmniCraftingBlockEntity;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = AE2OmniCells.MODID, bus = EventBusSubscriber.Bus.MOD)
public class OCCapabilities
{
    @SubscribeEvent
    public static void onRegisterCaps(RegisterCapabilitiesEvent event)
    {
        OmniCraftingBlockEntity.onRegisterCaps(event);
        AEPortableUniversalCellItem.onRegisterCaps(event);
        event.registerBlockEntity(
                AECapabilities.IN_WORLD_GRID_NODE_HOST,
                OCBlockEntities.OMNI_CRAFTING_MONITOR_BLOCK_ENTITY.get(),
                (be, unused) -> be
        );
    }
}
