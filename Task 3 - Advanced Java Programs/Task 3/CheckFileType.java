import java.io.File;
import java.util.Scanner;

public class CheckFileType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("It is a file.");
            } else if (file.isDirectory()) {
                System.out.println("It is a directory.");
            }
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}
