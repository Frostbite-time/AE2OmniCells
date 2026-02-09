package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider
{
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, AE2OmniCells.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        driveBlockModel("block/drive/omni_drive_cell", "block/drive/cells/omni_cell_drive");
        driveBlockModel("block/drive/complex_omni_drive_cell", "block/drive/cells/complex_omni_cell_drive");
        driveBlockModel("block/drive/quantum_omni_drive_cell", "block/drive/cells/quantum_omni_cell_drive");
        driveBlockModel("block/drive/spent_nuclear_waste_drive_cell", "block/drive/cells/spent_nuclear_waste_drive_cell");
    }

    /**
     * 生成便携元件的模型
     *
     * @param texture 纹理
     */
    protected BlockModelBuilder driveBlockModel(String name, String texture)
    {
        // 让 EFH 放行校验
        allowExternalModel("ae2:block/drive/drive_cell");
        allowExternalTexture(texture);

        return withExistingParent(name, new ResourceLocation("ae2:block/drive/drive_cell"))
                .texture("cell", texture);
    }

    private String getItemName(ItemLike item)
    {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }

    private void allowExternalModel(String path)
    {
        ResourceLocation rl = new ResourceLocation(path);
        if (!rl.getNamespace().equals(AE2OmniCells.MODID))
        {
            this.existingFileHelper.trackGenerated(rl, ModelProvider.MODEL); // 注意这里是 MODEL
        }
    }

    /**
     * 把非本模组命名空间的纹理标记为“已生成”，从而绕过存在性校验
     */
    private void allowExternalTexture(String path)
    {
        ResourceLocation rl = new ResourceLocation(path);
        if (!rl.getNamespace().equals(AE2OmniCells.MODID))
        {
            this.existingFileHelper.trackGenerated(rl, ModelProvider.TEXTURE);
        }
    }

}
