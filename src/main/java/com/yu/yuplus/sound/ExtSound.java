package com.yu.yuplus.sound;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.net.URL;

/**
 * @author TartaricAcid
 */
@SideOnly(Side.CLIENT)
public class ExtSound extends MovingSound {

    //
    public String getSongLocation() {
        return songLocation;
    }

    private final String songLocation;


    public ExtSound(String songUrl) {
        super(SoundEventInitializer.EXT_AUDIO, SoundCategory.RECORDS);

        this.songLocation = songUrl;
    }

    @Override
    public void update() {

    }




}