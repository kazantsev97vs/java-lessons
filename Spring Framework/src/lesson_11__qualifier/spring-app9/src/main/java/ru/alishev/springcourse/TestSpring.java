package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alishev.springcourse.music.Music;
import ru.alishev.springcourse.music.musicImpl.ClassicalMusic;
import ru.alishev.springcourse.player.MusicListPlayer;
import ru.alishev.springcourse.player.MusicPlayer;

public class TestSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        MusicListPlayer musicListPlayer = context.getBean("musicListPlayer", MusicListPlayer.class);

        System.out.println( musicListPlayer.playMusic(MusicListPlayer.MusicGenre.CLASSICAL) );
        System.out.println( musicListPlayer.playMusic(MusicListPlayer.MusicGenre.ROCK) );

        context.close();

    }
}
