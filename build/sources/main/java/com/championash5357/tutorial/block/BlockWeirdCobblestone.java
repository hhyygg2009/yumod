package com.championash5357.tutorial.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockWeirdCobblestone extends Block {
	
	private Random random = new Random();
	private int solution;
	
	public BlockWeirdCobblestone() {
		super(Material.ROCK, MapColor.GRAY);
		setUnlocalizedName("weird_cobblestone");
		setRegistryName("blockweirdcobblestone");
		setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		solution = random.nextInt(4);
		if(!worldIn.isRemote) {
			switch(solution) {
			case 0:
				EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND));
				worldIn.spawnEntity(item);
				break;
			case 1:
				worldIn.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
				break;
			case 2:
				worldIn.setSpawnPoint(pos);
				worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 9.0d, false).sendMessage(new TextComponentString("Spawn point set!"));
				break;
			case 3:
				EntityDragon dragon = new EntityDragon(worldIn);
				dragon.setLocationAndAngles(pos.getX(), pos.getY() + 10, pos.getZ(), 159, 62);
				worldIn.spawnEntity(dragon);
				break;
			default:
				worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 9.0d, false).sendMessage(new TextComponentString("Looks like you got the short end of the stick bub!"));
			}
		}
	}
}
