package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class Assets {
    public static BufferedImage playerImage ,enemy, boss;
    public static void init(){
    SpriteSheet spriteSheet = new SpriteSheet(
            ImageLoader.load("/Images/player.jpg")
    );
        playerImage = spriteSheet.crop(0,0,200,200);
        enemy = spriteSheet.crop(0,0,200,200);
    }
}
