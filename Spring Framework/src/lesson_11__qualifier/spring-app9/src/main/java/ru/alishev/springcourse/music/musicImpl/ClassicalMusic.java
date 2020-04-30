package ru.alishev.springcourse.music.musicImpl;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;

import java.util.List;

@Component("musicBean")
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Classical Music";
    }
}
