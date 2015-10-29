package com.company;

import Display.Display;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Java project", 800, 600);
        game.start();
    }
}
