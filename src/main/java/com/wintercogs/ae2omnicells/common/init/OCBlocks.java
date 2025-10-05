package com.wintercogs.ae2omnicells.common.init;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OCBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AE2OmniCells.MODID);

    public static final List<RegistryObject<? extends Block>> ALL = new ArrayList<>();

    // 末影钢块
    public static final RegistryObject<Block> ENDER_INGOT_BLOCK = registerBlock("ender_ingot_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    // 下界合金碎片块
    public static final RegistryObject<Block> NETHERITE_SCRAP_BLOCK = registerBlock("netherite_scrap_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    // 奇点块
    public static final RegistryObject<Block> SINGULARITY_BLOCK = registerBlock("singularity_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        ALL.add(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        OCItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}