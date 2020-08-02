package com.championash5357.tutorial.block;

import com.championash5357.tutorial.tileentity.TileEntityStonePedestal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStonePedestal extends Block {

	public BlockStonePedestal() {
		super(Material.ROCK);
		this.setHardness(3.0f);
		this.setResistance(3.0f);
		this.setRegistryName("stone_pedestal");
		this.setUnlocalizedName("blockstonepedestal");
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityStonePedestal pedestal = (TileEntityStonePedestal) worldIn.getTileEntity(pos);
		if(playerIn.getHeldItem(hand).isEmpty()) {
			ItemStack stack = pedestal.removeItemStack();
			playerIn.addItemStackToInventory(stack);
			return stack.isEmpty() ? false : true;
		} else if(playerIn.getHeldItem(hand).getItem() instanceof ItemSword) {
			int angle = (int) Math.abs(Math.round(playerIn.getRotatedYaw(Rotation.CLOCKWISE_180) / 45.0));
			boolean works = pedestal.setItemStack(playerIn.getHeldItem(hand), angle == 8 ? 0 : angle);
			return works ? true : false;
		}
		return false;
	}
	
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack) {
		TileEntityStonePedestal pedestal = (TileEntityStonePedestal) te;
		if(!worldIn.isRemote) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), pedestal.removeItemStack()));
		
		super.harvestBlock(worldIn, player, pos, state, te, stack);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return new AxisAlignedBB(0, 0, 0, 1, .5, 1);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityStonePedestal();
	}
}
