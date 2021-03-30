package com.yu.yuplus;

import com.yu.yuplus.proxy.CommonProxy;
import com.yu.yuplus.sound.command.ExtSoundCommand;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = YuPlus.MODID, name = YuPlus.NAME, version = YuPlus.VERSION)
public class YuPlus
{
    public static final String MODID = "yuplus";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    public static Logger logger;
    
    @Instance("yuplus")
	public static YuPlus instance;

    @SidedProxy(serverSide = "com.yu.yuplus.proxy.CommonProxy",clientSide = "com.yu.yuplus.proxy.ClientProxy")
    private static CommonProxy proxy;
    


    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preinit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postinit(event);
    }

    @EventHandler
    public static void registerCommands(FMLServerStartingEvent event){
        YuPlus.logger.info("registercommand");
        event.registerServerCommand(new ExtSoundCommand());
    }

    


    
    
}
