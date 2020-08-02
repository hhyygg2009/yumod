package com.championash5357.tutorial.init;

import com.championash5357.tutorial.world.dimension.WorldProviderTutorial;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class TutorialDimensions {
	
	public static final DimensionType TUTORIAL = DimensionType.register("Tutorial", "_tutorial", 2, WorldProviderTutorial.class, false);
	
	public static void register() {
		DimensionManager.registerDimension(2, TUTORIAL);
	}
}
