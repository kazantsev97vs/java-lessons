package ru.alishev.springcourse.music.musicImpl;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;

@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Rock Music";
    }
}
