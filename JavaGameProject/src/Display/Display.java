package Display;

import sun.misc.Cache;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {
    private String title;
    private int WIDTH;
    private int HEIGHT;
    private Canvas canvas;
    private JFrame frame;



    public Display(String title, int WIDTH, int HEIGHT){
        this.title = title;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        this.createFrame();
    }
    private void createFrame(){

        Dimension dimension = new Dimension(this.WIDTH, this.HEIGHT);
        this.frame = new JFrame(this.title);
        this.frame.setFocusable(true);
        this.frame.setSize(this.WIDTH, this.HEIGHT);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.canvas = new Canvas();
        this.canvas.setMaximumSize(dimension);
        this.canvas.setMinimumSize(dimension);
        this.canvas.setPreferredSize(dimension);

        this.frame.add(this.canvas);
        this.frame.pack();
    }
    public Canvas getCanvas() {
        return canvas;
    }
}
