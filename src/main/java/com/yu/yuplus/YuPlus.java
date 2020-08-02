package com.yu.yuplus;

import org.apache.logging.log4j.Logger;

import com.yu.yuplus.entity.EntityInitializer;

import net.minecraft.init.Blocks;
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
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        EntityInitializer.init();
        
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        
    }
}
