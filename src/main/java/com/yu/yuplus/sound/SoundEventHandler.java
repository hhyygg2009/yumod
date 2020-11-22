package com.yu.yuplus.sound;

import com.yu.yuplus.YuPlus;

import de.cuina.fireandfuel.CodecJLayerMP3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundSourceEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.client.event.sound.SoundSetupEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecWav;


import java.net.MalformedURLException;
import java.net.URL;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = YuPlus.MODID)
public class SoundEventHandler {
    private static final float DEFAULT_VOLUME = 1.0f;
    private static final float DEFAULT_DISTANCE = 16.0f;
    private static final String DEFAULT_FORMAT = "mp3";



    private static boolean stopBuildInMusic=true;

    @SubscribeEvent
    public static void onSoundSetup(SoundSetupEvent event) {
        try {
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            SoundSystemConfig.setCodec("mp3", CodecJLayerMP3.class);
            YuPlus.logger.info("Loaded Codec");
            
        } catch (SoundSystemException e) {
            e.printStackTrace();
        }
    }
    
    @SubscribeEvent
    public static void onPlaySoundEvent(PlaySoundEvent event)
    {
//      记录音乐事件名称
    	YuPlus.logger.info("PlaySoundEvent:"+
    			"name:"+event.getName()+
    			",sound:"+event.getSound());

//	    移除原版音乐
        if(stopBuildInMusic&&event.getName().startsWith("music")&&ExtSoundManager.getInstance().isSongPlaying()){
            event.setResultSound(null);
        }


    }


    //女仆mod
    @SubscribeEvent
    public static void onPlaySoundSourceEvent(PlaySoundSourceEvent event) {
        YuPlus.logger.info("PlaySoundSourceEvent:"+
                event.getName());

        ISound sound = event.getSound();

//        EntityPlayerSP sp=Minecraft.getMinecraft().player;
//        if(sp!=null){
//            sp.sendChatMessage(event.getName()+"volume:"+sound.getVolume());
//        }

        if (sound instanceof ExtSound) {
            YuPlus.logger.info("play2");

            String songLocation = ((ExtSound) sound).getSongLocation();

            float volume = sound.getVolume();
            float distance = DEFAULT_DISTANCE;
            if (volume > DEFAULT_VOLUME) {
                distance *= volume;
            }
            boolean soundCanRepeat = sound.canRepeat() && sound.getRepeatDelay() == 0;
            try {
//                event.getManager().sndSystem.newStreamingSource(false, event.getUuid(),
//                        songUrl, DEFAULT_FORMAT, soundCanRepeat,
//                        sound.getXPosF(), sound.getYPosF(), sound.getZPosF(),
//                        sound.getAttenuationType().getTypeInt(), distance);
//                event.getManager().sndSystem.backgroundMusic("ext", songUrl,"", false);
                event.getManager().sndSystem.backgroundMusic("ext", songLocation, false);
//                event.getManager().sndSystem.backgroundMusic("ext", "http://127.0.0.1/cat.ogg", false);

                Minecraft.getMinecraft().ingameGUI.setOverlayMessage(I18n.format("playing"),
                        true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

//文档
    @SubscribeEvent
    public static void onPlayStreamingSource(PlayStreamingSourceEvent event){
        YuPlus.logger.info("PlayStreamingSourceEvent:"+
                event.getName());

    }

}
