package com.wintercogs.ae2omnicells.datagen;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.recipes.handlers.ChargerRecipeBuilder;
import appeng.recipes.handlers.InscriberProcessType;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import gripe._90.megacells.definition.MEGAItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{

    public ModRecipeProvider(PackOutput output)
    {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeOutput)
    {
        // 末影钢锭
        InscriberRecipeBuilder.inscribe(Items.IRON_INGOT, OCItems.ENDER_INGOT.get(), 1)
                .setTop(Ingredient.of(AEItems.ENDER_DUST.asItem()))
                .setBottom(Ingredient.of(AEItems.CERTUS_QUARTZ_CRYSTAL))
                .setMode(InscriberProcessType.PRESS)
                .save(recipeOutput, AE2OmniCells.makeId("ender_ingot"));

        // 充能末影钢锭
        ChargerRecipeBuilder.charge(recipeOutput, AE2OmniCells.makeId("charged_ender_ingot"), OCItems.ENDER_INGOT.get(), OCItems.CHARGED_ENDER_INGOT.get());

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
         * 全能存储组件（Omni Components）1M → 256M
         * 1M：
         *  R E R
         *  U Q U   (U = AE 原版 256k 组件，Q = 石英玻璃，E = 末影钢锭，R = 红石粉)
         *  R U R
         * 后续套娃（中心 E→工程处理器，U=上一级“普通组件”）
         *  R P R
         *  U Q U
         *  R U R
         * 仅在 MEGA 未加载时启用配方。
         * ============================================================ */
        // 1M（中心：末影钢锭；U=AE 256k 组件）
        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_1M.get())
                        .pattern("RER")
                        .pattern("UQU")
                        .pattern("RUR")
                        .define('R', Items.REDSTONE)
                        .define('E', OCItems.ENDER_INGOT.get())
                        .define('U', AEItems.CELL_COMPONENT_256K.asItem())
                        .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                        .unlockedBy("has_prev_component", has(AEItems.CELL_COMPONENT_256K.asItem()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("omni_component/1m"));

        // 4M（中心：工程处理器；U=上一级普通组件 1M）
        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_4M.get())
                        .pattern("RPR")
                        .pattern("UQU")
                        .pattern("RUR")
                        .define('R', Items.REDSTONE)
                        .define('P', AEItems.ENGINEERING_PROCESSOR)
                        .define('U', OCItems.OMNI_CELL_COMPONENT_1M.get())
                        .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                        .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("omni_component/4m"));

        // 16M（中心：工程处理器；U=上一级普通组件 4M）
        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_16M.get())
                        .pattern("RPR")
                        .pattern("UQU")
                        .pattern("RUR")
                        .define('R', Items.REDSTONE)
                        .define('P', AEItems.ENGINEERING_PROCESSOR)
                        .define('U', OCItems.OMNI_CELL_COMPONENT_4M.get())
                        .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                        .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("omni_component/16m"));

        // 64M（中心：工程处理器；U=上一级普通组件 16M）
        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_64M.get())
                        .pattern("RPR")
                        .pattern("UQU")
                        .pattern("RUR")
                        .define('R', Items.REDSTONE)
                        .define('P', AEItems.ENGINEERING_PROCESSOR)
                        .define('U', OCItems.OMNI_CELL_COMPONENT_16M.get())
                        .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                        .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("omni_component/64m"));

        // 256M（中心：工程处理器；U=上一级普通组件 64M）
        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_COMPONENT_256M.get())
                        .pattern("RPR")
                        .pattern("UQU")
                        .pattern("RUR")
                        .define('R', Items.REDSTONE)
                        .define('P', AEItems.ENGINEERING_PROCESSOR)
                        .define('U', OCItems.OMNI_CELL_COMPONENT_64M.get())
                        .define('Q', AEBlocks.QUARTZ_GLASS.asItem())
                        .unlockedBy("has_prev_component", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("omni_component/256m"));

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
        // 存储元件（OMNI / COMPLEX / QUANTUM）1k → 256m
        // 两套配方：有序(Shaped) + 无序(Shapeless)
        // ============================================================

        // -------------------------
        // 普通系列（OMNI） – 外壳形状：
        //  "ABA"
        //  "B B" -> 中央填入 'M'（对应组件）
        //  "CCC"
        // A: 石英玻璃, B: 末影粉, C: 末影钢锭
        // -------------------------

        // 1k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_1K.get())
                .pattern("ABA")
                .pattern("BMB")
                .pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', AEItems.CELL_COMPONENT_1K)
                .unlockedBy("has_component_1k", has(AEItems.CELL_COMPONENT_1K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/1k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_1K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(AEItems.CELL_COMPONENT_1K)
                .unlockedBy("has_component_1k", has(AEItems.CELL_COMPONENT_1K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/1k_shapeless"));

        // 4k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_4K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', AEItems.CELL_COMPONENT_4K)
                .unlockedBy("has_component_4k", has(AEItems.CELL_COMPONENT_4K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/4k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_4K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(AEItems.CELL_COMPONENT_4K)
                .unlockedBy("has_component_4k", has(AEItems.CELL_COMPONENT_4K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/4k_shapeless"));

        // 16k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_16K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', AEItems.CELL_COMPONENT_16K)
                .unlockedBy("has_component_16k", has(AEItems.CELL_COMPONENT_16K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/16k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_16K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(AEItems.CELL_COMPONENT_16K)
                .unlockedBy("has_component_16k", has(AEItems.CELL_COMPONENT_16K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/16k_shapeless"));

        // 64k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_64K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', AEItems.CELL_COMPONENT_64K)
                .unlockedBy("has_component_64k", has(AEItems.CELL_COMPONENT_64K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/64k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_64K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(AEItems.CELL_COMPONENT_64K)
                .unlockedBy("has_component_64k", has(AEItems.CELL_COMPONENT_64K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/64k_shapeless"));

        // 256k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_256K.get())
                .pattern("ABA").pattern("BMB").pattern("CCC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.ENDER_INGOT.get())
                .define('M', AEItems.CELL_COMPONENT_256K)
                .unlockedBy("has_component_256k", has(AEItems.CELL_COMPONENT_256K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/256k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_256K.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(AEItems.CELL_COMPONENT_256K)
                .unlockedBy("has_component_256k", has(AEItems.CELL_COMPONENT_256K))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/256k_shapeless"));

        // ============ 1M ============
        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID)) // mega 已加载 → 用 mega 组件
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_1M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', MEGAItems.CELL_COMPONENT_1M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/1m_ordered_mega"));

        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID))) // mega 未加载 → 用自家组件
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_1M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', OCItems.OMNI_CELL_COMPONENT_1M.get())
                        .unlockedBy("has_component_1m", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/1m_ordered_fallback"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_1M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_component_1m", has(OCItems.OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/1m_shapeless"));

        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_1M.get())
                        .requires(OCItems.OMNI_CELL_HOUSING.get())
                        .requires(MEGAItems.CELL_COMPONENT_1M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/1m_shapeless_mega"));


        // ============ 4M ============
        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_4M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', MEGAItems.CELL_COMPONENT_4M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/4m_ordered_mega"));

        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_4M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', OCItems.OMNI_CELL_COMPONENT_4M.get())
                        .unlockedBy("has_component_4m", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/4m_ordered_fallback"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_4M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_component_4m", has(OCItems.OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/4m_shapeless"));

        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_4M.get())
                        .requires(OCItems.OMNI_CELL_HOUSING.get())
                        .requires(MEGAItems.CELL_COMPONENT_4M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/4m_shapeless_mega"));


        // ============ 16M ============
        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_16M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', MEGAItems.CELL_COMPONENT_16M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/16m_ordered_mega"));

        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_16M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', OCItems.OMNI_CELL_COMPONENT_16M.get())
                        .unlockedBy("has_component_16m", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/16m_ordered_fallback"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_16M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_component_16m", has(OCItems.OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/16m_shapeless"));

        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_16M.get())
                        .requires(OCItems.OMNI_CELL_HOUSING.get())
                        .requires(MEGAItems.CELL_COMPONENT_16M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/16m_shapeless_mega"));


        // ============ 64M ============
        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_64M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', MEGAItems.CELL_COMPONENT_64M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/64m_ordered_mega"));

        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_64M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', OCItems.OMNI_CELL_COMPONENT_64M.get())
                        .unlockedBy("has_component_64m", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/64m_ordered_fallback"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_64M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_component_64m", has(OCItems.OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/64m_shapeless"));

        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_64M.get())
                        .requires(OCItems.OMNI_CELL_HOUSING.get())
                        .requires(MEGAItems.CELL_COMPONENT_64M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/64m_shapeless_mega"));


        // ============ 256M ============
        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_256M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', MEGAItems.CELL_COMPONENT_256M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/256m_ordered_mega"));

        ConditionalRecipe.builder()
                .addCondition(not(modLoaded(AE2OmniCells.MEGA_MODID)))
                .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.OMNI_CELL_256M.get())
                        .pattern("ABA").pattern("BMB").pattern("CCC")
                        .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                        .define('B', AEItems.ENDER_DUST.asItem())
                        .define('C', OCItems.ENDER_INGOT.get())
                        .define('M', OCItems.OMNI_CELL_COMPONENT_256M.get())
                        .unlockedBy("has_component_256m", has(OCItems.OMNI_CELL_COMPONENT_256M.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/256m_ordered_fallback"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_256M.get())
                .requires(OCItems.OMNI_CELL_HOUSING.get())
                .requires(OCItems.OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_component_256m", has(OCItems.OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/omni/256m_shapeless"));

        ConditionalRecipe.builder()
                .addCondition(modLoaded(AE2OmniCells.MEGA_MODID))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.OMNI_CELL_256M.get())
                        .requires(OCItems.OMNI_CELL_HOUSING.get())
                        .requires(MEGAItems.CELL_COMPONENT_256M.asItem())
                        .unlockedBy("has_housing", has(OCItems.OMNI_CELL_HOUSING.get()))
                        .save(c))
                .build(recipeOutput, AE2OmniCells.makeId("cells/omni/256m_shapeless_mega"));


        // -------------------------
        // 复杂系列（COMPLEX） – 外壳形状：
        //  "ABA"
        //  "B B" -> 中央填 'M'
        //  "CDC"
        // A: 石英玻璃, B: 末影粉, C: 充能末影钢, D: 复杂处理器
        // -------------------------

        // 1k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1K.get())
                .pattern("ABA")
                .pattern("BMB")
                .pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_complex_component_1k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/1k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_complex_component_1k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/1k_shapeless"));

        // 4k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_complex_component_4k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/4k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_complex_component_4k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/4k_shapeless"));

        // 16k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_complex_component_16k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/16k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_complex_component_16k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/16k_shapeless"));

        // 64k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_complex_component_64k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/64k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_complex_component_64k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/64k_shapeless"));

        // 256k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_complex_component_256k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/256k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256K.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_complex_component_256k", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/256k_shapeless"));

        // 1M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_complex_component_1m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/1m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_1M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_complex_component_1m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/1m_shapeless"));

        // 4M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_complex_component_4m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/4m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_4M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_complex_component_4m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/4m_shapeless"));

        // 16M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_complex_component_16m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/16m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_16M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_complex_component_16m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/16m_shapeless"));

        // 64M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_complex_component_64m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/64m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_64M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_complex_component_64m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/64m_shapeless"));

        // 256M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.COMPLEX_LINK_PROCESSOR.get())
                .define('M', OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_complex_component_256m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/256m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.COMPLEX_OMNI_CELL_256M.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_HOUSING.get())
                .requires(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_complex_component_256m", has(OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/complex/256m_shapeless"));


        // -------------------------
        // 量子系列（QUANTUM） – 外壳形状：
        //  "ABA"
        //  "B B" -> 中央填 'M'
        //  "CDC"
        // A: 石英玻璃, B: 末影粉, C: 充能末影钢, D: 多维展开处理器
        // -------------------------

        // 1k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1K.get())
                .pattern("ABA")
                .pattern("BMB")
                .pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_quantum_component_1k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/1k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get())
                .unlockedBy("has_quantum_component_1k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/1k_shapeless"));

        // 4k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_quantum_component_4k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/4k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get())
                .unlockedBy("has_quantum_component_4k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/4k_shapeless"));

        // 16k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_quantum_component_16k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/16k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get())
                .unlockedBy("has_quantum_component_16k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/16k_shapeless"));

        // 64k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_quantum_component_64k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/64k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get())
                .unlockedBy("has_quantum_component_64k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/64k_shapeless"));

        // 256k
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256K.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_quantum_component_256k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/256k_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256K.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get())
                .unlockedBy("has_quantum_component_256k", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/256k_shapeless"));

        // 1M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_quantum_component_1m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/1m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_1M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get())
                .unlockedBy("has_quantum_component_1m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/1m_shapeless"));

        // 4M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_quantum_component_4m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/4m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_4M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get())
                .unlockedBy("has_quantum_component_4m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/4m_shapeless"));

        // 16M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_quantum_component_16m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/16m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_16M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get())
                .unlockedBy("has_quantum_component_16m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/16m_shapeless"));

        // 64M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_quantum_component_64m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/64m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_64M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get())
                .unlockedBy("has_quantum_component_64m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/64m_shapeless"));

        // 256M
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256M.get())
                .pattern("ABA").pattern("BMB").pattern("CDC")
                .define('A', AEBlocks.QUARTZ_GLASS.asItem())
                .define('B', AEItems.ENDER_DUST.asItem())
                .define('C', OCItems.CHARGED_ENDER_INGOT.get())
                .define('D', OCItems.MULTIDIMENSIONAL_EXPANSION_PROCESSOR.get())
                .define('M', OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_quantum_component_256m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/256m_ordered"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OCItems.QUANTUM_OMNI_CELL_256M.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_HOUSING.get())
                .requires(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get())
                .unlockedBy("has_quantum_component_256m", has(OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get()))
                .save(recipeOutput, AE2OmniCells.makeId("cells/quantum/256m_shapeless"));



    }
}
