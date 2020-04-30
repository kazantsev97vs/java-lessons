package ru.alishev.springcourse.music.musicImpl;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.Music;

@Component
public class ClassicalMusic implements Music {

    public void doMyInitMethod() {
        System.out.println("Doing my Classical Music initialization..");
    }

    /**
     * Пока scope="singleton"
     *  getClassicalMusic() - этот метод будет вызван один раз и все вызовы getBean(),
     *  будут получать ссылку на единственный объект класса ClassicalMusic
     */
    public static ClassicalMusic getClassicalMusic() {
        System.out.println("---getClassicalMusic---");
        return new ClassicalMusic();
    }

    private ClassicalMusic() {}

    @Override
    public String getSong() {
        return "Classical Music";
    }

    public void doMyDestroyMethod() {
        System.out.println("Doing my Classical Music destroy..");
    }
}
