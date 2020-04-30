package ru.alishev.springcourse.music.musicImpl;

import ru.alishev.springcourse.music.Music;

public class PopMusic implements Music {

    public void doMyInitMethod() {
        System.out.println("Doing my Pop Music initialization..");
    }

    @Override
    public String getSong() {
        return "Pop Music";
    }

    public void doMyDestroyMethod() {
        System.out.println("Doing my Pop Music destroy..");
    }
}
