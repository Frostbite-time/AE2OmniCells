package com.wintercogs.ae2omnicells.common.items;

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.GenericStack;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.api.upgrades.Upgrades;
import appeng.core.AEConfig;
import appeng.items.contents.CellConfig;
import appeng.items.storage.StorageCellTooltipComponent;
import appeng.items.tools.powered.AbstractPortableCell;
import appeng.util.ConfigInventory;
import appeng.util.Platform;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.me.IAEUniversalCell;
import com.wintercogs.ae2omnicells.common.me.localization.AEUniversalTooltips;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * 便携通用单元（统一 Key 类型的便携盘）
 * - 继承 AE2 便携盘的能量/GUI/右键交互/拆解逻辑
 * - 实现 IAEUniversalCell：提供显示用 NBT、容量/类型/待机功耗等
 * - 构造参数精简：自动推导配方ID，充电速率随能量卡增长
 */
public class AEPortableUniversalCellItem extends AbstractPortableCell implements IAEUniversalCell
{
    /** 默认染色（可被 display.color 覆盖） */
    private static final int DEFAULT_COLOR = 0xFFFFFF;

    private final double idleDrain;
    private final int totalBytes;  // <=0 视为无限
    private final int totalTypes;  // <=0 视为无限

    /**
     * @param menuType   对应的便携盘菜单类型
     * @param props      物品属性
     * @param totalTypes 最大类型数（<=0 不限制）
     * @param kiloBytes  容量（KB；<=0 不限制）
     * @param idleDrain  待机功耗（AE/t）
     */
    public AEPortableUniversalCellItem(
            MenuType<?> menuType,
            Item.Properties props,
            int totalTypes,
            int kiloBytes,
            double idleDrain)
    {
        super(menuType, props, DEFAULT_COLOR);
        this.idleDrain = idleDrain;
        this.totalBytes = kiloBytes > 0 ? kiloBytes * 1024 : -1;
        this.totalTypes = totalTypes;
    }

    // ---------- AbstractPortableCell 必需实现 ----------

    /** 拆解时用的配方 ID，按注册名自动推导，保持与 AE 原版一致的 UX */
    @Override
    public ResourceLocation getRecipeId()
    {
        return AE2OmniCells.makeId("cells/shapeless/" +
                Objects.requireNonNull(this.getRegistryName()).getPath());
    }

    /** 充电速率：基础 80 AE/t，每张能量卡再 +80 AE/t（与原版便携盘一致） */
    @Override
    public double getChargeRate(ItemStack stack)
    {
        return 80.0 + 80.0 * Upgrades.getEnergyCardMultiplier(this.getUpgrades(stack));
    }

    // ---------- IAEUniversalCell 实现 ----------

    @Override
    public int getTotalBytes()
    {
        return this.totalBytes;
    }

    @Override
    public int getTotalTypes()
    {
        return this.totalTypes;
    }

    @Override
    public double getIdleDrain()
    {
        return this.idleDrain;
    }

    // ---------- 升级 / 配置 ----------

    @Override
    public IUpgradeInventory getUpgrades(ItemStack is)
    {
        // 4 槽，并保留能量卡变化的回调（提升能量上限倍率）
        return UpgradeInventories.forItem(is, 6, this::onUpgradesChanged);
    }

    @Override
    public ConfigInventory getConfigInventory(ItemStack is)
    {
        // 通用盘：允许所有 AEKey 作为过滤对象
        return CellConfig.create(key -> true, is);
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack is)
    {
        final var tag = is.getOrCreateTag();
        final String fz = tag.getString("FuzzyMode");
        if (fz.isEmpty()) return FuzzyMode.IGNORE_ALL;
        try {
            return FuzzyMode.valueOf(fz);
        } catch (IllegalArgumentException ex) {
            return FuzzyMode.IGNORE_ALL;
        }
    }

    @Override
    public void setFuzzyMode(ItemStack is, FuzzyMode fzMode)
    {
        is.getOrCreateTag().putString("FuzzyMode", fzMode.name());
    }

    // ---------- Tooltip：文本 + 预览组件 ----------

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @Nullable Level level,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag isAdvanced)
    {
        super.appendHoverText(stack, level, lines, isAdvanced);
        // 仅客户端做纯展示文本（不影响服务端逻辑）
        if (Platform.isClient())
        {
            long usedBytes = IAEUniversalCell.getUsedBytes(stack);
            long usedTypes = IAEUniversalCell.getUsedTypes(stack);

            lines.add(AEUniversalTooltips.bytesUsed(usedBytes, getTotalBytes()));
            lines.add(AEUniversalTooltips.typesUsed(usedTypes, getTotalTypes()));
        }
    }

    @Override
    public @NotNull Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack stack)
    {
        final boolean showUpg = AEConfig.instance().isTooltipShowCellUpgrades();
        final boolean showCnt = AEConfig.instance().isTooltipShowCellContent();

        if (!showUpg && !showCnt)
            return Optional.empty();

        // 升级图标
        List<ItemStack> upgrades = Collections.emptyList();
        if (showUpg) {
            List<ItemStack> tmp = new ArrayList<>();
            getUpgrades(stack).forEach(tmp::add);
            upgrades = tmp;
        }

        // 内容预览（最多 5 条）
        List<GenericStack> content = Collections.emptyList();
        boolean hasMore = false;
        if (showCnt) {
            List<GenericStack> show = IAEUniversalCell.getTooltipShowStacks(stack);
            if (!show.isEmpty()) {
                final int limit = 5;
                if (show.size() > limit) {
                    content = new ArrayList<>(show.subList(0, limit));
                    hasMore = true;
                } else {
                    content = new ArrayList<>(show);
                }
            }
        }

        // 显示进度条（由组件内部根据 NBT 状态绘制）
        return Optional.of(new StorageCellTooltipComponent(upgrades, content, hasMore, true));
    }
}