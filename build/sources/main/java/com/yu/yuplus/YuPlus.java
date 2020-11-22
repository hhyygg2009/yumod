package com.yu.yuplus;

import com.yu.yuplus.proxy.CommonProxy;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.yu.yuplus.entity.EntityInitializer;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.sound.SoundSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecWav;
import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;



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



    


    
    
}
