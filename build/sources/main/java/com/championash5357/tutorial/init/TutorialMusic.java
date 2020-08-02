package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Reference.MOD_ID)
public class TutorialMusic {
	
	public static final SoundEvent PERSPECTIVES = new SoundEvent(new ResourceLocation(Reference.MOD_ID, "perspectives")).setRegistryName(new ResourceLocation(Reference.MOD_ID, "perspectives"));
	
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class SoundEventRegistration {
		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
			final SoundEvent[] sounds = {
					PERSPECTIVES
			};
			
			event.getRegistry().registerAll(sounds);
		}
	}
}
