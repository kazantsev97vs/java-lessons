package java.part_2_Java_Collections_Framework.Queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Очередь
 * FIFO - First In First Out (Первый Зашел Первый Вышел)
 * При многопоточности
 *
 * Очередь имеет ограничение по длине, задаваемое в конструкторе.
 *
 * Throws exception | Returns special value
 *  add()           |   offer() - добавить
 *  remove()        |   poll() - удалить первого в очереди
 *  element()       |   peek() - посмотреть первого в очереди
 *
 */
public class CollectionQueue {

    public static void main(String[] args) {

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);

        Queue<Person> people = new ArrayBlockingQueue<Person>(3);
        // people.add();   |   people.remove();
        // people.offer(); |   people.poll();

        people.offer(person3);
        people.offer(person2);
        people.offer(person4);
        people.offer(person5);
        people.offer(person1);

        System.out.println(people);

        System.out.println(people.remove());

        System.out.println(people);

        System.out.println(people.peek());

        System.out.println(people);


    }
}

class Person {

    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
