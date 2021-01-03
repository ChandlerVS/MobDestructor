package com.chandlervanscoy.mobdestructor.items;

import com.chandlervanscoy.mobdestructor.MobDestructor;
import com.chandlervanscoy.mobdestructor.blocks.BlocksRegistryManager;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistryManager {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MobDestructor.MODID);
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> MOB_DESTRUCTOR = ITEMS.register("mob_destructor", () -> new BlockItem(BlocksRegistryManager.MOB_DESTRUCTOR.get(), new Item.Properties().group(ItemGroup.COMBAT)));
}
