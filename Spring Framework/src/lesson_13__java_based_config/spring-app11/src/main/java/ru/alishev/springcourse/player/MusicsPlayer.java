package ru.alishev.springcourse.player;

import ru.alishev.springcourse.music.Music;
import java.util.List;
import java.util.Random;

public class MusicsPlayer {

    private List<Music> musicList;

    public MusicsPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic() {
        return "Playing: " + musicList.get(new Random().nextInt(musicList.size())).getSong();
    }
}
