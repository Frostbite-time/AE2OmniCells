package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.common.config.MekRadialChemicalCheck;
import com.wintercogs.ae2omnicells.common.config.MekRadialChemicalCheckConfig;
import com.wintercogs.ae2omnicells.common.config.OmniCoProcessorConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;


public class Config
{
    public final Config.CommonConfig commonConfig = new Config.CommonConfig();

    public static Config INSTANCE;

    private Config(ModLoadingContext container, IEventBus modEventBus)
    {
        container.registerConfig(ModConfig.Type.COMMON, commonConfig.spec);
        modEventBus.addListener((ModConfigEvent.Loading evt) ->
        {
            if (evt.getConfig().getSpec() == commonConfig.spec)
            {
                commonConfig.onLoaded();
            }
        });
        modEventBus.addListener((ModConfigEvent.Reloading evt) ->
        {
            if (evt.getConfig().getSpec() == commonConfig.spec)
            {
                commonConfig.onReloaded();
            }
        });
    }

    public static void register(ModLoadingContext container, IEventBus modEventBus)
    {
        INSTANCE = new Config(container, modEventBus);
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
                    .defineEnum("mek_radial_chemical_check", MekRadialChemicalCheck.DENY_SPENT);

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

            OmniCoProcessorConfig.omni_1k = omniCoProcessor_1k.get();
            OmniCoProcessorConfig.omni_4k = omniCoProcessor_4k.get();
            OmniCoProcessorConfig.omni_16k = omniCoProcessor_16k.get();
            OmniCoProcessorConfig.omni_64k = omniCoProcessor_64k.get();
            OmniCoProcessorConfig.omni_256k = omniCoProcessor_256k.get();
            OmniCoProcessorConfig.omni_1m = omniCoProcessor_1m.get();
            OmniCoProcessorConfig.omni_4m = omniCoProcessor_4m.get();
            OmniCoProcessorConfig.omni_16m = omniCoProcessor_16m.get();
            OmniCoProcessorConfig.omni_64m = omniCoProcessor_64m.get();
            OmniCoProcessorConfig.omni_256m = omniCoProcessor_256m.get();
            OmniCoProcessorConfig.complex_1k = complexCoProcessor_1k.get();
            OmniCoProcessorConfig.complex_4k = complexCoProcessor_4k.get();
            OmniCoProcessorConfig.complex_16k = complexCoProcessor_16k.get();
            OmniCoProcessorConfig.complex_64k = complexCoProcessor_64k.get();
            OmniCoProcessorConfig.complex_256k = complexCoProcessor_256k.get();
            OmniCoProcessorConfig.complex_1m = complexCoProcessor_1m.get();
            OmniCoProcessorConfig.complex_4m = complexCoProcessor_4m.get();
            OmniCoProcessorConfig.complex_16m = complexCoProcessor_16m.get();
            OmniCoProcessorConfig.complex_64m = complexCoProcessor_64m.get();
            OmniCoProcessorConfig.complex_256m = complexCoProcessor_256m.get();
            OmniCoProcessorConfig.quantum_1k = quantumCoProcessor_1k.get();
            OmniCoProcessorConfig.quantum_4k = quantumCoProcessor_4k.get();
            OmniCoProcessorConfig.quantum_16k = quantumCoProcessor_16k.get();
            OmniCoProcessorConfig.quantum_64k = quantumCoProcessor_64k.get();
            OmniCoProcessorConfig.quantum_256k = quantumCoProcessor_256k.get();
            OmniCoProcessorConfig.quantum_1m = quantumCoProcessor_1m.get();
            OmniCoProcessorConfig.quantum_4m = quantumCoProcessor_4m.get();
            OmniCoProcessorConfig.quantum_16m = quantumCoProcessor_16m.get();
            OmniCoProcessorConfig.quantum_64m = quantumCoProcessor_64m.get();
            OmniCoProcessorConfig.quantum_256m = quantumCoProcessor_256m.get();
        }

        public void onReloaded()
        {
            MekRadialChemicalCheckConfig.checkMode = checkMode.get();
        }
    }
}