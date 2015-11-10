package com.company;

import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by abelina on 10.11.2015 ã..
 */
public class FirstBoss extends Enemy{
    private SpriteSheet shb = new SpriteSheet(ImageLoader.load("/Images/ZombieSheet.png"));
    private int health = 100;


    public FirstBoss(float x, float y, int width, int height, Controller c, Player p, float speed) {
        super(x, y, width, height, c, p, speed);
    }
    public void tick() {
        for (int i = 0; i < c.b.size(); i++) {
            if(this.enemyColisionBox.intersects(c.b.get(i).boundingBox)){
                health -= 10;
                c.b.remove(c.b.get(i));
            }
            if(health == 0){
                c.removeFirstBoss(this);
            }
        }

        if (p.getX() > this.x) {
            this.x += speed;
        } else if (p.getX() < this.x) {
            this.x -= speed;
        }

        if (p.getY() > this.y) {
            this.y += speed;
        } else if (p.getY() < this.y) {
            this.y -= speed;
        }

        this.enemyColisionBox = new Rectangle((int) this.x + 4, (int) this.y + 2, this.width - 6, this.height - 4);
    }


    public void render(Graphics g){
        //g.drawRect(10,10,100,40);
        g.drawImage(this.shb.crop(this.cropWidth*this.width,128,this.width,this.height),(int)this.x,(int)this.y,null);
    }
}
