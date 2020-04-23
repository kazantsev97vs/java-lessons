package part_4_Regular_Expressions.lesson_30__regular_expressions;

/**
 * RegExLib.com
 * Regular Expressions (Регулярные выражения)
 *      - это очень мощный инструмент, который позволяет нам работать с текстом
 *      это язык, который позволяет нам описывать паттерны в тексте
 *
 *      Regs:
 *      \\ - обозначение того, что дальше - это не буква, а какой-то специальный символ и наоборот
 *      \\w - одна английская буква
 *      \\d - одна цифра
 *      \\d+ - описываем строку, в которой одна или более цифр
 *      + - 1 или более
 *      * - 0 или более
 *      ? - символ, который идет до него - он может быть или не быть - 0 или 1 символов до
 *
 *      ( x | y | z ) - в скобках мы пишем какие-то вероятные вещи и разделяем эти вещи | логическое или - одна из множества
 *
 *      [abc] == (a|b|c)
 *
 *      [a-zA-z] - описываем все английские буквы ("-" - это множество, т.е. a-z - это  множество англ. букв в нижнем регистре)
 *      [0-9] - все возможные цифры (что-то от 0 до 9)
 *      [^abc] - все символы, кроме символов a, b и c
 *
 *      . - любой символ
 *      .+ - любой набор символов
 *
 *      цифры в фигурных скобках - точное количество предыдущих символов
 *      {2}    - 2 символа до (\\d{2} - две цифры до)
 *      {2, }  - 2 или более вимвола до
 *      {2, 4} - от 2 до 4 символов до
 *
 */
public class RegularExpressions {

    public static void main(String[] args) {

        /*
            matches() - он вызывается на объекте класса String и принимает на вход строку regex
                        он сравнивает ту строку, которая приходит ему на вход в качестве аргументов
                        с той строкой, на которой он вызывается

                        return true - если строка совпадает с тем что, пришло в качестве аргументов
                        return false - если она не совпадает.
         */
//        System.out.println("1234".matches("\\d"));          // false
//
//        System.out.println("hello".matches("e"));           // false
//
//        System.out.println("99123".matches("\\d+"));        // true
//        System.out.println("".matches("\\d+"));             // false
//        System.out.println("-99123".matches("\\d+"));       // false
//        System.out.println("-99123".matches("-\\d+"));      // true
//
//        // минус мб а мб и не быть
//        System.out.println("-?\\\\d+");
//        System.out.println("-99123".matches("-?\\d+"));      // true
//        System.out.println("99123".matches("-?\\d+"));       // true
//
//        System.out.println("(-|+)?\\\\d+");
//        System.out.println("-99123".matches("(-|\\+)?\\d*"));      // true
//        System.out.println("99123".matches("(-|\\+)?\\d*"));       // true
//        System.out.println("+99123".matches("(-|\\+)?\\d*"));      // true

//        System.out.println("awd3sadwawdawdaw12".matches("[a-zA-Z3]*\\d+"));     // true

//        System.out.println("hello".matches("[^abc]*"));     // true
//        System.out.println("helloa".matches("[^abc]*"));     // false

//        System.out.println("http://www.google.com".matches("http://www\\..+\\.(com|ru)"));      // true
//        System.out.println("http://www.yandex.ru".matches("http://www\\..+\\.(com|ru)"));       // true
//        System.out.println("Hello there".matches("http://www\\..+\\.(com|ru)"));                // false

//        System.out.println("1".matches("\\d{2}"));                  // false
//        System.out.println("12".matches("\\d{2}"));                 // true
//        System.out.println("123".matches("\\d{2}"));                // false
//        System.out.println("123324423412323".matches("\\d{2,}"));   // true

        System.out.println("f".matches("\\w"));   // true
        System.out.println("п".matches("\\w"));   // false

    }
}
