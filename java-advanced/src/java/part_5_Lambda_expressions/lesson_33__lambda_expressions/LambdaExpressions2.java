package part_5_Lambda_expressions.lesson_33__lambda_expressions;

interface Executable2 {
//    void execute();
    int executeInt(int x);
}

class Runner2 {
    public void run(Executable2 executable) {
//        executable.execute();
        System.out.println( executable.executeInt(10) );
    }
}

public class LambdaExpressions2 {

    public static void main(String[] args) {

        // Без лямбда выражения
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        });

        // С лямбда выражением - тот же самый код, только проще и короче
        Thread thread2 = new Thread(() -> System.out.println("Hello!"));

        Runner2 runner = new Runner2();
        runner.run(new Executable2() {
//            @Override
//            public void execute() {
//                System.out.println("Hello!!2");
//            }

            @Override
            public int executeInt(int x) {
                return x + 10;
            }
        });
        runner.run((int x) -> {
            System.out.println("Hello!!2");
            return x + 10;
        });

        runner.run((int x) -> x + 777);
        runner.run( x -> x + 1);
    }
}


