package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.common.config.MekRadialChemicalCheck;
import com.wintercogs.ae2omnicells.common.config.MekRadialChemicalCheckConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;


public class Config
{
    public final Config.CommonConfig commonConfig = new Config.CommonConfig();

    public static Config INSTANCE;

    private Config(ModLoadingContext container)
    {
        container.registerConfig(ModConfig.Type.COMMON, commonConfig.spec);
        MinecraftForge.EVENT_BUS.addListener((ModConfigEvent.Loading evt) ->
        {
            if (evt.getConfig().getSpec() == commonConfig.spec)
            {
                commonConfig.onLoaded();
            }
        });
        MinecraftForge.EVENT_BUS.addListener((ModConfigEvent.Reloading evt) ->
        {
            if (evt.getConfig().getSpec() == commonConfig.spec)
            {
                commonConfig.onLoaded();
            }
        });
    }

    public static void register(ModLoadingContext container)
    {
        INSTANCE = new Config(container);
    }

    public static class CommonConfig
    {
        public final ForgeConfigSpec spec;

        public final ForgeConfigSpec.EnumValue<MekRadialChemicalCheck> checkMode;

        // 三系cpu并行值
        public final ForgeConfigSpec.IntValue omniCoProcessor_1k;
        public final ForgeConfigSpec.IntValue omniCoProcessor_4k;
        public final ForgeConfigSpec.IntValue omniCoProcessor_16k;
        public final ForgeConfigSpec.IntValue omniCoProcessor_64k;
        public final ForgeConfigSpec.IntValue omniCoProcessor_256k;
        public final ForgeConfigSpec.IntValue omniCoProcessor_1m;
        public final ForgeConfigSpec.IntValue omniCoProcessor_4m;
        public final ForgeConfigSpec.IntValue omniCoProcessor_16m;
        public final ForgeConfigSpec.IntValue omniCoProcessor_64m;
        public final ForgeConfigSpec.IntValue omniCoProcessor_256m;
        public final ForgeConfigSpec.IntValue complexCoProcessor_1k;
        public final ForgeConfigSpec.IntValue complexCoProcessor_4k;
        public final ForgeConfigSpec.IntValue complexCoProcessor_16k;
        public final ForgeConfigSpec.IntValue complexCoProcessor_64k;
        public final ForgeConfigSpec.IntValue complexCoProcessor_256k;
        public final ForgeConfigSpec.IntValue complexCoProcessor_1m;
        public final ForgeConfigSpec.IntValue complexCoProcessor_4m;
        public final ForgeConfigSpec.IntValue complexCoProcessor_16m;
        public final ForgeConfigSpec.IntValue complexCoProcessor_64m;
        public final ForgeConfigSpec.IntValue complexCoProcessor_256m;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_1k;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_4k;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_16k;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_64k;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_256k;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_1m;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_4m;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_16m;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_64m;
        public final ForgeConfigSpec.IntValue quantumCoProcessor_256m;

        public CommonConfig()
        {
            ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

            checkMode = builder
                    .comment("是否允许OMNI系列元件存入MEK的放射性化学品，DENY_SPENT代表仅阻止用尽的核废料，其余为字面意思")
                    .defineEnum("mek_radial_chemical_check", MekRadialChemicalCheck.ALLOW);

            // 这部分不会做热重载支持，因为很难预测运行时变化的cpu并行数会造成什么后果
            builder.push("CPU Processors Config (Must restart your game after changed)");
            omniCoProcessor_1k = builder.defineInRange("omni_coprocessor_1k", 4, 0, 81920);
            omniCoProcessor_4k = builder.defineInRange("omni_coprocessor_4k", 4, 0, 81920);
            omniCoProcessor_16k = builder.defineInRange("omni_coprocessor_16k", 4, 0, 81920);
            omniCoProcessor_64k = builder.defineInRange("omni_coprocessor_64k", 4, 0, 81920);
            omniCoProcessor_256k = builder.defineInRange("omni_coprocessor_256k", 4, 0, 81920);
            omniCoProcessor_1m = builder.defineInRange("omni_coprocessor_1m", 8, 0, 81920);
            omniCoProcessor_4m = builder.defineInRange("omni_coprocessor_4m", 8, 0, 81920);
            omniCoProcessor_16m = builder.defineInRange("omni_coprocessor_16m", 8, 0, 81920);
            omniCoProcessor_64m = builder.defineInRange("omni_coprocessor_64m", 8, 0, 81920);
            omniCoProcessor_256m = builder.defineInRange("omni_coprocessor_256m", 8, 0, 81920);
            complexCoProcessor_1k = builder.defineInRange("complex_coprocessor_1k", 0, 0, 81920);
            complexCoProcessor_4k = builder.defineInRange("complex_coprocessor_4k", 1, 0, 81920);
            complexCoProcessor_16k = builder.defineInRange("complex_coprocessor_16k", 2, 0, 81920);
            complexCoProcessor_64k = builder.defineInRange("complex_coprocessor_64k", 4, 0, 81920);
            complexCoProcessor_256k = builder.defineInRange("complex_coprocessor_256k", 8, 0, 81920);
            complexCoProcessor_1m = builder.defineInRange("complex_coprocessor_1m", 16, 0, 81920);
            complexCoProcessor_4m = builder.defineInRange("complex_coprocessor_4m", 32, 0, 81920);
            complexCoProcessor_16m = builder.defineInRange("complex_coprocessor_16m", 64, 0, 81920);
            complexCoProcessor_64m = builder.defineInRange("complex_coprocessor_64m", 128, 0, 81920);
            complexCoProcessor_256m = builder.defineInRange("complex_coprocessor_256m", 256, 0, 81920);
            quantumCoProcessor_1k = builder.defineInRange("quantum_coprocessor_1k", 512, 0, 81920);
            quantumCoProcessor_4k = builder.defineInRange("quantum_coprocessor_4k", 512, 0, 81920);
            quantumCoProcessor_16k = builder.defineInRange("quantum_coprocessor_16k", 1024, 0, 81920);
            quantumCoProcessor_64k = builder.defineInRange("quantum_coprocessor_64k", 1024, 0, 81920);
            quantumCoProcessor_256k = builder.defineInRange("quantum_coprocessor_256k", 2048, 0, 81920);
            quantumCoProcessor_1m = builder.defineInRange("quantum_coprocessor_1m", 2048, 0, 81920);
            quantumCoProcessor_4m = builder.defineInRange("quantum_coprocessor_4m", 4096, 0, 81920);
            quantumCoProcessor_16m = builder.defineInRange("quantum_coprocessor_16m", 4096, 0, 81920);
            quantumCoProcessor_64m = builder.defineInRange("quantum_coprocessor_64m", 8192, 0, 81920);
            quantumCoProcessor_256m = builder.defineInRange("quantum_coprocessor_256m", 8192, 0, 81920);
            builder.pop();

            this.spec = builder.build();
        }

        public void onLoaded()
        {
            MekRadialChemicalCheckConfig.checkMode = checkMode.get();
        }
    }
}