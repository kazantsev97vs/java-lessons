package lesson_47__serialization___transient_serialVersionUID;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -5207836352984595080L;

    // было до того как переименовали name -> personName, добавили age и type
    // private static final long serialVersionUID = 2392072499662292874L;

    private transient int id;

    // transient - это ключевое слово используется тогда, когда мы не хотим сериализовывать какое-то поле.
    private String personName;

    private int age;
    private byte type;

    public Person(int id, String personName) {
        this.id = id;
        this.personName = personName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +      // id + " : " + name
                "id=" + id +
                ", personName='" + personName + '\'' +
                '}';
    }
}
