package com.yu.yuplus.sound;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.sound.sound.ExtSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundSourceEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;
import paulscode.sound.SoundSystem;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = YuPlus.MODID)
public class SoundEventHandler {
    private static final float DEFAULT_VOLUME = 1.0f;
    private static final float DEFAULT_DISTANCE = 16.0f;
    private static final String DEFAULT_FORMAT = "mp3";

    Logger logger = YuPlus.logger;


    private static boolean stopBuildInMusic = true;


    /*
    主菜单声音
    会换歌
PlaySoundEvent -> PlayStreamingSourceEvent
[16:48:30] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:music.menu,sound:net.minecraft.client.audio.PositionedSoundRecord@ce69b0a,resultsound:net.minecraft.client.audio.PositionedSoundRecord@ce69b0a
[16:51:08] [Client thread/INFO] [yuplus]: PlayStreamingSourceEvent:name:music.menu,uuid:980ad0f3-0dbb-43f1-9c93-fa45a507832e,sound:net.minecraft.client.audio.PositionedSoundRecord@ce69b0a
[16:54:38] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:music.menu,sound:net.minecraft.client.audio.PositionedSoundRecord@738fb8e8,resultsound:net.minecraft.client.audio.PositionedSoundRecord@738fb8e8
[16:54:38] [Client thread/INFO] [yuplus]: PlayStreamingSourceEvent:name:music.menu,uuid:d6753f24-b11a-4da3-9020-5e1260a4ab28,sound:net.minecraft.client.audio.PositionedSoundRecord@738fb8e8

ui.button
PlaySoundEvent->PlaySoundSourceEvent
[17:03:06] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:ui.button.click,sound:net.minecraft.client.audio.PositionedSoundRecord@76351c98,resultsound:net.minecraft.client.audio.PositionedSoundRecord@76351c98
[17:03:06] [Client thread/INFO] [yuplus]: PlaySoundSourceEvent:name:ui.button.click,uuid:159e0c39-282f-40c5-80f0-eef65b577a05,sound:net.minecraft.client.audio.PositionedSoundRecord@76351c98
[17:03:12] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:ui.button.click,sound:net.minecraft.client.audio.PositionedSoundRecord@71ba8f53,resultsound:net.minecraft.client.audio.PositionedSoundRecord@71ba8f53
[17:03:12] [Client thread/INFO] [yuplus]: PlaySoundSourceEvent:name:ui.button.click,uuid:a2aa75a7-eb0c-4722-8910-10f0537629e1,sound:net.minecraft.client.audio.PositionedSoundRecord@71ba8f53

entity.slime.jump
PlaySoundEvent->PlaySoundSourceEvent
[17:04:09] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:entity.slime.jump,sound:net.minecraft.client.audio.PositionedSoundRecord@1f21f1f,resultsound:net.minecraft.client.audio.PositionedSoundRecord@1f21f1f
[17:04:09] [Client thread/INFO] [yuplus]: PlaySoundSourceEvent:name:entity.slime.jump,uuid:0b47baa9-247b-4fcf-9e41-a0a21e0cffa0,sound:net.minecraft.client.audio.PositionedSoundRecord@1f21f1f
[17:04:09] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:entity.slime.squish,sound:net.minecraft.client.audio.PositionedSoundRecord@7f7637b7,resultsound:net.minecraft.client.audio.PositionedSoundRecord@7f7637b7
[17:04:09] [Client thread/INFO] [yuplus]: PlaySoundSourceEvent:name:entity.slime.squish,uuid:ed8fe068-0f56-4b2a-9cc1-199646079176,sound:net.minecraft.client.audio.PositionedSoundRecord@7f7637b7

游戏内音乐
music.creative
PlaySoundEvent -> PlayStreamingSourceEvent
[17:04:06] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:music.creative,sound:net.minecraft.client.audio.PositionedSoundRecord@2be51f04,resultsound:net.minecraft.client.audio.PositionedSoundRecord@2be51f04
[17:04:06] [Client thread/INFO] [yuplus]: PlayStreamingSourceEvent:name:music.creative,uuid:37198783-9d53-465a-8fc4-fcb7bb4ab189,sound:net.minecraft.client.audio.PositionedSoundRecord@2be51f04

打草地
PlaySoundEvent->PlaySoundSourceEvent
[17:07:14] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:block.grass.break,sound:net.minecraft.client.audio.PositionedSoundRecord@25b0fd0c,resultsound:net.minecraft.client.audio.PositionedSoundRecord@25b0fd0c
[17:07:14] [Client thread/INFO] [yuplus]: PlaySoundSourceEvent:name:block.grass.break,uuid:c7eca3a8-1d5b-4ed0-8dfc-572cee5d4161,sound:net.minecraft.client.audio.PositionedSoundRecord@25b0fd0c

PlaySoundEvent->PlaySoundSourceEvent
[17:15:40] [Client thread/INFO] [yuplus]: PlaySoundEvent:name:entity.snowball.throw,sound:net.minecraft.client.audio.PositionedSoundRecord@13bfd6,resultsound:net.minecraft.client.audio.PositionedSoundRecord@13bfd6
[17:15:40] [Client thread/INFO] [yuplus]: PlaySoundSourceEvent:name:entity.snowball.throw,uuid:f99cc708-ec8f-4568-8007-b9c0f44d9be1,sound:net.minecraft.client.audio.PositionedSoundRecord@13bfd6

PlaySoundEvent->PlaySoundSourceEvent
[17:15:40] [Server thread/INFO] [yuplus]: PlaySoundEvent:name:ext.sound,sound:com.yu.yuplus.sound.sound.ExtSound@41558d97,resultsound:com.yu.yuplus.sound.sound.ExtSound@41558d97
[17:15:40] [Server thread/INFO] [yuplus]: PlaySoundSourceEvent:name:ext.sound,uuid:1d801b77-d65a-4a4b-b9bd-c159dcf3208c,sound:com.yu.yuplus.sound.sound.ExtSound@41558d97


    * */
    @SubscribeEvent
    public static void onPlaySoundEvent(PlaySoundEvent event) {
//      记录音乐事件名称
        YuPlus.logger.info("PlaySoundEvent:" + "name:" + event.getName() + ",sound:" + event.getSound()
                + ",resultsound:" + event.getResultSound());

//	    移除原版音乐
//        if(stopBuildInMusic&&event.getName().startsWith("music")&&ExtSoundManager.getInstance().isSongPlaying()){
//            event.setResultSound(null);
//        }
        return;

    }


    @SubscribeEvent
    public static void onSoundSourceEvent(SoundEvent.SoundSourceEvent soundSourceEvent) {

        return;
    }


    //女仆mod
    @SubscribeEvent
    public static void onExtSoundEvent(PlaySoundSourceEvent event) {
//        YuPlus.logger.info("PlaySoundSourceEvent:name:" + event.getName() + ",uuid:" + event.getUuid() + ",sound:" + event.getSound());

        ISound sound = event.getSound();

//        EntityPlayerSP sp=Minecraft.getMinecraft().player;
//        if(sp!=null){
//            sp.sendChatMessage(event.getName()+"volume:"+sound.getVolume());
//        }

        if (sound instanceof ExtSound) {
            YuPlus.logger.info("play2");

            String songUrl = ((ExtSound) sound).getSongUrl();
            boolean soundCanRepeat = sound.canRepeat() && sound.getRepeatDelay() == 0;
            float volume = sound.getVolume();
            float distance = DEFAULT_DISTANCE;
            if (volume > DEFAULT_VOLUME) {
                distance *= volume;
            }


            try {
                SoundSystem soundSystem = event.getManager().sndSystem;
                //getAttenuationType为2时音乐不播放
                soundSystem.newStreamingSource(false, ExtSoundManager.defaultSource,
                        songUrl, soundCanRepeat,
                        sound.getXPosF(), sound.getYPosF(), sound.getZPosF(),
                        sound.getAttenuationType().getTypeInt(), distance);
                soundSystem.play(ExtSoundManager.defaultSource);
//                soundSystem.backgroundMusic(ExtSoundManager.defaultSource, songUrl, false);
                Minecraft.getMinecraft().ingameGUI.setOverlayMessage(I18n.format("playing"), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return;
    }

    //女仆mod
    @SubscribeEvent
    public static void onPlaySoundSourceEvent(PlaySoundSourceEvent event) {
        YuPlus.logger.info("PlaySoundSourceEvent:name:" + event.getName() + ",uuid:" + event.getUuid() + ",sound:" + event.getSound());
        return;
    }

    //文档
    @SubscribeEvent
    public static void onPlayStreamingSource(PlayStreamingSourceEvent event) {
        YuPlus.logger.info("PlayStreamingSourceEvent:name:" + event.getName() + ",uuid:" + event.getUuid() + ",sound:" + event.getSound());

        return;
    }

}
