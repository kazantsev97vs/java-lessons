package lesson_48__enum;

public enum Season {

    // Все эти времена года являются объектами этого класса Season
    // по большому счету можно было бы написать new WINTER
    // Но когда мы пишем эти перечисления в enum - JAVA сама создает объекты этого класса
    // Как только мы написали WINTER - JAVA сама создала объект Season WINTER = new Season();
    WINTER (-30),
    SPRING (10),
    AUTUMN (10),
    SUMMER (25);

    private int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    //    Season SEASON = new Season();
}