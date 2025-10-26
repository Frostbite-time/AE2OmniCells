package com.wintercogs.ae2omnicells.common.config;

public enum MekRadialChemicalCheck
{
    ALLOW,
    DENY_SPENT, // 仅阻止用尽的核废料
    DENY_ALL; // 阻止所有放射性化学品
}
