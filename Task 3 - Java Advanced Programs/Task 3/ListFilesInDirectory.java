import java.io.File;
import java.util.Scanner;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                for (String file : files) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}
