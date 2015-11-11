package com.company;

import java.awt.*;
import java.util.Random;

/**
 * Created by Rossen on 11.11.2015 ã..
 */
public class Shadow {
    public Rectangle boundingBox;
    Controller c;
    Player p;

    public Shadow(Controller c, Player p) {
        this.c = c;
        this.p = p;
        this.boundingBox = new Rectangle((int)p.getBoundingBox().getX() ,(int)p.getBoundingBox().getY(), 26, 28);
    }

    public void render(Graphics g) {
       // g.fillRect((int)p.getBoundingBox().getX() ,(int)p.getBoundingBox().getY(), 26, 28);
    }

    public void tick() {
        this.boundingBox = new Rectangle((int)p.getBoundingBox().getX() ,(int)p.getBoundingBox().getY(), 26, 28);
    }

}
