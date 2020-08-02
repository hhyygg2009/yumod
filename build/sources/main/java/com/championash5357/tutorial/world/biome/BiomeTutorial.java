package com.championash5357.tutorial.world.biome;

import java.util.Random;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.init.TutorialBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeTutorial extends Biome {

	public BiomeTutorial() {
		super(new BiomeProperties("Tutorial").setBaseHeight(2.2F).setHeightVariation(.3F).setTemperature(.01F));
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.BEDROCK.getDefaultState();
		
		this.setRegistryName(Reference.MOD_ID, "tutorial");
		
		this.decorator.treesPerChunk = 5;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 95, 1, 10));
	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xff0000;
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) {
		return 0x00ff00;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 0x0000ff;
	}
	
	@Override
	public int getWaterColorMultiplier() {
		return 0xFFFF00;
	}
}
