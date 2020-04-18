package java;

public class Box <T> {

    private T something;

    public Boolean isEmpty () {
        return something == null;
    }

    public void putSomething(T something) {

        this.something = something;

        Thread waitingForRemoving = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                putSomething(null);
            }
        });

        waitingForRemoving.start();

    }


    public static void main(String[] args) {
        Box<String> box = new Box<>();
        System.out.println(box.isEmpty());

        box.putSomething("Строка");
        System.out.println(box.isEmpty());

    }
}
