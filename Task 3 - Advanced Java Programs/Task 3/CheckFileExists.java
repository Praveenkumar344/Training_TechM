import java.io.File;
import java.util.Scanner;

public class CheckFileExists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file or directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            System.out.println("File or directory exists.");
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}
