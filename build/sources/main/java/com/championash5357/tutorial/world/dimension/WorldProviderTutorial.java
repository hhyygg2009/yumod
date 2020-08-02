package com.championash5357.tutorial.world.dimension;

import com.championash5357.tutorial.init.TutorialBiomes;
import com.championash5357.tutorial.init.TutorialDimensions;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderTutorial extends WorldProvider {
	
	@Override
	protected void init() {
		this.biomeProvider = new BiomeProviderSingle(TutorialBiomes.TUTORIAL);
		this.hasSkyLight = true;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return TutorialDimensions.TUTORIAL;
	}
	
	@Override
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.1803921568627451, 0.0313725490196078, 0.3294117647058824);
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return super.canCoordinateBeSpawn(x, z);
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	@Override
	public boolean doesXZShowFog(int x, int z) {
		return Math.abs(x) <= 256 && Math.abs(z) <= 256;
	}
	
	@Override
	public WorldBorder createWorldBorder() {
		return new WorldBorder() {
			
			@Override
			public double getCenterX() {
				return super.getCenterX() / 256.0D;
			}
			
			@Override
			public double getCenterZ() {
				return super.getCenterZ() / 256.0D;
			}
		};
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorTutorial(world, true, this.getSeed());
	}
}
