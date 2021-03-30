package com.yu.yuplus.sound;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.yu.yuplus.YuPlus;
import com.yu.yuplus.sound.config.Playlist;
import de.cuina.fireandfuel.CodecJLayerMP3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecWav;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Mod.EventBusSubscriber(modid = YuPlus.MODID)
public final class ExtSoundConfig {


    private static Path directory;
    public static List<Playlist> playlists;
    private static Path path;
    private static SoundManager soundManager;

    public static SoundManager getSoundManager() {
        return soundManager;
    }


    //给SoundSystem载入解码插件
    @SubscribeEvent
    public static void onSoundSetup(SoundSetupEvent event) {
        try {
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            SoundSystemConfig.setCodec("mp3", CodecJLayerMP3.class);
            soundManager = event.getManager();
            YuPlus.logger.info("Loaded Codec");

        } catch (SoundSystemException e) {
            e.printStackTrace();
        }
    }

    static void setup() {
        directory = Paths.get(Minecraft.getMinecraft().gameDir.toString(), "config/yuplus");
        path = directory.resolve("playlists.json");
        path = directory.resolve("setting.json");

        try {
            Files.createDirectories(directory);
            YuPlus.logger.info(directory.toAbsolutePath());
            loadPlaylist();
        } catch (Exception ex) {
            YuPlus.logger.error("Could not create music player directories", ex);
        }


    }

    public static Path getDirectory() {
        return directory;
    }


    static void loadPlaylist() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(Files.newBufferedReader(path));
        playlists = gson.fromJson(reader, new TypeToken<List<Playlist>>() {
        }.getType());
        reader.close();
    }


}