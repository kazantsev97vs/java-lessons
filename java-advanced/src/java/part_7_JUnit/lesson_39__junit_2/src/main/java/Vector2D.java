
public class Vector2D {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Сумма квадратов катетов равна квадрату гипотенузы (по теореме Пифагора)
     * @return длину вектора
     */
    public double length () {
         return Math.sqrt(x * x + y * y);
//        return 1;
    }

}
