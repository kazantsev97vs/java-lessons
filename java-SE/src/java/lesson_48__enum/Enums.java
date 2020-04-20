package lesson_48__enum;


/**
 * enum (перечисления) - используется тогда, когда нужно перечислить типы объекта.
 *
 * Например, есть времена года, типы животных, страны и мы хотим их перечислить в программе и использовать.
 *
 * Время года: зима, весна, лето, осень.
 *
 * enum
 *
 *     .name() - возвращает название enum-а в виде строки
 *
 *     .valueOf() - (static) используется для того случая, когда мы хотим из строки получить enum
 *                   Допустим, пользователь вводит свое любимое животное, а мы получаем это животное
 *                   в виде enum-а и получаем всю дополнительную информацию к нему,
 *                   Наприимер, пользователь вводит слово "CAT" и valueOf вернет CAT("Кошка").
 *
 *      .ordinal() - возвращает порядок, в котором этот enum объявлен
 *                   Например, в классе Seasons {
 *                       WINTER (-30), SPRING (10), AUTUMN (10), SUMMER (25);
 *                   }
 *                   у WINTER ordinal == 0, у SPRING ordinal == 1 и т.д.
 */
public class Enums {


    public static void main(String[] args) {

        Season autumn = Season.AUTUMN;
        System.out.println(autumn.name()); // name() - возвращает название enum-а в виде строки
        System.out.println(autumn.ordinal());

        Animal cat = Animal.valueOf("CAT");
        System.out.println(cat);

        Animal frog = Animal.valueOf("DOG");
        System.out.println(frog);

        System.out.println();

        Animal animal = Animal.DOG;
        System.out.println(animal);
        System.out.println(animal.getTranslation());
//
//        switch (animal) {
//
//            case DOG:
//                System.out.println("It is a DOG");
//                break;
//
//            case CAT:
//                System.out.println("It is a CAT");
//                break;
//
//            case FROG:
//                System.out.println("It is a FROG");
//                break;
//
//            default:
//                System.out.println("It is a not animal");
//                break;
//        }

        Season season = Season.WINTER;
        System.out.println(season.getTemperature());

        // Object -> Enum -> Season

        // В JAVA объект является не только объектом своего класса,
        // но и является объектом всех родителей этого класса
        // ключевое слово "instanceof" проверяет является ли объект объектом этого класса
        System.out.println(season instanceof Season);   // true
        System.out.println(season instanceof Enum);     // true
        System.out.println(season instanceof Object);   // true
        System.out.println(season.getClass());

        switch (season) {

            case WINTER:
                System.out.println("It is cold outside!");
                break;

            case SPRING:
                System.out.println("It is less cold outside!");
                break;

            case SUMMER:
                System.out.println("It is warm outside");
                break;

            case AUTUMN:
                System.out.println("It is less warm outside");
                break;

            default:
                System.out.println("It is a not season");
                break;
        }

    }
}

/**
 * Способ перечисления до появления Enum
 */
class AnimalTypes {

    private static final int DOG = 0;
    private static final int CAT = 1;

    public static void main(String[] args) {

        int animal = 1;

        switch (animal) {

            case DOG:
                System.out.println("It is a DOG");
                break;

            case CAT:
                System.out.println("It is a CAT");
                break;


            default:
                System.out.println("It is a not animal");
                break;
        }
    }
}
