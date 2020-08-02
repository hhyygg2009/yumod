package com.championash5357.tutorial.entity;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.client.Tutorial;

import net.minecraft.util.ResourceLocation;

public class EntityRegistry {
	public static void registerEntities() {
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":rock"), EntityRock.class, "Rock", -1, Tutorial.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":modded_iron_golem"), EntityModdedIronGolem.class, "Modded Iron Golem", -2, Tutorial.instance, 64, 1, true, 0xF52A35, 0x589BCD);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":tnt_primed_10x10"), Entity10x10TNTPrimed.class, "10x10 Tnt Primed", -3, Tutorial.instance, 64, 1, true);
	}
}
