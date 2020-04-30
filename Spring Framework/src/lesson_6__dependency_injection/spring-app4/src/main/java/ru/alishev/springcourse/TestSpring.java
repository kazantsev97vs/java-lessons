package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        System.out.println("---");

        MusicListPlayer musicListPlayer = context.getBean("musicListPlayer", MusicListPlayer.class);
        musicListPlayer.playMusic();
        System.out.println(musicListPlayer.getName());
        System.out.println(musicListPlayer.getVolume());

        context.close();

    }
}
