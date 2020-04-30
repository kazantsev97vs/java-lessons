package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alishev.springcourse.music.musicImpl.ClassicalMusic;
import ru.alishev.springcourse.music.musicImpl.PopMusic;
import ru.alishev.springcourse.music.musicImpl.RockMusic;

public class TestSpring {

    public static void main(String[] args) {

        System.out.println("context was created");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        PopMusic musicSingletonBean = context.getBean("musicSingletonBean", PopMusic.class);
        System.out.println(musicSingletonBean.getSong());

        PopMusic musicSingletonBean2 = context.getBean("musicSingletonBean", PopMusic.class);
        System.out.println(musicSingletonBean2.getSong());

        System.out.println("---");

        RockMusic musicPrototypeBean = context.getBean("musicPrototypeBean", RockMusic.class);
        System.out.println(musicPrototypeBean.getSong());

        RockMusic musicPrototypeBean2 = context.getBean("musicPrototypeBean", RockMusic.class);
        System.out.println(musicPrototypeBean2.getSong());
        System.out.println("---");

        ClassicalMusic classicalMusic = context.getBean("classicalMusicSingletonBean", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusicSingletonBean", ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
        System.out.println(classicalMusic2.getSong());
        System.out.println("---");

        context.close();
        System.out.println("context was closed");

    }
}
