package com.company;

import gfx.ImageLoader;

import java.awt.*;

/**
 * Created by Miroslav on 11/3/2015.
 */
public class Bullet {
    int direction;
    int bulletX,bulletY,bulletW,bulletH, bulletVelocityX = 0, bulletVelocityY = 0 ;
    public Rectangle boundingBox;
    Controller c;


    public Bullet(int direction, int bulletX, int bulletY, Controller c) {
        this.direction = direction;
        this.bulletX = bulletX;
        this.bulletY = bulletY;
        this.c = c;
        this.boundingBox = new Rectangle(this.bulletX , this.bulletY, 7,7);
    }

    public  Rectangle bulletBoundixBox(){
        return boundingBox;
    }

    public void tick(){
        if(this.bulletX < 0 || this.bulletX > 800 || this.bulletY < 0 || this.bulletY > 600){
            c.removeBullet(this);
        }
        this.bulletX += bulletVelocityX;
        this.bulletY += bulletVelocityY;
        if(direction == 0){
            bulletVelocityY = -15;
        }
        if(direction == 1){
            bulletVelocityY = +15;
        }
        if(direction == 2){
            bulletVelocityX = -15;
        }
        if(direction == 3){
            bulletVelocityX = +15;
        }

    }
    public void render(Graphics g) {
        g.drawImage(ImageLoader.load("/Images/bullet.png"),bulletX,bulletY,null);
        g.drawRect(this.bulletX,this.bulletY,7,7);
    }
}
