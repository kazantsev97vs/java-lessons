package ru.alishev.springcourse.music.musicImpl;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.music.MusicList;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusicList implements MusicList {

    private List<String> songs = new ArrayList<>();

    // Блок инициализации
    // Выполняется каждый раз, когда создается объкт класса
    {
        songs.add("«Bohemian Rhapsody», - Queen. Величайшая песня величайшей рок-группы.");
        songs.add("«Smells Like Teen Spirit», - Nirvana. Не знаю, имеет ли смысл что-то говорить. ...");
        songs.add("«Another Brick In the Wall», - Pink Floyd. ...");
        songs.add("«It's My Life», - Bon Jovi. ...");
        songs.add("«Numb», - Linkin Park. ...");
        songs.add("«My Immortal», - Evanescence. ...");
        songs.add("«Zombie», - The Cranberries. ...");
        songs.add("«Stairway to Heaven», - Led Zeppelin. ...");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
