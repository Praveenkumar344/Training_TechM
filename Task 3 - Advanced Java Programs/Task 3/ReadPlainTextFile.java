import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadPlainTextFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error : " + e);
        }
    }
}
