import java.io.*;
import java.util.*;

public class ReadFileToByteArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            System.out.println("File content in bytes: " + Arrays.toString(data));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
