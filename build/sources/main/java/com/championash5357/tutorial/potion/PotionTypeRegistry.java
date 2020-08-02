package com.championash5357.tutorial.potion;

import com.championash5357.tutorial.client.Tutorial;
import com.google.common.base.Predicate;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionTypeRegistry {

	public static final PotionType FLY = new PotionType("fly", new PotionEffect[] {new PotionEffect(Tutorial.FLY_POTION, 2400)}).setRegistryName("fly");
	public static final PotionType LONG_FLY = new PotionType("fly", new PotionEffect[] {new PotionEffect(Tutorial.FLY_POTION, 9600)}).setRegistryName("long_fly");
	
	public static void registerPotionTypes() {
		ForgeRegistries.POTION_TYPES.register(FLY);
		ForgeRegistries.POTION_TYPES.register(LONG_FLY);
		PotionHelper.addMix(PotionTypes.INVISIBILITY, Items.ENDER_EYE, FLY);
		PotionHelper.addMix(FLY, Items.REDSTONE, LONG_FLY);
	}
}