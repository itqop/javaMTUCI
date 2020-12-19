package itqop;


import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{
    public void getInitialRange(Rectangle2D.Double range){
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    public int numIterations(double x, double y) {
        int count = 0;
        double Z = 0;
        Complex one = new Complex(0,0);
        Complex next = new Complex(0,0);
        while (count++ < MAX_ITERATIONS && Z*Z < 4) {
            next.real(one.real()*one.real() - one.imag()* one.imag() + x);
            next.imag(2 * one.real() * one.imag() + y);
            one.real(next.real());
            one.imag(next.imag());
            Z = next.getMagnitude();
        }
        if (count<MAX_ITERATIONS){return count;}else { return -1; }

    }

}
/*import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Mandelbrot extends JFrame {

    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;

    public Mandelbrot() {
        super("Mandelbrot Set");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }

    public static void main(String[] args) {
        new Mandelbrot().setVisible(true);
    }
}*/