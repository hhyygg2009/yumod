package com.yu.yuplus.sound.config;
/**
*   @author		:hhyygg2009
*   @date		:Created in 2020/11/16
*   @package 	:PlayLists.java
*   @description:
*	@modified By：
*	@version:
*/
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class PlayLists {
    Map<String, Playlist> playlists;
    Map<String, String> songs;


    private transient String playingName;

    PlayLists(){
        playlists=new HashMap<>();
        songs = new HashMap<>();
    }

    public void addPlayList(String playlistName, Playlist playlist){
        playlists.put(playlistName,playlist);
    }

    public void removePlayList(String playlistName){
        playlists.remove(playlistName);
    }

    public Playlist getPlaying() {
        return playlists.get(playingName);
    }

    public void setPlaying(String playingName) {
        this.playingName = playingName;
    }




    public void addSong(String songName, String songUrl) {
        songs.put(songName, songUrl);

    }

    public String getSongUrl(String songName){
        return songs.get(songName);
    }

    public String getNextSongUrl(){
        String nextSongName=getPlaying().getNextSong();
        return getSongUrl(nextSongName);
    }

    public void addSong(String songUrl) {
        URL url = null;
        try {
            url = new URL(songUrl);
            String songName = url.getFile();
            songs.put(songName, songUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public void removeSong(String songName) {
//    songs.remove(songName);
    }

}
