package com.championash5357.tutorial.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public interface IProxy {
	
	void preInit(FMLPreInitializationEvent event);
	
	void init(FMLInitializationEvent event);
	
	void postInit(FMLPostInitializationEvent event);
	
	void serverStarting(FMLServerStartingEvent event);
	
	<T extends EntityPlayer> T getPlayerFromContext(MessageContext ctx);
	
	<T extends World> T getWorldFromContext(MessageContext ctx);
	
	void addRunnableFromContext(MessageContext ctx, Runnable task);
}
