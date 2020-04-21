package part_3_Java_Multithreading.lesson_27__multithreading___concurrent_semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore (Семафор)
 *  - этот класс используется в том случае, когда у нас используется какой-то ресурс
 *  и много потоков используют этот ресурс.
 *  Мы используем класс Semaphore в том случае, когда мы хотим ограничить доступ к какому-то ресурсу.
 *  С помощью Semaphore мы можем делить один ограниченный ресурс между всеми потоками.
 */

public class ConcurrentSemaphore {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

//        // Permits (Разрешение) - количество разрешений для потоков
//        // мы хотим чтобы максимум 3 потока одновременно использовали какой-то ресурс
//        // Потоки могут либо забиратб это разрешение себе и взаимодействовать с ресурсом
//        // но после того как они закончили взаимодействие с ресурсом - они это разрешение отдают обратно
//        // и другой поток может взять это разрешение и взаимодействовать с этим ресурсом.
//        Semaphore semaphore = new Semaphore(3);
//
//        /*
//           вызываем метод acquire() в том случае, когда мы в потоке начинаем взаимодействовать с ресурсом
//           и количество разрешений уменьшается на единицу
//           acquire() будет ждать если у нас количество разрешений равно нулю
//        */
//        try {
//            semaphore.acquire();
//            semaphore.acquire();
//            semaphore.acquire();
//
//            System.out.println("All permits have been acquired!");
//
//            semaphore.acquire();
//
//            System.out.println("Can't reach here...!");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        /*
//           release() - отпускает одно из этих разрешений
//           отдает разрешениие, т.е. мы вызываем метод release() тогда,
//           когда в потоке заканчиваем использовать ресурс
//           и количество разрешений увеличивается на единицу
//        */
//        semaphore.release();
//
//        // Возвращает количество разрешений, которое у нас сейчас свободно
//        semaphore.availablePermits();
//
//        System.out.println(semaphore.availablePermits());

        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();

        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        long endTime = System.currentTimeMillis();
        System.out.println("Program time is " + (endTime - startTime));
    }
}

// Singleton
class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {}

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();

        try {
            doWork();
        } finally {
            semaphore.release();
        }

    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCount--;
        }
    }
}