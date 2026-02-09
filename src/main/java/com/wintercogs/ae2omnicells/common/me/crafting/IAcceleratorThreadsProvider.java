package com.wintercogs.ae2omnicells.common.me.crafting;

/**
 * 绕过CraftingCPUCluster的16线程限制时，尽可能保证mixin的兼容性
 */
public interface IAcceleratorThreadsProvider
{
    /**
     * 获得线程数
     */
    int getOmniCustomAcceleratorThreads();
}
