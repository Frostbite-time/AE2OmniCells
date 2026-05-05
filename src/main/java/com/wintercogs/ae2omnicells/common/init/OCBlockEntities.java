package com.wintercogs.ae2omnicells.common.init;

import appeng.block.AEBaseEntityBlock;
import appeng.blockentity.AEBaseBlockEntity;
import appeng.blockentity.ClientTickingBlockEntity;
import appeng.blockentity.ServerTickingBlockEntity;
import appeng.blockentity.crafting.CraftingMonitorBlockEntity;
import com.google.common.base.Preconditions;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.blocks.entities.OmniCraftingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class OCBlockEntities
{

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, AE2OmniCells.MODID);

    // 维护一个列表，提供和 AE 一样的检索功能（按父类/接口查询）
    private static final List<DeferredBlockEntityType<?>> ALL = new ArrayList<>();

    // OMNI合成存储器共用此实体类型
    @SuppressWarnings("unchecked")
    public static final DeferredBlockEntityType<OmniCraftingBlockEntity> OMNI_CRAFTING_BLOCK_ENTITY = create(
            "omni_crafting_block_entity",
            OmniCraftingBlockEntity.class,
            OmniCraftingBlockEntity::new,
            OCBlocks.CRAFTING_STORAGES.toArray(new Supplier[0]) // 这里我们自己清楚很安全
    );

    @SuppressWarnings("unchecked")
    public static final DeferredBlockEntityType<CraftingMonitorBlockEntity> OMNI_CRAFTING_MONITOR_BLOCK_ENTITY = create(
            "omni_crating_monitor_block_entity",
            CraftingMonitorBlockEntity.class,
            CraftingMonitorBlockEntity::new,
            OCBlocks.CRAFTING_MONITORS.toArray(new Supplier[0]) // 此处安全
    );

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }


    /**
     * 用于AEBaseBlockEntity注册，自动附加ticker并绑定物品型态以用于AE的一些机制
     */
    @SafeVarargs
    private static <T extends AEBaseBlockEntity> DeferredBlockEntityType<T> create(
            String id,
            Class<T> entityClass,
            BlockEntityFactory<T> factory,
            Supplier<? extends AEBaseEntityBlock<?>>... blockSuppliers
    )
    {
        Preconditions.checkArgument(blockSuppliers.length > 0);

        var deferred = BLOCK_ENTITY_TYPES.register(id, () -> {
            AtomicReference<BlockEntityType<T>> typeHolder = new AtomicReference<>();

            BlockEntityType.BlockEntitySupplier<T> supplier = (pos, state) ->
                    factory.create(typeHolder.get(), pos, state);

            AEBaseEntityBlock<?>[] blocks = Arrays.stream(blockSuppliers)
                    .map(Supplier::get)
                    .toArray(AEBaseEntityBlock[]::new);

            BlockEntityType<T> type = new BlockEntityType<>(supplier, blocks);
            typeHolder.setPlain(type);

            AEBaseBlockEntity.registerBlockEntityItem(type, blocks[0].asItem());

            // 自动生成 tickers（如果实现了 AE 的标记接口）
            BlockEntityTicker<T> serverTicker = null;
            if (ServerTickingBlockEntity.class.isAssignableFrom(entityClass))
            {
                serverTicker = (lvl, p, st, be) -> ((ServerTickingBlockEntity) be).serverTick();
            }
            BlockEntityTicker<T> clientTicker = null;
            if (ClientTickingBlockEntity.class.isAssignableFrom(entityClass))
            {
                clientTicker = (lvl, p, st, be) -> ((ClientTickingBlockEntity) be).clientTick();
            }

            // 把 “type + tickers + 具体 BE 类” 绑定到每个方块上
            for (var b : blocks)
            {
                @SuppressWarnings("unchecked")
                AEBaseEntityBlock<T> base = (AEBaseEntityBlock<T>) b;
                base.setBlockEntity(entityClass, type, clientTicker, serverTicker);
            }

            return type;
        });

        var wrapped = new DeferredBlockEntityType<>(entityClass, deferred);
        ALL.add(wrapped);
        return wrapped;
    }

    /**
     * 返回实现类是 baseClass 的所有 BlockEntityType
     */
    @SuppressWarnings("unchecked")
    public static <T extends BlockEntity> List<BlockEntityType<? extends T>> getSubclassesOf(Class<T> baseClass)
    {
        var result = new ArrayList<BlockEntityType<? extends T>>();
        for (var t : ALL)
        {
            if (baseClass.isAssignableFrom(t.getBlockEntityClass()))
            {
                result.add((BlockEntityType<? extends T>) t.get());
            }
        }
        return result;
    }

    /**
     * 返回实现了某接口的所有 BlockEntityType
     */
    public static List<BlockEntityType<?>> getImplementorsOf(Class<?> iface)
    {
        var result = new ArrayList<BlockEntityType<?>>();
        for (var t : ALL)
        {
            if (iface.isAssignableFrom(t.getBlockEntityClass()))
            {
                result.add(t.get());
            }
        }
        return result;
    }


    /**
     * 包装类型
     */
    public static final class DeferredBlockEntityType<T extends BlockEntity> implements Supplier<BlockEntityType<T>>
    {
        private final Class<T> entityClass;
        private final Supplier<BlockEntityType<T>> delegate;

        private DeferredBlockEntityType(Class<T> cls, Supplier<BlockEntityType<T>> delegate)
        {
            this.entityClass = cls;
            this.delegate = delegate;
        }

        public BlockEntityType<T> get()
        {
            return delegate.get();
        }

        public Class<T> getBlockEntityClass()
        {
            return entityClass;
        }
    }

    /**
     * 三参构造版接口
     */
    @FunctionalInterface
    private interface BlockEntityFactory<T extends AEBaseBlockEntity>
    {
        T create(BlockEntityType<T> type, BlockPos pos, BlockState state);
    }

}
