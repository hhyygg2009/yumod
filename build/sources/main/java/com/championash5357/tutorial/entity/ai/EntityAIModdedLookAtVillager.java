package com.championash5357.tutorial.entity.ai;

import com.championash5357.tutorial.entity.EntityModdedIronGolem;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;

public class EntityAIModdedLookAtVillager extends EntityAIBase
{
    private final EntityModdedIronGolem ironGolem;
    private EntityVillager villager;
    private int lookTime;

    public EntityAIModdedLookAtVillager(EntityModdedIronGolem ironGolemIn)
    {
        this.ironGolem = ironGolemIn;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.ironGolem.world.isDaytime())
        {
            return false;
        }
        else if (this.ironGolem.getRNG().nextInt(8000) != 0)
        {
            return false;
        }
        else
        {
            this.villager = (EntityVillager)this.ironGolem.world.findNearestEntityWithinAABB(EntityVillager.class, this.ironGolem.getEntityBoundingBox().grow(6.0D, 2.0D, 6.0D), this.ironGolem);
            return this.villager != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        return this.lookTime > 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.lookTime = 400;
        this.ironGolem.setHoldingRose(true);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.ironGolem.setHoldingRose(false);
        this.villager = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        this.ironGolem.getLookHelper().setLookPositionWithEntity(this.villager, 30.0F, 30.0F);
        --this.lookTime;
    }
}