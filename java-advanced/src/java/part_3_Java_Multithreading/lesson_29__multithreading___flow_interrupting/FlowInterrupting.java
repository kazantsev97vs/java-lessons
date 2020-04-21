package part_3_Java_Multithreading.lesson_29__multithreading___flow_interrupting;

import java.util.Random;

/**
 * прерывание потоков
 *
 * InterruptedException - выбрасывается тогда, когда выполняемый поток был прерван каким-то другим потоком
 */
public class FlowInterrupting {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                /*
                    Для того чтобы понять внутри потока, что его снаружи хотят завершить существует такая констркуция:
                    Thread.currentThread().isInterrupted()
                    Если нас прервут то isInterrupted() вернет true
                 */

                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted!");
                        break;
                    }

//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("Thread was interrupted!");
//                        break;
//                    }

                    Math.sin(random.nextDouble());
                }
            }
        });

        System.out.println("Starting thread..");

        thread1.start();

        Thread.sleep(1000);
        // не останавливает поток, но мы даем сообщение потоку, о том, что мы хотим его остановить
        // поток принимает это сообщение и мы можем его как-нибудь обработать
        // и как-то грамотно завершить поток не вызывая какое-то неопределенное состояние
        thread1.interrupt();

        thread1.join();

        System.out.println("Thread has finished..");

        long endTime = System.currentTimeMillis();
        System.out.println("Program time is " + (endTime - startTime));
    }
}
