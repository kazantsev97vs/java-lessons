package ru.alishev.springcourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.alishev.springcourse.music.Music;
import ru.alishev.springcourse.music.MusicList;
import ru.alishev.springcourse.music.musicImpl.*;
import ru.alishev.springcourse.player.MusicListPlayer;
import ru.alishev.springcourse.player.MusicPlayer;
import ru.alishev.springcourse.player.MusicsPlayer;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("ru.alishev.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusicList classicalMusicList () {
        return new ClassicalMusicList();
    }

    @Bean
    public RockMusicList rockMusicList () {
        return new RockMusicList();
    }

    @Bean
    public MusicListPlayer musicListPlayer () {
        return new MusicListPlayer(classicalMusicList(), rockMusicList());
    }

    @Bean
    public ClassicalMusic musicBean() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public RepMusic repMusic() {
        return new RepMusic();
    }

    @Bean
    public List<Music> musicList() {
        return Arrays.asList(musicBean(), rockMusic(), repMusic());
    }

    @Bean
    public MusicsPlayer musicsPlayer() {
        return new MusicsPlayer(musicList());
    }
}
