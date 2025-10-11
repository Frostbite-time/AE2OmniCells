package com.wintercogs.ae2omnicells;

import com.wintercogs.ae2omnicells.client.me.AE2ClientPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

import java.nio.file.Path;

public class AE2OmniCellsClient
{
    public static void clientInit()
    {

    }

    public static void clientCommonSetup()
    {
        AE2ClientPlugin.register();
    }

    public static void clientRegister(IEventBus modBus, IEventBus gameBus)
    {
        AE2ClientPlugin.registerStorageLED(modBus);
        modBus.addListener(AE2OmniCellsClient::onAddPackFinders);
    }

    public static void onAddPackFinders(AddPackFindersEvent event)
    {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

        var modFileInfo = ModList.get().getModFileById(AE2OmniCells.MODID);
        if (modFileInfo == null) return;

        Path packRoot = modFileInfo.getFile().findResource("resourcepacks/optional_textures"); // 指向包含 pack.mcmeta 的目录

        // 关键：直接提供 ResourcesSupplier（用 PathPackResources 构造包）
        Pack.ResourcesSupplier supplier = (name) -> new PathPackResources(name, packRoot, /* isBuiltin = */ false);

        Pack pack = Pack.readMetaAndCreate(
                AE2OmniCells.MODID + ":optional_textures",
                Component.translatable("pack." + AE2OmniCells.MODID + ".optional_textures.title"),
                /* required = */ false,
                supplier,
                PackType.CLIENT_RESOURCES,
                Pack.Position.TOP,
                PackSource.BUILT_IN
        );

        if (pack != null)
        {
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }
    }
}
