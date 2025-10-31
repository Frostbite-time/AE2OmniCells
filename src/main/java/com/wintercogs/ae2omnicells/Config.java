package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.common.config.MekRadialChemicalCheck;
import com.wintercogs.ae2omnicells.common.config.MekRadialChemicalCheckConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
    public final Config.StartUpConfig startUpConfig = new Config.StartUpConfig();
    public final Config.CommonConfig commonConfig = new Config.CommonConfig();

    public static Config INSTANCE;

    private Config(ModContainer container)
    {
        container.registerConfig(ModConfig.Type.STARTUP, startUpConfig.spec);
        container.registerConfig(ModConfig.Type.COMMON, commonConfig.spec);
        container.getEventBus().addListener((ModConfigEvent.Loading evt) ->
        {
            if (evt.getConfig().getSpec() == commonConfig.spec)
            {
                commonConfig.onLoaded();
            }
        });
        container.getEventBus().addListener((ModConfigEvent.Reloading evt) ->
        {
            if (evt.getConfig().getSpec() == commonConfig.spec)
            {
                commonConfig.onLoaded();
            }
        });
    }

    public static void register(ModContainer container)
    {
        INSTANCE = new Config(container);
    }

    public static class StartUpConfig
    {
        public final ModConfigSpec spec;

        // 三系cpu并行值
        public final ModConfigSpec.IntValue omniCoProcessor_1k;
        public final ModConfigSpec.IntValue omniCoProcessor_4k;
        public final ModConfigSpec.IntValue omniCoProcessor_16k;
        public final ModConfigSpec.IntValue omniCoProcessor_64k;
        public final ModConfigSpec.IntValue omniCoProcessor_256k;
        public final ModConfigSpec.IntValue omniCoProcessor_1m;
        public final ModConfigSpec.IntValue omniCoProcessor_4m;
        public final ModConfigSpec.IntValue omniCoProcessor_16m;
        public final ModConfigSpec.IntValue omniCoProcessor_64m;
        public final ModConfigSpec.IntValue omniCoProcessor_256m;
        public final ModConfigSpec.IntValue complexCoProcessor_1k;
        public final ModConfigSpec.IntValue complexCoProcessor_4k;
        public final ModConfigSpec.IntValue complexCoProcessor_16k;
        public final ModConfigSpec.IntValue complexCoProcessor_64k;
        public final ModConfigSpec.IntValue complexCoProcessor_256k;
        public final ModConfigSpec.IntValue complexCoProcessor_1m;
        public final ModConfigSpec.IntValue complexCoProcessor_4m;
        public final ModConfigSpec.IntValue complexCoProcessor_16m;
        public final ModConfigSpec.IntValue complexCoProcessor_64m;
        public final ModConfigSpec.IntValue complexCoProcessor_256m;
        public final ModConfigSpec.IntValue quantumCoProcessor_1k;
        public final ModConfigSpec.IntValue quantumCoProcessor_4k;
        public final ModConfigSpec.IntValue quantumCoProcessor_16k;
        public final ModConfigSpec.IntValue quantumCoProcessor_64k;
        public final ModConfigSpec.IntValue quantumCoProcessor_256k;
        public final ModConfigSpec.IntValue quantumCoProcessor_1m;
        public final ModConfigSpec.IntValue quantumCoProcessor_4m;
        public final ModConfigSpec.IntValue quantumCoProcessor_16m;
        public final ModConfigSpec.IntValue quantumCoProcessor_64m;
        public final ModConfigSpec.IntValue quantumCoProcessor_256m;

        public StartUpConfig()
        {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

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
    }

    public static class CommonConfig
    {
        public final ModConfigSpec spec;

        public final ModConfigSpec.EnumValue<MekRadialChemicalCheck> checkMode;

        public CommonConfig()
        {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

            checkMode = builder
                    .comment("是否允许OMNI系列元件存入MEK的放射性化学品，DENY_SPENT代表仅阻止用尽的核废料，其余为字面意思")
                    .defineEnum("mek_radial_chemical_check", MekRadialChemicalCheck.DENY_SPENT);

            this.spec = builder.build();
        }

        public void onLoaded()
        {
            MekRadialChemicalCheckConfig.checkMode = checkMode.get();
        }
    }
}