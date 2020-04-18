package java.part_2_Java_Collections_Framework.Stack;

import java.util.Stack;

/**
 * Stack
 * LIFO - Last In First Out (Последним Зашел Первым Вышел)
 *
 * Печем блины
 *
 * push() - кладет элемент в стэк
 * pop()  - извлекает элемент из стэка (достает и удаляет)
 * peek() - достает/показывает элемент из стэка (не удаляет)
 * empty() - true, если стэк пустой и false, если не пустой
 *
 */
public class CollectionStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        //  5 -> 3 -> 1
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack);

        while (!stack.empty()) {
            System.out.println(stack.pop());
            System.out.println(stack);
        }

    }
}
