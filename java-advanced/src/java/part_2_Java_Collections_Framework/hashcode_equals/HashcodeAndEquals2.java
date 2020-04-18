package java.part_2_Java_Collections_Framework.hashcode_equals;

public class HashcodeAndEquals2 {

    public static void main(String[] args) {

    }
}


class Person2 {

    private int id;
    private String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
        Контракт hashCode и equals:
        1. У двух проверяемых объектов вызываем hashCode()
            - если хэши разные -> два объекта точно разные
            - если хэши одинаковые:
                1) Одинаковые объекты
                2) Произошла коллизия
                Чтобы убедиться наверняка, следует вызвать equals()

        2. equals() -> выдает правильный ответ
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person2 person = (Person2) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person {"
                + "id = " + id + ", "
                + "name = " + name
                + "}";
    }


}
