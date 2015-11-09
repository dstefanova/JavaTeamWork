package com.company;

import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;

/**
 * Created by Rossen on 9.11.2015 ã..
 */
public class Zombie1 extends Enemy {
    private SpriteSheet sh = new SpriteSheet(ImageLoader.load("/Images/ZombieSheet.png"));
    public Zombie1(double x, double y, int width, int height, Controller c, Player p, double speed) {
        super(x, y, width, height, c, p, speed);
    }

    public void tick(){
        if (this.enemyColisionBox.intersects(p.getBoundingBox())){
            c.removeZombie1(this);
        }

        if (p.getX() > this.x){
            this.x += speed;
        }else if(p.getX() < this.x){
            this.x -= speed;
        }

        if (p.getY() > this.y){
            this.y += speed;
        }else if(p.getY() < this.y){
            this.y -= speed;
        }

        this.enemyColisionBox = new Rectangle((int)this.x + 4 , (int)this.y + 2, this.width -6,this.height -4);
    }

    public void render(Graphics g){
        g.drawImage(this.sh.crop(1+this.cropWidth*this.width,0,this.width,this.height),(int)this.x,(int)this.y,null);
    }
}
