package com.championash5357.tutorial.client;

import com.championash5357.tutorial.capability.TutorialCapability;
import com.championash5357.tutorial.enchantment.EnchantmentFly;
import com.championash5357.tutorial.entity.EntityRegistry;
import com.championash5357.tutorial.gui.TutorialGuiHandler;
import com.championash5357.tutorial.init.TutorialDimensions;
import com.championash5357.tutorial.init.TutorialFluids;
import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.potion.PotionFly;
import com.championash5357.tutorial.potion.PotionTypeRegistry;
import com.championash5357.tutorial.proxy.IProxy;
import com.championash5357.tutorial.render.RenderingRegistry;
import com.championash5357.tutorial.world.TutorialWorldGenerator;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Tutorial {
	
	@Instance(Reference.MOD_ID)
	public static Tutorial instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	public static final Enchantment FLY = new EnchantmentFly(Rarity.VERY_RARE, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
	public static final Potion FLY_POTION = new PotionFly();
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TutorialFluids.register();
		ForgeRegistries.ENCHANTMENTS.register(FLY);
		ForgeRegistries.POTIONS.register(FLY_POTION);
		PotionTypeRegistry.registerPotionTypes();
		RenderingRegistry.registerEntityRenders();
		TutorialCapability.register();
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new TutorialGuiHandler());
		EntityRegistry.registerEntities();
		GameRegistry.addSmelting(Items.LEATHER_HELMET, new ItemStack(TutorialItems.FLY_HELMET), 20.0f);
		GameRegistry.addSmelting(Items.LEATHER_CHESTPLATE, new ItemStack(TutorialItems.FLY_CHESTPLATE), 20.0f);
		GameRegistry.addSmelting(Items.LEATHER_LEGGINGS, new ItemStack(TutorialItems.FLY_LEGGINGS), 20.0f);
		GameRegistry.addSmelting(Items.LEATHER_BOOTS, new ItemStack(TutorialItems.FLY_BOOTS), 20.0f);
		ItemStack stack = new ItemStack(Items.DIAMOND_SWORD);
		stack.addEnchantment(Enchantment.getEnchantmentByLocation("fire_aspect"), 2);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, "fire_sword"), null, stack, Ingredient.fromItem(Items.DIAMOND_SWORD), Ingredient.fromItem(Items.BLAZE_POWDER));
		GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 0);
		TutorialDimensions.register();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		proxy.serverStarting(event);
	}
}