package com.championash5357.tutorial.proxy;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {}

	@Override
	public void init(FMLInitializationEvent event) {}

	@Override
	public void postInit(FMLPostInitializationEvent event) {}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		
	}

	@Override
	public EntityPlayerMP getPlayerFromContext(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}

	@Override
	public WorldServer getWorldFromContext(MessageContext ctx) {
		return getPlayerFromContext(ctx).getServerWorld();
	}

	@Override
	public void addRunnableFromContext(MessageContext ctx, Runnable task) {
		getWorldFromContext(ctx).addScheduledTask(task);
	}
}
