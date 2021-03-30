package com.yu.yuplus.sound.sound;

import com.yu.yuplus.sound.SoundEventInitializer;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author        :hhyygg2009
 * @date        :Created in 2020/12/14 12:27
 * @package :ExtSound.java
 * @description:
 * @modified By：
 * @version:
 */

/*
PositionedSoundRecord 固定位置播放音乐


positionedSoundLocation = {ResourceLocation@9394} "minecraft:music.menu"
 namespace = "minecraft"
 path = "music.menu"

volume = 1.0
pitch = 1.0
xPosF = 0.0
yPosF = 0.0
zPosF = 0.0
repeat = false
repeatDelay = 0

*/
@SideOnly(Side.CLIENT)
public class ExtSound extends PositionedSoundRecord {


    private final String songURL;

    public ExtSound(String songURL) {
        super(SoundEventInitializer.EXT_AUDIO.getSoundName(), SoundCategory.MUSIC
                , 1f, 1f,false,0, AttenuationType.NONE,
                 0, 0, 0);
        this.songURL = songURL;
    }

    public String getSongUrl() {
        return songURL;
    }


}