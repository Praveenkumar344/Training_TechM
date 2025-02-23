import java.io.File;
import java.util.Scanner;

public class FilterFilesByExtension {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File folder = new File(path);
        String extension = ".txt";

        File[] files = folder.listFiles((dir, name) -> name.endsWith(extension));
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found with extension " + extension);
        }
    }
}
