package part_4_Regular_Expressions.lesson_32__regular_expressions___pattern_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern - представляет из себя само регулярное выражение
 *
 * Matcher - использует наш Pattern для того, чтобы проводить операции над строкой
 *
 * Пример, поиск совпадения в тексте
 */
public class PatternMatcher {

    public static void main(String[] args) {

        String text = "Hello, Guys! I send you my email joe@gmail.com so we can\n"
                + "keep in touch. Thanks, Joe. That's cool. I am sending you\n"
                + "my address: tim@yandex.ru. Let's stay in touch...";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        /*
            find() ищет очередное соответсвие нашему паттерну
            если true - значит он нашел совпадение с нашим регулярным выражением
            false - больше не нашлось совпадений
         */
        while (matcher.find()) {
            /*
                group() - возвращает то, что было найдено методом find()
                Вызов без аргументов -- мы получаем всю подстроку, которая совпала с нашим регулярным выражением
                Вызов с аргументом - числом (id группы) -- вернет часть подстроки под указанным id заключенную в скобки

                Группа в регулярном выражении - это любая строка, которая находится в круглых скобках.
                Нумерация группы id идет с 1, она идет слева направо, также она идет в глубину:
                              1         4       5
                         ( (2) (3) )   ( )   ( (6) )
             */

            System.out.println(matcher.group());
            // joe@gmail.com
            // tim@yandex.ru
            System.out.println(matcher.group(1));
            // joe
            // tim
            System.out.println(matcher.group(2));
            // gmail
            // yandex
            System.out.println(matcher.group(3));
            // com
            // ru
        }
    }
}