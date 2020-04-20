package lesson_48__enum;

public enum Animal {

    DOG("Собака"), // JAVA сама создает объект: Animal DOG = new Animal("Собака");

    CAT("Кошка"),

    FROG("Лягушка");

    private String translation;

    Animal(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return this.name() + ", перевод на русский язык " + translation;
//        return "Animal{" +
//                "translation='" + translation + '\'' +
//                '}';
    }
}
