package com.company;

import sun.security.provider.SHA;

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
    public ArrayList<BossBullet> bbl = new ArrayList<>();
    public ArrayList<FirstZombie> z = new ArrayList<FirstZombie>();
    public ArrayList<FirstBoss> fbf = new ArrayList<FirstBoss>();
    public ArrayList<SecondBoss> sbl = new ArrayList<>();
    public ArrayList<Shadow> sl = new ArrayList<>();
    private Player p;
    private int zombieCount = 0;
    private int bossCount = 0;
    public boolean stopZombies;
    private int zombieKillCount = 0;
    private boolean firstBossKilled = false;
    private boolean secondBossKilled = false;

    public void setSecondBossKilled(boolean secondBossKilled) {
        this.secondBossKilled = secondBossKilled;
    }

    public boolean isFirstBossKilled() {
        return firstBossKilled;
    }

    public void setFirstBossKilled(boolean firstBossKilled) {
        this.firstBossKilled = firstBossKilled;
    }



    Random rand = new Random();
    Game game;
    public boolean reset = false;

    public Controller(Game game, Player p) {
        this.game = game;
        this.p = p;
    }

    public void tick(){
//    if(reset){
//        zombieCount = 0;
//        bossCount = 0;
//        zombieKillCount = 0;
//        firstBossKilled = false;
//        secondBossKilled = false;
//        p.danchoIsAlive = true;
//        reset = false;
//        for (int i = 0; i < b.size(); i++) {
//            removeBullet(b.get(i));
//        }
//
//        for (int i = 0; i < fbf.size(); i++) {
//            removeFirstBoss(fbf.get(i));
//        }
//        for (int i = 0; i < z.size(); i++) {
//            removeFirstZombie(z.get(i));
//        }
//        for (int i = 0; i < sbl.size(); i++) {
//            removeSecondBoss(sbl.get(i));
//        }
//        for (int i = 0; i < bbl.size(); i++) {
//            removeBossBullet(bbl.get(i));
//        }
//    }
    if(sl.size() <1){
     addShadow(new Shadow(this,p));
    }
        if(bossCount<1 && zombieKillCount >= 40 && firstBossKilled && !secondBossKilled) {
            if (sbl.size() == 0) {
                addSecondBoss(new SecondBoss(400, 610, 32, 32, this, this.p, 0.1f));
            }
        }
        if (zombieCount<6 && zombieKillCount < 30 && !firstBossKilled){
            addFirstZombie(new FirstZombie(rand.nextInt(800),rand.nextInt(600),32,32,this,this.p,0.2f));
        }
        if (zombieCount<6 && zombieKillCount < 40 && firstBossKilled){
            addFirstZombie(new FirstZombie(rand.nextInt(800),rand.nextInt(600),32,32,this,this.p,0.1f));
        }
        if(bossCount<1 && zombieKillCount >= 30 && !firstBossKilled) {
            addFirstBoss(new FirstBoss(400, -42, 32, 32, this, this.p, 0.4f));
        }
        for (int i = 0; i < b.size(); i++) {
            b.get(i).tick();
        }

        for (int i = 0; i < fbf.size(); i++) {
            fbf.get(i).tick();
        }
        for (int i = 0; i < z.size(); i++) {
            z.get(i).tick();
        }
        for (int i = 0; i < sbl.size(); i++) {
            sbl.get(i).tick();

        }
        for (int i = 0; i < bbl.size(); i++) {
            bbl.get(i).tick();
        }
        for (int i = 0; i < sl.size(); i++) {
            sl.get(i).tick();
        }

    }
    public  void render(Graphics g){
        if (p.danchoIsAlive){

        for (int i = 0; i < fbf.size(); i++) {
            fbf.get(i).render(g);
        }
        for (int i = 0; i < b.size(); i++) {
            b.get(i).render(g);

        }
        for (int i = 0; i < z.size(); i++) {
            z.get(i).render(g);

        }
        for (int i = 0; i < sbl.size(); i++) {
            sbl.get(i).render(g);

        }
            for (int i = 0; i < bbl.size(); i++) {
                bbl.get(i).render(g);

            }
            for (int i = 0; i < sl.size(); i++) {
                sl.get(i).render(g);

            }
        }
    }
    public void addBullet(Bullet bullet){
        b.add(bullet);
    }
    public void addBossBullet(BossBullet bullet){
        bbl.add(bullet);
    }
    public void addFirstZombie(FirstZombie zombie){
        z.add(zombie);
        zombieCount++;
    }
    public void addFirstBoss(FirstBoss boss){
        fbf.add(boss);
        bossCount++;
    }

    public void addSecondBoss(SecondBoss boss){
        sbl.add(boss);
        bossCount++;
    }
    public void addShadow(Shadow shadow){
        sl.add(shadow);
    }
    public void removeBullet(Bullet bullet){
        b.remove(bullet);
    }
    public void removeBossBullet(BossBullet bullet){
        bbl.remove(bullet);
    }
    public void removeFirstZombie(FirstZombie zombie){
        z.remove(zombie);
        zombieCount--;
    }
    public void removeFirstBoss(FirstBoss boss){
        fbf.remove(boss);
        bossCount--;
    }
    public void removeSecondBoss(SecondBoss boss){
        sbl.remove(boss);
        bossCount--;
    }

    public int getZombieKillCount() {
        return zombieKillCount;
    }

    public void setZombieKillCount(int zombieKillCount) {
        this.zombieKillCount = zombieKillCount;
    }
}
