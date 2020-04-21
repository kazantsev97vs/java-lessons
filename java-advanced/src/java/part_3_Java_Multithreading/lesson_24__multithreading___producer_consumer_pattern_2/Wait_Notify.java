package part_3_Java_Multithreading.lesson_24__multithreading___producer_consumer_pattern_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class Wait_Notify {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

/**
 * Добавление и вынимание чисел должно быть совместное,
 * чтобы если очередь пустая, то поток consumer (потребитель) - он ждал
 * и не извлекал из пустой очереди элементы (потому что их там нету)
 *
 * Также мы хотим чтобы поток producer - он не добавлял новые элементы в очередь,
 * если она уже итак полна - если в ней уже 10 элементов
 */
class ProducerConsumer {

    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    /**
     * Добавление новых чисел в очередь
     * Не добавляет в очередь новые объекты, если она уже полна
     * @throws InterruptedException
     */
    public void produce() throws InterruptedException {

        Integer value = 0;

        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }

                queue.offer(value++);
                lock.notify();
            }
        }
    }

    /**
     * Вынимание добавленных чисел из очереди
     * @throws InterruptedException
     */
    public void consume() throws InterruptedException {

        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }

                Integer value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                lock.notify();
            }

            Thread.sleep(1000);
        }
    }
}