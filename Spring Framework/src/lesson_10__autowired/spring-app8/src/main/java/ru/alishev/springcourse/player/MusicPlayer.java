package ru.alishev.springcourse.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;
import ru.alishev.springcourse.music.musicImpl.ClassicalMusic;
import ru.alishev.springcourse.music.musicImpl.RockMusic;

@Component
public class MusicPlayer {

    // @Autowired
    // private Music music;

    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    // IoC
    // @Autowired
    // public MusicPlayer(Music music) {
    //     this.music = music;
    // }

    // @Autowired
    // public void setMusic(Music music) {
    //     this.music = music;
    // }

    public String playMusic() {
        // System.out.println("Playing: " + music.getSong());
        return "Playing: " + classicalMusic.getSong();
    }
}
