package com.company;

import Display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Rossen on 29.10.2015 ã..
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
    private Zombie1 zombie;
    private InputHandler ih;
    private Controller c;
    private Bullet bullet;


    public Game(String title, int WIDTH, int HEIGHT) {
        this.HEIGHT = HEIGHT;
        this.title = title;
        this.WIDTH = WIDTH;
        this.isRunning = false;

    }
    public void init(){
        this.display = new Display(title, WIDTH, HEIGHT);
        this.sh = new SpriteSheet(ImageLoader.load("/Images/Dancho.png")); //player
        Assets.init();
        this.player = new Player(100,0,32,32,c);
        this.c = new Controller(this,this.player);
        this.ih = new InputHandler(display, c, player);
    }

    private void tick(){
        this.player.tick();
        c.tick();
    }
    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();
        if (this.bs == null){
            this.display.getCanvas().createBufferStrategy(3);
            return;
        }
        this.g = this.bs.getDrawGraphics();
        this.g.clearRect(0, 0, this.WIDTH, this.HEIGHT);
        // image Start
        //this.g.drawImage(ImageLoader.load("/Images/TU.jpg"),0,0,null); //Background
        this.player.redner(g);
        c.render(g);
        this.g.drawRect(this.player.getBoundingBox().x,this.player.getBoundingBox().y,this.player.getBoundingBox().width,this.player.getBoundingBox().height);
        //this.g.drawRect(this.bullet.bulletBoundixBox().x,this.bullet.bulletBoundixBox().y,8,8);
        // this.g.drawImage(Assets.playerImage,100,200,null);
        //image end
        this.bs.show();
        this.g.dispose();

    }
    @Override
    public void run() {
        this.init();
        int fps = 60;
        double  ticksPerFrame = 300_000_000d/fps;
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
