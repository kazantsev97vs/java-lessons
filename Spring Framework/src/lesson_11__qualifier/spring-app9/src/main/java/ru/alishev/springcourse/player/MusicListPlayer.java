package ru.alishev.springcourse.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.MusicList;

import java.util.List;
import java.util.Random;

@Component
public class MusicListPlayer {

    private MusicList classicalMusicList;
    private MusicList rockMusicList;

    @Autowired
    public MusicListPlayer(@Qualifier("classicalMusicList") MusicList classicalMusicList,
                           @Qualifier("rockMusicList") MusicList rockMusicList) {
        this.classicalMusicList = classicalMusicList;
        this.rockMusicList = rockMusicList;
    }

    public void setClassicalMusicList(MusicList classicalMusicList) {
        this.classicalMusicList = classicalMusicList;
    }

    public void setRockMusicList(MusicList rockMusicList) {
        this.rockMusicList = rockMusicList;
    }

    public String playMusic(MusicGenre musicGenre) {
        Random random = new Random();
        List<String> songs;

        if (musicGenre == MusicGenre.CLASSICAL) {
            songs = classicalMusicList.getSongs();
            int idx = random.nextInt(songs.size());
            return "Playing: №" + idx + ". " + songs.get(idx);

        } else if (musicGenre == MusicGenre.ROCK) {
            songs = rockMusicList.getSongs();
            int idx = random.nextInt(songs.size());
            return "Playing: №" + idx + ". " + songs.get(idx);

        } else {
            return "Playing: some music";
        }
    }

    public enum MusicGenre {
        CLASSICAL,
        ROCK
    }
}
