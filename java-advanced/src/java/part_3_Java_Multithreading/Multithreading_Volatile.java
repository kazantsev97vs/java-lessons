package java.part_3_Java_Multithreading;

import java.util.Scanner;

/**
 * volatile (изменчивый) - гарантирует когерентность кэшей ядер.
 *                         (не дает кэшироваться в памяти ядра -> каждый поток будет обращаться к главной
 *                         памяти, чтобы взять свежее значение переменной)
 *                         Для того случая, когда одна переменная делится между несколькими потоками
 *                         и когда один поток пишет в одну переменную, а другой или более потоков -
 *                         читают из этой переменной тогда с помощью ключевого слова volatile
 *                         - мы можем настроить взаимодействие этих потоков
 *
 *               +-------+     +-------+
 *               |  CPU  |     |  CPU  |
 *               +---+---+     +---+---+
 *                   |             |
 *               +---+---+     +---+---+     +-------------+
 *               | Cache |     | Cache |     | Main Memory |
 *               +---+---+     +---+---+     +------+------+
 *                   |             |                |
 *        <----------+-------------+----------------+------->
 *     <                 Bus                                   >
 *        <------------------------------------------------->
 *
 *    private volatile boolean running = true;
 */
public class Multithreading_Volatile {


    public static void main(String[] args) throws InterruptedException {

        MyVolatileThread volatileThread = new MyVolatileThread();
        volatileThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        volatileThread.shutdown();
    }
}

class MyVolatileThread extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {

        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // останавливаем поток
    public void shutdown () {
        this.running = false;
    }
}