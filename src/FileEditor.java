import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEditor {
    public static byte[] getBytesFromFile(String Path){
        Path path = Paths.get(Path);
        byte[] data = null;
        try {
          data = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println("Error Unable to read file: " + Path);
            throw new RuntimeException(e);
        }

        if (data == null) {
            throw new RuntimeException();
        }

        return data;
    }

    public static void write(byte[] bytes, String Path){
        File output = new File(Path);
        try {
            Files.write(output.toPath(), bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
