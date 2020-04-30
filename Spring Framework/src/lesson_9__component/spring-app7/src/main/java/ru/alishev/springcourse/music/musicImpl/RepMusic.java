package ru.alishev.springcourse.music.musicImpl;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;

@Component
public class RepMusic implements Music {

    @Override
    public String getSong() {
        return "Rep Music";
    }
}
