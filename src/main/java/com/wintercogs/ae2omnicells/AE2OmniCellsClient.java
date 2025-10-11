package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.client.me.AE2ClientPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.AddPackFindersEvent;

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

    @SubscribeEvent
    static void onAddPackFinders(AddPackFindersEvent event)
    {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

        // “相对模组 resources”的路径：resources/resourcepacks/optional_textures
        ResourceLocation id = AE2OmniCells.makeId("resourcepacks/optional_textures");

        Component title = Component.translatable("pack.ae2omnicells.optional_textures.title");

        // 注册：客户端资源、内建注册表、非强制、默认放底部
        event.addPackFinders(
                id,
                PackType.CLIENT_RESOURCES,
                title,
                PackSource.BUILT_IN,
                false,
                Pack.Position.BOTTOM
        );
    }
}
