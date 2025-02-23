import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class LastModifiedDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            Date date = new Date(file.lastModified());
            System.out.println("Last Modified: " + date);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
