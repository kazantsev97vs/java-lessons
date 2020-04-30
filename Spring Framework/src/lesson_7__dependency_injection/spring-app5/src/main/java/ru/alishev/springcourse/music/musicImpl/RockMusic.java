package ru.alishev.springcourse.music.musicImpl;

import ru.alishev.springcourse.music.Music;

public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Rock Music";
    }
}
