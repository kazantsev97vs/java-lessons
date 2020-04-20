package lesson_42__equals_string_pool;

/**
 * Equals - если мы хотим сравнить объекты структурно, а не ссылки на них, то нужно переопределить метод equals
 */
public class EqualsStringPool {

    public static void main(String[] args) {

        //  animal1     ->      {1}
        //  animal2     ->      {1}

        int x = 1;
        int y = 1;
        System.out.println("Примитивы x == y -> " + (x == y));

        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);

        // мы сравниваем здесь не сами объекты, а их указатели
        // т.к. мы создали два разных объекта - их указатели будут разными
        System.out.println("Указатели animal1 == animal2 -> " + (animal1 == animal2)); // всегда будет false

        // Equals определен в Object и он просто сравнивает два объекта как две ссылки (this == obj)
        // Запустив программу, мы получим тот же самый результат, что и раньше,
        // потому что в принципе мы сейчас делаем тоже самое, что и делали раньше - сравниваем объекты как ссылки
        // Для того, чтобы сравнивать объекты структурно, нужно переопределить метод equals в классе Animal!
        System.out.println("equals animal1.equals(animal2) -> " + (animal1.equals(animal2)));

        String string1 = "Hello";       // string1     ->       {"Hello"}
        String string2 = "Hello";       // string2     ->       {"Hello"}
        System.out.println("Строки string1 == string2 -> " + (string1 == string2));
        System.out.println("Строки string1.equals(string2) -> " + (string1.equals(string2)));

        String a = "a";
        String a123 = "a123".substring(0, 1);

        System.out.println("a    == " + a);
        System.out.println("a123 == " + a123);
        System.out.println("a == a123 -> " + (a == a123));
        System.out.println("a.equals(a123) -> " + (a.equals(a123)));
    }
}

class Animal {
    private int id;

    public Animal(int id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Animal animal = (Animal) o;
//
//        return id == animal.id;
//    }

        @Override
    public boolean equals(Object o) {
        Animal otherAnimal = (Animal) o;
        return this.id == otherAnimal.id;
    }
}
