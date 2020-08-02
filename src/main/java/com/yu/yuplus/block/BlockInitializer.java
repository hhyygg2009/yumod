package com.yu.yuplus.block;


import com.yu.yuplus.YuPlus;
import com.yu.yuplus.creativetabs.YuTab;
import com.yu.yuplus.entity.RockSpawnerEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
@Mod.EventBusSubscriber(modid = YuPlus.MODID)
public class BlockInitializer {
	public static Block rockspawner;
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(
				rockspawner=new RockSpanwer()
				.setRegistryName(YuPlus.MODID,"rockspawner")
				.setCreativeTab(YuTab.getInstance())
				.setTranslationKey(YuPlus.MODID+"."+"rockspawner")
				);
//		GameRegistry.registerTileEntity(RockSpawnerEntity.class, new ResourceLocation(YuPlus.MODID,"rockspawnerentity"));
		
	}
	
	public static Item rockspawneritem;
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(
				rockspawneritem=new ItemBlock(rockspawner)
				.setRegistryName(YuPlus.MODID,"rockspawner"));
				
	}
	
		
	
	
	
	
	
}


@Mod.EventBusSubscriber(value = Side.CLIENT,modid = YuPlus.MODID)
 class ModelMapper {
	@SubscribeEvent
	public static void onModelReg(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(BlockInitializer.rockspawneritem, 0, new ModelResourceLocation(BlockInitializer.rockspawneritem.getRegistryName(),"inventory"));
	}
	
}