package com.company;

import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by Rossen on 9.11.2015 ã..
 */
public class Zombie1 extends Enemy {
    private SpriteSheet sh = new SpriteSheet(ImageLoader.load("/Images/ZombieSheet.png"));
    public Zombie1(float x, float y, int width, int height, ZombieController zc, Player p, float speed, Controller c) {
        super(x, y, width, height, zc, p,speed,c);
    }

    public void tick() {
        if (this.enemyColisionBox.intersects(p.getBoundingBox())) {
            zc.removeZombie1(this);
        }
        if (this.enemyColisionBox.intersects(bullet.boundingBox)) {
            zc.removeZombie1(this);


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
    }

    public void render(Graphics g){
        g.drawImage(this.sh.crop(1+this.cropWidth*this.width,0,this.width,this.height),(int)this.x,(int)this.y,null);
    }
}
