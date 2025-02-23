import java.io.File;
import java.util.Scanner;

public class GetFileSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            long bytes = file.length();
            double mb = bytes / (1024.0 * 1024.0);
            System.out.println("Size in MB: " + mb);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
