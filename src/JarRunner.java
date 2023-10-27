import java.io.File;

/**
 @Author Arnav Dadarya
 Contains the  UI for program
 */
public class JarRunner {

    private static void printinst(){
        System.out.println("In order to use the CLI please read bellow");
        System.out.println("-----------------------");
        System.out.println("Convert File to Image: ");
        System.out.println("-img [file folder/path] [output folder/path]");
        System.out.println("You can convert entire Dirs too! (Output folder needs to already exist in file system)");
        System.out.println("-----------------------");
        System.out.println("Convert Image to File: ");
        System.out.println("-file [file path] [output path]");
        System.out.println("You can convert entire Dirs too! (Output folder needs to already exist in file system)");
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
                    File file = new File(args[1]);
                    if(file.isDirectory()){
                        BatchCreate.createfromDIR(args[1], args[2]);
                    }else {
                        System.out.println("Reading Image");
                        pictureCreate create = new pictureCreate();
                        create.createImg(FileEditor.getBytesFromFile(args[1]), args[2]);
                        System.out.println("Created File: " + args[2]);
                    }
                    break;
                case ("-file"):
                    File file2 = new File(args[1]);
                    if(file2.isDirectory()){
                        BatchRead.readFromDir(args[1], args[2]);
                    }else {
                        pictureRead read = new pictureRead();
                        FileEditor.write(read.getData(args[1]), args[2]);
                        System.out.println("Created File: " + args[2]);
                    }                    break;
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
