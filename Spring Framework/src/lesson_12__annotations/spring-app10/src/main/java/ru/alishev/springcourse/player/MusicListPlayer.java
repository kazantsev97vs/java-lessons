package ru.alishev.springcourse.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.MusicList;

import java.util.List;
import java.util.Random;

@Component
public class MusicListPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private MusicList classicalMusicList;
    private MusicList rockMusicList;

    @Autowired
    public MusicListPlayer(@Qualifier("classicalMusicList") MusicList classicalMusicList,
                           @Qualifier("rockMusicList") MusicList rockMusicList) {
        this.classicalMusicList = classicalMusicList;
        this.rockMusicList = rockMusicList;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
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
