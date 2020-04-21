package part_3_Java_Multithreading.lesson_23__multithreading___wait_notify;

import java.util.Scanner;

/**
 * wait() - отдает монитор и ждет, пока в другом потоке, будет вызван метод notify()
 * notify() - вызывается и пробуждает тот самый поток, который вызвал метод wait()
 *
 * ВЫЗОВ ЭТИХ МЕТОДОВ НЕ ПРИВЯЗЫВАЕТСЯ К ОБЪКТУ НА КОТОРОМ ИДЕТ СИНХРОНИЗАЦИЯ.
 * ВЫЗОВ ЭТИХ МЕТОДОВ ПРИВЯЗЫВАЕТСЯ К ТОМУ КОНТЕКСТУ, ГДЕ МЫ НАХОДИМСЯ.
 * ПО УМОЛЧАНИЮ МЕТОДЫ ВЫЗЫВАЮТСЯ КАК this.wait() и this.notify()
 * НО ЛУЧШЕ ВРУЧНУЮ УКАЗЫВАТЬ НА КАКОМ ОБЪЕКТЕ ОНИ ВЫЗЫВАЮТСЯ
 *
 * Причем, самое важное, это чтобы эти 2 потока, синхронизировались на одном и том же объекте
 * ВАЖНО, чтобы методы wait() и notify() вызвались на одном и том же объекте, иначе работать не будет
 * Потому что именно за счет этого объекта и происходит связь этих потоков,
 * один ждет, второй оповещает, что ты можешь проснуться и продолжить свое исполнение.
 *
 * Еще один важный момент, notify() в отличие от wait() - не возвращает монитор.
 * Т.е. когда мы вызвали notify() - мы не освобождаем монитор и если мы монитор не освободим,
 * то поток, который ждет - он не продолжит свое выполнение потому,
 * что для того чтобы он продолжил свое выполение - должны быть удовлетворены ДВА условия:
 *      1) Монитор (intrinsic lock) - снова у этого потока
 *      2) Вызван метод notify()
 *
 * - эти два метода определены у любого объекта в JAVA, т.к. они определены у объекта класса Object
 *   Есть они по той причине, что мы в Java можем синхронизироваться на любом объекте.
 *
 */
public class Wait_Notify {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started");

            // wait() - может вызываться только в пределах синхронизованного блока
            // вызывается на том объекте, на котором определен ваш синхронизованный блок
            // в данном случае определен на объекте this. Поэтому wait() вызывается на объекте this.

            wait(); // this.wait() - эквивалентно -- 1. Отдает intrinsic lock; 2. Ждет, пока будет вызван notify().

            // wait(timeout) - timeout столько миллисекунд этот поток будет ждать,
            // пока где-то будет вызван метод notify(), если notify() не будет вызван,
            // то он продолжит свое выполнение, в том только случае, если монитор этого объекта будет у этого потока

            // Когда в синхронизованном потоке вызывается метод wait() происходит 2 вещи:
            //  1. Мы отдаем этот внутренний intrinsic lock, который мы забрали в потоке, на котором шла синхронизация,
            //  т.о. мы как будто бы в этом потоке вышли из этого синхронизованного блока.
            // поэтому если у нас этом объекте синхронизируются другие потоки,
            // то они могут забрать lock этого объекта и продолжить свою работу.
            //  2. Мы в текущем потоке, в котором мы вызвали метод wait(),
            //  мы ждем пока будет вызван notify, причем будет вызван notify именно на этом объекте
            System.out.println("Producer thread resumed");
        }
    }

    public void consume() throws InterruptedException {

        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            // Вызываем метод notify(), чтобы на этом объекте this, все потоки, которые ждут,
            // которые вызвали метод wait(), чтобы они проснулись,
            // notify() - пробуждает только один поток
            // notifyAll() - пробуждает все потоки, которые ждут
            notify();

            Thread.sleep(5000);
        }
    }
}