package com.company;

import Display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Rossen on 29.10.2015 �..
 */
public class Game implements Runnable{
    private String title;
    private int WIDTH, HEIGHT;
    private Display display;
    private SpriteSheet sh;
    private Thread thread;
    private boolean isRunning = false;
    private final int w = 200;
    private final int h = 200;
    private int i = 0;
    private BufferStrategy bs;
    private Graphics g;
    private Player player;
    private InputHandler ih;

    public Game(String title, int WIDTH, int HEIGHT) {
        this.HEIGHT = HEIGHT;
        this.title = title;
        this.WIDTH = WIDTH;
        this.isRunning = false;

    }
    public void init(){
        this.display = new Display(title, WIDTH, HEIGHT);
        this.ih = new InputHandler(display);
        this.sh = new SpriteSheet(ImageLoader.load("/Images/Dancho.png")); //player
        Assets.init();
        this.player = new Player(100,0,32,32,"Dancho");
    }

    private void tick(){
        this.player.tick();
    }
    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();
        if (this.bs == null){
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }
        this.g = this.bs.getDrawGraphics();
        this.g.clearRect(0, 0, this.WIDTH, this.HEIGHT);
        // image Start
        this.g.drawImage(ImageLoader.load("/Images/TU.png"),0,0,null); //Background
        this.player.redner(g);
       // this.g.drawImage(Assets.playerImage,100,200,null);
        //image end
        this.bs.show();
        this.g.dispose();

    }
    @Override
    public void run() {
        this.init();
        int fps = 30;
        double  ticksPerFrame = 1_000_000_000/fps;
        double delta = 0;
        long now;
        long lastTimeTicked = System.nanoTime();
        while (isRunning){
            now = System.nanoTime();
            delta += (now - lastTimeTicked)/ticksPerFrame ;
            lastTimeTicked = now;
            if(delta >= 1) {
                tick();
                render();
                delta --;
            }
        }
        this.stop();
    }

    public synchronized void start(){
        if (!this.isRunning){
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }
    public synchronized void stop(){
        if (this.isRunning){
            this.isRunning = false;
            try {
                this.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}