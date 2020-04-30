package ru.alishev.springcourse.music.musicImpl;

import ru.alishev.springcourse.music.Music;

public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Classical Music";
    }
}
