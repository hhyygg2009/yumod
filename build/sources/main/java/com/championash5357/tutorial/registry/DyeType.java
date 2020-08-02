package com.championash5357.tutorial.registry;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

@ObjectHolder(Reference.MOD_ID)
public class DyeType extends IForgeRegistryEntry.Impl<DyeType> {
	
	public static final DyeType WHITE = new DyeType("white");
	public static final DyeType ORANGE = new DyeType("orange");
	public static final DyeType MAGENTA = new DyeType("magenta");
	public static final DyeType LIGHT_BLUE = new DyeType("light_blue");
	public static final DyeType YELLOW = new DyeType("yellow");
	public static final DyeType LIME = new DyeType("lime");
	public static final DyeType PINK = new DyeType("pink");
	public static final DyeType GRAY = new DyeType("gray");
	public static final DyeType SILVER = new DyeType("silver");
	public static final DyeType CYAN = new DyeType("cyan");
	public static final DyeType PURPLE = new DyeType("purple");
	public static final DyeType BLUE = new DyeType("blue");
	public static final DyeType BROWN = new DyeType("brown");
	public static final DyeType GREEN = new DyeType("green");
	public static final DyeType RED = new DyeType("red");
	public static final DyeType BLACK = new DyeType("black");
	
	private final String name;
	
	public DyeType(String name) {
		this.name = name.toLowerCase();
		
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "dye." + this.name));
	}
	
	public String getName() {
		return this.name;
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class Register {
		
		@SubscribeEvent
		public static void create(RegistryEvent.NewRegistry event) {
			RegistryBuilder<DyeType> dye = new RegistryBuilder();
			dye.setType(DyeType.class);
			ResourceLocation key = new ResourceLocation(Reference.MOD_ID, "dyes");
			dye.setName(key);
			dye.setDefaultKey(key);
			dye.create();
		}
		
		@SubscribeEvent
		public static void add(final RegistryEvent.Register<DyeType> event) {
			final IForgeRegistry<DyeType> registry = event.getRegistry();
			
			final DyeType[] dyes = {
				WHITE,
				ORANGE,
				MAGENTA,
				LIGHT_BLUE,
				YELLOW,
				LIME,
				PINK,
				GRAY,
				SILVER,
				CYAN,
				PURPLE,
				BLUE,
				BROWN,
				GREEN,
				RED,
				BLACK
			};
			
			registry.registerAll(dyes);
		}
	}
}
