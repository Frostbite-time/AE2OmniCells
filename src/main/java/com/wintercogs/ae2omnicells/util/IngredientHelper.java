package com.wintercogs.ae2omnicells.util;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class IngredientHelper
{
    private static Ingredient ingredient(TagKey<Item> tagKey)
    {
        return Ingredient.of(HolderSet.emptyNamed(BuiltInRegistries.ITEM, tagKey));
    }
}
