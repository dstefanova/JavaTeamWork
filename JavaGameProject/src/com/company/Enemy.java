package com.company;

import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by Miroslav on 10/29/2015.
 */
public abstract class Enemy {
    public int width, height, velocity;
    public double x, y, speed;
    public Player p;
    public Controller c;
    public SpriteSheet sh;
    public int cropWidth;
    public Rectangle enemyColisionBox;

    public Enemy(double x, double y, int width, int height, Controller c, Player p, double speed) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
        this.p = p;
        this.enemyColisionBox = new Rectangle((int)this.x + 4 , (int)this.y + 2, this.width -6,this.height -4);
    }



}
