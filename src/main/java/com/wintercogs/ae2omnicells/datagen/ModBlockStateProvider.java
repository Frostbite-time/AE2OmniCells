package com.wintercogs.ae2omnicells.datagen;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.datagen.provider.CustomizableBlockModelProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockStateProvider extends BlockStateProvider
{
    // 内嵌一个AE2命名空间的模型provider，以便于注册合成存储器的模型
    private final CustomizableBlockModelProvider ae2Models;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, AE2OmniCells.MODID, exFileHelper);
        this.ae2Models = new CustomizableBlockModelProvider(output, AE2OmniCells.AE2_MODID, exFileHelper);
    }

    // 覆写 run，把 ae2 命名空间的模型也一起写出去
    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cache)
    {
        this.ae2Models.clearForInternal();
        CompletableFuture<?> base = super.run(cache);
        CompletableFuture<?> ae2 = this.ae2Models.generateAllForInternal(cache);

        return CompletableFuture.allOf(base, ae2);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(OCBlocks.ENDER_INGOT_BLOCK);
        blockWithItem(OCBlocks.NETHERITE_SCRAP_BLOCK);
        blockWithItem(OCBlocks.SINGULARITY_BLOCK);

        for (DeferredBlock<? extends OmniCraftingUnitBlock> craftingBlock : OCBlocks.CRAFTING_STORAGES)
        {
            craftingModel(craftingBlock);
        }
        // 我们手写合成监视器的blockmodel和blockstate
        // 为它写一套datagen方法太麻烦了
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    /**
     * 合成存储器
     */
    private void craftingModel(DeferredBlock<? extends OmniCraftingUnitBlock> block)
    {
        String path = block.getId().getPath();
        var blockModel = models().cubeAll("block/crafting/" + path, AE2OmniCells.makeId("block/crafting/" + path));
        ModelFile formed = ae2Models.getBuilder("block/crafting/" + path + "_formed");
        getVariantBuilder(block.get()).partialState().with(AbstractCraftingUnitBlock.FORMED, false)
                .setModels(new ConfiguredModel(blockModel))
                .partialState().with(AbstractCraftingUnitBlock.FORMED, true)
                .setModels(new ConfiguredModel(formed));
        simpleBlockItem(block.get(), blockModel);
    }
}
