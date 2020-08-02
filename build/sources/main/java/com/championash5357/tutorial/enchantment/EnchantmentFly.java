package com.championash5357.tutorial.enchantment;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentFly extends Enchantment{

	public EnchantmentFly(Rarity rarityIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, EnumEnchantmentType.ARMOR_FEET, slots);
		this.setName("fly");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + "fly"));
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 30 * enchantmentLevel;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
}