package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alishev.springcourse.music.Music;
import ru.alishev.springcourse.player.MusicPlayer;

public class TestSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        Music musicBean = context.getBean("musicBean", Music.class);
//        Music repMusicBean = context.getBean("repMusic", Music.class);
//
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();
//
//        MusicPlayer repMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        repMusicPlayer.playMusic();

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        context.close();

    }
}
