package com.wintercogs.ae2omnicells.common.init;

import appeng.core.definitions.AEItems;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.items.AEPortableUniversalCellItem;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class OCItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AE2OmniCells.MODID);

    // ---- 四套列表 ----
    /** 全部注册过的物品 */
    private static final List<DeferredItem<? extends Item>> ALL = new ArrayList<>();
    /** 元件（= 非便携存储元件：普通/复杂/量子 的所有存储盘） */
    private static final List<DeferredItem<AEUniversalCellItem>> CELLS = new ArrayList<>();
    /** 便携元件（= 便携通用盘：普通/复杂/量子 的所有便携盘） */
    private static final List<DeferredItem<AEPortableUniversalCellItem>> PORTABLE_CELLS = new ArrayList<>();
    /** 其他物品（= 元件外壳、各类组件、锭/处理器/压印模板等杂项） */
    private static final List<DeferredItem<Item>> OTHERS = new ArrayList<>();

    // ---- 杂项 / 其他物品 ----
    public static final DeferredItem<Item> ENDER_INGOT = registerOtherItem("ender_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHARGED_ENDER_INGOT = registerOtherItem("charged_ender_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OMNI_LINK_PRINT_PRESS = registerOtherItem("omni_link_print_press", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COMPLEX_LINK_PRINT_PRESS = registerOtherItem("complex_link_print_press", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MULTIDIMENSIONAL_EXPANSION_PRINT_PRESS = registerOtherItem("multidimensional_expansion_print_press", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OMNI_LINK_CIRCUIT_PRINT = registerOtherItem("omni_link_circuit_print", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COMPLEX_LINK_CIRCUIT_PRINT = registerOtherItem("complex_link_circuit_print", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MULTIDIMENSIONAL_EXPANSION_CIRCUIT_PRINT = registerOtherItem("multidimensional_expansion_circuit_print", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OMNI_LINK_PROCESSOR = registerOtherItem("omni_link_processor", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COMPLEX_LINK_PROCESSOR = registerOtherItem("complex_link_processor", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MULTIDIMENSIONAL_EXPANSION_PROCESSOR = registerOtherItem("multidimensional_expansion_processor", () -> new Item(new Item.Properties()));

    // 外壳
    public static final DeferredItem<Item> OMNI_CELL_HOUSING = registerOtherItem("omni_cell_housing", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_HOUSING = registerOtherItem("complex_omni_cell_housing", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_HOUSING = registerOtherItem("quantum_omni_cell_housing", () -> new Item(new Item.Properties()));

    // ---- 全能存储组件（其他物品归类） ----
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_1K = registerComponent("omni_cell_component_1k");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_4K = registerComponent("omni_cell_component_4k");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_16K = registerComponent("omni_cell_component_16k");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_64K = registerComponent("omni_cell_component_64k");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_256K = registerComponent("omni_cell_component_256k");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_1M = registerComponent("omni_cell_component_1m");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_4M = registerComponent("omni_cell_component_4m");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_16M = registerComponent("omni_cell_component_16m");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_64M = registerComponent("omni_cell_component_64m");
    public static final DeferredItem<Item> OMNI_CELL_COMPONENT_256M = registerComponent("omni_cell_component_256m");

    // ---- 非便携：全能存储元件（= 元件） ----
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_1K = registerCell("omni_cell_1k",    AEItems.CELL_COMPONENT_1K,   1,  63,     1);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_4K = registerCell("omni_cell_4k",    AEItems.CELL_COMPONENT_4K,   2,  63,     4);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_16K = registerCell("omni_cell_16k",   AEItems.CELL_COMPONENT_16K,  3,  63,    16);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_64K = registerCell("omni_cell_64k",   AEItems.CELL_COMPONENT_64K,  4,  63,    64);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_256K = registerCell("omni_cell_256k",  AEItems.CELL_COMPONENT_256K, 5,  63,   256);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_1M = registerCell("omni_cell_1m",    OMNI_CELL_COMPONENT_1M,      6,  63,  1024);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_4M = registerCell("omni_cell_4m",    OMNI_CELL_COMPONENT_4M,      7,  63,  4096);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_16M = registerCell("omni_cell_16m",   OMNI_CELL_COMPONENT_16M,     8,  63, 16384);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_64M = registerCell("omni_cell_64m",   OMNI_CELL_COMPONENT_64M,     9,  63, 65536);
    public static final DeferredItem<AEUniversalCellItem> OMNI_CELL_256M = registerCell("omni_cell_256m",  OMNI_CELL_COMPONENT_256M,   10,  63,262144);

    // ---- 复杂：组件（其他物品归类） ----
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_1K = registerComponent("complex_omni_cell_component_1k");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_4K = registerComponent("complex_omni_cell_component_4k");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_16K = registerComponent("complex_omni_cell_component_16k");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_64K = registerComponent("complex_omni_cell_component_64k");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_256K = registerComponent("complex_omni_cell_component_256k");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_1M = registerComponent("complex_omni_cell_component_1m");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_4M = registerComponent("complex_omni_cell_component_4m");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_16M = registerComponent("complex_omni_cell_component_16m");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_64M = registerComponent("complex_omni_cell_component_64m");
    public static final DeferredItem<Item> COMPLEX_OMNI_CELL_COMPONENT_256M = registerComponent("complex_omni_cell_component_256m");

    // ---- 非便携：复杂存储元件（= 元件） ----
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_1K = registerComplexCell("complex_omni_cell_1k",    COMPLEX_OMNI_CELL_COMPONENT_1K,    2,    12,     1);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_4K = registerComplexCell("complex_omni_cell_4k",    COMPLEX_OMNI_CELL_COMPONENT_4K,    4,    25,     4);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_16K = registerComplexCell("complex_omni_cell_16k",   COMPLEX_OMNI_CELL_COMPONENT_16K,   8,    50,    16);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_64K = registerComplexCell("complex_omni_cell_64k",   COMPLEX_OMNI_CELL_COMPONENT_64K,  16,   100,    64);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_256K = registerComplexCell("complex_omni_cell_256k",  COMPLEX_OMNI_CELL_COMPONENT_256K, 32,   200,   256);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_1M = registerComplexCell("complex_omni_cell_1m",    COMPLEX_OMNI_CELL_COMPONENT_1M,   64,   400,  1024);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_4M = registerComplexCell("complex_omni_cell_4m",    COMPLEX_OMNI_CELL_COMPONENT_4M,  128,   800,  4096);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_16M = registerComplexCell("complex_omni_cell_16m",   COMPLEX_OMNI_CELL_COMPONENT_16M, 256,  1600, 16384);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_64M = registerComplexCell("complex_omni_cell_64m",   COMPLEX_OMNI_CELL_COMPONENT_64M, 512,  3200, 65536);
    public static final DeferredItem<AEUniversalCellItem> COMPLEX_OMNI_CELL_256M = registerComplexCell("complex_omni_cell_256m",  COMPLEX_OMNI_CELL_COMPONENT_256M,1024,  6400,262144);

    // ---- 量子：组件（其他物品归类） ----
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_1K = registerComponent("quantum_omni_cell_component_1k");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_4K = registerComponent("quantum_omni_cell_component_4k");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_16K = registerComponent("quantum_omni_cell_component_16k");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_64K = registerComponent("quantum_omni_cell_component_64k");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_256K = registerComponent("quantum_omni_cell_component_256k");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_1M = registerComponent("quantum_omni_cell_component_1m");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_4M = registerComponent("quantum_omni_cell_component_4m");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_16M = registerComponent("quantum_omni_cell_component_16m");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_64M = registerComponent("quantum_omni_cell_component_64m");
    public static final DeferredItem<Item> QUANTUM_OMNI_CELL_COMPONENT_256M = registerComponent("quantum_omni_cell_component_256m");

    // ---- 非便携：量子存储元件（= 元件；types = -1；idle 从 3 起，每档×3） ----
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_1K = registerQuantumCell("quantum_omni_cell_1k",    QUANTUM_OMNI_CELL_COMPONENT_1K,     3,   -1,       1);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_4K = registerQuantumCell("quantum_omni_cell_4k",    QUANTUM_OMNI_CELL_COMPONENT_4K,     9,   -1,       4);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_16K = registerQuantumCell("quantum_omni_cell_16k",   QUANTUM_OMNI_CELL_COMPONENT_16K,   27,   -1,      16);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_64K = registerQuantumCell("quantum_omni_cell_64k",   QUANTUM_OMNI_CELL_COMPONENT_64K,   81,   -1,      64);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_256K = registerQuantumCell("quantum_omni_cell_256k",  QUANTUM_OMNI_CELL_COMPONENT_256K, 243,   -1,     256);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_1M = registerQuantumCell("quantum_omni_cell_1m",    QUANTUM_OMNI_CELL_COMPONENT_1M,   729,   -1,    1024);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_4M = registerQuantumCell("quantum_omni_cell_4m",    QUANTUM_OMNI_CELL_COMPONENT_4M,  2187,   -1,    4096);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_16M = registerQuantumCell("quantum_omni_cell_16m",   QUANTUM_OMNI_CELL_COMPONENT_16M, 6561,   -1,   16384);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_64M = registerQuantumCell("quantum_omni_cell_64m",   QUANTUM_OMNI_CELL_COMPONENT_64M,19683,   -1,   65536);
    public static final DeferredItem<AEUniversalCellItem> QUANTUM_OMNI_CELL_256M = registerQuantumCell("quantum_omni_cell_256m",  QUANTUM_OMNI_CELL_COMPONENT_256M,59049,  -1,  262144);

    // ---- 便携：普通（参数沿用非便携：types/容量/idle） ----
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_1K = registerPortableCell("portable_omni_cell_1k",     1,  63,     1);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_4K = registerPortableCell("portable_omni_cell_4k",     2,  63,     4);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_16K = registerPortableCell("portable_omni_cell_16k",    3,  63,    16);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_64K = registerPortableCell("portable_omni_cell_64k",    4,  63,    64);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_256K = registerPortableCell("portable_omni_cell_256k",   5,  63,   256);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_1M = registerPortableCell("portable_omni_cell_1m",     6,  63,  1024);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_4M = registerPortableCell("portable_omni_cell_4m",     7,  63,  4096);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_16M = registerPortableCell("portable_omni_cell_16m",    8,  63, 16384);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_64M = registerPortableCell("portable_omni_cell_64m",    9,  63, 65536);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_OMNI_CELL_256M = registerPortableCell("portable_omni_cell_256m",  10,  63,262144);

    // ---- 便携：复杂 ----
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_1K = registerPortableCell("portable_complex_omni_cell_1k",     2,    12,     1);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_4K = registerPortableCell("portable_complex_omni_cell_4k",     4,    25,     4);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_16K = registerPortableCell("portable_complex_omni_cell_16k",    8,    50,    16);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_64K = registerPortableCell("portable_complex_omni_cell_64k",   16,   100,    64);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_256K = registerPortableCell("portable_complex_omni_cell_256k",  32,   200,   256);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_1M = registerPortableCell("portable_complex_omni_cell_1m",    64,   400,  1024);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_4M = registerPortableCell("portable_complex_omni_cell_4m",   128,   800,  4096);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_16M = registerPortableCell("portable_complex_omni_cell_16m",  256,  1600, 16384);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_64M = registerPortableCell("portable_complex_omni_cell_64m",  512,  3200, 65536);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_COMPLEX_OMNI_CELL_256M = registerPortableCell("portable_complex_omni_cell_256m",1024,  6400,262144);

    // ---- 便携：量子（types = -1；idle 从 3 起×3） ----
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_1K = registerPortableCell("portable_quantum_omni_cell_1k",      3,   -1,       1);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_4K = registerPortableCell("portable_quantum_omni_cell_4k",      9,   -1,       4);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_16K = registerPortableCell("portable_quantum_omni_cell_16k",    27,   -1,      16);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_64K = registerPortableCell("portable_quantum_omni_cell_64k",    81,   -1,      64);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_256K = registerPortableCell("portable_quantum_omni_cell_256k",  243,   -1,     256);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_1M = registerPortableCell("portable_quantum_omni_cell_1m",    729,   -1,    1024);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_4M = registerPortableCell("portable_quantum_omni_cell_4m",   2187,   -1,    4096);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_16M = registerPortableCell("portable_quantum_omni_cell_16m",  6561,   -1,   16384);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_64M = registerPortableCell("portable_quantum_omni_cell_64m", 19683,   -1,   65536);
    public static final DeferredItem<AEPortableUniversalCellItem> PORTABLE_QUANTUM_OMNI_CELL_256M = registerPortableCell("portable_quantum_omni_cell_256m", 59049,   -1,  262144);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

    // ---------- 只读访问 ----------
    public static List<DeferredItem<? extends Item>> getAllItems()
    {
        return Collections.unmodifiableList(ALL);
    }
    /** 非便携元件（存储盘本体） */
    public static List<DeferredItem<AEUniversalCellItem>> getCells()
    {
        return Collections.unmodifiableList(CELLS);
    }
    /** 便携元件（便携通用盘） */
    public static List<DeferredItem<AEPortableUniversalCellItem>> getPortableCells()
    {
        return Collections.unmodifiableList(PORTABLE_CELLS);
    }
    /** 其他物品（组件/外壳/锭/处理器/压印模板等） */
    public static List<DeferredItem<Item>> getOthers()
    {
        return Collections.unmodifiableList(OTHERS);
    }

    // ---------- 工具方法 ----------
    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> supplier)
    {
        DeferredItem<T> obj = ITEMS.register(name, () -> {
            T t = supplier.get();
            return t instanceof Item ? t : (T) new Item(new Item.Properties());
        });
        ALL.add(obj);
        return obj;
    }

    private static DeferredItem<Item> registerOtherItem(String name, Supplier<Item> sup)
    {
        DeferredItem<Item> obj = registerItem(name, () -> new Item(new Item.Properties()));
        OTHERS.add(obj);
        return obj;
    }

    // 组件统一归“其他物品”
    private static DeferredItem<Item> registerComponent(String name)
    {
        DeferredItem<Item> obj = registerOtherItem(name, () -> new Item(new Item.Properties()));
        return obj;
    }

    // 非便携：全能存储元件（= 元件）
    private static DeferredItem<AEUniversalCellItem> registerCell(
            String name, DeferredItem<Item> component, int idlePower, int types, int kilobytes)
    {
        DeferredItem<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.get(), OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        CELLS.add(obj);
        return obj;
    }
    private static DeferredItem<AEUniversalCellItem> registerCell(
            String name, ItemLike component, int idlePower, int types, int kilobytes)
    {
        DeferredItem<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.asItem(), OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        CELLS.add(obj);
        return obj;
    }

    // 非便携：复杂元件
    private static DeferredItem<AEUniversalCellItem> registerComplexCell(
            String name, DeferredItem<Item> component, int idlePower, int types, int kilobytes)
    {
        DeferredItem<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.get(), COMPLEX_OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        CELLS.add(obj);
        return obj;
    }

    // 非便携：量子元件
    private static DeferredItem<AEUniversalCellItem> registerQuantumCell(
            String name, DeferredItem<Item> component, int idlePower, int types, int kilobytes)
    {
        DeferredItem<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.get(), QUANTUM_OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        CELLS.add(obj);
        return obj;
    }

    // 便携元件注册（菜单类型统一使用 OCMenus.PORTABLE_UNIVERSAL_CELL_MENU）
    private static DeferredItem<AEPortableUniversalCellItem> registerPortableCell(
            String name, int idlePower, int types, int kilobytes)
    {
        DeferredItem<AEPortableUniversalCellItem> obj = ITEMS.register(name, () ->
                new AEPortableUniversalCellItem(
                        OCMenus.PORTABLE_UNIVERSAL_CELL_MENU,
                        new Item.Properties().stacksTo(1),
                        types, kilobytes, idlePower
                )
        );
        ALL.add(obj);
        PORTABLE_CELLS.add(obj);
        return obj;
    }
}
