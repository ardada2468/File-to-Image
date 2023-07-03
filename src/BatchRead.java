import java.io.File;

public class BatchRead {

    public static void readFromDir(String DirFile, String OutputPath){
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

    public static Thread threadCreate(String inputFile, String OutputPath){
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
