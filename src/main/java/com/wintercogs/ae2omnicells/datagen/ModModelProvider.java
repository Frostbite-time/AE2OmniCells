package com.wintercogs.ae2omnicells.datagen;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.client.item.PortableCellColorTintSource;
import appeng.client.item.StorageCellStateTintSource;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.client.render.OmniCraftingCubeModel;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingMonitorBlock;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingUnitBlock;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.common.items.AEUniversalCellItem;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingFamily;
import net.minecraft.client.color.item.Constant;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider
{
    private static final TextureSlot LAYER3 = TextureSlot.create("layer3");
    private static final ModelTemplate FOUR_LAYERED_ITEM = ModelTemplates.createItem("generated",
            new TextureSlot[]{TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, LAYER3});

    public ModModelProvider(PackOutput output)
    {
        super(output, AE2OmniCells.MODID);
    }

    @Override
    protected @NotNull Stream<? extends Holder<Item>> getKnownItems()
    {
        return OCItems.ITEMS.getEntries().stream();
    }

    @Override
    protected @NotNull Stream<? extends Holder<Block>> getKnownBlocks()
    {
        return OCBlocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels)
    {
        // 方块
        blockWithItem(blockModels, OCBlocks.ENDER_INGOT_BLOCK);
        blockWithItem(blockModels, OCBlocks.NETHERITE_SCRAP_BLOCK);
        blockWithItem(blockModels, OCBlocks.SINGULARITY_BLOCK);

        for (DeferredBlock<? extends @NotNull OmniCraftingUnitBlock> block : OCBlocks.CRAFTING_STORAGES)
        {
            craftingStorage(blockModels, block);
        }
        for (DeferredBlock<? extends @NotNull OmniCraftingMonitorBlock> block : OCBlocks.CRAFTING_MONITORS)
        {
            craftingMonitor(blockModels, block);
        }

        // 物品
        for (DeferredItem<@NotNull Item> registryItem : OCItems.getOthers())
        {
            itemModels.generateFlatItem(registryItem.get(), ModelTemplates.FLAT_ITEM);
        }
        for (DeferredItem<@NotNull AEUniversalCellItem> registryItem : OCItems.getCells())
        {
            cellWithOwnBaseAndAeLed(itemModels, registryItem.get());
        }
        for (DeferredItem<@NotNull Item> registryItem : OCItems.getCreativeCells())
        {
            cellWithOwnBaseAndAeLed(itemModels, registryItem.get());
        }

        // 便携存储
        // —— 普通（omni） ——
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_1K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_1k");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_4K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_4k");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_16K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_16k");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_64K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_64k");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_256K.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_256k");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_1M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_1m");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_4M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_4m");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_16M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_16m");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_64M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_64m");
        portableCell(itemModels, OCItems.PORTABLE_OMNI_CELL_256M.get(),
                "ae2omnicells:item/portable_cell_omni_housing",
                "ae2omnicells:item/portable_cell_side_256m");
        // —— 复杂（complex） ——
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_1K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_1k");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_4K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_4k");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_16K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_16k");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_64K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_64k");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_256K.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_256k");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_1M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_1m");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_4M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_4m");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_16M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_16m");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_64M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_64m");
        portableCell(itemModels, OCItems.PORTABLE_COMPLEX_OMNI_CELL_256M.get(),
                "ae2omnicells:item/portable_cell_complex_housing",
                "ae2omnicells:item/portable_cell_side_256m");
        // —— 量子（quantum） ——
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_1K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_1k");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_4K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_4k");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_16K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_16k");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_64K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_64k");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_256K.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_256k");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_1M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_1m");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_4M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_4m");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_16M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_16m");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_64M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_64m");
        portableCell(itemModels, OCItems.PORTABLE_QUANTUM_OMNI_CELL_256M.get(),
                "ae2omnicells:item/portable_cell_quantum_housing",
                "ae2omnicells:item/portable_cell_side_256m");

        // 废核系列
        cellWithOwnBaseAndAeLed(itemModels, OCItems.SPENT_NUCLEAR_WASTE_CELL.get());
        itemModels.generateFlatItem(OCItems.SPENT_NUCLEAR_WASTE_COMPONENT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(OCItems.SPENT_NUCLEAR_WASTE_SINGULARITY.get(), ModelTemplates.FLAT_ITEM);
    }

    // 辅助方法---物品
    private void cellWithOwnBaseAndAeLed(ItemModelGenerators itemModels, Item item)
    {
        Identifier id = BuiltInRegistries.ITEM.getKey(item);
        Identifier base = modLocation("item/" + id.getPath());
        Identifier model = itemModels.generateLayeredItem(item.asItem(), new Material(base), new Material(modLocation("item/led/storage_cell_led")));
        itemModels.itemModelOutput.accept(item.asItem(), ItemModelUtils.tintedModel(model, new ItemTintSource[]{new Constant(-1), new StorageCellStateTintSource()}));
    }

    private void portableCell(ItemModelGenerators itemModels, Item item, String housing, String side)
    {
        Identifier model = FOUR_LAYERED_ITEM.create(item, TextureMapping.layered(
                        new Material(modLocation("item/led/portable_cell_screen")),
                        new Material(modLocation("item/led/portable_cell_led")),
                        new Material(Identifier.parse(housing))
                ).put(LAYER3, new Material(Identifier.parse(side))),
                itemModels.modelOutput
        );
        itemModels.itemModelOutput.accept(item.asItem(), ItemModelUtils.tintedModel(model, new ItemTintSource[]{new Constant(-1), new StorageCellStateTintSource(), new PortableCellColorTintSource()}));
    }

    // 辅助方法---方块
    protected void blockWithItem(BlockModelGenerators blockModels, DeferredBlock<? extends Block> deferredBlock)
    {
        Block block = deferredBlock.get();
        blockModels.createTrivialCube(block);
        blockModels.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block));
    }

    private void craftingStorage(BlockModelGenerators blockModels, DeferredBlock<? extends OmniCraftingUnitBlock> block)
    {
        var craftingBlock = block.get();
        Identifier model = craftingCubeAllModel(blockModels, craftingBlock);

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(craftingBlock)
                .with(PropertyDispatch.initial(AbstractCraftingUnitBlock.FORMED)
                        .select(false, BlockModelGenerators.plainVariant(model))
                        .select(true, craftingCubeVariant(craftingBlock.omniCraftingType))));
        blockModels.itemModelOutput.accept(craftingBlock.asItem(), ItemModelUtils.plainModel(model));
    }

    private void craftingMonitor(BlockModelGenerators blockModels, DeferredBlock<? extends OmniCraftingMonitorBlock> block)
    {
        var monitorBlock = block.get();
        Identifier model = craftingMonitorModel(blockModels, monitorBlock);

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(monitorBlock)
                .with(PropertyDispatch.initial(AbstractCraftingUnitBlock.FORMED)
                        .select(false, BlockModelGenerators.plainVariant(model))
                        .select(true, craftingCubeVariant(monitorBlock.omniCraftingType)))
                .with(BlockModelGenerators.ROTATION_FACING));
        blockModels.itemModelOutput.accept(monitorBlock.asItem(), ItemModelUtils.plainModel(model));
    }

    private Identifier craftingCubeAllModel(BlockModelGenerators blockModels, Block block)
    {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        Identifier model = AE2OmniCells.makeId("block/crafting/" + id.getPath());
        Identifier texture = AE2OmniCells.makeId("block/crafting/" + id.getPath());
        return ModelTemplates.CUBE_ALL.create(model, TextureMapping.cube(new Material(texture)), blockModels.modelOutput);
    }

    private Identifier craftingMonitorModel(BlockModelGenerators blockModels, OmniCraftingMonitorBlock block)
    {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        Identifier model = AE2OmniCells.makeId("block/crafting/" + id.getPath());
        Identifier monitorTexture = AE2OmniCells.makeId("block/crafting/monitor/" + id.getPath());
        Identifier unitTexture = AE2OmniCells.makeId("block/crafting/" + unitTextureName(block.omniCraftingType.family));
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(monitorTexture))
                .put(TextureSlot.NORTH, new Material(monitorTexture))
                .put(TextureSlot.SOUTH, new Material(unitTexture))
                .put(TextureSlot.EAST, new Material(unitTexture))
                .put(TextureSlot.WEST, new Material(unitTexture))
                .put(TextureSlot.UP, new Material(unitTexture))
                .put(TextureSlot.DOWN, new Material(unitTexture));
        return ModelTemplates.CUBE.create(model, textures, blockModels.modelOutput);
    }

    private String unitTextureName(OmniCraftingFamily family)
    {
        return switch (family)
        {
            case OMNI -> "omni_crafting_unit_block";
            case COMPLEX -> "complex_crafting_unit_block";
            case QUANTUM -> "quantum_crafting_unit_block";
        };
    }

    private MultiVariant craftingCubeVariant(com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType type)
    {
        return MultiVariant.of(new CustomBlockStateModelBuilder.Simple(new OmniCraftingCubeModel.Unbaked(type)));
    }

}
