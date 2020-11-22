package com.yu.yuplus.sound;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.yu.yuplus.YuPlus;
import com.yu.yuplus.sound.config.Playlist;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public final class ExtSoundConfig {


    private static Path directory;
    public static List<Playlist> playlists;
    private static Path path;

    static void setup(){
        directory = Paths.get(Minecraft.getMinecraft().gameDir.toString(), "config/yuplus");
        path=directory.resolve("playlists.json");
        path=directory.resolve("setting.json");

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
            Gson gson=new Gson();
            JsonReader reader=new JsonReader(Files.newBufferedReader(path));
            playlists=gson.fromJson(reader, new TypeToken<List<Playlist>>(){}.getType());
            reader.close();
    }


}