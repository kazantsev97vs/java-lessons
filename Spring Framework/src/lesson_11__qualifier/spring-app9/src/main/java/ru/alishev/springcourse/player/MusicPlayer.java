package ru.alishev.springcourse.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;
import ru.alishev.springcourse.music.musicImpl.ClassicalMusic;
import ru.alishev.springcourse.music.musicImpl.RockMusic;

@Component
public class MusicPlayer {

    @Autowired
    @Qualifier("musicBean")
    private Music music;

    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("repMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic() {
        // System.out.println("Playing: " + music.getSong());
        return "Playing: " + music.getSong() + ", " + music1.getSong() + ", " + music2.getSong() + "..";
    }
}
