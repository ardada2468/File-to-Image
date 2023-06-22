import java.io.File;

/**
 * Created by Arnav Dadarya
 */

public class JarRunner {

    private static void printinst(){
        System.out.println("In order to use the CLI please read bellow");
        System.out.println("-----------------------");
        System.out.println("Convert File to Image: ");
        System.out.println("-img [file path] [output path]");
        System.out.println("-----------------------");
        System.out.println("Convert Image to File: ");
        System.out.println("-file [file path] [output path]");
    }

    //args[0] --> mode
    //mode --> -img, -file, -help

    //args[1] --inputfile
    //args[2] --outputfile
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Error no arguments! ");
            printinst();
        } else {

            switch (args[0]) {
                case ("-img"):
                    System.out.println("Reading Image");
                    pictureCreate create = new pictureCreate();
                    create.createImg(FileEditor.getBytesFromFile(args[1]), args[2]);
                    System.out.println("Created File: " + args[2]);

                    break;
                case ("-file"):
//                    File file = new File(args[1]);
//                    if(file.isDirectory()){
//                        BatchCreate.createfromDIR();
//                    }
                    pictureRead read = new pictureRead();
                    FileEditor.write(read.getData(args[1]), args[2]);
                    System.out.println("Created File: " + args[2]);
                    break;
                case ("help"):
                    System.out.println("Hello!");
                    printinst();
                    break;
                default:
                    System.out.println("invalid command");
                    printinst();
                    break;

            }
        }
    }
}
