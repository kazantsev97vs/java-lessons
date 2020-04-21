package part_3_Java_Multithreading.lesson_25__multithreading___concurrent_count_down_latch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch (защелка обратного отсчета) -
 *  это такой класс при создании которого мы передаем ему в аргументы число,
 *  это число означает сколько раз мы должны вызвать метод countDown()
 *  из одного или более количества потоков,
 *  чтобы метод await() - больше не ждал.
 *  Т.е. пока счетчик не равен нулю - await() дальше не идет.
 *  Как только счетчик равен нулю - await() больше не ждет, защелка открыта
 *  и мы можем дальше продолжить нашу работу
 *
 * Методы этого класса можно вызывать в любых потоках и не использовать никакую синхронизацию
 * и не волноваться - он потокобезопасен
 */
public class ConcurrentCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        // Количество итераций прежде чем защелка отопрется 3
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(i, countDownLatch));
        }

        executorService.shutdown();
//        countDownLatch.await();
//        System.out.println("Latch has been opened, main thread is proceeding!");

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Program time is " + (endTime - startTime));
    }
}

class Processor implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // countDown - декрементирует ту переменную 3 на единицу
//        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id " + id + " proceeded");
    }
}