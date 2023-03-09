import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        pictureCreate picture =  new pictureCreate();
        //Creating the img
        byte[] bytes = FileEditor.getBytesFromFile("src/hello.txt");
        System.out.println("Read input file...");
//        System.out.println(Arrays.toString(bytes));
        System.out.println("Creating Img.....");
        picture.createImg(bytes, "hello.png");

        System.out.println("now reading img");
        //Reading the IMG
        pictureRead reader = new pictureRead();
        byte[] data = reader.getData("hello.png");
        FileEditor.write(data,"text1");
    }
}