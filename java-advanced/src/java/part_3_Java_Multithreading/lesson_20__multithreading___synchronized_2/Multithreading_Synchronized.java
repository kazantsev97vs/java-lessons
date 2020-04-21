package part_3_Java_Multithreading.lesson_20__multithreading___synchronized_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class Multithreading_Synchronized {

    public static void main(String[] args) {

        new Worker().main();

    }
}

class Worker {

    // random.nextInt(100) - вернет целое псевдослучайное число в рамках того числа которое передали в аргументы => 0-99
    Random random = new Random(); // с помощью этого класса можно получить псевдослучайное число

    /*
       Если вы хотите синхронизоваться на каком-то объекте, то создавайте для этого отдельный объект
       и давайте ему какое-то очевидное имя вроде lock - вы этот объект используете только для синхронизации
       и больше не для чего.
    */
    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> integerList1 = new ArrayList<>();
    private List<Integer> integerList2 = new ArrayList<>();

    /*
        В программе 2 этапа работы:
            1 этап - мы добавляем элемент в integerList1,
            2 этап - мы добавляем элемент в integerList2
     */

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            integerList1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            integerList2.add(random.nextInt(100));
        }
    }

    public void work () {
        for (int i = 0; i < 1_000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {

        long before = System.currentTimeMillis();

//        work();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long after = System.currentTimeMillis();

        /*
            Если работает один поток, то время выполнения примерно 3514 ms и результат всегда:
                List1 : 1000
                List2 : 1000

            Если работает два потока, и нет синхронизации, то время выполнения примерно такое же 3514 ms,
            а вот результат всегда разный:
                List1 : 1999
                List2 : 1996
            и иногда выскакивает ошибка: Exception in thread "Thread-0" ArrayIndexOutOfBoundsException: 15 at ArrayList.add

            Если работает два потока, то
                Если синхронизация потоков достигается за счет добавления в сигнатуры методов addToList1 и addToList2
                ключевого слова "synchronized", то время выполнения примерно в 2 раза больше  6946 ms и результат всегда:
                    List1 : 2000
                    List2 : 2000

                Так происходит потому, что синхронизация идет на объекте this,
                объект this в данном случае является объектом new Worker(), созданном в методе main().
                и объект this в обоих методах addToList1 и addToList2 - один и тот же,
                т.е. получается что в этих двух методах мы синхронизируемся на одном и том же объекте - на объекте this.
                И поэтому если у нас один поток вырывается вперед, например и начинает выполнять метод addToList1,
                то второй поток ждет и в этот момент он не может выполнить ни метод addToList1 ни метод addToList2,
                потому что первый поток, который вырвался вперед, он уже себе забрал МОНИТОР объекта this.
                И он его не отдаст пока он не выполнит свой метод addToList1,
                т.к. объекты равны - объекты на которых мы синхронизируемся в этих двух методах - равны,
                соответсвенно и монитор равен, поэтому если поток забрал монитор,
                выполняя addToList1, то и второй метод addToList2 другие потоки не могут выполнить,
                потому что монитор один и тот же.

                Для того чтобы достичь того чтобы один поток мог выполнять один метод,
                а другой соответственно второй метод в один момент времени
                    - мы можем синхронизоваться на разных объектах.

                Если синхронизация потоков достигается за счет создания специальных объектов lock1 и lock2
                и использования synchronized-блоков synchronized (lock1) {...} и synchronized (lock2) {...}
                и передачи этих самых специальных объектов в параметры synchronized-блокам, то
                Время исполнения программы: 3573 ms - такое же как и при одном потоке без второго
                и результат всегда:
                    List1 : 2000
                    List2 : 2000

                Теперь у нас методы синхронизованы - не возникает такого случая,
                что два потока одновременно выполняют метод add(), т.е. одновременно добавляют в тот же ArrayList.
                тем самым вызывая какие-то не предвиденные состояния этого ArrayList-а.
                - это мы исключили с помощью ключевого слова synchronized,
                НО теперь т.к. локи разные - мы разрешаем нашим потокам одновременно выполнять эти два метода
                addToList1 и addToList2.
                Поэтому если один поток выполняет addToList1, то другой выполняет - addToList2
                => они работают параллельно но при этом они не пересекаются - не пишут одновременно в один и тот же ArrayList
                они пишут параллельно в разные ArrayList-ы и тем самым достигается стабильный результат
                за то же время что и при одном потоке без второго

         */
        System.out.println("Время исполнения программы: " + (after - before) + " ms");
        System.out.println("List1 : " + integerList1.size());
        System.out.println("List2 : " + integerList2.size());
    }
}