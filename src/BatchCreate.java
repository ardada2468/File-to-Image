import java.io.File;
import java.io.FileNotFoundException;
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
