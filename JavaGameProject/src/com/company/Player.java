package com.company;

import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class Player {


    private int x, y, width, height, velocity;
    private SpriteSheet sh;
    private int cropWidth;
    public Rectangle getBoundingBox(){
        return boundingBox;
    }
    public Rectangle boundingBox;
    public static boolean danchoIsAlive = true;
    Controller c;



    public static boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight;
    public static boolean facingUp, facingLeft;
    public static boolean hasShotUp = true,hasShotDown = true,hasShotLeft = true,hasShotRight = true;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player(int x, int y, int width, int height, Controller c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.boundingBox = new Rectangle(this.x + 2 , this.y + 2, this.width -4,this.height -4);
        this.sh = new SpriteSheet(ImageLoader.load("/Images/Dancho.png"));
        this.velocity = 2;
        this.cropWidth = 1;

        this.c = c;

    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void tick() {
        this.boundingBox = new Rectangle(this.x + 4, this.y + 2, this.width - 6, this.height - 4);



        if (danchoIsAlive) {
            this.cropWidth++;
            if (this.x > 768) {
                x = 768;
            }
            if (this.x < 0) {
                x = 0;
            }
            if (this.y > 568) {
                y = 568;
            }
            if (this.y < 0) {
                y = 0;
            }
            if (this.cropWidth >= 3) {
                this.cropWidth = 1;
            }
            if (isMovingDown && isMovingLeft) {
                this.y += this.velocity;
                this.x -= this.velocity;
            } else if (isMovingDown && isMovingRight) {
                this.y += this.velocity;
                this.x += this.velocity;
            } else if (isMovingUp && isMovingLeft) {
                this.y -= this.velocity;
                this.x -= this.velocity;
            } else if (isMovingUp && isMovingRight) {
                this.y -= this.velocity;
                this.x += this.velocity;
            } else if (isMovingUp) {
                this.y -= this.velocity;
            } else if (isMovingRight) {
                this.x += this.velocity;
            } else if (isMovingLeft) {
                this.x -= this.velocity;
            } else if (isMovingDown) {
                this.y += this.velocity;
            }


        }
    }

    public void redner(Graphics g){
        if (danchoIsAlive) {
            if (isMovingDown || isMovingRight) {
                g.drawImage(this.sh.crop(1 + this.cropWidth * this.width, 0, this.width, this.height), this.x, this.y, null);
            } else if (isMovingLeft || facingLeft) {
                g.drawImage(this.sh.crop(1 + this.cropWidth * this.width, 32, this.width, this.height), this.x, this.y, null);
            } else if (isMovingUp || facingUp) {
                g.drawImage(this.sh.crop(1 + this.cropWidth * this.width, 64, this.width, this.height), this.x, this.y, null);
            } else {
                g.drawImage(this.sh.crop(0, 0, this.width, this.height), this.x, this.y, null);
            }
        }else{
            g.drawImage(ImageLoader.load("/Images/Ripip.jpg"), 0, 0, null);
        }

    }
}
