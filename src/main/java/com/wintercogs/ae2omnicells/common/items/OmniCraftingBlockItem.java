package com.wintercogs.ae2omnicells.common.items;

import appeng.block.crafting.CraftingBlockItem;
import appeng.core.definitions.AEParts;
import appeng.recipes.game.CraftingUnitTransformRecipe;
import appeng.util.InteractionUtil;
import com.wintercogs.ae2omnicells.common.blocks.OmniCraftingMonitorBlock;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingFamily;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
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
    public @NotNull InteractionResult use(Level level, Player player, InteractionHand hand)
    {
        if (InteractionUtil.isInAlternateUseMode(player) &&
                level instanceof ServerLevel serverLevel)
        {
            ItemStack stack = player.getItemInHand(hand);

            ItemStack removedUpgrade;
            if (getBlock() instanceof OmniCraftingMonitorBlock)
            {
                removedUpgrade = AEParts.STORAGE_MONITOR.stack();
            }
            else
            {
                removedUpgrade = CraftingUnitTransformRecipe.getRemovedUpgrade(serverLevel, getBlock());
            }
            if (removedUpgrade.isEmpty()) return super.use(level, player, hand);

            int itemCount = stack.getCount();
            player.setItemInHand(hand, ItemStack.EMPTY);

            Inventory inv = player.getInventory();
            inv.placeItemBackInInventory(removedUpgrade.copyWithCount(removedUpgrade.getCount() * itemCount));

            // 这里，将我们自己的方块物品写进去
            ItemLike unitBlock = this.family.getUnitBaseBlock();
            inv.placeItemBackInInventory(new ItemStack(unitBlock, itemCount));

            return InteractionResult.SUCCESS;
        }
        return super.use(level, player, hand);
    }
}
