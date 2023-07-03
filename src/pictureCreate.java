import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

/**
 * Created by Arnav Dadarya
 */
public class pictureCreate {

    protected int height = 10;
    protected int width = 10;

    void setDimensions(int size){
        int totalpix = (width*height);
        if(size > totalpix-10){
            width = (int) (Math.pow(size,.5)) +1;
            height = (int) (Math.pow(size,.5)) +1;
        }
    }

    public  void createImg(byte[] bytes, String path){

        System.out.println("Processing: " + path);

        setDimensions(bytes.length);
        System.out.println(path + " Picture Dimension: " + width);


        BufferedImage Image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        File output = null;
        int index = 0;

        for(int x = 0; x < width; x++){
            for (int y = 0; y < height; y++) {
                int[] Pixel = null;
                //{Alpha, Red, Green, Blue}
                if(index < bytes.length) {
                    //R,G,B in array
                    //Only blue pixel will be actual data
                    Pixel = new int[]{RandVal(), RandVal(), RandVal(), bytes[index]};
                } else if (index == bytes.length) {
                    //make that red pixel black to detect when random data starts
                    Pixel = new int[]{RandVal(), 0, RandVal(), RandVal()};
                }else{
                    //Create random pixel data
                    Pixel = new int[]{RandVal(), RandVal(), RandVal(), RandVal()};

                }

                //write pixel to img
                int valPix = (Pixel[0]<<24) | (Pixel[1]<<16) | (Pixel[2]<<8) | Pixel[3];
                Image.setRGB(x, y, valPix);

                index++;
            }

//            if(index%10000 == 0){
//                System.out.println("Currently Processing: " + path);
//            }

        }
        try {
            output = new File(path);
            System.out.println("Writing to Disk: " + path);
            ImageIO.write(Image, "png", output);
            System.out.println("Image saved to disk " + path);

        } catch (IOException e) {
            System.out.println("Unable to write to disk!");
            throw new RuntimeException(e);
        }

    }

    //Simple function to generate a random value
     int RandVal(){
        //Cannot return 0 value or 256
        return  (int) ( (Math.random()*254) + 1);
    }

}
