package com.championash5357.tutorial.potion;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionFly extends Potion {

	public PotionFly() {
		super(false, 8376831);
		setPotionName("effect.fly");
		setIconIndex(0, 0);
		setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + "fly"));
	}
	
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/custom_effects.png"));
		return true;
	} 
}