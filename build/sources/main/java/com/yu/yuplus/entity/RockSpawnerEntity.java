package com.yu.yuplus.entity;


import com.yu.yuplus.YuPlus;
import com.yu.yuplus.item.ItemInitializer;
import com.yu.yuplus.item.LittleStoneItem;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class RockSpawnerEntity extends Entity {
	private static final DataParameter<ItemStack> ITEM = EntityDataManager.createKey(RockSpawnerEntity.class, DataSerializers.ITEM_STACK);

	RockSpawnerEntity(World worldIn){
        super(worldIn);
        this.setSize(0.25F, 0.25F);
        this.setItem(ItemStack.EMPTY);
//        YuPlus.logger.info("loadempty");
	}
	
	private int age = 6000;
	
	
	public RockSpawnerEntity(World worldIn,double x,double y,double z) {
		super(worldIn);
        this.setSize(0.25F, 0.25F);
        this.setPosition(x, y, z);
        this.rotationYaw = (float) (Math.random() * 360.0D);
        this.motionX = (float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        YuPlus.logger.info("load");
        setItem(new ItemStack(Blocks.GRAVEL));        
	}
	
	public RockSpawnerEntity(World worldIn,double x,double y,double z,ItemStack itemStack) {
		this(worldIn, x, y, z);
        this.setItem(itemStack);
        itemStack.getItem();
	}
	
	
	public void setItem(ItemStack stack) {
        this.getDataManager().set(ITEM, stack);
        this.getDataManager().setDirty(ITEM);
	}
	
    public ItemStack getItem() {
        return this.getDataManager().get(ITEM);
    }

	@Override
	protected void entityInit() {
		this.getDataManager().register(ITEM, ItemStack.EMPTY);
		
	}
	
    @Override
    public boolean canBePushed() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    //右键掉落
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand) {
        return dropItem();
    }
    //攻击掉落
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!(source.getTrueSource() instanceof EntityPlayer)) return false;
        return dropItem();
    }
    

    
public boolean dropItem() {
        if (!world.isRemote) {
            ItemStack itemStack = this.getItem();
            Block block = Block.getBlockFromItem(this.getItem().getItem());
            if (block == Blocks.STONE || block == Blocks.GRAVEL) itemStack = new ItemStack(ItemInitializer.littlestone);
            this.entityDropItem(itemStack, 0);
            this.setDead();
        }
        return true;
    }
	
    

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	if (this.ticksExisted > age) this.setDead();
        if (this.getItem().isEmpty())
        {
            this.setDead();
        }
        else
        {
            super.onUpdate();

            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            double d0 = this.motionX;
            double d1 = this.motionY;
            double d2 = this.motionZ;

            if (!this.hasNoGravity())
            {
                this.motionY -= 0.03999999910593033D;
            }

            if (this.world.isRemote)
            {
                this.noClip = false;
            }
            else
            {
                this.noClip = this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0D, this.posZ);
            }

            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            boolean flag = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;

            if (flag || this.ticksExisted % 25 == 0)
            {
                if (this.world.getBlockState(new BlockPos(this)).getMaterial() == Material.LAVA)
                {
                    this.motionY = 0.20000000298023224D;
                    this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F;
                    this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F;
                    this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
                }

            }

            float f = 0.98F;

            if (this.onGround)
            {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                net.minecraft.block.state.IBlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.98F;
            }

            this.motionX *= f;
            this.motionY *= 0.9800000190734863D;
            this.motionZ *= f;

            if (this.onGround)
            {
                this.motionY *= -0.5D;
            }

            this.handleWaterMovement();

            if (!this.world.isRemote)
            {
                double d3 = this.motionX - d0;
                double d4 = this.motionY - d1;
                double d5 = this.motionZ - d2;
                double d6 = d3 * d3 + d4 * d4 + d5 * d5;

                if (d6 > 0.01D)
                {
                    this.isAirBorne = true;
                }
            }

            ItemStack item = this.getItem();

            if (item.isEmpty())
            {
                this.setDead();
            }
        }
    }

//	@Override
//	protected void readEntityFromNBT(NBTTagCompound compound) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected void writeEntityToNBT(NBTTagCompound compound) {
//		// TODO Auto-generated method stub
//		
//	}




    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        if (!this.getItem().isEmpty()) {
            compound.setTag("Item", this.getItem().writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        NBTTagCompound nbttagcompound = compound.getCompoundTag("Item");
        this.setItem(new ItemStack(nbttagcompound));

        if (this.getItem().isEmpty()) {
            this.setDead();
        }
    }

}
