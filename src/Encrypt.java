import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Encrypt {

    String Path;
    FileWriter writer;

    {
        try {
            writer = new FileWriter(new File(Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  int[][] encrypt(int [][] array){

        int[][] copy = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = shiftRow(array[i]);
        }

        System.out.println(Arrays.deepToString(copy));

        return copy;
    }

    public  int[] shiftRow(int[] array) {

        int shift = (int) (Math.random() * array.length) + 1;
        try {
            writer.write(shift+", ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Shifting by: " + shift);
        int[] clone = new int[array.length];

        for (int i = shift; i < array.length; i++) {
            clone[i - shift] = array[i];
        }
        for (int i = 0; i < shift; i++) {
            clone[i + (array.length - shift)] = array[i];
        }
//        System.out.println(Arrays.toString(clone));
        return clone;
    }

     private static int[] shiftRow(int[] array, int shift){

        System.out.println("Shifting by: " + shift);
        int[] clone = new int[array.length];

        for (int i = shift; i < array.length; i++) {
            clone[i-shift] = array[i];
        }
        for (int i = 0; i < shift; i++) {
            clone[i+(array.length-shift)] = array[i];
        }
//        System.out.println(Arrays.toString(clone));
        return clone;
    }

    private int[] decryptrow(int[] array, int shift){
      return shiftRow(array, array.length-shift);
    }
    public void decrypt(int[][] array, String PathtoKey){
        Scanner scanner;
        try {
           scanner = new Scanner(new File(PathtoKey));
           scanner.useDelimiter(",");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int[][] copy = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = decryptrow(array[i], scanner.nextInt());
        }
    }
}
