import org.junit.Assert;
import org.junit.Test;

public class Vector2DTest {

    @Test
    public void newVectorShouldHaveZeroLength() {
        /*
         * Action - создание нового вектора
         */
        Vector2D v1 = new Vector2D();

        /*
         * Assertion - проверить, что у нас ожидаемый результат совпадает с фактическим
         *
         *         assertEquals (
         *              expected: ожидаемый результат,
         *              actual:   фактический - то, что метод реально возвращает,
         *              delta:    то, с какой точностью ожидаемый и фактический результат совпадают
         *         )
         *
         * "1e-9 = 0.000_000_0001" - т.н. научная аннотация (scientific annotation)
         *  на такую delta может отличаться результат
         */
        Assert.assertEquals(0, v1.length(), 1e-9);

        /*
            java.lang.AssertionError:
            Expected :0.0
            Actual   :1.0
         */
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Vector2D v1 = new Vector2D();
        Assert.assertEquals(0, v1.getX(), 1e-9);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Vector2D v1 = new Vector2D();
        Assert.assertEquals(0, v1.getY(), 1e-9);
    }
}
