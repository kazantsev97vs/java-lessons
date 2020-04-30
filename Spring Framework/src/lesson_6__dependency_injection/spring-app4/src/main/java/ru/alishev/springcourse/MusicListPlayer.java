package ru.alishev.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicListPlayer {

    private List<Music> musicList = new ArrayList<>();

    private String name;
    private int volume;

    // IoC
    public MusicListPlayer() {}

    public MusicListPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
        for (Music music : musicList) {
            System.out.println("Playing: " + music.getSong());
        }
    }
}
