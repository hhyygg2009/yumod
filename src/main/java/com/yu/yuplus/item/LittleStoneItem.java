package com.yu.yuplus.item;

import com.yu.yuplus.entity.LittleStoneEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class LittleStoneItem extends Item {

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            LittleStoneEntity littleStoneEntity = new LittleStoneEntity(worldIn, playerIn);
            littleStoneEntity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 1.5f, 1.0f);
            worldIn.spawnEntity(littleStoneEntity);
        }


        itemStack.shrink(1);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

}
