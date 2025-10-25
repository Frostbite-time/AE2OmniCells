package com.wintercogs.ae2omnicells.common.blocks;

import appeng.block.crafting.CraftingMonitorBlock;
import appeng.blockentity.crafting.CraftingBlockEntity;
import appeng.core.definitions.AEParts;
import appeng.core.localization.PlayerMessages;
import appeng.menu.MenuOpener;
import appeng.menu.locator.MenuLocators;
import appeng.menu.me.crafting.CraftingCPUMenu;
import appeng.recipes.game.CraftingUnitTransformRecipe;
import appeng.util.InteractionUtil;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingStorageType;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class OmniCraftingMonitorBlock extends CraftingMonitorBlock implements IOmniCraftingBlock
{
    /** 与type变量一致，但是这里保留了更多类型信息 */
    public final OmniCraftingUnitType omniCraftingType;

    public OmniCraftingMonitorBlock(OmniCraftingUnitType type)
    {
        super(type);
        this.omniCraftingType = type;
    }

    @Override
    public @NotNull OmniCraftingUnitType getOmniCraftingUnitType()
    {
        return this.omniCraftingType;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (InteractionUtil.isInAlternateUseMode(player))
        {
            Block unitBlock = this.omniCraftingType.family.getUnitBaseBlock();
            var result = this.removeUpgrade(level, player, pos, unitBlock.defaultBlockState());
            if (result != InteractionResult.FAIL)
                return result;
        }

        if (level.getBlockEntity(pos) instanceof CraftingBlockEntity be && be.isFormed() && be.isActive())
        {
            if (!level.isClientSide()) {
                MenuOpener.open(CraftingCPUMenu.TYPE, player, MenuLocators.forBlockEntity(be));
            }

            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public boolean upgrade(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit)
    {
        if (heldItem.isEmpty()) return false;

        Block upgradedBlock;
        // 用于特判合成监控器
        if(heldItem.getItem() == AEParts.STORAGE_MONITOR.get())
            upgradedBlock = this.omniCraftingType.family.getMonitorBlock();
        else
            upgradedBlock = CraftingUnitTransformRecipe.getUpgradedBlock(level, heldItem);

        if(upgradedBlock == null) return false;
        if(!(upgradedBlock instanceof IOmniCraftingBlock upgradedOCBlock)) return false;
        if(upgradedBlock == state.getBlock()) return false;
        // 升级配方只能在一个系列之内进行，不同系列不能互转
        if(upgradedOCBlock.getOmniCraftingUnitType().family != this.omniCraftingType.family) return false;

        // 遵循ae原版行为，返回true以播放动画
        if (level.isClientSide()) return true;

        BlockState newState = upgradedBlock.defaultBlockState();

        // 确保合成监视器指向玩家
        newState = newState.trySetValue(BlockStateProperties.FACING, hit.getDirection());

        boolean isUnitBlock = this.omniCraftingType.storageType == OmniCraftingStorageType.UNIT;
        InteractionResult result = isUnitBlock
                ? this.transform(level, pos, newState) ? InteractionResult.SUCCESS : InteractionResult.FAIL
                : this.removeUpgrade(level, player, pos, newState);

        if (result == InteractionResult.FAIL)
            return false;
        // Pass => 控制器正在运行中，禁止修改
        if (result == InteractionResult.PASS)
            return true;
        heldItem.consume(1, player);
        return true;
    }

    @Override
    public InteractionResult removeUpgrade(Level level, Player player, BlockPos pos, BlockState newState)
    {
        if (this.omniCraftingType.storageType == OmniCraftingStorageType.UNIT || level.isClientSide())
            return InteractionResult.FAIL;

        ItemStack removedUpgrade;
        if(this.omniCraftingType.storageType == OmniCraftingStorageType.MONITOR)
        {
            removedUpgrade = AEParts.STORAGE_MONITOR.stack();
        }
        else
        {
            removedUpgrade = CraftingUnitTransformRecipe.getRemovedUpgrade(level, this);
        }
        if (removedUpgrade.isEmpty()) return InteractionResult.FAIL;

        var cb = this.getBlockEntity(level, pos);
        if (cb != null && cb.getCluster() != null && cb.getCluster().isBusy())
        {
            player.displayClientMessage(PlayerMessages.CraftingCpuBusy.text().withColor(0xFF1F1F), true);
            return InteractionResult.PASS;
        }

        if (!this.transform(level, pos, newState))
            return InteractionResult.FAIL;

        player.getInventory().placeItemBackInInventory(removedUpgrade);

        return InteractionResult.SUCCESS;
    }

    // ae将其设为私有方法，我们不需要重写，但是仍需要调用它
    private boolean transform(Level level, BlockPos pos, BlockState state)
    {
        if (level.isClientSide() || !level.removeBlock(pos, false) || !level.setBlock(pos, state, UPDATE_ALL))
        {
            return false;
        }

        level.playSound(
                null,
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                SoundEvents.ITEM_FRAME_REMOVE_ITEM,
                SoundSource.BLOCKS,
                0.5f,
                1f);
        return true;
    }
}
