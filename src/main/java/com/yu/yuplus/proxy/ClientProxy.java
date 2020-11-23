package com.yu.yuplus.proxy;


import com.yu.yuplus.YuPlus;
import com.yu.yuplus.entity.EntityInitializer;
import com.yu.yuplus.sound.ExtSoundManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
		System.setProperty("http.agent", "Chrome");

		YuPlus.logger = event.getModLog();
		EntityInitializer.init();

		YuPlus.logger.info(event.getModConfigurationDirectory().getPath());

		ExtSoundManager.getInstance();

	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

	}
	
	@Override
	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
	}
}
