package com.company;

import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;
import java.util.*;

/**
 * Created by abelina on 10.11.2015 ã..
 */
public class FirstBoss extends Enemy{
    private SpriteSheet shb = new SpriteSheet(ImageLoader.load("/Images/ZombieSheet.png"));
    private int health = 100;
    private Random rand = new Random();
    private java.util.List<FirstZombie> listOfBossZombies = new ArrayList<FirstZombie>();
    private boolean isDark = false;
    private  float minionSpeed  = 0.5f;
    private  float speedo;


    public FirstBoss(float x, float y, int width, int height, Controller c, Player p, float speed) {
        super(x, y, width, height, c, p, speed);
    }
    public void tick() {
        for (int i = 0; i < c.b.size(); i++) {
            if(this.enemyColisionBox.intersects(c.b.get(i).boundingBox)){
                health -= 2;
                c.b.remove(c.b.get(i));
            }
            if(health <= 0){
                c.removeFirstBoss(this);
                c.setFirstBossKilled(true);
                c.setZombieKillCount(0);
            }
            if(health>0){
                int chanceToSpawn = rand.nextInt(265);
                if(chanceToSpawn == 69){
                    c.addFirstZombie((new FirstZombie(this.x+50,this.y+50,32,32,this.c,this.p,(float)rand.nextInt(100)/150)));
                    c.addFirstZombie((new FirstZombie(this.x-50,this.y+50,32,32,this.c,this.p,(float)rand.nextInt(100)/150)));
                    c.addFirstZombie((new FirstZombie(this.x+50,this.y-50,32,32,this.c,this.p,(float)rand.nextInt(100)/150)));
                    c.addFirstZombie((new FirstZombie(this.x-50,this.y-50,32,32,this.c,this.p,(float)rand.nextInt(100)/150)));
                }

            }
        }

        if (p.getX() > this.x) {
            this.x += speed;
        } else if (p.getX() < this.x) {
            this.x -= speed;
        }

        if (p.getY() > this.y) {
            this.y += speed;
        } else if (p.getY() < this.y) {
            this.y -= speed;
        }

        this.enemyColisionBox = new Rectangle((int) this.x + 4, (int) this.y + 2, this.width - 6, this.height - 4);
    }


    public void render(Graphics g){
        //g.drawRect(10,10,100,40);
        g.drawImage(this.shb.crop(this.cropWidth*this.width,128,this.width,this.height),(int)this.x,(int)this.y,null);
        g.setColor(Color.red);
        g.fillRect(0,0,this.health*8,16);

        if (!isDark){
            Color myOtherColour = new Color(0, 0, 0, 255);
            g.setColor(myOtherColour);
            g.fillRect(0,0,800,600);
            isDark = true;
        }else{
            Color myColour = new Color(0, 0,0, 128);
            g.setColor(myColour);
            g.fillRect(0,0,800,600);
            isDark = false;
        }


    }
}
