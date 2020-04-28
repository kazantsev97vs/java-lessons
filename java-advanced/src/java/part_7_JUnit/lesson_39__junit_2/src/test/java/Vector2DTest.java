import org.junit.*;

public class Vector2DTest {

    private final double EPS = 1e-9;
    private Vector2D v1;

    @BeforeClass
    public static void beforeClassMethod() {
        System.out.println("Vector2D class was start tests");
    }

    @Before
    public void createNewVector() {
        System.out.println("Some method was run");
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, v1.length(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Assert.assertEquals(0, v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Assert.assertEquals(0, v1.getY(), EPS);
    }

    @After
    public void AfterMethod() {
        System.out.println("AfterMethod");
    }

    @AfterClass
    public static void AfterClassMethod() {
        System.out.println("AfterClassMethod!!");
    }
}
