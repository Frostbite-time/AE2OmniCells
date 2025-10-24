package com.wintercogs.ae2omnicells.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class OCTags
{
    // 通用的末影珍珠粉标签
    public static final TagKey<Item> ENDER_PEARL_DUST =
            TagKey.create(Registries.ITEM, ResourceLocation.parse("c:dusts/ender_pearl"));
}
