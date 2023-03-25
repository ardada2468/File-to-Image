import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Arnav Dadarya
 */

public class pictureRead {
    public byte[] getData(String Path){

        File file= new File(Path);
        BufferedImage image = null;
        try {
           image = ImageIO.read(file);
            System.out.println("Compleated Reading File: " + Path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int size = 0;

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                int[] argb = new int[]{color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue()};
                if(argb[1] == 0){
                    x = image.getWidth()+1;
                    y = image.getHeight()+1;
                }else {
                    size++;
                }
            }
        }

        byte[] bytes = new byte[size];

        int index = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                int[] argb = new int[]{color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue()};
//                System.out.println(Arrays.toString(argb));
                if(argb[1] == 0){
                    x = image.getWidth()+1;
                    y = image.getHeight()+1;
                }else {
                    bytes[index] = (byte) argb[3];

                }
                index++;
            }
        }



//        System.out.println(Arrays.toString(bytes));

      return bytes;
        
    }

}
