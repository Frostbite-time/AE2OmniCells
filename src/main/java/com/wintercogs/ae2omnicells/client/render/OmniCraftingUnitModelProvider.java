package com.wintercogs.ae2omnicells.client.render;


import appeng.client.render.crafting.AbstractCraftingUnitModelProvider;
import appeng.client.render.crafting.LightBakedModel;
import appeng.client.render.crafting.MonitorBakedModel;
import appeng.client.render.crafting.UnitBakedModel;
import com.wintercogs.ae2omnicells.AE2OmniCells;
import com.wintercogs.ae2omnicells.common.me.crafting.OmniCraftingUnitType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class OmniCraftingUnitModelProvider extends AbstractCraftingUnitModelProvider<OmniCraftingUnitType>
{
    private static final List<Material> MATERIALS = new ArrayList<>();

    protected final static Material OMNI_RING_CORNER = texture("omni_ring_corner");
    protected final static Material OMNI_RING_SIDE_HOR = texture("omni_ring_side_hor");
    protected final static Material OMNI_RING_SIDE_VER = texture("omni_ring_side_ver");
    protected final static Material OMNI_UNIT_BASE = texture("omni_unit_base");
    protected final static Material OMNI_LIGHT_BASE = texture("omni_light_base");
    protected final static Material OMNI_MONITOR_BASE = texture("monitor/omni_monitor_base");

    protected final static Material COMPLEX_RING_CORNER = texture("complex_ring_corner");
    protected final static Material COMPLEX_RING_SIDE_HOR = texture("complex_ring_side_hor");
    protected final static Material COMPLEX_RING_SIDE_VER = texture("complex_ring_side_ver");
    protected final static Material COMPLEX_UNIT_BASE = texture("complex_unit_base");
    protected final static Material COMPLEX_LIGHT_BASE = texture("complex_light_base");
    protected final static Material COMPLEX_MONITOR_BASE = texture("monitor/complex_monitor_base");

    protected final static Material QUANTUM_RING_CORNER = texture("quantum_ring_corner");
    protected final static Material QUANTUM_RING_SIDE_HOR = texture("quantum_ring_side_hor");
    protected final static Material QUANTUM_RING_SIDE_VER = texture("quantum_ring_side_ver");
    protected final static Material QUANTUM_UNIT_BASE = texture("quantum_unit_base");
    protected final static Material QUANTUM_LIGHT_BASE = texture("quantum_light_base");
    protected final static Material QUANTUM_MONITOR_BASE = texture("monitor/quantum_monitor_base");

    protected final static Material STORAGE_1K_LIGHT = texture("light/1k_storage_light");
    protected final static Material STORAGE_4K_LIGHT = texture("light/4k_storage_light");
    protected final static Material STORAGE_16K_LIGHT = texture("light/16k_storage_light");
    protected final static Material STORAGE_64K_LIGHT = texture("light/64k_storage_light");
    protected final static Material STORAGE_256K_LIGHT = texture("light/256k_storage_light");
    protected final static Material STORAGE_1M_LIGHT = texture("light/1m_storage_light");
    protected final static Material STORAGE_4M_LIGHT = texture("light/4m_storage_light");
    protected final static Material STORAGE_16M_LIGHT = texture("light/16m_storage_light");
    protected final static Material STORAGE_64M_LIGHT = texture("light/64m_storage_light");
    protected final static Material STORAGE_256M_LIGHT = texture("light/256m_storage_light");

    protected final static Material MONITOR_LIGHT_DARK = texture(AE2OmniCells.AE2_MODID, "monitor_light_dark");
    protected final static Material MONITOR_LIGHT_MEDIUM = texture(AE2OmniCells.AE2_MODID, "monitor_light_medium");
    protected final static Material MONITOR_LIGHT_BRIGHT = texture(AE2OmniCells.AE2_MODID, "monitor_light_bright");

    public OmniCraftingUnitModelProvider(OmniCraftingUnitType type)
    {
        super(type);
    }

    @Override
    public List<Material> getMaterials()
    {
        return Collections.unmodifiableList(MATERIALS);
    }

    @Override
    public BakedModel getBakedModel(Function<Material, TextureAtlasSprite> spriteGetter)
    {
        Material ringCornerMaterial = switch (type.family)
        {
            case OMNI -> OMNI_RING_CORNER;
            case COMPLEX -> COMPLEX_RING_CORNER;
            case QUANTUM -> QUANTUM_RING_CORNER;
        };
        Material ringSideHorMaterial = switch (type.family)
        {
            case OMNI -> OMNI_RING_SIDE_HOR;
            case COMPLEX -> COMPLEX_RING_SIDE_HOR;
            case QUANTUM -> QUANTUM_RING_SIDE_HOR;
        };
        Material ringSideVerMaterial = switch (type.family)
        {
            case OMNI -> OMNI_RING_SIDE_VER;
            case COMPLEX -> COMPLEX_RING_SIDE_VER;
            case QUANTUM -> QUANTUM_RING_SIDE_VER;
        };
        Material unitMaterial = switch (type.family)
        {
            case OMNI -> OMNI_UNIT_BASE;
            case COMPLEX -> COMPLEX_UNIT_BASE;
            case QUANTUM -> QUANTUM_UNIT_BASE;
        };
        Material monitorMaterial = switch (type.family)
        {
            case OMNI -> OMNI_MONITOR_BASE;
            case COMPLEX -> COMPLEX_MONITOR_BASE;
            case QUANTUM -> QUANTUM_MONITOR_BASE;
        };
        TextureAtlasSprite ringCorner = spriteGetter.apply(ringCornerMaterial);
        TextureAtlasSprite ringSideHor = spriteGetter.apply(ringSideHorMaterial);
        TextureAtlasSprite ringSideVer = spriteGetter.apply(ringSideVerMaterial);

        return switch (type.storageType)
        {
            case UNIT -> new UnitBakedModel(ringCorner, ringSideHor, ringSideVer, spriteGetter.apply(unitMaterial));

            case MONITOR -> new MonitorBakedModel(ringCorner, ringSideHor, ringSideVer,
                    spriteGetter.apply(unitMaterial), spriteGetter.apply(monitorMaterial),
                    spriteGetter.apply(MONITOR_LIGHT_DARK),
                    spriteGetter.apply(MONITOR_LIGHT_MEDIUM),
                    spriteGetter.apply(MONITOR_LIGHT_BRIGHT));

            default ->
            {
                Material lightBaseMaterial = switch (type.family)
                {
                    case OMNI -> OMNI_LIGHT_BASE;
                    case COMPLEX -> COMPLEX_LIGHT_BASE;
                    case QUANTUM -> QUANTUM_LIGHT_BASE;
                };
                Material lightMaterial = switch (type.storageType)
                {
                    case STORAGE_1K -> STORAGE_1K_LIGHT;
                    case STORAGE_4K -> STORAGE_4K_LIGHT;
                    case STORAGE_16K -> STORAGE_16K_LIGHT;
                    case STORAGE_64K -> STORAGE_64K_LIGHT;
                    case STORAGE_256K -> STORAGE_256K_LIGHT;
                    case STORAGE_1M -> STORAGE_1M_LIGHT;
                    case STORAGE_4M -> STORAGE_4M_LIGHT;
                    case STORAGE_16M -> STORAGE_16M_LIGHT;
                    case STORAGE_64M -> STORAGE_64M_LIGHT;
                    case STORAGE_256M -> STORAGE_256M_LIGHT;
                    default -> throw new IllegalStateException("Unexpected value: " + type.storageType);
                };

                yield new LightBakedModel(
                        ringCorner, ringSideHor, ringSideVer,
                        spriteGetter.apply(lightBaseMaterial),
                        spriteGetter.apply(lightMaterial));
            }
        };
    }

    private static Material texture(String name)
    {
        Material mat = new Material(TextureAtlas.LOCATION_BLOCKS,
                AE2OmniCells.makeId("block/crafting/" + name));
        MATERIALS.add(mat);
        return mat;
    }

    private static Material texture(String namespace, String name)
    {
        Material mat = new Material(TextureAtlas.LOCATION_BLOCKS,
                new ResourceLocation(namespace, "block/crafting/" + name));
        MATERIALS.add(mat);
        return mat;
    }
}