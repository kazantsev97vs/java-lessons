package part_3_Java_Multithreading.lesson_22__multithreading___producer_consumer_pattern;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Pattern "Producer Consumer" (паттерн "Производитель-Потребитель")
 *  - один или более потоков производят что-то, а один или более потоков - потребляют что-то.
 *
 * Прелесть классов находящихся в пакете java.util.concurrent заключается в том,
 * что все эти классы - они потокобезопасны (Thread Saved)
 * Т.е. все эти классы по умолчанию синхронизованы и к ним можн обращаться во ммногих потоках
 * и при этом у нас не будет возникать состояния гонки
 *
 * Producer(Производитель) - это один или много потоков, которые создают запросы или создают что-то еще в систему.
 * Consumer(Потребитель) - это то, что берет из этого общего пула сущностей, берет сущность и как-то ее обрабатывает.
 */
public class ProducerConsumerPattern {

    // FIFO, потокобезопасная, имеет предельный размер,
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

        long endTime = System.currentTimeMillis();
        System.out.println("Время исполнения: " + (endTime - startTime) + " ms");
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            // put - ждет, если очередь заполнена, если consumer не взял еще элемент из этой очереди еще,
            // то не будет класть элементы в этот blockingQueue и будет ждать, пока место в нашей очереди не освободится
            blockingQueue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(100);

            if (random.nextInt(10) == 5) {
                // take() отличается от метода pull(), который есть у queue тем, что этот метод ждет,
                // если в нашем ArrayBlockingQueue нету элементов, ждет пока элементы будут добавлены
                System.out.println(blockingQueue.take());
                System.out.println("Queue size is " + blockingQueue.size());
            }
        }
    }
}