package part_3_Java_Multithreading.lesson_30__multithreading___callable_future;

import java.util.Random;
import java.util.concurrent.*;

/**
 *  Callable и Future
 *   - эти классы позволяют возвращать значения из потоков
 *      и также позволяют выбрасывать исключения из потоков
 */
public class Callable_Future {

    private static int result;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt(10);
            if (randomValue < 5) {
                throw new Exception("Something bad happened, randomValue is " + randomValue);
            }
            return randomValue;
        });


        /*
            Лямбда выражение
                1.
                    System.out.println("Starting");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                    result = 5;

                преобразуется в

                    new Runnable() {
                        @Override
                        public void run() {...}
                    }

                2.
                    System.out.println("Starting");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                    return result = 5;

                преобразуется в

                    new Callable<Integer>() {
                        @Override
                        public Integer call() throws Exception {...}
                    }

            JAVA сама понимает во что преобразовать:
            в Runnable, если ничего не возвращается
            и в Callable, если есть возвращаемое значение
         */

        executorService.shutdown();
//        executorService.awaitTermination(1, TimeUnit.DAYS);

        try {
            // get() - дожидается окончания выполнения потока
            // когда мы здесь вызываем метод get() - мы в главном потоке останавливаемся,
            // ждем пока выполнится поток и вернет значение
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("Our exception");
            // getCause() - чтобы получить самое исключение, которое мы выбросили
            Throwable exception = e.getCause();
            System.out.println(exception.getMessage());
        }

        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("Program time is " + (endTime - startTime));
    }

    public static int calculate () {
        return 5 + 4;
    }
}
