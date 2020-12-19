package itqop;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JImageDisplay extends JComponent{
    int width;
    int heigth;
    private BufferedImage image;
    JImageDisplay(){
        this(200,200);
    }
    JImageDisplay(int w,int h){
        width = w;
        heigth = h;
        image = new BufferedImage(width,heigth,BufferedImage.TYPE_INT_RGB);
        Dimension dim = new Dimension(width,heigth);
        super.setPreferredSize(dim);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }
    public void clearImage(){
        for (int h = 0; h< image.getHeight();h++){
            for (int w = 0; w< image.getHeight();w++){
                this.drawPixel(w,h,0);
            }
        }
    }
    public void drawPixel (int x, int y, int rgbColor){
            this.image.setRGB(x,y,rgbColor);
    }
    /*public static void run(int ww,int hh){
        int w= ww;
        int h = hh;
        JFrame frame = new JFrame();
        JImageDisplay red = new JImageDisplay(w,h);
        frame.getContentPane().add(red);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setVisible(true);
    }*/
}
