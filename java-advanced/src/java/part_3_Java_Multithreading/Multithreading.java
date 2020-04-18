package java.part_3_Java_Multithreading;

public class Multithreading {

    /**
     * Это главный поток
     * (остальные потоки отпочковываются от него)
     *
     * Виртуальная параллельность - при одноядерном процессоре,
     *                              процессор быстро переключается между задачами,
     *                              поэтому кажется, что он выполняюет куски кода однавременно
     *
     * В многоядерном процессоре - java сама распределяем код между ядрами процессора.
     *
     * Thread - поток
     *
     * public void run() - метод, который следует переопределить,
     *                     для выполнения заданного кода в потоке
     *
     * start() - запускает поток
     * Thread.sleep() - заставляет поток "лечь спать" - на какое-то время прекратить свое выполнение
     *
     * Java-программа заканчивается тогда, когда заканчиваются все текущие потоки
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        /**
         * Первый способ создания потока
         */
        // Создаем поток
        MyThread myThread1 = new MyThread();
        myThread1.setName("myThread1");
        // Запускаем его
        myThread1.start();

        System.out.println("I am going to sleep");
        Thread.sleep(1000);
        System.out.println("I am waked up");

        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread2");
        // Запускаем его
        myThread2.start();

        System.out.println("Hello world!");

        /**
         * Второй способ создания потока
         */
        Thread thread = new Thread(new Runner());
        thread.start();

        System.out.println("Hello world!");

    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1_000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner - " + i);
        }
    }
}

class MyThread extends Thread {

    /**
     * Здесь пишется код, который должен выполняться в потоке
     */
    @Override
    public void run() {
        System.out.println(this.getName());
        for (int i = 0; i < 1_000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " - " + i);
        }
    }
}