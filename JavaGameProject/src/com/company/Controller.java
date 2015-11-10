package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rossen on 3.11.2015 ã..
 */
public class Controller {
    //MAKE PRIVATE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public ArrayList<Bullet> b = new ArrayList<Bullet>();
    public ArrayList<FirstZombie> z = new ArrayList<FirstZombie>();
    public ArrayList<FirstBoss> fbf = new ArrayList<FirstBoss>();
    private Player p;
    private int zombieCount = 0;
    private int bossCount = 0;

    Random rand = new Random();
    Game game;

    public Controller(Game game, Player p) {
        this.game = game;
        this.p = p;
    }

    public void tick(){

        if (zombieCount<6){
            addFirstZombie(new FirstZombie(rand.nextInt(800),rand.nextInt(600),32,32,this,this.p,0.5f));
        }
        if(bossCount<1) {
            addFirstBoss(new FirstBoss(10, 10, 32, 32, this, this.p, 0.2f));
        }
        for (int i = 0; i < b.size(); i++) {
            b.get(i).tick();

        }

        ////SPAWNING THE ZOMBIES////

        ////SPAWNING THE ZOMBIES////
        for (int i = 0; i < fbf.size(); i++) {
            fbf.get(i).tick();
        }
        for (int i = 0; i < z.size(); i++) {
            z.get(i).tick();
        }
    }
    public  void render(Graphics g){
        for (int i = 0; i < fbf.size(); i++) {
            fbf.get(i).render(g);
        }
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
    public void addFirstZombie(FirstZombie zombie){
        z.add(zombie);
        zombieCount++;
    }
    public void addFirstBoss(FirstBoss boss){
        fbf.add(boss);
        bossCount++;
    }

    public void removeBullet(Bullet bullet){
        b.remove(bullet);
    }
    public void removeFirstZombie(FirstZombie zombie){
        z.remove(zombie);
        zombieCount--;
    }
    public void removeFirstBoss(FirstBoss boss){
        fbf.remove(boss);
        bossCount--;
    }
}
