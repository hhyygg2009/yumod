package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.item.ItemCutter;
import com.championash5357.tutorial.item.ItemFlyArmor;
import com.championash5357.tutorial.item.ItemModAxe;
import com.championash5357.tutorial.item.ItemNBTDye;
import com.championash5357.tutorial.item.ItemRock;
import com.championash5357.tutorial.item.ItemStrawberry;
import com.championash5357.tutorial.item.ItemStrawberrySeeds;
import com.championash5357.tutorial.item.ItemTutorialRecord;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;

@ObjectHolder(Reference.MOD_ID)
public class TutorialItems {
	
	public static class ToolMaterials {
		public static final ToolMaterial GARNET = EnumHelper.addToolMaterial("Garnet", 4, 2000, 15.0f, 6.0f, 64);
	}
	
	public static class ArmorMaterials {
		public static final ArmorMaterial FLYARMOR = EnumHelper.addArmorMaterial("FlyArmor", "tutorial:fly", 40, new int[]{1,5,3,1}, 20, SoundEvents.BLOCK_ANVIL_LAND, 0.0f);
	}
	
	public static final Item FLY_HELMET = new ItemFlyArmor(ArmorMaterials.FLYARMOR, 1, EntityEquipmentSlot.HEAD).setUnlocalizedName("fly_helmet").setRegistryName("itemflyhelmet");
	public static final Item FLY_CHESTPLATE = new ItemFlyArmor(ArmorMaterials.FLYARMOR, 1, EntityEquipmentSlot.CHEST).setUnlocalizedName("fly_chestplate").setRegistryName("itemflychestplate");
	public static final Item FLY_LEGGINGS = new ItemFlyArmor(ArmorMaterials.FLYARMOR, 2, EntityEquipmentSlot.LEGS).setUnlocalizedName("fly_leggings").setRegistryName("itemflyleggings");
	public static final Item FLY_BOOTS = new ItemFlyArmor(ArmorMaterials.FLYARMOR, 1, EntityEquipmentSlot.FEET).setUnlocalizedName("fly_boots").setRegistryName("itemflyboots");
	
	public static final Item GARNET_AXE = new ItemModAxe(ToolMaterials.GARNET, "garnet_axe", "itemgarnetaxe");;
	
	public static final Item STRAWBERRY_SEEDS = new ItemStrawberrySeeds(TutorialBlocks.STRAWBERRY_CROP, Blocks.FARMLAND);
	public static final Item STRAWBERRY = new ItemStrawberry(2, 1.0f, false);
	
	public static final Item ROCK = new ItemRock();
	
	public static final Item CUTTER = new ItemCutter();
	
	public static final ItemTutorialRecord PERSPECTIVES_RECORD = new ItemTutorialRecord("perspectives", TutorialMusic.PERSPECTIVES, "perspectives_record", "itemperspectivesrecord");
	
	public static final Item DYE = new ItemNBTDye();
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class ItemRegistration {
		public static final NonNullList<Item> ITEMS = NonNullList.<Item>create();
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] items = {
					CUTTER,
					FLY_BOOTS,
					FLY_CHESTPLATE,
					FLY_HELMET,
					FLY_LEGGINGS,
					GARNET_AXE,
					ROCK,
					STRAWBERRY,
					STRAWBERRY_SEEDS,
					PERSPECTIVES_RECORD
			};
			
			for(final Item item : items) {
				event.getRegistry().register(item);
				ITEMS.add(item);
			}
			
			event.getRegistry().register(DYE);
			
			registerOreDictionary();
		}
		
		private static void registerOreDictionary() {
			OreDictionary.registerOre("cutter", new ItemStack(TutorialItems.CUTTER, 1, OreDictionary.WILDCARD_VALUE));
		}
	}
}