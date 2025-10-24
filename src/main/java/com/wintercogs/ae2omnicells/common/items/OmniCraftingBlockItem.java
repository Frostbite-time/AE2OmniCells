package com.wintercogs.ae2omnicells.common.items;

import appeng.block.crafting.CraftingBlockItem;
import appeng.recipes.game.CraftingUnitTransformRecipe;
import appeng.util.InteractionUtil;
import com.wintercogs.ae2omnicells.common.init.OCBlocks;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingFamily;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class OmniCraftingBlockItem extends CraftingBlockItem
{
    private final OmniCraftingFamily family;

    public OmniCraftingBlockItem(Block id, Properties props, OmniCraftingFamily family)
    {
        super(id, props);
        this.family = family;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if (InteractionUtil.isInAlternateUseMode(player))
        {
            ItemStack stack = player.getItemInHand(hand);

            ItemStack removedUpgrade = CraftingUnitTransformRecipe.getRemovedUpgrade(level, getBlock());
            if (removedUpgrade.isEmpty())
            {
                return super.use(level, player, hand);
            }

            int itemCount = stack.getCount();
            player.setItemInHand(hand, ItemStack.EMPTY);

            Inventory inv = player.getInventory();
            inv.placeItemBackInInventory(removedUpgrade.copyWithCount(removedUpgrade.getCount() * itemCount));

            // 这里，将我们自己的方块物品写进去
            var unitBlock = switch(this.family)
            {
                case OMNI -> OCBlocks.OMNI_CRAFTING_UNIT_BLOCK;
                case COMPLEX -> OCBlocks.COMPLEX_CRAFTING_UNIT_BLOCK;
                case QUANTUM -> OCBlocks.QUANTUM_CRAFTING_UNIT_BLOCK;
            };
            inv.placeItemBackInInventory(new ItemStack(unitBlock, itemCount));

            return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
        }
        return super.use(level, player, hand);
    }
}
