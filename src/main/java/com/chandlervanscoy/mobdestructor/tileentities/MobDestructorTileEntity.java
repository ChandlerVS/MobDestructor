package com.chandlervanscoy.mobdestructor.tileentities;

import com.chandlervanscoy.mobdestructor.MobDestructor;
import net.minecraft.entity.MobEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class MobDestructorTileEntity extends TileEntity implements ITickableTileEntity {
    @SuppressWarnings("FieldMayBeFinal")
    private long timePerDestruction = MobDestructor.TIME_PER_DESTRUCTION;
    private long nextDestruction = 0;

    public MobDestructorTileEntity() {
        super(TileEntityRegistryManager.MOB_DESTRUCTOR);
        nextDestruction = (this.world != null ? this.world.getGameTime() : 0) + timePerDestruction;
    }


    @Override
    public void tick() {
        if (this.world != null && !this.world.isRemote && this.world.getGameTime() >= nextDestruction) {
            int x1 = this.pos.getX() - 5;
            int y1 = this.pos.getY() - 5;
            int z1 = this.pos.getZ() - 5;

            int x2 = this.pos.getX() + 5;
            int y2 = this.pos.getY() + 5;
            int z2 = this.pos.getZ() + 5;

            List<? extends MobEntity> mobs = this.world.getEntitiesWithinAABB(MobEntity.class, new AxisAlignedBB(x1, y1, z1, x2, y2, z2));
            for (MobEntity entity : mobs) {
                entity.attackEntityFrom(DamageSource.GENERIC, 9999);
            }

            nextDestruction = this.world.getGameTime() + timePerDestruction;
        }
    }
}
