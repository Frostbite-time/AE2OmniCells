package com.wintercogs.ae2omnicells.datagen;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.recipes.handlers.ChargerRecipeBuilder;
import appeng.recipes.handlers.InscriberProcessType;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import com.glodblock.github.extendedae.recipe.CircuitCutterRecipeBuilder;
import com.glodblock.github.extendedae.recipe.CrystalAssemblerRecipeBuilder;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.datagen.builder.CellDisassemblyRecipeBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.registries.DeferredItem;
import net.pedroksl.advanced_ae.recipes.ReactionChamberRecipeBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        // 末影钢锭
        InscriberRecipeBuilder.inscribe(Items.IRON_INGOT, OCItems.ENDER_INGOT.get(), 1)
                .setTop(Ingredient.of(AEItems.ENDER_DUST.asItem()))
                .setBottom(Ingredient.of(AEItems.CERTUS_QUARTZ_DUST))
                .setMode(InscriberProcessType.PRESS)
                .save(recipeOutput, AE2OmniCells.makeId("ender_ingot"));

        // 末影钢块 以及其拆解配方
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, OCItems.ENDER_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS, OCBlocks.ENDER_INGOT_BLOCK.get(),
                AE2OmniCells.makeId("ender_ingot_block_from_ingots").toString(), null,
                AE2OmniCells.makeId("ender_ingot_from_blocks").toString(), null);

        // 下界合金碎片块以及其拆解配方
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, Items.NETHERITE_SCRAP,
                RecipeCategory.BUILDING_BLOCKS, OCBlocks.NETHERITE_SCRAP_BLOCK.get(),
                AE2OmniCells.makeId("netherite_scrap_block_from_ingots").toString(), null,
                AE2OmniCells.makeId("netherite_scrap_from_blocks").toString(), null);

        // 奇点块以及其拆解配方
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, AEItems.SINGULARITY,
                RecipeCategory.BUILDING_BLOCKS, OCBlocks.SINGULARITY_BLOCK.get(),
                AE2OmniCells.makeId("singularity_block_from_ingots").toString(), null,
                AE2OmniCells.makeId("singularity_from_blocks").toString(), null);

        // 充能末影钢锭
        ChargerRecipeBuilder.charge(recipeOutput, AE2OmniCells.makeId("charged_ender_ingot"), OCItems.ENDER_INGOT.get(), OCItems.CHARGED_ENDER_INGOT.get());

        // 全能链路压印模板
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_LINK_PRINT_PRESS.get())
                .pattern("EAE")
                .pattern("DFB")
                .pattern("ECE")
                .define('A', AEItems.ENGINEERING_PROCESSOR_PRESS.asItem())
                .define('B', AEItems.LOGIC_PROCESSOR_PRESS.asItem())
                .define('C', AEItems.SILICON_PRESS.asItem())
                .define('D', AEItems.CALCULATION_PROCESSOR_PRESS.asItem())
                .define('E', OCItems.ENDER_INGOT.get())
                .define('F', OCItems.CHARGED_ENDER_INGOT.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .save(recipeOutput);
        InscriberRecipeBuilder.inscribe(OCBlocks.ENDER_INGOT_BLOCK.get(), OCItems.OMNI_LINK_PRINT_PRESS.get(), 1)
                .setTop(Ingredient.of(OCItems.OMNI_LINK_PRINT_PRESS.get()))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(recipeOutput, AE2OmniCells.makeId("inscriber/omni_link_print_press"));

        // 复杂链路压印模板
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_LINK_PRINT_PRESS.get())
                .pattern("EAE")
                .pattern("DFB")
                .pattern("ECE")
                .define('A', AEItems.ENGINEERING_PROCESSOR_PRESS.asItem())
                .define('B', AEItems.LOGIC_PROCESSOR_PRESS.asItem())
                .define('C', AEItems.SILICON_PRESS.asItem())
                .define('D', AEItems.CALCULATION_PROCESSOR_PRESS.asItem())
                .define('E', Items.NETHERITE_SCRAP)
                .define('F', OCItems.CHARGED_ENDER_INGOT.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .save(recipeOutput);
        InscriberRecipeBuilder.inscribe(OCBlocks.ENDER_INGOT_BLOCK.get(), OCItems.COMPLEX_LINK_PRINT_PRESS.get(), 1)
                .setTop(Ingredient.of(OCItems.COMPLEX_LINK_PRINT_PRESS.get()))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(recipeOutput, AE2OmniCells.makeId("inscriber/complex_link_print_press"));

        // 多维展开压印模板
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.MULTIDIMENSIONAL_EXPANSION_PRINT_PRESS.get())
                .pattern("EAE")
                .pattern("DFB")
                .pattern("ECE")
                .define('A', AEItems.ENGINEERING_PROCESSOR_PRESS.asItem())
                .define('B', AEItems.LOGIC_PROCESSOR_PRESS.asItem())
                .define('C', AEItems.SILICON_PRESS.asItem())
                .define('D', AEItems.CALCULATION_PROCESSOR_PRESS.asItem())
                .define('E', AEItems.SINGULARITY.asItem())
                .define('F', OCItems.CHARGED_ENDER_INGOT.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .save(recipeOutput);
        InscriberRecipeBuilder.inscribe(OCBlocks.ENDER_INGOT_BLOCK.get(), OCItems.MULTIDIMENSIONAL_EXPANSION_PRINT_PRESS.get(), 1)
                .setTop(Ingredient.of(OCItems.MULTIDIMENSIONAL_EXPANSION_PRINT_PRESS.get()))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(recipeOutput, AE2OmniCells.makeId("inscriber/multidimensional_expansion_print_press"));

        // 全能链路电路板
        InscriberRecipeBuilder.inscribe(OCItems.ENDER_INGOT.get(), OCItems.OMNI_LINK_CIRCUIT_PRINT.get(), 1)
                .setTop(Ingredient.of(OCItems.OMNI_LINK_PRINT_PRESS.get()))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(recipeOutput, AE2OmniCells.makeId("omni_link_circuit_print"));

        // 复杂链路电路板
        InscriberRecipeBuilder.inscribe(Items.NETHERITE_SCRAP, OCItems.COMPLEX_LINK_CIRCUIT_PRINT.get(), 1)
                .setTop(Ingredient.of(OCItems.COMPLEX_LINK_PRINT_PRESS.get()))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(recipeOutput, AE2OmniCells.makeId("complex_link_circuit_print"));

        // 多维展开电路板
        InscriberRecipeBuilder.inscribe(AEItems.SINGULARITY, OCItems.MULTIDIMENSIONAL_EXPANSION_CIRCUIT_PRINT.get(), 1)
                .setTop(Ingredient.of(OCItems.MULTIDIMENSIONAL_EXPANSION_PRINT_PRESS.get()))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(recipeOutput, AE2OmniCells.makeId("multidimensional_expansion_circuit_print"));

        // 全能链路处理器
        InscriberRecipeBuilder.inscribe(Items.REDSTONE, OCItems.OMNI_LINK_PROCESSOR.get(), 1)
                .setTop(Ingredient.of(OCItems.OMNI_LINK_CIRCUIT_PRINT.get()))
                .setBottom(Ingredient.of(AEItems.SILICON_PRINT.asItem()))
                .setMode(InscriberProcessType.PRESS)
                .save(recipeOutput, AE2OmniCells.makeId("omni_link_processor"));

        // 复杂链路处理器
        InscriberRecipeBuilder.inscribe(Items.REDSTONE, OCItems.COMPLEX_LINK_PROCESSOR.get(), 1)
                .setTop(Ingredient.of(OCItems.COMPLEX_LINK_CIRCUIT_PRINT.get()))
                .setBottom(Ingredient.of(AEItems.SILICON_PRINT.asItem()))
                .setMode(InscriberProcessType.PRESS)
                .save(recipeOutput, AE2OmniCells.makeId("complex_link_processor"));

        // 多维展开处理器
        InscriberRecipeBuilder.inscribe(Items.REDSTONE, OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get(), 1)
                .setTop(Ingredient.of(OCItems.MULTIDIMENSIONAL_EXPANSION_CIRCUIT_PRINT.get()))
                .setBottom(Ingredient.of(AEItems.SILICON_PRINT.asItem()))
                .setMode(InscriberProcessType.PRESS)
                .save(recipeOutput, AE2OmniCells.makeId("multidimensional_expansion_processor"));

        // 统一生成所有外壳、组件、元件配方
        buildAllByTiers(recipeOutput);

        // EAE联动配方---------------------------------------------------------------------------------------------------------

        // 电路切片
        CircuitCutterRecipeBuilder.cut(OCItems.OMNI_LINK_CIRCUIT_PRINT.get(), 9)
                .input(OCBlocks.ENDER_INGOT_BLOCK.get())
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("cutter/omni_link_circuit_print"));
        CircuitCutterRecipeBuilder.cut(OCItems.COMPLEX_LINK_CIRCUIT_PRINT.get(), 9)
                .input(OCBlocks.NETHERITE_SCRAP_BLOCK.get())
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("cutter/complex_link_circuit_print"));
        CircuitCutterRecipeBuilder.cut(OCItems.MULTIDIMENSIONAL_EXPANSION_CIRCUIT_PRINT.get(), 9)
                .input(OCBlocks.SINGULARITY_BLOCK.get())
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("cutter/multidimensional_expansion_circuit_print"));

        // 水晶装配
        CrystalAssemblerRecipeBuilder.assemble(OCItems.OMNI_LINK_PROCESSOR, 4)
                .input(OCItems.OMNI_LINK_CIRCUIT_PRINT, 4)
                .input(AEItems.SILICON_PRINT, 4)
                .input(Items.REDSTONE, 4)
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("assembler/omni_link_processor"));
        CrystalAssemblerRecipeBuilder.assemble(OCItems.COMPLEX_LINK_PROCESSOR, 4)
                .input(OCItems.COMPLEX_LINK_CIRCUIT_PRINT, 4)
                .input(AEItems.SILICON_PRINT, 4)
                .input(Items.REDSTONE, 4)
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("assembler/complex_link_processor"));
        CrystalAssemblerRecipeBuilder.assemble(OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR, 4)
                .input(OCItems.MULTIDIMENSIONAL_EXPANSION_CIRCUIT_PRINT, 4)
                .input(AEItems.SILICON_PRINT, 4)
                .input(Items.REDSTONE, 4)
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("assembler/multidimensional_expansion_processor"));

        // 水晶装配器 -> 末影钢
        CrystalAssemblerRecipeBuilder.assemble(OCItems.ENDER_INGOT, 4)
                .input(AEItems.ENDER_DUST, 4)
                .input(Items.IRON_INGOT, 4)
                .input(AEItems.CERTUS_QUARTZ_DUST, 4)
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.EAE_MODID)),
                        AE2OmniCells.makeId("assembler/ender_ingot"));

        // AAE联动配方 -----------------------------------------------------------------------------------------------
        // 反应仓 -> 末影钢 / 充能末影钢
        ReactionChamberRecipeBuilder.react(OCItems.ENDER_INGOT, 64, 500000)
                .input(AEItems.ENDER_DUST, 32)
                .input(Items.IRON_INGOT, 32)
                .input(AEItems.CERTUS_QUARTZ_DUST, 32)
                .fluid(Fluids.WATER, 500)
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.AAE_MODID)),
                        AE2OmniCells.makeId("reaction_chamber/ender_ingot"));
        ReactionChamberRecipeBuilder.react(OCItems.CHARGED_ENDER_INGOT, 64, 1300000)
                .input(OCItems.ENDER_INGOT, 64)
                .fluid(Fluids.WATER, 1000)
                .save(recipeOutput.withConditions(new ModLoadedCondition(AE2OmniCells.AAE_MODID)),
                        AE2OmniCells.makeId("reaction_chamber/charged_ender_ingot"));

    }

    // ---------- 统一ID工具 ----------
    private static ResourceLocation componentShapedId(DeferredItem<? extends Item> comp) {
        return AE2OmniCells.makeId("components/shaped/" + comp.getId().getPath());
    }
    private static ResourceLocation housingShapedId(DeferredItem<? extends Item> housing) {
        return AE2OmniCells.makeId("cells/housing/" + housing.getId().getPath());
    }
    private static ResourceLocation cellShapedId(DeferredItem<? extends Item> cell) {
        return AE2OmniCells.makeId("cells/shaped/" + cell.getId().getPath());
    }
    private static ResourceLocation cellShapelessId(DeferredItem<? extends Item> cell) {
        return AE2OmniCells.makeId("cells/shapeless/" + cell.getId().getPath());
    }
    private static ResourceLocation disassemblyId(String series, DeferredItem<? extends Item> idLike, boolean portable) {
        String base = (portable ? "disassembly/portable/" : "disassembly/") + series + "/" + idLike.getId().getPath();
        return AE2OmniCells.makeId(base);
    }

    // 这是什么系列的硬盘？
    private enum Series { OMNI, COMPLEX, QUANTUM }

    private record TierRow(
            DeferredItem<? extends Item> component,
            DeferredItem<? extends Item> cell,
            DeferredItem<? extends Item> portableCell
    ) {}

    // 系列材料描述
    private record SeriesMaterials(
            Series series,
            ItemLike housing,              // 对应外壳（非便携 & 便携）
            ItemLike materialC,            // 单元配方里的 C：OMNI=ender_ingot；COMPLEX/QUANTUM=charged_ender_ingot
            ItemLike cellProcessorD,       // 单元配方里的 D：OMNI=null；COMPLEX=complex_processor；QUANTUM=quantum_processor
            ItemLike componentProcessorP,  // 组件配方里使用的处理器（OMNI/COMPLEX/QUANTUM 各自不同）
            String componentGroupKey,      // 组件分组 key（REI/JEI）
            String seriesFolder            // 拆解路径段：omni/complex/quantum
    ) {}

    private void buildAllByTiers(RecipeOutput out)
    {
        // --------- 公共材料（A、B）---------
        ItemLike A_GLASS = AEBlocks.QUARTZ_GLASS.asItem();
        ItemLike B_ENDER_DUST = AEItems.ENDER_DUST.asItem();

        // --------- 三系材料定义 ---------
        SeriesMaterials OMNI_MATS = new SeriesMaterials(
                Series.OMNI,
                OCItems.OMNI_CELL_HOUSING.get(),
                OCItems.ENDER_INGOT.get(),
                null, // OMNI 单元不需要 D
                OCItems.OMNI_LINK_PROCESSOR.get(),
                "ae2omnicells:components/omni",
                "omni"
        );
        SeriesMaterials COMPLEX_MATS = new SeriesMaterials(
                Series.COMPLEX,
                OCItems.COMPLEX_OMNI_CELL_HOUSING.get(),
                OCItems.CHARGED_ENDER_INGOT.get(),
                OCItems.COMPLEX_LINK_PROCESSOR.get(),
                OCItems.COMPLEX_LINK_PROCESSOR.get(),
                "ae2omnicells:components/complex",
                "complex"
        );
        SeriesMaterials QUANTUM_MATS = new SeriesMaterials(
                Series.QUANTUM,
                OCItems.QUANTUM_OMNI_CELL_HOUSING.get(),
                OCItems.CHARGED_ENDER_INGOT.get(),
                OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get(),
                OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get(),
                "ae2omnicells:components/quantum",
                "quantum"
        );

        // --------- Tier 列表（按 1k→256m）---------
        TierRow[] OMNI_ROWS = new TierRow[]{
                new TierRow(OCItems.OMNI_CELL_COMPONENT_1K,  OCItems.OMNI_CELL_1K,  OCItems.PORTABLE_OMNI_CELL_1K),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_4K,  OCItems.OMNI_CELL_4K,  OCItems.PORTABLE_OMNI_CELL_4K),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_16K, OCItems.OMNI_CELL_16K, OCItems.PORTABLE_OMNI_CELL_16K),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_64K, OCItems.OMNI_CELL_64K, OCItems.PORTABLE_OMNI_CELL_64K),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_256K,OCItems.OMNI_CELL_256K,OCItems.PORTABLE_OMNI_CELL_256K),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_1M,  OCItems.OMNI_CELL_1M,  OCItems.PORTABLE_OMNI_CELL_1M),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_4M,  OCItems.OMNI_CELL_4M,  OCItems.PORTABLE_OMNI_CELL_4M),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_16M, OCItems.OMNI_CELL_16M, OCItems.PORTABLE_OMNI_CELL_16M),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_64M, OCItems.OMNI_CELL_64M, OCItems.PORTABLE_OMNI_CELL_64M),
                new TierRow(OCItems.OMNI_CELL_COMPONENT_256M,OCItems.OMNI_CELL_256M,OCItems.PORTABLE_OMNI_CELL_256M)
        };
        TierRow[] COMPLEX_ROWS = new TierRow[]{
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K,  OCItems.COMPLEX_OMNI_CELL_1K,  OCItems.PORTABLE_COMPLEX_OMNI_CELL_1K),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K,  OCItems.COMPLEX_OMNI_CELL_4K,  OCItems.PORTABLE_COMPLEX_OMNI_CELL_4K),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K, OCItems.COMPLEX_OMNI_CELL_16K, OCItems.PORTABLE_COMPLEX_OMNI_CELL_16K),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K, OCItems.COMPLEX_OMNI_CELL_64K, OCItems.PORTABLE_COMPLEX_OMNI_CELL_64K),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K,OCItems.COMPLEX_OMNI_CELL_256K,OCItems.PORTABLE_COMPLEX_OMNI_CELL_256K),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M,  OCItems.COMPLEX_OMNI_CELL_1M,  OCItems.PORTABLE_COMPLEX_OMNI_CELL_1M),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M,  OCItems.COMPLEX_OMNI_CELL_4M,  OCItems.PORTABLE_COMPLEX_OMNI_CELL_4M),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M, OCItems.COMPLEX_OMNI_CELL_16M, OCItems.PORTABLE_COMPLEX_OMNI_CELL_16M),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M, OCItems.COMPLEX_OMNI_CELL_64M, OCItems.PORTABLE_COMPLEX_OMNI_CELL_64M),
                new TierRow(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M,OCItems.COMPLEX_OMNI_CELL_256M,OCItems.PORTABLE_COMPLEX_OMNI_CELL_256M)
        };
        TierRow[] QUANTUM_ROWS = new TierRow[]{
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K,  OCItems.QUANTUM_OMNI_CELL_1K,  OCItems.PORTABLE_QUANTUM_OMNI_CELL_1K),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K,  OCItems.QUANTUM_OMNI_CELL_4K,  OCItems.PORTABLE_QUANTUM_OMNI_CELL_4K),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K, OCItems.QUANTUM_OMNI_CELL_16K, OCItems.PORTABLE_QUANTUM_OMNI_CELL_16K),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K, OCItems.QUANTUM_OMNI_CELL_64K, OCItems.PORTABLE_QUANTUM_OMNI_CELL_64K),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K,OCItems.QUANTUM_OMNI_CELL_256K,OCItems.PORTABLE_QUANTUM_OMNI_CELL_256K),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M,  OCItems.QUANTUM_OMNI_CELL_1M,  OCItems.PORTABLE_QUANTUM_OMNI_CELL_1M),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M,  OCItems.QUANTUM_OMNI_CELL_4M,  OCItems.PORTABLE_QUANTUM_OMNI_CELL_4M),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M, OCItems.QUANTUM_OMNI_CELL_16M, OCItems.PORTABLE_QUANTUM_OMNI_CELL_16M),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M, OCItems.QUANTUM_OMNI_CELL_64M, OCItems.PORTABLE_QUANTUM_OMNI_CELL_64M),
                new TierRow(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M,OCItems.QUANTUM_OMNI_CELL_256M,OCItems.PORTABLE_QUANTUM_OMNI_CELL_256M)
        };

        // --------- 外壳三条（ID 也统一到 cells/housing/...）---------
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OMNI_MATS.housing())
                .pattern("ABA").pattern("B B").pattern("CCC")
                .define('A', A_GLASS).define('B', B_ENDER_DUST).define('C', OCItems.ENDER_INGOT.get())
                .unlockedBy("has_ender_ingot", has(OCItems.ENDER_INGOT.get()))
                .group("ae2omnicells:cells/housing")
                .save(out, housingShapedId(OCItems.OMNI_CELL_HOUSING));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, COMPLEX_MATS.housing())
                .pattern("ABA").pattern("B B").pattern("CDC")
                .define('A', A_GLASS).define('B', B_ENDER_DUST)
                .define('C', OCItems.CHARGED_ENDER_INGOT.get()).define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .group("ae2omnicells:cells/housing")
                .save(out, housingShapedId(OCItems.COMPLEX_OMNI_CELL_HOUSING));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, QUANTUM_MATS.housing())
                .pattern("ABA").pattern("B B").pattern("CDC")
                .define('A', A_GLASS).define('B', B_ENDER_DUST)
                .define('C', OCItems.CHARGED_ENDER_INGOT.get()).define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .group("ae2omnicells:cells/housing")
                .save(out, housingShapedId(OCItems.QUANTUM_OMNI_CELL_HOUSING));

        // --------- 各系列：组件 + 单元（非便携/便携） + 拆解 ---------
        buildSeriesByRows(out, OMNI_MATS, OMNI_ROWS, A_GLASS, B_ENDER_DUST);
        buildSeriesByRows(out, COMPLEX_MATS, COMPLEX_ROWS, A_GLASS, B_ENDER_DUST);
        buildSeriesByRows(out, QUANTUM_MATS, QUANTUM_ROWS, A_GLASS, B_ENDER_DUST);
    }

    private void buildSeriesByRows(RecipeOutput out,
                                   SeriesMaterials mats,
                                   TierRow[] rows,
                                   ItemLike A_GLASS,
                                   ItemLike B_ENDER_DUST) {
        // 组件（1K 基础式 + 其余套娃）
        for (int i = 0; i < rows.length; i++) {
            var comp = rows[i].component().get();

            ShapedRecipeBuilder b = ShapedRecipeBuilder.shaped(RecipeCategory.MISC, comp)
                    .group(mats.componentGroupKey());

            if (i == 0) {
                // 基础式：各系不同
                switch (mats.series()) {
                    case OMNI -> {
                        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, comp)
                                .pattern("RPR")
                                .pattern("ECE")
                                .pattern("RER")
                                .define('R', Items.REDSTONE)
                                .define('P', mats.componentProcessorP())
                                .define('E', OCItems.ENDER_INGOT.get())
                                .define('C', AEItems.CELL_COMPONENT_1K.asItem())
                                .unlockedBy("has_ae_1k", has(AEItems.CELL_COMPONENT_1K.asItem()))
                                .group(mats.componentGroupKey())
                                .save(out, componentShapedId(rows[i].component()));
                        continue;
                    }
                    case COMPLEX -> {
                        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, comp)
                                .pattern("GPG")
                                .pattern("ECE")
                                .pattern("GEG")
                                .define('G', Items.GLOWSTONE_DUST)
                                .define('P', mats.componentProcessorP())
                                .define('E', OCItems.CHARGED_ENDER_INGOT.get())
                                .define('C', AEItems.CELL_COMPONENT_1K.asItem())
                                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                                .group(mats.componentGroupKey())
                                .save(out, componentShapedId(rows[i].component()));
                        continue;
                    }
                    case QUANTUM -> {
                        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, comp)
                                .pattern("NPN")
                                .pattern("ECE")
                                .pattern("NEN")
                                .define('N', AEItems.ENDER_DUST.asItem())
                                .define('P', mats.componentProcessorP())
                                .define('E', OCItems.CHARGED_ENDER_INGOT.get())
                                .define('C', AEItems.CELL_COMPONENT_1K.asItem())
                                .unlockedBy("has_quantum_processor", has(OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get()))
                                .group(mats.componentGroupKey())
                                .save(out, componentShapedId(rows[i].component()));
                        continue;
                    }
                }
            } else {
                // 套娃式：统一 U/Q 模板，材料依系列而不同只体现在 P（已经注入）
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, comp)
                        .pattern("RPR").pattern("UQU").pattern("RUR")
                        .define('R', Items.REDSTONE)
                        .define('P', mats.componentProcessorP())
                        .define('U', rows[i - 1].component().get())
                        .define('Q', A_GLASS)
                        .unlockedBy("has_prev_component", has(rows[i - 1].component().get()))
                        .group(mats.componentGroupKey())
                        .save(out, componentShapedId(rows[i].component()));
            }
        }

        // 单元（非便携：shaped + shapeless）
        for (TierRow row : rows) {
            var cell = row.cell().get();
            var comp = row.component().get();

            // shaped
            if (mats.series() == Series.OMNI) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, cell)
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', A_GLASS).define('B', B_ENDER_DUST)
                        .define('C', mats.materialC()).define('M', comp)
                        .unlockedBy("has_component", has(comp))
                        .save(out, cellShapedId(row.cell()));
            } else {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, cell)
                        .pattern("ABA").pattern("BMB").pattern("CDC")
                        .define('A', A_GLASS).define('B', B_ENDER_DUST)
                        .define('C', mats.materialC()).define('D', mats.cellProcessorD())
                        .define('M', comp)
                        .unlockedBy("has_component", has(comp))
                        .save(out, cellShapedId(row.cell()));
            }

            // shapeless
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, cell)
                    .requires(mats.housing())
                    .requires(comp)
                    .unlockedBy("has_component", has(comp))
                    .save(out, cellShapelessId(row.cell()));
        }

        // 便携（shapeless）
        for (TierRow row : rows) {
            var pCell = row.portableCell().get();
            var comp  = row.component().get();

            ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, pCell)
                    .requires(mats.housing())
                    .requires(comp)
                    .requires(AEBlocks.ME_CHEST.asItem())
                    .requires(AEBlocks.ENERGY_CELL.asItem())
                    .unlockedBy("has_component", has(comp))
                    .save(out, cellShapelessId(row.portableCell()));
        }

        // 拆解（非便携 & 便携）
        for (TierRow row : rows) {
            // 非便携
            CellDisassemblyRecipeBuilder.cell(row.cell().get())
                    .add(mats.housing())
                    .add(row.component().get())
                    .save(out, disassemblyId(mats.seriesFolder(), row.cell(), false));

            // 便携
            CellDisassemblyRecipeBuilder.cell(row.portableCell().get())
                    .add(mats.housing())
                    .add(row.component().get())
                    .add(AEBlocks.ME_CHEST.asItem())
                    .add(AEBlocks.ENERGY_CELL.asItem())
                    .save(out, disassemblyId(mats.seriesFolder(), row.portableCell(), true));
        }
    }

}
