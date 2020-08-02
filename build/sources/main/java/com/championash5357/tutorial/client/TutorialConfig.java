package com.championash5357.tutorial.client;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.RequiresWorldRestart;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = Reference.MOD_ID, name = "tutorial_config", type = Type.INSTANCE)
public class TutorialConfig {
	
	@Name("String Key")
	@Comment("This string is just a placeholder to explain what config comments are.")
	public static String string_tut = "forever";
	
	public static Ranges ranges = new Ranges();
	
	public static class Ranges {
		@RangeInt(min = 5, max = 20)
		public int range_value = 10;
		
		@RangeDouble(min = 5.0123, max = 24.12390)
		public double doub_value = 10;
		
		public SubSub sub = new SubSub();
		
		public class SubSub {
			
		}
	}

	@Name("Ore Gen")
	@RequiresWorldRestart
	public static boolean ore_gen = true;
	
	@LangKey("config.is_mod")
	@RequiresMcRestart
	public static boolean is_mod = false;
}
