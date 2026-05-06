package com.wintercogs.ae2omnicells.client.render;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ResolvableModel;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;
import org.jetbrains.annotations.NotNull;

public final class OmniCraftingCubeModel
{
    private OmniCraftingCubeModel()
    {
    }

    public record Unbaked(OmniCraftingUnitType type) implements CustomUnbakedBlockStateModel
    {
        public static final Identifier ID = AE2OmniCells.makeId("crafting_cube");
        public static final MapCodec<Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                OmniCraftingUnitType.CODEC.fieldOf("unit_type").forGetter(Unbaked::type)
        ).apply(instance, Unbaked::new));

        @Override
        public @NotNull BlockStateModel bake(ModelBaker baker)
        {
            return new OmniCraftingUnitModelProvider(this.type).bake(baker.materials());
        }

        @Override
        public void resolveDependencies(ResolvableModel.@NotNull Resolver resolver)
        {
        }

        @Override
        public @NotNull MapCodec<? extends CustomUnbakedBlockStateModel> codec()
        {
            return MAP_CODEC;
        }
    }
}
