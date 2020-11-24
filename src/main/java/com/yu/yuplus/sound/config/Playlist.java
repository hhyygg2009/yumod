package com.yu.yuplus.sound.config;

/**
 *  @author		:hhyygg2009
 *  @date		:Created in 2020/11/16
 *  @package 	:PlayList.java
 *  @description:
 *	@modified By：
 *	@version:
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {
//    String name;
    public List<String> songNames;

    private transient int index;
    private transient String currentSong;


//    public int getIndex() {
//        return index;
//    }

    public int getSize(){
        return songNames.size();
    }

    public String getSongName(int index){
        return songNames.get(index);
    }

    public String getNextSong(){
        if (songNames.size()>0){
            index+=1;
            if(index==songNames.size()){
                index=0;
            }
            currentSong=songNames.get(index);
        }
        return currentSong;
    }



//    public String getName() {
//        return name;
//    }

    public String getCurrentSong() {
        return currentSong;
    }


    public Playlist(String name) {
//        this.name = name;
        songNames = new ArrayList<>();

        index=-1;
    }


    public void addSong(String songName) {
        songNames.add(songName);
    }

    public void removeSong(String songName) {
        songNames.remove(songName);
    }



}


