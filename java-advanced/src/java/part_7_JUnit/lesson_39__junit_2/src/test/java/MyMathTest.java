import org.junit.Test;

public class MyMathTest {

    /**
     * Если ArithmeticException - это исключение не будет выброшено, значит наш тест завалится
     */
    @Test(expected = ArithmeticException.class)
    public void zeroDenominatorShouldThrowException() {
        MyMath.divide(1, 0);
    }
}
