package com.wintercogs.ae2omnicells.datagen;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.recipes.handlers.ChargerRecipeBuilder;
import appeng.recipes.handlers.InscriberProcessType;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import com.glodblock.github.extendedae.recipe.CircuitCutterRecipeBuilder;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.registries.DeferredItem;
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
                .setBottom(Ingredient.of(AEItems.CERTUS_QUARTZ_CRYSTAL))
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

        // 基础全能存储外壳
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_HOUSING.get())
                .pattern("ABA")
                .pattern("B B")
                .pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .unlockedBy("has_ender_ingot", has(OCItems.ENDER_INGOT.get()))
                .save(recipeOutput);

        // 复杂全能存储外壳
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .pattern("ABA")
                .pattern("B B")
                .pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .save(recipeOutput);

        // 量子全能存储外壳
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .pattern("ABA")
                .pattern("B B")
                .pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .save(recipeOutput);

        /* ============================================================
         * 普通全能组件（Omni Components）1K → 256M
         * - 不联动 MEGA，不使用 AE 原版组件
         * - 1K 为起点：R/E/Q 基底，无 U
         * - 4K+ 套娃：中心 P=全能处理器（自制），U=上一阶普通全能组件
         * - 1M 的 U= 自家 256K 组件（不再用 AE 256K）
         * ============================================================ */
        // 1K（起点：以 AE 1K 为核心，周围是末影钢 & 红石）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_1K.get())
                .pattern("RPR")
                .pattern("ECE")
                .pattern("RER")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('E', OCItems.ENDER_INGOT.get())
                .define('C', AEItems.CELL_COMPONENT_1K.asItem())
                .unlockedBy("has_ae_1k", has(AEItems.CELL_COMPONENT_1K.asItem()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/1k"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_4K.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_1K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/4k"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_16K.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_4K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/16k"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_64K.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_16K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/64k"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_256K.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_64K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/256k"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_1M.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_256K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/1m"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_4M.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_1M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/4m"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_16M.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_4M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/16m"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_64M.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_16M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/64m"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_256M.get())
                .pattern("RPR")
                .pattern("UQU")
                .pattern("RUR")
                .define('R', Items.REDSTONE)
                .define('P', OCItems.OMNI_LINK_PROCESSOR.get())
                .define('U', OCItems.OMNI_CELL_COMPONENT_64M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("omni_component/256m"));

        /* ============================================================
         * 复杂存储组件（Complex Components）1k → 256m
         * 1k：
         *  G P G
         *  E V E     (V = AE原版1k组件)
         *  G E G
         * 其余套娃：
         *  G P G
         *  U Q U     (U = 上一级复杂组件, Q = 石英玻璃)
         *  G U G
         * 其中 G=萤石粉，P=复杂处理器，E=充能末影钢
         * ============================================================ */
        // 复杂 1k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .pattern("GPG")
                .pattern("ECE")
                .pattern("GEG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('E', OCItems.CHARGED_ENDER_INGOT.get())
                .define('C', AEItems.CELL_COMPONENT_1K.asItem()) // 如版本名不同，请替换为实际常量
                .unlockedBy("has_charged_ender_ingot", has(OCItems.CHARGED_ENDER_INGOT.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/1k"));

        // 复杂 4k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/4k"));

        // 复杂 16k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/16k"));

        // 复杂 64k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/64k"));

        // 复杂 256k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/256k"));

        // 复杂 1M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/1m"));

        // 复杂 4M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/4m"));

        // 复杂 16M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/16m"));

        // 复杂 64M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/64m"));

        // 复杂 256M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get())
                .pattern("GPG")
                .pattern("UQU")
                .pattern("GUG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('P', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('U', OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_complex_component", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("complex_component/256m"));

        /* ============================================================
         * 量子存储组件（Quantum Components）1k → 256m
         * 1k：在复杂1k基础上把 G(萤石粉) → N(末影粉)，P(复杂处理器) → QP(量子处理器)
         * 套娃同理：G → N；U 为本系上一级量子组件
         * N = AE的 Ender Dust，QP = 多维展开处理器
         * ============================================================ */

        // 量子 1k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .pattern("NQN")
                .pattern("ECE")
                .pattern("NEN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('Q', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('E', OCItems.CHARGED_ENDER_INGOT.get())
                .define('C', AEItems.CELL_COMPONENT_1K.asItem()) // 如版本名不同，请替换为实际常量
                .unlockedBy("has_quantum_processor", has(OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/1k"));

        // 量子 4k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/4k"));

        // 量子 16k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/16k"));

        // 量子 64k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/64k"));

        // 量子 256k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/256k"));

        // 量子 1M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/1m"));

        // 量子 4M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/4m"));

        // 量子 16M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/16m"));

        // 量子 64M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/64m"));

        // 量子 256M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get())
                .pattern("NPN")
                .pattern("UQU")
                .pattern("NUN")
                .define('N', AEItems.ENDER_DUST.asItem())
                .define('P', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('U', OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                .unlockedBy("has_prev_quantum_component", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("quantum_component/256m"));


        // ============================================================
        // 存储单元（OMNI / COMPLEX / QUANTUM）1k → 256M
        // 统一ID规范：
        // - Shaped  : cells/shaped/<物品id路径>
        // - Shapeless: cells/shapeless/<物品id路径>
        // ============================================================
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_1K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_component_1k", has(OCItems.OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_1K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_1K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_component_1k", has(OCItems.OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_1K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_4K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_component_4k", has(OCItems.OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_4K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_4K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_component_4k", has(OCItems.OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_4K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_16K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_component_16k", has(OCItems.OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_16K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_16K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_component_16k", has(OCItems.OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_16K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_64K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_component_64k", has(OCItems.OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_64K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_64K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_component_64k", has(OCItems.OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_64K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_256K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_component_256k", has(OCItems.OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_256K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_256K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_component_256k", has(OCItems.OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_256K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_1M.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_component_1m", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_1M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_1M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_component_1m", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_1M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_4M.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_component_4m", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_4M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_4M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_component_4m", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_4M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_16M.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_component_16m", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_16M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_16M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_component_16m", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_16M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_64M.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_component_64m", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_64M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_64M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_component_64m", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_64M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_256M.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', OCItems.OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_component_256m", has(OCItems.OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapedId(OCItems.OMNI_CELL_256M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_256M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_component_256m", has(OCItems.OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.OMNI_CELL_256M));


        // -------------------------
        // 复杂系列（COMPLEX） – 外壳形状： "ABA" / "BMB" / "CDC"
        // A: 石英玻璃, B: 末影粉, C: 充能末影钢, D: 复杂处理器
        // -------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_complex_component_1k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_1K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_complex_component_1k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_1K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_complex_component_4k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_4K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_complex_component_4k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_4K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_complex_component_16k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_16K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_complex_component_16k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_16K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_complex_component_64k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_64K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_complex_component_64k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_64K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_complex_component_256k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_256K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_complex_component_256k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_256K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_complex_component_1m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_1M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_complex_component_1m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_1M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_complex_component_4m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_4M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_complex_component_4m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_4M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_complex_component_16m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_16M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_complex_component_16m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_16M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_complex_component_64m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_64M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_complex_component_64m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_64M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_complex_component_256m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapedId(OCItems.COMPLEX_OMNI_CELL_256M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_complex_component_256m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.COMPLEX_OMNI_CELL_256M));

        // -------------------------
        // 量子系列（QUANTUM） – 外壳形状： "ABA" / "BMB" / "CDC"
        // A: 石英玻璃, B: 末影粉, C: 充能末影钢, D: 多维展开处理器
        // -------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_quantum_component_1k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_1K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_quantum_component_1k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_1K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_quantum_component_4k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_4K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_quantum_component_4k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_4K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_quantum_component_16k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_16K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_quantum_component_16k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_16K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_quantum_component_64k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_64K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_quantum_component_64k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_64K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_quantum_component_256k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_256K));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_quantum_component_256k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_256K));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_quantum_component_1m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_1M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_quantum_component_1m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_1M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_quantum_component_4m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_4M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_quantum_component_4m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_4M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_quantum_component_16m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_16M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_quantum_component_16m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_16M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_quantum_component_64m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_64M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_quantum_component_64m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_64M));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_quantum_component_256m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapedId(OCItems.QUANTUM_OMNI_CELL_256M));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_quantum_component_256m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.QUANTUM_OMNI_CELL_256M));


        // =====================
        // 便携 · 普通（OMNI）
        // =====================
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_1K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_1K)
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_1k", has(OCItems.OMNI_CELL_COMPONENT_1K))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_1K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_4K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_4K)
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_4k", has(OCItems.OMNI_CELL_COMPONENT_4K))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_4K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_16K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_16K)
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_16k", has(OCItems.OMNI_CELL_COMPONENT_16K))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_16K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_64K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_64K)
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_64k", has(OCItems.OMNI_CELL_COMPONENT_64K))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_64K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_256K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_256K)
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_256k", has(OCItems.OMNI_CELL_COMPONENT_256K))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_256K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_1M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_1M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_1m", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_1M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_4M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_4M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_4m", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_4M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_16M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_16M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_16m", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_16M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_64M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_64M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_64m", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_64M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_OMNI_CELL_256M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_256M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_component_256m", has(OCItems.OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_OMNI_CELL_256M));

        // =====================
        // 便携 · 复杂（COMPLEX） 1k~256M：复杂外壳 + 复杂组件
        // =====================
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_1K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_1k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_1K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_4K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_4k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_4K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_16K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_16k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_16K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_64K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_64k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_64K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_256K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_256k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_256K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_1M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_1m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_1M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_4M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_4m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_4M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_16M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_16m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_16M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_64M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_64m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_64M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_COMPLEX_OMNI_CELL_256M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_complex_component_256m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_COMPLEX_OMNI_CELL_256M));

        // =====================
        // 便携 · 量子（QUANTUM） 1k~256M：量子外壳 + 量子组件
        // =====================
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_1K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_1k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_1K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_4K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_4k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_4K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_16K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_16k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_16K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_64K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_64k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_64K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_256K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_256k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_256K));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_1M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_1m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_1M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_4M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_4m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_4M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_16M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_16m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_16M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_64M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_64m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_64M));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, OCItems.PORTABLE_QUANTUM_OMNI_CELL_256M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get())
                .requires(AEBlocks.ME_CHEST.asItem())
                .requires(AEBlocks.ENERGY_CELL.asItem())
                .unlockedBy("has_quantum_component_256m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, cellShapelessId(OCItems.PORTABLE_QUANTUM_OMNI_CELL_256M));

        // EAE联动配方---------------------------------------------------------------------------------------------------------
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

    }

    // 统一生成“存储单元”配方 ID（非便携）
    private static ResourceLocation cellShapedId(DeferredItem<? extends Item> cell)
    {
        return AE2OmniCells.makeId("cells/shaped/" + cell.getId().getPath());
    }
    private static ResourceLocation cellShapelessId(DeferredItem<? extends Item> cell)
    {
        return AE2OmniCells.makeId("cells/shapeless/" + cell.getId().getPath());
    }

}
