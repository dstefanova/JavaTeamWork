package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Rossen on 3.11.2015 �..
 */
public class Controller {
    //MAKE PRIVATE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public ArrayList<Bullet> b = new ArrayList<Bullet>();
  //  public ArrayList<Zombie1> z = new ArrayList<Zombie1>();
    private Player p;
    private int zombieCount = 0;
    Random rand = new Random();
    private int x,y,direction;
    Game game;

    public Controller(Game game, Player p) {
        this.game = game;
        this.p = p;
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
