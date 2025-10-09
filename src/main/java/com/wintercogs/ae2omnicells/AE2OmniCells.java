package com.wintercogs.ae2omnicells;

import com.mojang.logging.LogUtils;
import com.wintercogs.ae2omnicells.common.init.*;
import com.wintercogs.ae2omnicells.common.me.AEPlugin;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(AE2OmniCells.MODID)
public class AE2OmniCells
{
    public static final String MODID = "ae2omnicells";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String MEGA_MODID = "megacells";
    public static boolean MEGA_LOADED = false;

    public static final String EAE_MODID = "extendedae";
    public static boolean EAE_LOADED = false;

    public static final String AAE_MODID = "advanced_ae";
    public static boolean AAE_LOADED = false;


    public AE2OmniCells(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::constructMod);
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        OCDataComponents.register(modEventBus);
        OCItems.register(modEventBus);
        OCBlocks.register(modEventBus);
        OCCreativeModeTabs.register(modEventBus);
        OCMenus.registerMenus(modEventBus);
    }

    private void constructMod(FMLConstructModEvent event)
    {
        if(ModList.get().isLoaded(MEGA_MODID))
            MEGA_LOADED = true;
        if(ModList.get().isLoaded(EAE_MODID))
            EAE_LOADED = true;
        if(ModList.get().isLoaded(AAE_MODID))
            AAE_LOADED = true;
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        AEPlugin.register();
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("AE2OmniCells - Server started");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("AE2OmniCells - Client started");
        }
    }

    public static ResourceLocation makeId(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(AE2OmniCells.MODID, path);
    }
}
