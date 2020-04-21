package part_3_Java_Multithreading.lesson_21__multithreading___thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread Pool - множество потоков
 *
 * Суть:
 *  создается N-ое число потоков и они выполняют какое-то задание, причем выполняют это задание параллельно.
 *
 */
public class Multithreading_ThreadPool {

    public static void main(String[] args) {

        /*
            класс Executors содержит в себе статические методы
            эти статические методы принимают на вход какие-то аргументы и возвращают ExecutorService

            ExecutorService (сервис по выполнению) - это и есть наш pool потоков
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            /*
                В метод submit мы должны передать объект, реализующий интерфейс Runnable.
                В методе run() - мы описываем то задание (ту логику),
                которое мы хотим выполнить (ту логику, которая будет выполняться в потоке)
             */
            executorService.submit(new Work(i));
        }

        long startTime = System.currentTimeMillis();
        /*
            shutdownNow - значит, что мы просто перестаем принимать новые задания,
                          мы беремся за выпорлнение тех заданий,
                          которые были переданы с помощью метода submit(new Work())

            С помощью метода submit() - мы передали 5 заданий нашим работникам,
            а с помощью метода shutdownNow - мы прекратили передачу новых заданий
            и говорим начать выполнять те задания, которые мы передали.
         */
        executorService.shutdown();
        System.out.println("All tasks submitted");

        /*
            awaitTermination - ожидание окончания, здесь мы указываем сколько хотим ждать,
                               пока наши потоки выполнят все задания, т.е. есть какой-то "предел времени"
                                - сколько мы готовы ждать наши потоки до того, как они выполнят задания.
                                (это что-то вроде join(), который был раньше)
         */
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS); // java.lang.InterruptedException: sleep interrupted at java.lang.Thread.sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Время исполнения: " + (endTime - startTime) + " ms");
    }
}

class Work implements Runnable {

    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work " + id + " was completed");
    }
}