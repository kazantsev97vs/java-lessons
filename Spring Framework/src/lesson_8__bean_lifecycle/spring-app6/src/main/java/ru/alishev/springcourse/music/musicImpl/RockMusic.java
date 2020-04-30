package ru.alishev.springcourse.music.musicImpl;

import ru.alishev.springcourse.music.Music;

public class RockMusic implements Music {

    public void doMyInitMethod() {
        System.out.println("Doing my Rock Music initialization..");
    }

    @Override
    public String getSong() {
        return "Rock Music";
    }

    public void doMyDestroyMethod() {
        System.out.println("Doing my Rock Music destroy..");
    }
}
