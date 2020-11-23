package com.yu.yuplus.item;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.creativetabs.YuTab;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = YuPlus.MODID)
public class ItemInitializer {
	public static Item littlestone;
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> eventRegister) {
		
		
		eventRegister.getRegistry().registerAll(
		littlestone = new LittleStoneItem()
			.setRegistryName(YuPlus.MODID+":"+"littlestone")
			.setCreativeTab(YuTab.getInstance())
			.setTranslationKey(YuPlus.MODID+"."+"littlestone")
		
		
		
		);
		
	};

}
@Mod.EventBusSubscriber(value = Side.CLIENT,modid = YuPlus.MODID)
 class ModelMapper {
	@SubscribeEvent
	public static void onModelReg(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(ItemInitializer.littlestone, 0, new ModelResourceLocation(ItemInitializer.littlestone.getRegistryName(),"inventory"));

		
//		ModelResourceLocation m=new ModelResourceLocation(ItemInitializer.littlestone.getRegistryName(),"inventory");
//		YuPlus.logger.info("111");
	}
	
}