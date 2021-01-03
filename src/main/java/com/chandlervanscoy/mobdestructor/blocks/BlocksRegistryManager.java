package com.chandlervanscoy.mobdestructor.blocks;

import com.chandlervanscoy.mobdestructor.MobDestructor;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksRegistryManager {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MobDestructor.MODID);
    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Block> MOB_DESTRUCTOR = BLOCKS.register("mob_destructor", com.chandlervanscoy.mobdestructor.blocks.MobDestructor::new);
}
