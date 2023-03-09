import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pictureCreate {

    private int height = 100;
    private int width = 100;

    private void setDimensions(int size){
        int totalpix = (width*height);
        if(size > totalpix-10){
            width = (int) (Math.pow(size,.5)) +1;
            height = (int) (Math.pow(size,.5)) +1;
        }
    }

    public  void createImg(byte[] bytes, String path){


        setDimensions(bytes.length);
        System.out.println("Picture Dimension: " + width);


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
                    //make that red pixel black
                    //We can later identify when we have all the data
                    Pixel = new int[]{RandVal(), 0, RandVal(), RandVal()};
                }else{
                    Pixel = new int[]{RandVal(), RandVal(), RandVal(), RandVal()};

                }

                int valPix = (Pixel[0]<<24) | (Pixel[1]<<16) | (Pixel[2]<<8) | Pixel[3];
                Image.setRGB(x, y, valPix);

                index++;
            }

        }
        try {
            output = new File(path);
            ImageIO.write(Image, "png", output);

        } catch (IOException e) {
            System.out.println("Unable to write to disk!");
            throw new RuntimeException(e);
        }

    }

    private int RandVal(){
        //Cannot return 0 value or 256
        return  (int) ( (Math.random()*254) + 1);
    }

}
