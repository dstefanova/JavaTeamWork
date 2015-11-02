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
    private String name;
    private int cropWidth;

    public static boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

    public Player(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sh = new SpriteSheet(ImageLoader.load("/Images/Dancho.png"));
        this.name = name;
        this.velocity = 8;
        this.cropWidth = 1;
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
    }
    public void redner(Graphics g){
        if (isMovingDown || isMovingRight){
            g.drawImage(this.sh.crop(1+this.cropWidth*this.width,0,this.width,this.height),this.x,this.y,null);
        }else if (isMovingLeft){
            g.drawImage(this.sh.crop(1+this.cropWidth*this.width,32,this.width,this.height),this.x,this.y,null);
        }else if (isMovingUp){
            g.drawImage(this.sh.crop(1+this.cropWidth*this.width,64,this.width,this.height),this.x,this.y,null);
        }else{
            g.drawImage(this.sh.crop(0,0,this.width,this.height),this.x,this.y,null);
        }


    }
}
