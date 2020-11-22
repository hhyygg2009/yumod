package com.yu.yuplus.block;

import java.util.List;
import java.util.Random;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.entity.RockSpawnerEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Chat;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RockSpanwer extends Block{



	public RockSpanwer() {
		super(Material.ROCK,MapColor.LIGHT_BLUE);
		setTickRandomly(true);
		setHardness(1f);
		
		
	}


	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote){
			YuPlus.logger.info("clicked blk");

		}
//		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		return false;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
//		super.updateTick(worldIn, pos, state, rand);
//		int x= pos.getX()+rand.nextInt(20)-10;
//		int z=pos.getZ()+rand.nextInt(20)-10;
//		int y=worldIn.getHeight(x,z);

				
		List<Entity> entitysList=worldIn.getEntitiesWithinAABB(RockSpawnerEntity.class, new AxisAlignedBB(pos.up(15).east(15).north(15), pos.down(15).west(15).south(15)));
//		YuPlus.logger.info("a");
		if(entitysList.size()<=3) {
			YuPlus.logger.info("b");
			int x,y,z;
		do {
			YuPlus.logger.info("c");
			 x= pos.getX()+rand.nextInt(20)-10;
			 z=pos.getZ()+rand.nextInt(20)-10;
			 y=worldIn.getHeight(x,z);
		}while(!canSpawn(worldIn, x, y-1, z));		
			
			RockSpawnerEntity rockSpawnerEntity=new RockSpawnerEntity(worldIn,x,y,z);			
			YuPlus.logger.info("spawn:"+worldIn.spawnEntity(rockSpawnerEntity)+"total:"+entitysList.size());				
		}
		
	}
	
    private boolean canSpawn(World world, int x, int y, int z) {    	
        Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
        YuPlus.logger.debug(block.getTranslationKey());
        return block == Blocks.STONE || block == Blocks.GRAVEL || block == Blocks.GRASS || block == Blocks.DIRT;
    }

}
