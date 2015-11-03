package com.company;

import gfx.ImageLoader;

import java.awt.*;

/**
 * Created by Miroslav on 11/3/2015.
 */
public class Bullet {
    int direction;
    int bulletX,bulletY,bulletW,bulletH, bulletVelocityX, bulletVelocityY ;
    private Rectangle boundingBox;

    public Bullet(int direction, int bulletX, int bulletY) {
        this.direction = direction;
        this.bulletX = bulletX;
        this.bulletY = bulletY;
    }

    public  Rectangle bulletBoundixBox(){
        return boundingBox;
    }
    public void tick(){
        this.bulletX += bulletVelocityX;
        this.bulletY += bulletVelocityY;
        if(direction == 0){
            bulletVelocityY = -5;
        }
        if(direction == 1){
            bulletVelocityY = +5;
        }
        if(direction == 2){
            bulletVelocityX = -5;
        }
        if(direction == 3){
            bulletVelocityX = +5;
        }
    }
    public void render(Graphics g) {
        g.drawImage(ImageLoader.load("/Images/bullet.png"),bulletX,bulletY,null);
    }
}
