package com.chandlervanscoy.mobdestructor.blocks;

import com.chandlervanscoy.mobdestructor.tileentities.MobDestructorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class MobDestructor extends Block {
    public MobDestructor() {
        super(Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MobDestructorTileEntity();
    }
}
