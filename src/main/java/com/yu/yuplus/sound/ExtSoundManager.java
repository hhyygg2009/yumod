package com.yu.yuplus.sound;

import com.yu.yuplus.YuPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;

public class ExtSoundManager {
    private boolean IsSongPlaying;
    private int index;
    private int nextTime;
    private int soundId;


    public static ExtSoundManager extSoundManager;

    public boolean isSongPlaying() {
        return IsSongPlaying;
    }

    //    单例
    public static ExtSoundManager getInstance() {
        if (extSoundManager==null){
            extSoundManager= new ExtSoundManager();
        }
        return extSoundManager;

    }

    private ExtSoundManager(){
        YuPlus.logger.info("starting "+getClass().getName());
        LocationHandler locationHandler=new LocationHandler();

        Thread thread=new Thread(locationHandler);
        thread.start();

        ExtSoundConfig extSoundConfig=new ExtSoundConfig();
        ExtSoundConfig.setup();
    }

    public BlockPos getLocation(){
        EntityPlayerSP sp=Minecraft.getMinecraft().player;
        if(sp!=null){
            return sp.getPosition();
        }
        return null;
    }

    public void playUrl(String url){

        YuPlus.logger.info("play1");
//        URL realSongUrl= null;
//        try {
//            realSongUrl = new URL(url);
//        } catch (  MalformedURLException e) {
//            e.printStackTrace();
//        }


        IsSongPlaying=true;
        ExtSound sound = new ExtSound(url);
        Minecraft.getMinecraft().getSoundHandler().stopSounds();
        Minecraft.getMinecraft().getSoundHandler().playSound(sound);
    }


}
