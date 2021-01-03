package com.chandlervanscoy.mobdestructor;

import com.chandlervanscoy.mobdestructor.blocks.BlocksRegistryManager;
import com.chandlervanscoy.mobdestructor.items.ItemRegistryManager;
import com.chandlervanscoy.mobdestructor.tileentities.MobDestructorTileEntity;
import com.chandlervanscoy.mobdestructor.tileentities.TileEntityRegistryManager;
import com.chandlervanscoy.mobdestructor.tileentities.renderer.MobDestructorTileEntityRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mobdestructor")
public class MobDestructor {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "mobdestructor";

    public static final int TIME_PER_DESTRUCTION = 40;

    public MobDestructor() {
        BlocksRegistryManager.init();
        ItemRegistryManager.init();

        FMLJavaModLoadingContext.get().getModEventBus().register(TileEntityRegistryManager.class);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(MobDestructor::clientStartup);
    }

    public static void clientStartup(final FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(TileEntityRegistryManager.MOB_DESTRUCTOR, MobDestructorTileEntityRenderer::new);
    }
}
