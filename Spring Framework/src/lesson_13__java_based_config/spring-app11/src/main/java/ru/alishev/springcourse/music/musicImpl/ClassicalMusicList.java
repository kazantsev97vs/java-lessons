package ru.alishev.springcourse.music.musicImpl;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.MusicList;

import java.util.ArrayList;
import java.util.List;

public class ClassicalMusicList implements MusicList {

    private List<String> songs = new ArrayList<>();

    // Блок инициализации
    // Выполняется каждый раз, когда создается объкт класса
    {
        songs.add("«К Элизе», Людвиг ван Бетховен ...");
        songs.add("«Турецкое рондо», Вольфганг Амадей Моцарт ...");
        songs.add("«Аве Мария», Франц Шуберт ...");
        songs.add("«Лунная соната», Людвиг ван Бетховен ...");
        songs.add("«Утро», Эдвард Григ ...");
        songs.add("«Лунный свет» из «Бергамасской сюиты», Клод Дебюсси ...");
        songs.add("«Фантазия-экспромт», Фредерик Шопен ...");
        songs.add("«Свадебный марш», Феликс Мендельсон");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
