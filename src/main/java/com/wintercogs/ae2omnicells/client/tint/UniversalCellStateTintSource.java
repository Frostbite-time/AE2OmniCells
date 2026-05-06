package com.wintercogs.ae2omnicells.client.tint;


import appeng.api.implementations.items.IAEItemPowerStorage;
import appeng.api.storage.cells.CellState;
import com.mojang.serialization.MapCodec;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.me.IAEUniversalCell;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record UniversalCellStateTintSource() implements ItemTintSource
{
    public static final Identifier ID = AE2OmniCells.makeId("storage_cell_state");
    public static final MapCodec<UniversalCellStateTintSource> MAP_CODEC = MapCodec.unit(UniversalCellStateTintSource::new);

    public UniversalCellStateTintSource()
    {
    }

    public int calculate(@NotNull ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity)
    {
        CellState cellState = this.getCellState(stack);
        return ARGB.opaque(cellState.getStateColor());
    }

    private CellState getCellState(ItemStack stack)
    {
        Item cell = stack.getItem();
        if (cell instanceof IAEItemPowerStorage powerStorage)
        {
            if (powerStorage.getAECurrentPower(stack) <= (double) 0.0F)
            {
                return CellState.ABSENT;
            }
        }
        return IAEUniversalCell.getCellState(stack);
    }

    public MapCodec<? extends ItemTintSource> type()
    {
        return MAP_CODEC;
    }
}
