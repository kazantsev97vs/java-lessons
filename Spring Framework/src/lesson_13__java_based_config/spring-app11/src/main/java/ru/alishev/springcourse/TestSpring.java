package ru.alishev.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alishev.springcourse.config.SpringConfig;
import ru.alishev.springcourse.music.Music;
import ru.alishev.springcourse.music.musicImpl.ClassicalMusic;
import ru.alishev.springcourse.player.MusicListPlayer;
import ru.alishev.springcourse.player.MusicPlayer;

public class TestSpring {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

//        Computer computer = context.getBean("computer", Computer.class);
//        System.out.println(computer);
//
//        MusicListPlayer musicListPlayer = context.getBean("musicListPlayer", MusicListPlayer.class);
//
//        System.out.println( musicListPlayer.playMusic(MusicListPlayer.MusicGenre.CLASSICAL) );
//        System.out.println( musicListPlayer.playMusic(MusicListPlayer.MusicGenre.ROCK) );

        MusicListPlayer musicListPlayer = context.getBean("musicListPlayer", MusicListPlayer.class);
        System.out.println(musicListPlayer.getName());
        System.out.println(musicListPlayer.getVolume());

        ClassicalMusic classicalMusic1 = context.getBean("musicBean", ClassicalMusic.class);
         ClassicalMusic classicalMusic2 = context.getBean("musicBean", ClassicalMusic.class);

        // @Scope("singleton") => true
        // @Scope("prototype") => false
         System.out.println(classicalMusic1 == classicalMusic2);

        /*
            output:
                Doing initialization...
                Some name
                100
                true
                Doing destroy...
         */

        context.close();

    }
}
