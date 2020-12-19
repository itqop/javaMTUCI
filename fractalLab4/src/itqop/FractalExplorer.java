package itqop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {

    private int Width;
    private int Height;

    private JImageDisplay ImageDisp;
    private FractalGenerator generateFractal;
    private Rectangle2D.Double range2D;


    public FractalExplorer(int w, int h){
        Width = w;
        Height = h;
        generateFractal = new Mandelbrot();
        range2D = new Rectangle2D.Double();
        generateFractal.getInitialRange(range2D);

    }

    protected void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal GEN");
        ImageDisp = new JImageDisplay(Width, Height);
        JButton myBtn = new JButton("Reset");

        myBtn.setActionCommand("Reset");
        myBtn.addActionListener(new Actions());

        frame.getContentPane().add(ImageDisp, BorderLayout.CENTER);
        frame.getContentPane().add(myBtn, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().addMouseListener(new MyMouseListener());

        frame.pack ();
        frame.setVisible (true);
        frame.setResizable (false);
    }

    protected void drawFractal (){
        for (int x = 0; x < Width; x++) {
            for (int y = 0; y < Height; y++) {
                double xCoord = generateFractal.getCoord(range2D.x, range2D.x + range2D.width, Width, x);
                double yCoord = generateFractal.getCoord(range2D.y, range2D.y + range2D.height, Height, y);

                double Iter = generateFractal.numIterations(xCoord, yCoord);

                int rgbColor = 0;
                if (Iter != -1){
                    float hue = 0.7f + (float) Iter / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }

                ImageDisp.drawPixel(x, y, rgbColor);
                ImageDisp.repaint();
            }
        }

    }

    public class Actions implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "Reset") {
                generateFractal.getInitialRange(range2D);
                drawFractal();

            }
        }
    }

    public class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2){
                double xCoord = generateFractal.getCoord(range2D.x, range2D.x + range2D.width, Width, e.getX());
                double yCoord = generateFractal.getCoord(range2D.y, range2D.y + range2D.height, Height, e.getY());
                generateFractal.recenterAndZoomRange(range2D, xCoord, yCoord, 0.5);
                drawFractal();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
