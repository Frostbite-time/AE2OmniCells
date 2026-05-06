package com.wintercogs.ae2omnicells.client.me;

import appeng.client.renderer.blockentity.CraftingMonitorRenderer;
import com.wintercogs.ae2omnicells.client.render.OmniCraftingCubeModel;
import com.wintercogs.ae2omnicells.common.init.OCBlockEntities;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterBlockStateModels;

public class AE2ClientPlugin
{
    /**
     * 运行在Client入口点
     */
    public static void onInit()
    {

    }

    /**
     * init后立刻运行此段代码，在这里进行注册相关内容
     */
    public static void onRegister(IEventBus modEventBus, IEventBus gameEventBus)
    {
        // 注册合成监控器渲染
        modEventBus.addListener(AE2ClientPlugin::registerEntityRenderers);
        // 注册合成存储器已成型状态的自定义 blockstate 模型
        modEventBus.addListener(AE2ClientPlugin::registerBlockStateModels);
    }

    /**
     * 允许在CommonSetup
     */
    public static void onCommonSetup()
    {
        // 注册存储元件模型
        AE2StorageModels.registerStorageModels();

    }

    private static void registerBlockStateModels(RegisterBlockStateModels event)
    {
        event.registerModel(OmniCraftingCubeModel.Unbaked.ID, OmniCraftingCubeModel.Unbaked.MAP_CODEC);
    }

    private static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(OCBlockEntities.OMNI_CRAFTING_MONITOR_BLOCK_ENTITY.get(), CraftingMonitorRenderer::new);
    }
}
