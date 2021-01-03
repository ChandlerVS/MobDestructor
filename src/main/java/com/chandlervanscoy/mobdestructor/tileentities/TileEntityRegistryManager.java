package com.chandlervanscoy.mobdestructor.tileentities;

import com.chandlervanscoy.mobdestructor.MobDestructor;
import com.chandlervanscoy.mobdestructor.blocks.BlocksRegistryManager;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistryManager {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MobDestructor.MODID);

    public static void init() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static TileEntityType<MobDestructorTileEntity> MOB_DESTRUCTOR;

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> evt) {
        MOB_DESTRUCTOR = TileEntityType.Builder.create(MobDestructorTileEntity::new, BlocksRegistryManager.MOB_DESTRUCTOR.get()).build(null);
        MOB_DESTRUCTOR.setRegistryName(MobDestructor.MODID, "mob_destroyer");
        evt.getRegistry().register(MOB_DESTRUCTOR);
    }
}
