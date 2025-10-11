package com.wintercogs.ae2omnicells.common.me.biginteger;

import appeng.api.stacks.GenericStack;
import appeng.api.storage.cells.CellState;
import appeng.api.upgrades.IUpgradeableItem;
import com.wintercogs.ae2omnicells.common.init.OCDataComponents;
import net.minecraft.world.item.ItemStack;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 定义一些信息获取接口以及一些为ItemStack快速设置/获取信息的方法
 * <p>
 * 与IAEUniversalCell的主要区别为——给所需接口提供BigInteger的路径以及简化方法
 *
 * @author Frostbite
 */
public interface IAEBigIntegerCell extends IUpgradeableItem
{

    double getIdleDrain();

    // === 以下辅助方法：从 NBT 迁移为 Data Components，行为保持一致 ===
    static BigInteger getUsedBytes(ItemStack stack)
    {
        BigInteger v = stack.get(OCDataComponents.CELL_BYTE_USAGE_BIG.get());
        return v == null ? BigInteger.ZERO : v;
    }

    static void setUsedBytes(ItemStack stack, BigInteger usedBytes)
    {
        stack.set(OCDataComponents.CELL_BYTE_USAGE_BIG.get(), usedBytes);
    }

    static int getUsedTypes(ItemStack stack)
    {
        Integer v = stack.get(OCDataComponents.CELL_TYPES_USAGE.get());
        return v == null ? 0 : v;
    }

    static void setUsedTypes(ItemStack stack, int usedTypes)
    {
        stack.set(OCDataComponents.CELL_TYPES_USAGE.get(), Math.max(0, usedTypes));
    }

    static CellState getCellState(ItemStack stack)
    {
        String s = stack.get(OCDataComponents.CELL_STATE.get());
        if (s == null) return CellState.EMPTY;
        try {
            return CellState.valueOf(s);
        } catch (IllegalArgumentException ex) {
            return CellState.EMPTY;
        }
    }

    static void setCellState(ItemStack stack, CellState newState)
    {
        stack.set(OCDataComponents.CELL_STATE.get(), newState.name());
    }

    static List<GenericStack> getTooltipShowStacks(ItemStack stack)
    {
        List<GenericStack> raw = stack.get(OCDataComponents.CELL_SHOW_TOOLTIP_STACKS.get());
        if (raw == null || raw.isEmpty()) return List.of();
        // 返回不可变拷贝，保持与原逻辑“只读视图”的语义
        return Collections.unmodifiableList(new ArrayList<>(raw));
    }

    static void setTooltipShowStacks(ItemStack stack, List<GenericStack> showStacks)
    {
        if (showStacks == null || showStacks.isEmpty()) {
            stack.remove(OCDataComponents.CELL_SHOW_TOOLTIP_STACKS.get());
            return;
        }
        // 过滤掉可能的 null，保持与旧实现“跳过坏条目”的语义
        List<GenericStack> cleaned = new ArrayList<>(showStacks.size());
        for (GenericStack gs : showStacks) {
            if (gs != null) cleaned.add(gs);
        }
        if (cleaned.isEmpty()) {
            stack.remove(OCDataComponents.CELL_SHOW_TOOLTIP_STACKS.get());
        } else {
            stack.set(OCDataComponents.CELL_SHOW_TOOLTIP_STACKS.get(), cleaned);
        }
    }
}
