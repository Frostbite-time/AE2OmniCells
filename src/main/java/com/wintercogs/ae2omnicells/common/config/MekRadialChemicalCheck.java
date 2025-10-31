package com.wintercogs.ae2omnicells.common.config;

public enum MekRadialChemicalCheck
{
    ALLOW,
    DENY_SPENT, // 仅阻止用尽的核废料
    DENY_ALL; // 阻止所有放射性化学品


    /**
     * 判定是否允许存入
     * @param isWasteCell     是否为“废核磁盘”
     * @param isSpent         是否是“用尽的核废料”
     * @param isRadioactive   是否是任意放射性化学品
     * @return true=允许；false=拒绝
     * <p>
     * 语义：
     * - 普通盘：按本枚举含义正常放行/拒绝；
     * - 废核盘：只能存“常规配置本来会拒绝”的化学品；
     *           若常规配置为 ALLOW（普通盘允许所有放射性），则至少允许“用尽的核废料”本体。
     */
    public boolean allow(boolean isWasteCell, boolean isSpent, boolean isRadioactive)
    {
        final boolean deniedByNormal = switch (this)
        {
            case ALLOW -> false;
            case DENY_SPENT -> isSpent;
            case DENY_ALL -> isRadioactive;
        };

        // 普通盘
        if (!isWasteCell)
        {
            // 不会被常规配置拒绝就允许
            return !deniedByNormal;
        }

        // 废核盘：
        // 优先允许“常规配置会拒绝”的化学品；
        // 若常规配置为 ALLOW，则特许“用尽的核废料”也可存。
        return deniedByNormal || (this == ALLOW && isSpent);
    }
}
