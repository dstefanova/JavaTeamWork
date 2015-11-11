package com.company;

import Display.Display;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class InputHandler implements KeyListener {
    Controller c;
    Player p;
    public InputHandler(Display display, Controller c, Player p){
        display.getCanvas().addKeyListener(this);
        this.c = c;
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_A){
            //from here we can set the images to go on the leftside
            Player.isMovingLeft = true;
        }
        else if(keyCode == KeyEvent.VK_S){
            Player.isMovingDown = true;
        }
        else if(keyCode == KeyEvent.VK_D){
            Player.isMovingRight = true;
        }
        else if(keyCode == KeyEvent.VK_W){
            Player.isMovingUp = true;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            //from here we can set the images to go on the left side
            Player.isMovingLeft = true;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            Player.isMovingDown = true;
        }
        else if(keyCode == KeyEvent.VK_RIGHT){
            Player.isMovingRight = true;
        }
        else if(keyCode == KeyEvent.VK_UP){
        Player.isMovingUp = true;
    }

               if (keyCode == KeyEvent.VK_L) {
                   if(Player.hasShotRight) {
                       c.addBullet(new Bullet(3, p.getX() + 23, p.getY() + 12, c));
//                       System.out.println(c.b.size());
                       Player.hasShotRight =false;
                   }

           }

           else if (keyCode == KeyEvent.VK_I) {
                   if(Player.hasShotUp) {
                       c.addBullet(new Bullet(0, p.getX() + 13, p.getY() + 4, c));
                       Player.facingUp = true;
                       Player.hasShotUp = false;
                   }
            }


         else   if (keyCode == KeyEvent.VK_K) {
                   if(Player.hasShotDown) {
                       c.addBullet(new Bullet(1, p.getX() + 13, p.getY() + 20, c));
                       Player.hasShotDown = false;
                   }
            }


        else if (keyCode == KeyEvent.VK_J) {
                   if(Player.hasShotLeft) {
                       c.addBullet(new Bullet(2, p.getX(), p.getY() + 12, c));
                       Player.facingLeft = true;
                       Player.hasShotLeft = false;
                   }
            }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_A){
            //from here we can set the images to go on the left side
            Player.isMovingLeft = false;
        }
        else if(keyCode == KeyEvent.VK_S){
            Player.isMovingDown = false;
        }
        else if(keyCode == KeyEvent.VK_D){
            Player.isMovingRight = false;
        }
        else if(keyCode == KeyEvent.VK_W){
            Player.isMovingUp = false;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            //from here we can set the images to go on the left side
            Player.isMovingLeft = false;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            Player.isMovingDown = false;
        }
        else if(keyCode == KeyEvent.VK_RIGHT){
            Player.isMovingRight = false;
        }
        else if(keyCode == KeyEvent.VK_UP){
            Player.isMovingUp = false;
        }

        if (keyCode == KeyEvent.VK_J){
            Player.facingLeft = false;
            Player.hasShotLeft = true;
        }else if (keyCode == KeyEvent.VK_I){
            Player.facingUp = false;
            Player.hasShotUp = true;
        }
        else if(keyCode == KeyEvent.VK_L){
            Player.hasShotRight = true;
        }
        else if(keyCode == KeyEvent.VK_K){
            Player.hasShotDown = true;
        }
    }
}
