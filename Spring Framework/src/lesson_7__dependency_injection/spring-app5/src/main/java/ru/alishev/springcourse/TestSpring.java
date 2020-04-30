package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alishev.springcourse.player.MusicListPlayer;
import ru.alishev.springcourse.player.MusicPlayer;

public class TestSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = firstMusicPlayer.equals(secondMusicPlayer);
        System.out.println("comparison = " + comparison);
        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);
        System.out.println("---");

        firstMusicPlayer.setVolume(10);
        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());
        System.out.println("---");

        firstMusicPlayer.playMusic();
        System.out.println(firstMusicPlayer.getName());
        System.out.println(firstMusicPlayer.getVolume());
        System.out.println("---");

        MusicListPlayer musicListPlayer = context.getBean("musicListPlayer", MusicListPlayer.class);
        musicListPlayer.playMusic();
        System.out.println(musicListPlayer.getName());
        System.out.println(musicListPlayer.getVolume());

        context.close();

    }
}
