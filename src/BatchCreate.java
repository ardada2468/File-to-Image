import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BatchCreate {
    public static void createMultipleImg(String PathFile) throws FileNotFoundException {
        //input, output

        Scanner scanner = new Scanner(new File(PathFile));
        while (scanner.hasNextLine()){
            String Line = scanner.nextLine();
            String[] paths = Line.split(",");
            threadCreate(paths[0], paths[1]);
        }

    }

    public static void createfromDIR(String DirFile, String OutputPath){
        File folder = new File(DirFile);
        File[] listOfFiles =folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            String pathsave = listOfFiles[i].getName().replace('.', '_')+".png";
            threadCreate(listOfFiles[i].getAbsolutePath(), OutputPath+pathsave);
        }


    }

    public static Thread threadCreate(String inputFile, String OutputPath){
        Thread runnable = new Thread() {
            @Override
            public void run() {
                String inputPath = inputFile;
                String OutputFilePath = OutputPath;
                pictureCreate create = new pictureCreate();
                create.createImg(FileEditor.getBytesFromFile(inputPath), OutputFilePath);
            }
        };
        runnable.start();

        return runnable;
    }

}
