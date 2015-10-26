package com.company;

import java.awt.*;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH/12*9;
    public static void main(String[] args) {
        new Game();
    }
    public synchronized void start(){

    }
    public void run(){

    }
    public Game(){
        new Window(WIDTH, HEIGHT, "Java Project =))",this);
    }
}
