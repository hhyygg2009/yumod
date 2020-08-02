package com.yu.yuplus.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LittleStoneEntity extends EntityThrowable{

	public LittleStoneEntity(World worldIn, EntityLivingBase thowerIn) {
		super(worldIn, thowerIn);

	}

	@SideOnly(Side.CLIENT)
	public LittleStoneEntity(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);

	}

	public LittleStoneEntity(World worldIn) {
		super(worldIn);

	}

	@Override
	protected void onImpact(RayTraceResult result) {


		if (result.entityHit != null)
			if (!this.world.isRemote) {
				{
					int hit = 3;

					result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
							(float) hit);
					this.setDead();
				}

			}

	}

	@Override
	public void onUpdate() {

        EntityLivingBase entitylivingbase = this.getThrower();
        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }
        else
        {
            super.onUpdate();
        }
	}}
