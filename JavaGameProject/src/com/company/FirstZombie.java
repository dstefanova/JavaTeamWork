package com.company;

import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by Rossen on 9.11.2015 ã..
 */
public class FirstZombie extends Enemy {
    private SpriteSheet sh = new SpriteSheet(ImageLoader.load("/Images/ZombieSheet.png"));
    public FirstZombie(float x, float y, int width, int height, Controller c, Player p, float speed) {
        super(x, y, width, height, c,p,speed);
    }

    public void tick() {
        for (int i = 0; i < c.b.size(); i++) {
            if (this.enemyColisionBox.intersects(c.b.get(i).boundingBox)) {
                c.removeFirstZombie(this);
                c.b.remove(c.b.get(i));
                c.setZombieKillCount(c.getZombieKillCount() + 1);
                System.out.println(c.getZombieKillCount());
            }
        }
        for (int i = 0; i < c.sl.size(); i++) {
            if (this.enemyColisionBox.intersects(c.sl.get(i).boundingBox)) {
                p.danchoIsAlive = false;
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
        g.drawImage(this.sh.crop(1+this.cropWidth*this.width,0,this.width,this.height),(int)this.x,(int)this.y,null);
    }
}
