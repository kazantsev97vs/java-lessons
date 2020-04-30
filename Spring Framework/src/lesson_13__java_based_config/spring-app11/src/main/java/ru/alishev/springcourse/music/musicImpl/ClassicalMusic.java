package ru.alishev.springcourse.music.musicImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

//@Component("musicBean")
//@Scope("singleton")
public class ClassicalMusic implements Music {

    @PostConstruct
    public void doInit() {
        System.out.println("Doing initialization...");
    }

    @Override
    public String getSong() {
        return "Classical Music";
    }

    @PreDestroy
    public void doDestroy() {
        System.out.println("Doing destroy...");
    }
}
