package itqop;


import java.awt.geom.Rectangle2D;
import java.lang.Math;
public class BShip extends FractalGenerator{
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }
    public int numIterations(double x, double y) {
        int count = 0;

        Complex one = new Complex(0,0);
        Complex next = new Complex(0,0);
        while (count < MAX_ITERATIONS && next.getMagnitude() < 4)
        {
            next.real(one.real()*one.real() - one.imag()* one.imag() + x);
            next.imag(2 * Math.abs(one.real()) * Math.abs(one.imag()) + y);
            one.real(next.real());
            one.imag(next.imag());
            count += 1;
        }

        if (count<MAX_ITERATIONS){return count;}else { return -1; }

    }

}
