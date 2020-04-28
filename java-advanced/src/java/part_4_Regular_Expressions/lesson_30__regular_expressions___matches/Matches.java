package part_4_Regular_Expressions.lesson_30__regular_expressions___matches;


/**
 * Регулярные выражения
 *  - это очень мощный инструмент, который позволяет нам работать с текстом,
 *    они описывают какую-то группу строк;
 *  - это язык, который позволяет нам описывать паттерны в тексте.
 *
 *  В любом тексте есть какие-то паттерны, описав эти паттерны,
 *  с помощью регулярных выражений, мы можем потом что-то с ними сделать.
 */
public class Matches {

    /**
     * Методы в java, которые позволяют нам изменять или работать с текстом,
     * и в которых используются регулярные выражения:
     *
     *      .matches() - вызывается на объекте класса String, принимает на вход строку regex,
     *                   сравнивает ту строку, которая приходит ему на вход, в качестве аргументов,
     *                   с той строкой, на которой он вызывается,
     *                   возвращает boolean:
     *                      - true, если строка как-то совпадает с тем, что пришло в качестве аргументов
     *                      - false, если не совпадает
     */
    public static void main(String[] args) {

        System.out.println("1234".matches("1234")); // true
        System.out.println("1234".matches("1235")); // false
        System.out.println("d".matches("d"));       // true

        /*
            Регулярные выражения:
                \\  - переводят обычную букву в специальный символ,
                      и также специальный символ - в обычную букву
                \\d - одна цифра
                \\w - одна буква
                +   - 1 или более
                *   - 0 или более
                ?   - 0 или 1 символов ДО

                (x|y|z)  - одна строка из множества строк

                [] - описывает множества, описывает все возможные символы, которые могут встречаться
                [abc]    == (a|b|c) - описывает букву "a" или "b" или "c"
                [a-zA-Z] == \\w     - описывает все английские буквы,
                [0-9]    == \\d     - описывает все цифры,
                [^] - отрицание, все что идет после этого символа - не должно быть в конечном множестве
                [^abc] - описывает все символы, кроме a, b и c

                .   - описывает любой символ
                .+  - описывает любой набор символов

                {цифры} - цифры в скобках означают точное количество предыдущих символов
                {2}     - 2 символа до           {\\d{2}} - на этом месте ровно 2 цифры
                {2,}    - 2 или более символа до {\\d{2,}} - на этом месте от 2 до бесконечности цифр
                {2,4}   - от 2 до 4 символов до  {\\d{2,4}} - на этом месте от 2 до 4 цифр
         */
        System.out.println("d".matches("\\d"));     // false
        System.out.println("1".matches("\\d"));     // true
        System.out.println("11".matches("\\d"));    // false
        System.out.println("11".matches("\\d+"));   // true
        System.out.println("".matches("\\d+"));     // false
        System.out.println("".matches("\\d*"));     // true
        System.out.println("-1".matches("\\d*"));       // false

        System.out.println("-1".matches("-\\d*"));      // true
        System.out.println("-1".matches("-?\\d*"));     // true
        System.out.println( "1".matches("-?\\d*"));     // true
        System.out.println("+1".matches("-?\\d*"));     // false

        System.out.println("+1".matches("(-|\\+)?\\d*"));   // true
        System.out.println("-1".matches("(-|\\+)?\\d*"));   // true
        System.out.println( "1".matches("(-|\\+)?\\d*"));   // true

        System.out.println("a1234556".matches("[a-zA-Z]\\d*"));     // true
        System.out.println("a1234556".matches("[a-zA-Z][0-9]*"));   // true
        System.out.println("ab1234556".matches("[a-zA-Z]\\d*"));    // false
        System.out.println("ab1234556".matches("[a-zA-Z]+\\d*"));   // true

        System.out.println("a2se7fb1234556".matches("[a-zA-Z]+\\d*"));     // false
        System.out.println("a2se7fb1234556".matches("[a-zA-Z0-9]+\\d*"));  // true

        System.out.println("hello".matches("[^abc]*"));     // true
        System.out.println("helloa".matches("[^abc]*"));    // false
        System.out.println("hellob".matches("[^abc]*"));    // false
        System.out.println("helloc".matches("[^abc]*"));    // false
        System.out.println("helloab".matches("[^abc]*"));   // false

        System.out.println("http://wwww.google.com".matches("http://wwww\\..+\\.(com|ru)")); // true
        System.out.println("http://wwww.yandex.ru".matches("http://wwww\\..+\\.(com|ru)"));  // true
        System.out.println("Hello there!".matches("http://wwww\\..+\\.(com|ru)"));  // false

        System.out.println("123".matches("\\d{2}"));        // false
        System.out.println( "12".matches("\\d{2}"));        // true
        System.out.println(  "3".matches("\\d{2}"));        // false
        System.out.println("1".matches("\\d{2,}"));         // false
        System.out.println("12132442".matches("\\d{2,}"));  // true


        /**
         * RegExLib.com -> Regex Cheat Sheet
         */
    }
}