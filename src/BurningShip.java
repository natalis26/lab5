import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator {
    private Complex z = new Complex(0, 0);
    private Complex c = new Complex(0, 0);
    public static final int MAX_ITERATIONS = 2000;



    public void getInitialRange(Rectangle2D.Double range) {
        range.setRect(-2, -2.5, 4,4);
    }

    public int numIterations(double x, double y) {
        z.real = 0; z.imag = 0; c.real = x; c.imag = y;
        double realTemp;
        for (int IterNum = 0; IterNum < MAX_ITERATIONS; IterNum++) {
            realTemp = z.real*z.real - z.imag*z.imag + x;
            z.imag = Math.abs(2*z.real*z.imag + y);
            z.real = Math.abs(realTemp);
            if (z.abs() > 4) return IterNum;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Горящий корабль";
    }
}