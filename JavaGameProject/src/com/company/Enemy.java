package com.company;

import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class Enemy {
    private int x, y, width, height, velocity;
    private SpriteSheet sh;
    private int cropWidth;

    public Enemy(int x, int y, int width, int height, Controller c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBoundingBox(){
        return boundingBox;
    }
    private Rectangle boundingBox;

}
