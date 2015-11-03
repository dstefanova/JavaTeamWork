package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Rossen on 3.11.2015 ã..
 */
public class Controller {
    private ArrayList<Bullet> b = new ArrayList<Bullet>();

    Bullet TempBullet;

    Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public void tick(){
        for (int i = 0; i < b.size(); i++) {
            b.get(i).tick();
        }
    }
    public  void render(Graphics g){
        for (int i = 0; i < b.size(); i++) {
            b.get(i).render(g);
        }
    }

    public void addBullet(Bullet bullet){
        b.add(bullet);
    }
    public void removeBullet(Bullet bullet){
        b.remove(bullet);
    }
}
