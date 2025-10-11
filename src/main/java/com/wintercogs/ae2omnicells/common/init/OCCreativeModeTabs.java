package com.wintercogs.ae2omnicells.common.init;

import appeng.api.config.Actionable;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
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
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(OCItems.QUANTUM_OMNI_CELL_256M.get()))
                    .title(Component.translatable("creativetab.ae2omnicells.items"))
                    .displayItems((params, output) -> {
                        // 其他物品
                        for (RegistryObject<Item> ro : OCItems.getOthers())
                        {
                            output.accept(ro.get());
                        }
                        // 方块物品
                        for (RegistryObject<? extends Block> ro : OCBlocks.ALL)
                        {
                            output.accept(ro.get());
                        }
                        // 普通元件（非便携）
                        for (RegistryObject<AEUniversalCellItem> ro : OCItems.getCells())
                        {
                            output.accept(ro.get());
                        }
                        // 便携元件：每个展示两份（空电 + 满电），两件相邻
                        for (RegistryObject<AEPortableUniversalCellItem> ro : OCItems.getPortableCells())
                        {
                            AEPortableUniversalCellItem portable = ro.get();

                            // 空电
                            ItemStack empty = new ItemStack(portable);
                            output.accept(empty);

                            // 满电（不改动物品注册，仅用于创意展示）
                            ItemStack full = new ItemStack(portable);
                            // 注：注入一个极大值，底层会按最大电量上限截断
                            portable.injectAEPower(full, Double.MAX_VALUE, Actionable.MODULATE);
                            output.accept(full);
                        }
                        // 创造元件
                        for(RegistryObject<Item> ro : OCItems.getCreativeCells())
                        {
                            output.accept(ro.get());
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}