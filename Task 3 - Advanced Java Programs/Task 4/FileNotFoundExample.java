import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundExample {
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) {
        try {
            readFile("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found!");
        }
    }
}
