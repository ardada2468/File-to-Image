import java.io.File;
import java.util.LinkedList;

/**
 * @Author Arnav Dadarya
 * Contains methods to read and process multiple files concurrently
 */
public class BatchRead {

    /**
     * Processes mutiple files in DIR concurrently
     * @param DirFile
     * @param OutputPath
     */

    public static void readFromDir(String DirFile, String OutputPath){

        LinkedList<String> x = new LinkedList<>();
        x.get(0);

        File folder = new File(DirFile);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            String pathsave;
            if(listOfFiles[i].getName().contains("_")){
                 pathsave = listOfFiles[i].getName().replace('_', '.').replace(".png", "");

            }else {
                 pathsave = listOfFiles[i].getName();
            }
            threadCreate(listOfFiles[i].getAbsolutePath(), OutputPath+pathsave);
        }



    }

    /**
     * Returns a thread that process a file
     * @param inputFile
     * @param OutputPath
     * @return
     */
    private static Thread threadCreate(String inputFile, String OutputPath){
        Thread runnable = new Thread() {
            @Override
            public void run() {
                String inputPath = inputFile;
                String OutputFilePath = OutputPath;
                pictureCreate create = new pictureCreate();
                pictureRead read = new pictureRead();
                FileEditor.write(read.getData(inputPath), OutputPath);
            }
        };
        runnable.start();
        return runnable;
    }
}
