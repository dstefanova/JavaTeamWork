package com.company;

import Display.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class InputHandler implements KeyListener {
    public InputHandler(Display display){
        display.getCanvas().addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_A){
            //from here we can set the images to go on the left side
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
    }
}
