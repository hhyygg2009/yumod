package com.championash5357.tutorial.world;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeadTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		boolean isAir = true;
		
		if(world.getBlockState(new BlockPos(x+2, y, z+2)).equals(Blocks.NETHERRACK.getDefaultState())) {
			
			for(int i = 0; i < 5; i++)
				for(int k = 0; k < 5; k++)
					for(int j = 1; j < 6; j++)
						if(!world.getBlockState(new BlockPos(x+i, y+j, z+k)).equals(Blocks.AIR.getDefaultState())) isAir = false;
			
			if(isAir) {
				world.setBlockState(new BlockPos(x+2, y+1, z+2), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA));
				world.setBlockState(new BlockPos(x+2, y+2, z+2), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA));
				world.setBlockState(new BlockPos(x+2, y+3, z+2), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA));
				
				world.setBlockState(new BlockPos(x+1, y+4, z+1), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, EnumAxis.X));
				world.setBlockState(new BlockPos(x+3, y+4, z+3), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, EnumAxis.X));
				world.setBlockState(new BlockPos(x, y+5, z), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, EnumAxis.X));
				world.setBlockState(new BlockPos(x+4, y+5, z+4), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, EnumAxis.X));
			}
		}
		
		return false;
	}
}
