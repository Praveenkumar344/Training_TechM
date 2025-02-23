import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

public class NegativeNumberChecker {
    public static void checkNumbers(String filePath) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                throw new PositiveNumberException("Positive number found: " + num);
            }
        }
        System.out.println("All numbers are negative.");
    }

    public static void main(String[] args) {
        try {
            checkNumbers("numbers.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found!");
        } catch (PositiveNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
