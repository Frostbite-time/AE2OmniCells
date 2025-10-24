package com.wintercogs.ae2omnicells.client.me;


import appeng.client.render.crafting.CraftingCubeModel;
import appeng.core.AppEng;
import appeng.hooks.BuiltInModelHooks;
import com.wintercogs.ae2omnicells.client.render.OmniCraftingUnitModelProvider;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;

public class AE2ClientPlugin
{
    /** 运行在Client入口点 */
    public static void init()
    {
        // 注册存储合成器模型
        for(DeferredBlock<? extends OmniCraftingUnitBlock> block : OCBlocks.CRAFTING_STORAGES)
        {
            if(block.get().type instanceof OmniCraftingUnitType omniCraftingUnitType)
                BuiltInModelHooks.addBuiltInModel(AppEng.makeId("block/crafting/" + block.getId().getPath() + "_formed"), new CraftingCubeModel(new OmniCraftingUnitModelProvider(omniCraftingUnitType)));
        }
    }

    public static void register()
    {
        AE2StorageModels.registerStorageModels();
    }

    public static void registerStorageLED(IEventBus modEventBus)
    {
        modEventBus.addListener(AE2StorageModels::registerItemColors);
    }
}
