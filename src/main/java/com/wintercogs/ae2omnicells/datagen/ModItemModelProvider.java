package com.wintercogs.ae2omnicells.datagen;

import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, AE2OmniCells.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        for(RegistryObject<Item> registryItem : OCItems.getOthers())
        {
            basicItem(registryItem.get());
        }
        for(RegistryObject<AEUniversalCellItem> registryItem : OCItems.getCells())
        {
            cellWithOwnBaseAndAeLed(registryItem.get());
        }
        for(RegistryObject<Item> registryItem : OCItems.getCreativeCells())
        {
            cellWithOwnBaseAndAeLed(registryItem.get());
        }

        // 便携存储
        // —— 普通（omni） ——
        portableCell(OCItems.PORTABLE_OMNI_CELL_1K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2:item/portable_cell_side_1k");
        portableCell(OCItems.PORTABLE_OMNI_CELL_4K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2:item/portable_cell_side_4k");
        portableCell(OCItems.PORTABLE_OMNI_CELL_16K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2:item/portable_cell_side_16k");
        portableCell(OCItems.PORTABLE_OMNI_CELL_64K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2:item/portable_cell_side_64k");
        portableCell(OCItems.PORTABLE_OMNI_CELL_256K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2:item/portable_cell_side_256k");
        portableCell(OCItems.PORTABLE_OMNI_CELL_1M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_1m");
        portableCell(OCItems.PORTABLE_OMNI_CELL_4M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_4m");
        portableCell(OCItems.PORTABLE_OMNI_CELL_16M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_16m");
        portableCell(OCItems.PORTABLE_OMNI_CELL_64M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_64m");
        portableCell(OCItems.PORTABLE_OMNI_CELL_256M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_256m");
        // —— 复杂（complex） ——
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_1K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2:item/portable_cell_side_1k");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_4K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2:item/portable_cell_side_4k");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_16K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2:item/portable_cell_side_16k");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_64K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2:item/portable_cell_side_64k");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_256K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2:item/portable_cell_side_256k");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_1M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_1m");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_4M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_4m");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_16M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_16m");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_64M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_64m");
        portableCell(OCItems.PORTABLE_COMPLEX_OMNI_CELL_256M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_256m");
        // —— 量子（quantum） ——
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_1K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2:item/portable_cell_side_1k");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_4K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2:item/portable_cell_side_4k");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_16K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2:item/portable_cell_side_16k");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_64K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2:item/portable_cell_side_64k");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_256K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2:item/portable_cell_side_256k");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_1M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_1m");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_4M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_4m");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_16M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_16m");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_64M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_64m");
        portableCell(OCItems.PORTABLE_QUANTUM_OMNI_CELL_256M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_256m");

    }

    /**
     * 生成便携元件的模型
     * @param item    物品
     * @param housing layer2 纹理
     * @param side    layer3 纹理
     */
    protected ItemModelBuilder portableCell(ItemLike item, String housing, String side)
    {
        // 让 EFH 放行校验
        allowExternalTexture(housing);
        allowExternalTexture("ae2:item/portable_cell_led");
        allowExternalTexture("ae2:item/portable_cell_screen");
        allowExternalTexture(side);

        return withExistingParent(getItemName(item), mcLoc("item/generated"))
                .texture("layer0", "ae2:item/portable_cell_screen")
                .texture("layer1", "ae2:item/portable_cell_led")
                .texture("layer2", housing)
                .texture("layer3", side);
    }

    private String getItemName(ItemLike item)
    {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
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

    // 快速注册带led灯状态的存储元件模型
    public ItemModelBuilder cellWithOwnBaseAndAeLed(Item item)
    {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        var base = modLoc("item/" + id.getPath());

        allowExternalTexture("ae2:item/storage_cell_led");
        return withExistingParent(id.getPath(), mcLoc("item/generated"))
                .texture("layer0", base)
                .texture("layer1", "ae2:item/storage_cell_led");
    }

}
