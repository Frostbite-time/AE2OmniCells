package com.wintercogs.ae2omnicells.common.items;


import appeng.block.crafting.CraftingBlockItem;
import appeng.core.definitions.AEParts;
import appeng.util.InteractionUtil;
import com.wintercogs.ae2omnicells.common.blocks.IOmniCraftingBlock;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingMonitorBlock;
import com.wintercogs.ae2omnicells.common.init.OCItems;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingFamily;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingStorageType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class OmniCraftingBlockItem extends CraftingBlockItem
{
    private final OmniCraftingFamily family;

    public OmniCraftingBlockItem(Block id, Properties props, OmniCraftingFamily family)
    {
        super(id, props, getDisassemblyExtraItem(id));
        this.family = family;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if (InteractionUtil.isInAlternateUseMode(player))
        {
            // 对空单元不执行操作
            if(getBlock() instanceof IOmniCraftingBlock omniCraftingBlock && omniCraftingBlock.getOmniCraftingUnitType().storageType == OmniCraftingStorageType.UNIT)
                return InteractionResultHolder.pass(player.getItemInHand(hand));

            ItemStack stack = player.getItemInHand(hand);

            ItemStack removedUpgrade;
            if(getBlock() instanceof OmniCraftingMonitorBlock)
            {
                removedUpgrade = AEParts.STORAGE_MONITOR.stack();
            }
            else
            {
                removedUpgrade = new ItemStack(getDisassemblyExtraItem(getBlock()).get(), 1);
            }
            if (removedUpgrade.isEmpty()) return super.use(level, player, hand);

            int itemCount = stack.getCount();
            player.setItemInHand(hand, ItemStack.EMPTY);

            Inventory inv = player.getInventory();
            inv.placeItemBackInInventory(removedUpgrade.copyWithCount(removedUpgrade.getCount() * itemCount));

            // 这里，将我们自己的方块物品写进去
            ItemLike unitBlock = this.family.getUnitBaseBlock();
            inv.placeItemBackInInventory(new ItemStack(unitBlock, itemCount));

            return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
        }
        return super.use(level, player, hand);
    }
    
    public static Supplier<ItemLike> getDisassemblyExtraItem(Block disassemblyBlock)
    {
        if(disassemblyBlock instanceof IOmniCraftingBlock omniCraftingBlock)
        {
            return () -> switch (omniCraftingBlock.getOmniCraftingUnitType())
            {
                case OMNI_MONITOR -> AEParts.STORAGE_MONITOR;
                case OMNI_STORAGE_1K -> OCItems.OMNI_CELL_COMPONENT_1K.get();
                case OMNI_STORAGE_4K -> OCItems.OMNI_CELL_COMPONENT_4K.get();
                case OMNI_STORAGE_16K -> OCItems.OMNI_CELL_COMPONENT_16K.get();
                case OMNI_STORAGE_64K -> OCItems.OMNI_CELL_COMPONENT_64K.get();
                case OMNI_STORAGE_256K -> OCItems.OMNI_CELL_COMPONENT_256K.get();
                case OMNI_STORAGE_1M -> OCItems.OMNI_CELL_COMPONENT_1M.get();
                case OMNI_STORAGE_4M -> OCItems.OMNI_CELL_COMPONENT_4M.get();
                case OMNI_STORAGE_16M -> OCItems.OMNI_CELL_COMPONENT_16M.get();
                case OMNI_STORAGE_64M -> OCItems.OMNI_CELL_COMPONENT_64M.get();
                case OMNI_STORAGE_256M -> OCItems.OMNI_CELL_COMPONENT_256M.get();

                case COMPLEX_MONITOR -> AEParts.STORAGE_MONITOR;
                case COMPLEX_STORAGE_1K -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_1K.get();
                case COMPLEX_STORAGE_4K -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_4K.get();
                case COMPLEX_STORAGE_16K -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_16K.get();
                case COMPLEX_STORAGE_64K -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_64K.get();
                case COMPLEX_STORAGE_256K -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_256K.get();
                case COMPLEX_STORAGE_1M -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_1M.get();
                case COMPLEX_STORAGE_4M -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_4M.get();
                case COMPLEX_STORAGE_16M -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_16M.get();
                case COMPLEX_STORAGE_64M -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_64M.get();
                case COMPLEX_STORAGE_256M -> OCItems.COMPLEX_OMNI_CELL_COMPONENT_256M.get();

                case QUANTUM_MONITOR -> AEParts.STORAGE_MONITOR;
                case QUANTUM_STORAGE_1K -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_1K.get();
                case QUANTUM_STORAGE_4K -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_4K.get();
                case QUANTUM_STORAGE_16K -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_16K.get();
                case QUANTUM_STORAGE_64K -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_64K.get();
                case QUANTUM_STORAGE_256K -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_256K.get();
                case QUANTUM_STORAGE_1M -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_1M.get();
                case QUANTUM_STORAGE_4M -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_4M.get();
                case QUANTUM_STORAGE_16M -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_16M.get();
                case QUANTUM_STORAGE_64M -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_64M.get();
                case QUANTUM_STORAGE_256M -> OCItems.QUANTUM_OMNI_CELL_COMPONENT_256M.get();

                default -> Items.AIR;
            };
        }
        return () -> Items.AIR;
    }
}

