package com.wintercogs.ae2omnicells;

import com.mojang.logging.LogUtils;
import com.wintercogs.ae2omnicells.common.init.*;
import com.wintercogs.ae2omnicells.common.me.AEPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(AE2OmniCells.MODID)
public class AE2OmniCells
{
    public static final String MODID = "ae2omnicells";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String AE2_MODID = "ae2";

    public static final String MEGA_MODID = "megacells";
    public static boolean MEGA_LOADED = false;

    public static final String EAE_MODID = "expatternprovider";
    public static boolean EAE_LOADED = false;

    public static final String AAE_MODID = "advanced_ae";
    public static boolean AAE_LOADED = false;

    public static final String AEMEK_MODID = "appmek";
    public static boolean AEMEK_LOADED = false;


    public AE2OmniCells()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::constructMod);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        Config.register(ModLoadingContext.get());

        OCItems.register(modEventBus);
        OCBlocks.register(modEventBus);
        OCBlockEntities.register(modEventBus);
        OCCreativeModeTabs.register(modEventBus);
        OCMenus.registerMenus(modEventBus);

        AEPlugin.onInit();
        AEPlugin.onRegister(modEventBus, MinecraftForge.EVENT_BUS);

        if(FMLEnvironment.dist == Dist.CLIENT)
        {
            AE2OmniCellsClient.clientInit();
            AE2OmniCellsClient.clientRegister(modEventBus, MinecraftForge.EVENT_BUS);
        }
    }

    private void constructMod(FMLConstructModEvent event)
    {
        if(ModList.get().isLoaded(MEGA_MODID))
            MEGA_LOADED = true;
        if(ModList.get().isLoaded(EAE_MODID))
            EAE_LOADED = true;
        if(ModList.get().isLoaded(AAE_MODID))
            AAE_LOADED = true;
        if(ModList.get().isLoaded(AEMEK_MODID))
            AEMEK_LOADED = true;
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        AEPlugin.onCommonSetup();

        if(FMLEnvironment.dist == Dist.CLIENT)
            AE2OmniCellsClient.clientCommonSetup();
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("AE2OmniCells - Server started");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
        return new ResourceLocation(AE2OmniCells.MODID, path);
    }
}
