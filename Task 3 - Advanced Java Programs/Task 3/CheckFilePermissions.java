import java.io.File;
import java.util.Scanner;

public class CheckFilePermissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
