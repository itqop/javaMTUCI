package itqop;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class FractalExplorer {

    private int Width;
    private int Height;

    private JImageDisplay ImageDisp;
    private FractalGenerator generateFractal;
    private Rectangle2D.Double range2D;
    private int rowsRemaining;
    private int dSize;
    private String[] fractals = {
            "Mandelbrot",
            "Tricorn",
            "Burning Ship"
    };
    private JFrame frame = new JFrame("Fractal GEN");
    private JPanel panelDown = new JPanel();
    private JPanel panelUp = new JPanel();
    private JButton BtnReset = new JButton("Reset");
    private JButton BtnSave = new JButton("Save2img");
    private JLabel topLabel = new JLabel("Fractals: ");
    private JComboBox comboBox = new JComboBox(fractals);


    public FractalExplorer(int w, int h){
        dSize = w;
        Width = w;
        Height = h;
        generateFractal = new Mandelbrot();

        range2D = new Rectangle2D.Double();
        generateFractal.getInitialRange(range2D);

    }

    protected void createAndShowGUI(){

        ImageDisp = new JImageDisplay(Width, Height);
        BtnReset.setActionCommand("Reset");
        BtnReset.addActionListener(new Actions());

        BtnSave.setActionCommand("Save2img");
        BtnSave.addActionListener(new Actions());

        comboBox.setActionCommand("vibor");
        comboBox.addActionListener(new Actions());

        panelDown.add(BtnSave);
        panelDown.add(BtnReset);

        panelUp.add(topLabel);
        panelUp.add(comboBox);

        frame.getContentPane().add(panelUp, BorderLayout.NORTH);
        frame.getContentPane().add(ImageDisp, BorderLayout.CENTER);
        frame.getContentPane().add(panelDown, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().addMouseListener(new MyMouseListener());

        frame.pack ();
        frame.setVisible (true);
        frame.setResizable (false);
    }

    private void enableUI(boolean val) {
        comboBox.setEnabled(val);
        BtnReset.setEnabled(val);
        BtnSave.setEnabled(val);
    }

    protected void drawFractal (){
        enableUI(false);


        rowsRemaining = dSize;


        for (int x=0; x<dSize; x++){
            FractalWorker drawRow = new FractalWorker(x);
            drawRow.execute();
        }

    }


    public class Actions implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "Reset") {
                generateFractal.getInitialRange(range2D);
                drawFractal();

            }
            if (e.getActionCommand() == "Save2img") {
                //TODO: save fractal to img

                JFileChooser myFileChooser = new JFileChooser();


                FileFilter extensionFilter =
                        new FileNameExtensionFilter("PNG Images", "png");
                myFileChooser.setFileFilter(extensionFilter);

                myFileChooser.setAcceptAllFileFilterUsed(false);


                int userSelection = myFileChooser.showSaveDialog(ImageDisp);


                if (userSelection == JFileChooser.APPROVE_OPTION) {


                    java.io.File file = myFileChooser.getSelectedFile();
                    String file_name = file.toString();


                    try {
                        BufferedImage displayImage = ImageDisp.getImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    }

                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(ImageDisp,
                                exception.getMessage(), "Cannot Save Image",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            if (e.getActionCommand() == "vibor") {
                //TODO: others fr
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                switch (item){
                    case "Mandelbrot":
                        generateFractal = new Mandelbrot();
                        break;
                    case "Tricorn":
                        generateFractal = new Tricorn();
                        break;
                    case "Burning Ship":
                        generateFractal = new BShip();
                        break;
                }
                generateFractal.getInitialRange(range2D);
                drawFractal();

            }

        }
    }

    public class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (rowsRemaining != 0) {
                return;
            }
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

    private class FractalWorker extends SwingWorker<Object, Object>
    {

        int yCoordinate;


        int[] computedRGBValues;


        private FractalWorker(int row) {
            yCoordinate = row;
        }


        protected Object doInBackground() {

            computedRGBValues = new int[dSize];


            for (int i = 0; i < computedRGBValues.length; i++) {


                double xCoord = generateFractal.getCoord(range2D.x,
                        range2D.x + range2D.width, dSize, i);
                double yCoord = generateFractal.getCoord(range2D.y,
                        range2D.y + range2D.height, dSize, yCoordinate);


                int iteration = generateFractal.numIterations(xCoord, yCoord);


                if (iteration == -1){
                    computedRGBValues[i] = 0;
                }

                else {

                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);


                    computedRGBValues[i] = rgbColor;
                }
            }
            return null;

        }
        /**
         * Called when the background task is completed.  Draws the pixels
         * for the current row & updates the display for that row.
         */
        protected void done() {

            for (int i = 0; i < computedRGBValues.length; i++) {
                ImageDisp.drawPixel(i, yCoordinate, computedRGBValues[i]);
            }
            ImageDisp.repaint(0, 0, yCoordinate, dSize, 1);


            rowsRemaining--;
            if (rowsRemaining == 0) {
                enableUI(true);
            }
        }
    }

}
