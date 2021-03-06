package part_3_Java_Multithreading.lesson_28__multithreading___deadlock;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Способы избежать dead lock:
 * 1. Не забирать локи в разных порядках, т.е. не допускать такого,
 *      что в каком-то потоке у нас локи забираются в одном порядке,
 *      а в другом потоке у нас эти же локи забираются в другом порядке.
 *
 * 2. Использовать ReentrantLock и его метод tryLock()
 */

public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Runner runner = new Runner();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();


        long endTime = System.currentTimeMillis();
        System.out.println("Program time is " + (endTime - startTime));
    }
}

class Runner {

    private Account account1 = new Account();
    private Account account2 = new Account();
    private Random random = new Random();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {

                if (firstLockTaken && secondLockTaken) return;

                if (firstLockTaken) lock1.unlock();

                if (secondLockTaken) lock2.unlock();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        for (int i = 0; i < 10_000; i++) {
//            lock1.lock();
//            // 1й поток здесь
//            lock2.lock();

            takeLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
//            synchronized (account1) {
//                synchronized (account2) {
//                    Account.transfer(account1, account2, random.nextInt(100));
//                }
//            }
        }
    }

    public void secondThread() {
        for (int i = 0; i < 10_000; i++) {
//            lock2.lock();
//            // 2й поток здесь
//            lock1.lock();

            takeLocks(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
//            synchronized (account1) {
//                synchronized (account2) {
//                    Account.transfer(account2, account1, random.nextInt(100));
//                }
//            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10_000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}