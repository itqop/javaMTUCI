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


    public FractalExplorer(int w, int h){
        Width = w;
        Height = h;
        generateFractal = new Mandelbrot();

        range2D = new Rectangle2D.Double();
        generateFractal.getInitialRange(range2D);

    }

    protected void createAndShowGUI(){
        String[] fractals = {
                "Mandelbrot",
                "Tricorn",
                "Burning Ship"
        };
        JFrame frame = new JFrame("Fractal GEN");
        ImageDisp = new JImageDisplay(Width, Height);
        JPanel panelDown = new JPanel();
        JPanel panelUp = new JPanel();
        JButton BtnReset = new JButton("Reset");
        JButton BtnSave = new JButton("Save2img");
        JLabel topLabel = new JLabel("Fractals: ");
        JComboBox comboBox = new JComboBox(fractals);

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
            if (e.getActionCommand() == "Save2img") {
                //TODO: save fractal to img

                // Allow the user to choose a file to save the image to.
                JFileChooser myFileChooser = new JFileChooser();

                // Save only PNG images.
                FileFilter extensionFilter =
                        new FileNameExtensionFilter("PNG Images", "png");
                myFileChooser.setFileFilter(extensionFilter);

                // Ensures that the filechooser won't allow non-".png"
                // filenames.
                myFileChooser.setAcceptAllFileFilterUsed(false);

                // Pops up a "Save file" window which lets the user select a
                // directory and file to save to.
                int userSelection = myFileChooser.showSaveDialog(ImageDisp);

                // If the outcome of the file-selection operation is
                // APPROVE_OPTION, continue with the file-save operation.
                if (userSelection == JFileChooser.APPROVE_OPTION) {

                    // Get the file and file name.
                    java.io.File file = myFileChooser.getSelectedFile();
                    String file_name = file.toString();

                    // Try saving the fractal image to disk.
                    try {
                        BufferedImage displayImage = ImageDisp.getImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    }
                    // Catches all exceptions and prints a message with the
                    // exception.
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
