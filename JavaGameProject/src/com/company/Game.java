package com.company;

import Display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Rossen on 29.10.2015 ã..
 */
public class Game implements Runnable{
    private String title;
    private int WIDTH, HEIGHT;
    private Display display;

    private Thread thread;
    private boolean isRunning = false;

    private BufferStrategy bs;
    private Graphics g;
    public Game(String title, int WIDTH, int HEIGHT) {
        this.HEIGHT = HEIGHT;
        this.title = title;
        this.WIDTH = WIDTH;
        this.isRunning = false;

    }
    public void init(){
        this.display = new Display(title, WIDTH, HEIGHT);
    }

    private void tick(){

    }
    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();
        if (this.bs == null){
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }
        this.g = this.bs.getDrawGraphics();
        this.g.clearRect(0, 0, this.WIDTH, this.HEIGHT);

        this.g.fillRect(0, 0, 100, 100);

        this.bs.show();
        this.g.dispose();
    }
    @Override
    public void run() {
        this.init();
        while (isRunning){
            tick();
            render();
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
