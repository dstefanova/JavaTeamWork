package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class SpriteSheet {
    private BufferedImage sprite;
    public SpriteSheet(BufferedImage sprite){
        this.sprite = sprite;
    }
    public BufferedImage crop(int x , int y , int width , int height){
        return this.sprite.getSubimage(x,y,width , height );
    }
}
