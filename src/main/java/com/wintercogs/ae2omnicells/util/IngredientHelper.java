package com.wintercogs.ae2omnicells.util;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class IngredientHelper
{
    @SuppressWarnings("deprecation")
    public static Ingredient of(TagKey<Item> tagKey)
    {
        return Ingredient.of(HolderSet.emptyNamed(BuiltInRegistries.ITEM, tagKey));
    }
}
