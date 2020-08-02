package com.championash5357.tutorial.item;

import com.championash5357.tutorial.init.TutorialBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStrawberry extends ItemFood{

	public ItemStrawberry(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName("strawberry");
		setRegistryName("itemstrawberry");
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		int side = facing.getIndex();
		
		switch(side) {
		case 0:
		default:
			y--;
			break;
		case 1:
			y++;
			break;
		case 2:
			z--;
			break;
		case 3:
			z++;
			break;
		case 4:
			x--;
			break;
		case 5:
			x++;
			break;
		}
		
		if(!player.canPlayerEdit(new BlockPos(x, y, z), facing, player.getHeldItem(hand))) {
			return EnumActionResult.FAIL;
		}
		
		IBlockState location = worldIn.getBlockState(new BlockPos(x, y, z));
		if(location == Blocks.AIR.getDefaultState()) {
			TutorialBlocks.PORTAL.trySpawnPortal(worldIn, new BlockPos(x, y, z));
		}
		player.getHeldItem(hand).shrink(1);
		return EnumActionResult.SUCCESS;
	}
}
