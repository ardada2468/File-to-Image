import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author Anrav Dadarya
 */

public class FileEditor {
    /**
     * Returns the bytes from a file
     * @param Path
     * @return bytes from a file
     */
    public static byte[] getBytesFromFile(String Path){
        Path path = Paths.get(Path);
        byte[] data;
        try {
          data = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println("Error Unable to read file: " + Path);
            throw new RuntimeException(e);
        }

//        if (data == null) {
//            throw new RuntimeException();
//        }
        System.out.println("Finished Reading File: " + path);
        return data;
    }

    /**
     * Writes a path givin a byte[] and a path
     * @param bytes
     * @param Path
     */

    public static void write(byte[] bytes, String Path){
        File output = new File(Path);
        try {
            Files.write(output.toPath(), bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        

    }


}
