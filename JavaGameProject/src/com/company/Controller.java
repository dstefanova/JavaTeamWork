package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Rossen on 3.11.2015 ã..
 */
public class Controller {
    //MAKE PRIVATE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public ArrayList<Bullet> b = new ArrayList<Bullet>();
    public ArrayList<Zombie1> z = new ArrayList<Zombie1>();
    private Player p;
    private int zombieCount = 0;
    Random rand = new Random();

    Game game;

    public Controller(Game game, Player p) {
        this.game = game;
        this.p = p;
    }

    public void tick(){

        ////SPAWNING THE ZOMBIES////
        if (zombieCount<6){
            addZombie1(new Zombie1(rand.nextInt(800),rand.nextInt(600),32,32,this,this.p,0.8));
        }
        ////SPAWNING THE ZOMBIES////

        for (int i = 0; i < b.size(); i++) {
            b.get(i).tick();
        }
        for (int i = 0; i < z.size(); i++) {
            z.get(i).tick();
        }
    }
    public  void render(Graphics g){
        for (int i = 0; i < b.size(); i++) {
            b.get(i).render(g);
        }
        for (int i = 0; i < z.size(); i++) {
            z.get(i).render(g);
        }
    }

    public void addBullet(Bullet bullet){
        b.add(bullet);
    }
    public void addZombie1(Zombie1 zombie){
        z.add(zombie);
        zombieCount++;
    }
    public void removeBullet(Bullet bullet){
        b.remove(bullet);
    }
    public void removeZombie1(Zombie1 zombie){
        z.remove(zombie);
        zombieCount--;
    }
}
