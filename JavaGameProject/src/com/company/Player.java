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
    private Rectangle boundingBox;
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
        this.velocity = 8;
        this.cropWidth = 1;

        this.c = c;

    }
    public void tick(){
        this.cropWidth++;

        if (this.cropWidth >= 3) {
            this.cropWidth = 1;
        }
        if(isMovingDown && isMovingLeft){
            this.y += this.velocity;
            this.x -= this.velocity;
        }else if(isMovingDown && isMovingRight){
            this.y += this.velocity;
            this.x += this.velocity;
        }
        else if(isMovingUp && isMovingLeft){
            this.y -= this.velocity;
            this.x -= this.velocity;
        }
        else if(isMovingUp && isMovingRight){
            this.y -= this.velocity;
            this.x += this.velocity;
        }
        else if(isMovingUp){
            this.y -= this.velocity;
        }
        else if(isMovingRight){
            this.x += this.velocity;
        }
        else if(isMovingLeft){
            this.x -= this.velocity;
        }
        else if(isMovingDown){
            this.y += this.velocity;
        }

        this.boundingBox = new Rectangle(this.x + 4 , this.y + 2, this.width -6,this.height -4);
    }
    public void redner(Graphics g){
        if (isMovingDown || isMovingRight){
            g.drawImage(this.sh.crop(1+this.cropWidth*this.width,0,this.width,this.height),this.x,this.y,null);
        }else if (isMovingLeft || facingLeft){
            g.drawImage(this.sh.crop(1+this.cropWidth*this.width,32,this.width,this.height),this.x,this.y,null);
        }else if (isMovingUp || facingUp){
            g.drawImage(this.sh.crop(1+this.cropWidth*this.width,64,this.width,this.height),this.x,this.y,null);
        }else{
            g.drawImage(this.sh.crop(0,0,this.width,this.height),this.x,this.y,null);
        }


    }
}
