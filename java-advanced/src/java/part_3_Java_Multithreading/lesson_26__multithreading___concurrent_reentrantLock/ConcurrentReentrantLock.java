package part_3_Java_Multithreading.lesson_26__multithreading___concurrent_reentrantLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *  - этот класс нужен для того чтобы синхронизировать потоки
 *  с помощью этого класса можно делать тоже что и с помощью ключевого слова "synchronized"
 *  но у ReentrantLock существуют свои плюсы
 */
public class ConcurrentReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();

        long endTime = System.currentTimeMillis();
        System.out.println("Program time is " + (endTime - startTime));
    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    public void increment() {
        for (int i = 0; i < 10_000; i++) {
            counter++;
        }
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showCounter() {
        System.out.println(counter);
    }
}