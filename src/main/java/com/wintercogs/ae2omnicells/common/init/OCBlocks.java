package com.wintercogs.ae2omnicells.common.init;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OCBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AE2OmniCells.MODID);

    public static final List<DeferredBlock<? extends Block>> ALL = new ArrayList<>();

    // 末影钢块
    public static final DeferredBlock<Block> ENDER_INGOT_BLOCK = registerBlock("ender_ingot_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    // 下界合金碎片块
    public static final DeferredBlock<Block> NETHERITE_SCRAP_BLOCK = registerBlock("netherite_scrap_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    // 奇点块
    public static final DeferredBlock<Block> SINGULARITY_BLOCK = registerBlock("singularity_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        ALL.add(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        OCItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}