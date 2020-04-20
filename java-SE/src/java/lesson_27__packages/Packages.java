package lesson_27__packages;

// импортируем класс
// * - импортировать всё
import lesson_27__packages.forest.*;
import lesson_27__packages.forest.Tree;

public class Packages {

    public static void main(String[] args) {

        /*
        Error:(7, 9) java: cannot find symbol
          symbol:   class Tree
          location: class lesson_27__packages.Packages

         Чтобы компилятор увидел этот класс нужно:
         его импортировать вверху
         */
        Tree tree = new Tree();
        Squirrel squirrel = new Squirrel();
    }
}
