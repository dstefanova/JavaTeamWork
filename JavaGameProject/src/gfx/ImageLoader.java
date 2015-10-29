package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class ImageLoader {
    public static BufferedImage load(String imagePath){
        try {
            return ImageIO.read(ImageLoader.class.getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
