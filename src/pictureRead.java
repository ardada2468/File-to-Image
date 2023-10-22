import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @Author Arnav Dadarya
 * reads an Image that has been previously processed
 *
 */

public class pictureRead {


    /**
     * Reads a previously processed img to get a byte array
     * @param Path
     * @return array of bytes hidden in the img
     */
    public static byte[] getData(String Path){
        File file= new File(Path);
        BufferedImage image = null;
        try {
           image = ImageIO.read(file);
            System.out.println("Compleated Reading File: " + Path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int size = 0;
        ArrayList<Byte> bytes = new ArrayList<>();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                //Reading each pixel
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                int[] argb = new int[]{ color.getRed(),  color.getBlue()};
                //                                                                              3
                if(argb[0] == 0){
                    x = image.getWidth()+1;
                    y = image.getHeight()+1;
                }else {
                    bytes.add((byte) argb[1]);
                    size++;
                }
            }
        }
        byte[] bytesArr = new byte[bytes.size()];

        for (int i = 0; i < bytes.size(); i++) {
            bytesArr[i] = bytes.get(i);
        }
      return bytesArr;
        
    }

}
