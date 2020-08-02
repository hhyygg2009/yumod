package com.yu.yuplus.entity;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.render.LittleStoneRender;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.registry.EntityRegistry;

//@EventBusSubscriber(modid = YuPlus.MODID)
public class EntityInitializer {
	

	
//	@SubscribeEvent
//	public static void onEntityRegistation(RegistryEvent.Register<EntityEntry> event) {
//		event.getRegistry().register(EntityEntryBuilder.create()
//				.entity(LittleStoneEntity.class)
//				.id(new ResourceLocation(YuPlus.MODID, "littlestone_entity"), 1)
//				.name("littlestone_entity")
//				.tracker(80, 20, true)				
//				.build()
//			);
//	}
		
	public  static void init()
	{
		EntityRegistry.registerModEntity(
				new ResourceLocation(YuPlus.MODID, "littlestone_entity"), LittleStoneEntity.class, "littlestone_entity", 1, YuPlus.instance, 64, 20, true);
		
		RenderingRegistry.registerEntityRenderingHandler(LittleStoneEntity.class,LittleStoneRender.FACTORY);
	}

}
