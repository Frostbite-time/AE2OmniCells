package com.wintercogs.ae2omnicells;

import com.mojang.logging.LogUtils;
import com.wintercogs.ae2omnicells.common.init.OCCreativeModeTabs;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.common.me.AEPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AE2OmniCells.MODID)
public class AE2OmniCells
{
    public static final String MODID = "ae2omnicells";
    private static final Logger LOGGER = LogUtils.getLogger();


    public AE2OmniCells()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        OCItems.register(modEventBus);
        OCCreativeModeTabs.register(modEventBus);
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
