package com.yu.yuplus.sound;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.sound.sound.ExtSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;

public class ExtSoundManager {

    private static boolean IsSongPlaying;
    private int index;
    private int nextTime;
    private int soundId;
    public static String defaultSource="extsound";


    public static ExtSoundManager extSoundManager;

    public boolean isSongPlaying() {
        return IsSongPlaying;
    }



    private ExtSoundManager(){
        YuPlus.logger.info("starting "+getClass().getName());
        LocationHandler locationHandler=new LocationHandler();

        Thread thread=new Thread(locationHandler);
        thread.start();

        ExtSoundConfig extSoundConfig=new ExtSoundConfig();
        ExtSoundConfig.setup();


    }

    public static ExtSoundManager getInstance() {
        if (extSoundManager==null){
            extSoundManager= new ExtSoundManager();
        }
        return extSoundManager;

    }


    public BlockPos getLocation(){
        EntityPlayerSP sp=Minecraft.getMinecraft().player;
        if(sp!=null){
            return sp.getPosition();
        }
        return null;
    }

    public static void playUrl(String url){
        IsSongPlaying=true;
        ExtSound sound = new ExtSound(url);
//        Minecraft.getMinecraft().getSoundHandler().stopSounds();
        Minecraft.getMinecraft().getSoundHandler().playSound(sound);
    }

    public static void pauseSound(){
        ExtSoundConfig.getSoundManager().sndSystem.pause(defaultSource);
    }

    public static void playSound(){
        ExtSoundConfig.getSoundManager().sndSystem.play(defaultSource);
    }


}
