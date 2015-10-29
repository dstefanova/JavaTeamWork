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

    public static boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

    public Player(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sh = new SpriteSheet(ImageLoader.load("/Images/player.jpg"));
        this.name = name;
        this.velocity = 5;
    }
    public void tick(){
        if(isMovingDown){
            this.y += this.velocity;
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
    }
    public void redner(Graphics g){
        g.drawImage(this.sh.crop(0,0,this.width,this.height),this.x,this.y,null);

    }
}
