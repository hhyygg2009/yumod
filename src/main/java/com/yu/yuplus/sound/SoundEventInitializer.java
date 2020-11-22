package com.yu.yuplus.sound;

import com.yu.yuplus.YuPlus;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = YuPlus.MODID)
public class SoundEventInitializer {
    private static final List<SoundEvent> SOUND_LIST = new ArrayList<>();
    public static final SoundEvent EXT_AUDIO=registerSound("ext.sound");

    @SubscribeEvent
    public static void register(RegistryEvent.Register<SoundEvent> event) {
        for (SoundEvent sound : SOUND_LIST) {
            event.getRegistry().register(sound);
        }
    }

    private static SoundEvent registerSound(String name) {
        SoundEvent event = new SoundEvent(new ResourceLocation(YuPlus.MODID, name))
                .setRegistryName(YuPlus.MODID, name);
        SOUND_LIST.add(event);
        return event;
    }

}
