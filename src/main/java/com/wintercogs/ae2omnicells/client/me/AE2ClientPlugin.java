package com.wintercogs.ae2omnicells.client.me;

import appeng.block.crafting.CraftingMonitorBlock;
import appeng.client.render.crafting.CraftingCubeModel;
import appeng.client.render.crafting.CraftingMonitorRenderer;
import appeng.core.AppEng;
import appeng.hooks.BuiltInModelHooks;
import com.wintercogs.ae2omnicells.client.render.OmniCraftingUnitModelProvider;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.init.OCBlockEntities;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class AE2ClientPlugin
{
    /** 运行在Client入口点 */
    public static void onInit()
    {

    }

    /** init后立刻运行此段代码，在这里进行注册相关内容 */
    public static void onRegister(IEventBus modEventBus, IEventBus gameEventBus)
    {
        // 注册硬盘led灯
        modEventBus.addListener(AE2StorageModels::registerItemColors);
        // 注册合成监控器渲染
        modEventBus.addListener(AE2ClientPlugin::registerEntityRenderers);
    }

    /** 允许在CommonSetup */
    public static void onCommonSetup()
    {
        // 注册存储元件模型
        AE2StorageModels.registerStorageModels();

        // 注册合成存储器以及监控器模型
        // 这里写入AE2的命名空间，能通过AE2的hook省去一个mixin
        for(RegistryObject<? extends OmniCraftingUnitBlock> block : OCBlocks.CRAFTING_STORAGES)
        {
            if(block.get().type instanceof OmniCraftingUnitType omniCraftingUnitType)
                BuiltInModelHooks.addBuiltInModel(AppEng.makeId("block/crafting/" + block.getId().getPath() + "_formed"), new CraftingCubeModel(new OmniCraftingUnitModelProvider(omniCraftingUnitType)));
        }
        for(RegistryObject<? extends CraftingMonitorBlock> block : OCBlocks.CRAFTING_MONITORS)
        {
            if(block.get().type instanceof OmniCraftingUnitType omniCraftingUnitType)
                BuiltInModelHooks.addBuiltInModel(AppEng.makeId("block/crafting/" + block.getId().getPath() + "_formed"), new CraftingCubeModel(new OmniCraftingUnitModelProvider(omniCraftingUnitType)));
        }
    }

    private static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(OCBlockEntities.OMNI_CRAFTING_MONITOR_BLOCK_ENTITY.get(), CraftingMonitorRenderer::new);
    }
}
