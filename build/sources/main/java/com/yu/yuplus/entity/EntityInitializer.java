package com.yu.yuplus.entity;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.render.LittleStoneRender;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@EventBusSubscriber(modid = YuPlus.MODID)
public class EntityInitializer {
	

	
	@SubscribeEvent
	public static void onEntityRegistation(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().register(EntityEntryBuilder.create()
				.entity(RockSpawnerEntity.class)
				.id(new ResourceLocation(YuPlus.MODID, "rockspawner_entity"), 233)
				.name("rockspawner_entity")
				.tracker(80, 20, true)				
				.build()
			);
	}
		
	public  static void init()
	{
		EntityRegistry.registerModEntity(
				new ResourceLocation(YuPlus.MODID, "littlestone_entity"), LittleStoneEntity.class, "littlestone_entity", 1, YuPlus.instance, 64, 20, true);
		
//		GameRegistry.registerTileEntity(RockSpawnerEntity.class, new ResourceLocation(YuPlus.MODID,"rockspawnerentity"));
		
		RenderingRegistry.registerEntityRenderingHandler(LittleStoneEntity.class,LittleStoneRender.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(RockSpawnerEntity.class,EntityRender.FACTORY);

	}

}
