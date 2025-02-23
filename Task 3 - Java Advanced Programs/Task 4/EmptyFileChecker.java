import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class EmptyFileChecker {
    public static void checkFileNotEmpty(String filePath) throws FileNotFoundException, EmptyFileException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        if (!scanner.hasNextLine()) {
            throw new EmptyFileException("File is empty!");
        }

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) {
        try {
            checkFileNotEmpty("empty.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found!");
        } catch (EmptyFileException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
