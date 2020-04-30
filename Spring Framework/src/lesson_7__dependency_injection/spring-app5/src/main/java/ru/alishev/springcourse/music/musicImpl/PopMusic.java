package ru.alishev.springcourse.music.musicImpl;

import ru.alishev.springcourse.music.Music;

public class PopMusic implements Music {

    @Override
    public String getSong() {
        return "Pop Music";
    }
}
