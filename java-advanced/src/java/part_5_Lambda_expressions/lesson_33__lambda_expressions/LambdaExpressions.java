package part_5_Lambda_expressions.lesson_33__lambda_expressions;

/**
 * Появились в JAVA 8  - это метод без названия
 * позволяют обойтись без анонимных классов
 * если что-то используется извне какая-то переменная, то она должна быть либо явно указана как final,
 * или неявно - не изменяться после создания в программе до использования в лямбда выражении
 * У лямбд нету своей слбственной области видимости
 */
public class LambdaExpressions {

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

        Runner runner = new Runner();
        // 1
        runner.run(new ExecutableImplementation());
        // 2
        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("Hello!!2");
            }
        });
        // 3
        runner.run(() -> System.out.println("Hello!!!3"));
    }
}

interface Executable {
    void execute();
}

class Runner {
    public void run(Executable executable) {
        executable.execute();
    }
}

class ExecutableImplementation implements Executable{
    @Override
    public void execute() {
        System.out.println("Hello!1");
    }
}