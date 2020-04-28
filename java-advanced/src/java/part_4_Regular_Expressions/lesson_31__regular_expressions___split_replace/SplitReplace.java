package part_4_Regular_Expressions.lesson_31__regular_expressions___split_replace;


import java.util.Arrays;

public class SplitReplace {

    /**
     * Методы в java, которые работают с регулярными выражениями
     * и позволяют нам изменять строки,
     */
    public static void main(String[] args) {

        /**
         * split() - принимает на вход регулярное выражение,
         *           и разбивает строку по этому регулярному выражению
         */
        String helloWorldThere = "Hello World There";
        String[] words = helloWorldThere.split(" ");
        System.out.println(Arrays.toString(words));             // [Hello, World, There]

        String helloWorldThereWithNumbers = "Hello324234141World24321546824361There";
        String[] words2 = helloWorldThereWithNumbers.split("\\d+");
        System.out.println(Arrays.toString(words2));            // [Hello, World, There]

        /**
         * replace()      - принимает просто строку, вернет новую строку с замененными символами
         * replaceAll()   - принимает регулярное выражение
         * replaceFirst() - принимает регулярное выражение,
         *                  заменяет не все появления паттерна в тексте, а только первое.
         */
        String newHelloWorldThere = helloWorldThere.replace(" ", ".");
        System.out.println(helloWorldThere);                    // Hello World There
        System.out.println(newHelloWorldThere);                 // Hello.World.There

        String newFirstModifiedHelloWorldThere = helloWorldThere.replaceFirst(" ", ".");
        System.out.println(helloWorldThere);                    // Hello World There
        System.out.println(newFirstModifiedHelloWorldThere);    // Hello.World There
    }
}