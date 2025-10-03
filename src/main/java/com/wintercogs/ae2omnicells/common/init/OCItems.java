package com.wintercogs.ae2omnicells.common.init;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class OCItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AE2OmniCells.MODID);

    /** 全部注册过的物品（便于 datagen/创造模式菜单） */
    private static final List<RegistryObject<? extends Item>> ALL = new ArrayList<>();
    /** 普通：仅组件 */
    private static final List<RegistryObject<Item>> COMPONENTS = new ArrayList<>();
    /** 普通：仅单元 */
    private static final List<RegistryObject<AEUniversalCellItem>> CELLS = new ArrayList<>();

    /** 复杂：仅组件 */
    private static final List<RegistryObject<Item>> COMPLEX_COMPONENTS = new ArrayList<>();
    /** 复杂：仅单元 */
    private static final List<RegistryObject<AEUniversalCellItem>> COMPLEX_CELLS = new ArrayList<>();

    /** 量子：仅组件 */
    private static final List<RegistryObject<Item>> QUANTUM_COMPONENTS = new ArrayList<>();
    /** 量子：仅单元 */
    private static final List<RegistryObject<AEUniversalCellItem>> QUANTUM_CELLS = new ArrayList<>();

    // 全能元件外壳
    public static final RegistryObject<Item> OMNI_CELL_HOUSING = registerItem("omni_cell_housing", () -> new Item(new Item.Properties()));

    // 普通存储组件
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_1K   = registerComponent("omni_cell_component_1k");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_4K   = registerComponent("omni_cell_component_4k");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_16K  = registerComponent("omni_cell_component_16k");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_64K  = registerComponent("omni_cell_component_64k");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_256K = registerComponent("omni_cell_component_256k");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_1M   = registerComponent("omni_cell_component_1m");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_4M   = registerComponent("omni_cell_component_4m");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_16M  = registerComponent("omni_cell_component_16m");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_64M  = registerComponent("omni_cell_component_64m");
    public static final RegistryObject<Item> OMNI_CELL_COMPONENT_256M = registerComponent("omni_cell_component_256m");

    // 普通存储元件（类型数固定 63，能耗 1→10，容量按 kB）
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_1K    = registerCell("omni_cell_1k",    OMNI_CELL_COMPONENT_1K,   1, 63, 1);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_4K    = registerCell("omni_cell_4k",    OMNI_CELL_COMPONENT_4K,   2, 63, 4);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_16K   = registerCell("omni_cell_16k",   OMNI_CELL_COMPONENT_16K,  3, 63, 16);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_64K   = registerCell("omni_cell_64k",   OMNI_CELL_COMPONENT_64K,  4, 63, 64);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_256K  = registerCell("omni_cell_256k",  OMNI_CELL_COMPONENT_256K, 5, 63, 256);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_1M    = registerCell("omni_cell_1m",    OMNI_CELL_COMPONENT_1M,   6, 63, 1024);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_4M    = registerCell("omni_cell_4m",    OMNI_CELL_COMPONENT_4M,   7, 63, 4096);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_16M   = registerCell("omni_cell_16m",   OMNI_CELL_COMPONENT_16M,  8, 63, 16384);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_64M   = registerCell("omni_cell_64m",   OMNI_CELL_COMPONENT_64M,  9, 63, 65536);
    public static final RegistryObject<AEUniversalCellItem> OMNI_CELL_256M  = registerCell("omni_cell_256m",  OMNI_CELL_COMPONENT_256M, 10, 63, 262144);

    // 复杂存储组件
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_1K   = registerComplexComponent("complex_omni_cell_component_1k");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_4K   = registerComplexComponent("complex_omni_cell_component_4k");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_16K  = registerComplexComponent("complex_omni_cell_component_16k");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_64K  = registerComplexComponent("complex_omni_cell_component_64k");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_256K = registerComplexComponent("complex_omni_cell_component_256k");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_1M   = registerComplexComponent("complex_omni_cell_component_1m");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_4M   = registerComplexComponent("complex_omni_cell_component_4m");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_16M  = registerComplexComponent("complex_omni_cell_component_16m");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_64M  = registerComplexComponent("complex_omni_cell_component_64m");
    public static final RegistryObject<Item> COMPLEX_OMNI_CELL_COMPONENT_256M = registerComplexComponent("complex_omni_cell_component_256m");

    // 复杂存储元件（能耗等比×2 至 1024；类型数等比到 6400）
    // 类型数序列：12, 25, 50, 100, 200, 400, 800, 1600, 3200, 6400
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_1K    = registerComplexCell("complex_omni_cell_1k",    COMPLEX_OMNI_CELL_COMPONENT_1K,    2,    12,     1);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_4K    = registerComplexCell("complex_omni_cell_4k",    COMPLEX_OMNI_CELL_COMPONENT_4K,    4,    25,     4);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_16K   = registerComplexCell("complex_omni_cell_16k",   COMPLEX_OMNI_CELL_COMPONENT_16K,   8,    50,    16);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_64K   = registerComplexCell("complex_omni_cell_64k",   COMPLEX_OMNI_CELL_COMPONENT_64K,  16,   100,    64);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_256K  = registerComplexCell("complex_omni_cell_256k",  COMPLEX_OMNI_CELL_COMPONENT_256K, 32,   200,   256);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_1M    = registerComplexCell("complex_omni_cell_1m",    COMPLEX_OMNI_CELL_COMPONENT_1M,   64,   400,  1024);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_4M    = registerComplexCell("complex_omni_cell_4m",    COMPLEX_OMNI_CELL_COMPONENT_4M,  128,   800,  4096);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_16M   = registerComplexCell("complex_omni_cell_16m",   COMPLEX_OMNI_CELL_COMPONENT_16M, 256,  1600, 16384);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_64M   = registerComplexCell("complex_omni_cell_64m",   COMPLEX_OMNI_CELL_COMPONENT_64M, 512,  3200, 65536);
    public static final RegistryObject<AEUniversalCellItem> COMPLEX_OMNI_CELL_256M  = registerComplexCell("complex_omni_cell_256m",  COMPLEX_OMNI_CELL_COMPONENT_256M,1024,  6400,262144);

    // ===================== 量子存储（quantum_ 前缀） =====================
    // 量子存储组件
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_1K   = registerQuantumComponent("quantum_omni_cell_component_1k");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_4K   = registerQuantumComponent("quantum_omni_cell_component_4k");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_16K  = registerQuantumComponent("quantum_omni_cell_component_16k");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_64K  = registerQuantumComponent("quantum_omni_cell_component_64k");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_256K = registerQuantumComponent("quantum_omni_cell_component_256k");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_1M   = registerQuantumComponent("quantum_omni_cell_component_1m");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_4M   = registerQuantumComponent("quantum_omni_cell_component_4m");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_16M  = registerQuantumComponent("quantum_omni_cell_component_16m");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_64M  = registerQuantumComponent("quantum_omni_cell_component_64m");
    public static final RegistryObject<Item> QUANTUM_OMNI_CELL_COMPONENT_256M = registerQuantumComponent("quantum_omni_cell_component_256m");

    // 量子存储元件（能耗从3起每档×3；类型数恒为-1；容量(kB)与常规一致）
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_1K    = registerQuantumCell("quantum_omni_cell_1k",    QUANTUM_OMNI_CELL_COMPONENT_1K,     3,   -1,       1);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_4K    = registerQuantumCell("quantum_omni_cell_4k",    QUANTUM_OMNI_CELL_COMPONENT_4K,     9,   -1,       4);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_16K   = registerQuantumCell("quantum_omni_cell_16k",   QUANTUM_OMNI_CELL_COMPONENT_16K,   27,   -1,      16);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_64K   = registerQuantumCell("quantum_omni_cell_64k",   QUANTUM_OMNI_CELL_COMPONENT_64K,   81,   -1,      64);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_256K  = registerQuantumCell("quantum_omni_cell_256k",  QUANTUM_OMNI_CELL_COMPONENT_256K, 243,   -1,     256);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_1M    = registerQuantumCell("quantum_omni_cell_1m",    QUANTUM_OMNI_CELL_COMPONENT_1M,   729,   -1,    1024);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_4M    = registerQuantumCell("quantum_omni_cell_4m",    QUANTUM_OMNI_CELL_COMPONENT_4M,  2187,   -1,    4096);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_16M   = registerQuantumCell("quantum_omni_cell_16m",   QUANTUM_OMNI_CELL_COMPONENT_16M, 6561,   -1,   16384);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_64M   = registerQuantumCell("quantum_omni_cell_64m",   QUANTUM_OMNI_CELL_COMPONENT_64M,19683,   -1,   65536);
    public static final RegistryObject<AEUniversalCellItem> QUANTUM_OMNI_CELL_256M  = registerQuantumCell("quantum_omni_cell_256m",  QUANTUM_OMNI_CELL_COMPONENT_256M,59049,  -1,  262144);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // ---------- 提供只读访问 ----------
    public static List<RegistryObject<? extends Item>> getAllItems() {
        return Collections.unmodifiableList(ALL);
    }
    public static List<RegistryObject<Item>> getComponents() { return Collections.unmodifiableList(COMPONENTS); }
    public static List<RegistryObject<AEUniversalCellItem>> getCells() { return Collections.unmodifiableList(CELLS); }
    public static List<RegistryObject<Item>> getComplexComponents() { return Collections.unmodifiableList(COMPLEX_COMPONENTS); }
    public static List<RegistryObject<AEUniversalCellItem>> getComplexCells() { return Collections.unmodifiableList(COMPLEX_CELLS); }
    public static List<RegistryObject<Item>> getQuantumComponents() { return Collections.unmodifiableList(QUANTUM_COMPONENTS); }
    public static List<RegistryObject<AEUniversalCellItem>> getQuantumCells() { return Collections.unmodifiableList(QUANTUM_CELLS); }

    // ---------- 工具方法 ----------
    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> supplier) {
        RegistryObject<T> obj = ITEMS.register(name, supplier);
        ALL.add(obj);
        return obj;
    }

    private static RegistryObject<Item> registerComponent(String name) {
        RegistryObject<Item> obj = registerItem(name, () -> new Item(new Item.Properties()));
        COMPONENTS.add(obj);
        return obj;
    }

    private static RegistryObject<AEUniversalCellItem> registerCell(
            String name, RegistryObject<Item> component, int idlePower, int types, int kilobytes) {
        RegistryObject<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.get(), OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        CELLS.add(obj);
        return obj;
    }

    private static RegistryObject<Item> registerComplexComponent(String name) {
        RegistryObject<Item> obj = registerItem(name, () -> new Item(new Item.Properties()));
        COMPLEX_COMPONENTS.add(obj);
        return obj;
    }

    private static RegistryObject<AEUniversalCellItem> registerComplexCell(
            String name, RegistryObject<Item> component, int idlePower, int types, int kilobytes) {
        RegistryObject<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.get(), OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        COMPLEX_CELLS.add(obj);
        return obj;
    }

    // 量子：注册存储组件（加入 QUANTUM_COMPONENTS）
    private static RegistryObject<Item> registerQuantumComponent(String name) {
        RegistryObject<Item> obj = registerItem(name, () -> new Item(new Item.Properties()));
        QUANTUM_COMPONENTS.add(obj);
        return obj;
    }

    // 量子：注册存储元件（加入 QUANTUM_CELLS）
    private static RegistryObject<AEUniversalCellItem> registerQuantumCell(
            String name, RegistryObject<Item> component, int idlePower, int types, int kilobytes) {
        RegistryObject<AEUniversalCellItem> obj = registerItem(name,
                () -> new AEUniversalCellItem(new Item.Properties().stacksTo(1),
                        component.get(), OMNI_CELL_HOUSING.get(),
                        idlePower, types, kilobytes));
        QUANTUM_CELLS.add(obj);
        return obj;
    }
}