package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.world.biome.BiomeTutorial;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Reference.MOD_ID)
public class TutorialBiomes {
	
	public static final Biome TUTORIAL = new BiomeTutorial();
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class Register {
		
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
			final Biome[] biomes = {
					TUTORIAL
			};
			
			event.getRegistry().registerAll(biomes);
			
			spawnBiomes();
		}
		
		private static void spawnBiomes() {
			BiomeManager.addBiome(BiomeType.COOL, new BiomeManager.BiomeEntry(TUTORIAL, 50));
			BiomeManager.addSpawnBiome(TUTORIAL);
		}
	}
}
