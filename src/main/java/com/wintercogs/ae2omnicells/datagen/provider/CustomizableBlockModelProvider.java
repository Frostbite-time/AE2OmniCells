package com.wintercogs.ae2omnicells.datagen.provider;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CustomizableBlockModelProvider extends BlockModelProvider
{

    public CustomizableBlockModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper)
    {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {

    }

    // 不自动执行，这里返回空 future；真正写文件时我们手动调用 generateAll
    @Override
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache)
    {
        return CompletableFuture.allOf();
    }

    // 用于执行清理
    public void clearForInternal()
    {
        this.clear();
    }

    // 用于生成
    public CompletableFuture<?> generateAllForInternal(@NotNull CachedOutput cache)
    {
        return this.generateAll(cache);
    }
}
