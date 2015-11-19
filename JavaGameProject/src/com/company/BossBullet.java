package com.company;

import gfx.ImageLoader;

import java.awt.*;
import java.util.Random;

/**
 * Created by Miroslav on 11/3/2015.
 */
public class BossBullet {
    int direction;
    int bulletX,bulletY,bulletW,bulletH, bulletVelocityX = 0, bulletVelocityY = 0 ;
    public Rectangle boundingBox;
    Controller c;
    Random randy = new Random();



    public BossBullet(int bulletX, int bulletY, Controller c) {
        this.bulletX = bulletX;
        this.bulletY = bulletY;
        bulletVelocityX = randy.nextInt(15 - (-15) + 1) + (-15);
        bulletVelocityY = randy.nextInt(15 - (-15) + 1) + (-15);
        this.c = c;
        this.boundingBox = new Rectangle(this.bulletX , this.bulletY, 7,7);
    }

    public Rectangle bulletBoundixBox(){
        return boundingBox;
    }

    public void tick(){
        if(this.bulletX < 0 || this.bulletX > 800 || this.bulletY < 0 || this.bulletY > 600){
            c.removeBossBullet(this);
        }
        this.bulletX += bulletVelocityX;
        this.bulletY += bulletVelocityY;

        for (int i = 0; i < c.sl.size(); i++) {
            if (this.boundingBox.intersects(c.sl.get(i).boundingBox)) {
                Player.danchoIsAlive = false;
            }
        }



        this.boundingBox = new Rectangle(this.bulletX , this.bulletY, 7,7);

    }
    public void render(Graphics g) {
        g.drawImage(ImageLoader.load("/Images/red_bullet.png"),bulletX,bulletY,null);
    }
}
