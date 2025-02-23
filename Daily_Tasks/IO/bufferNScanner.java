import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bufferNScanner {
    public static void main(String[] args) {
        try {
            inputBuffer();
        } catch (Exception e) {
            System.out.println("error in buffer");
        }
        bufferNScanner obj = new bufferNScanner();
        obj.inputScanner();

    }

    static void inputBuffer() throws IOException {
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter the input:");
        String s = r.readLine();

        System.out.println("The given input:" + s);
    }

    void inputScanner() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the input string :");
        String s1 = s.nextLine();
        System.out.println("You entered string " + s1);

        System.out.println("Enter the input integer :");
        int a = s.nextInt();
        System.out.println("You entered integer " + a);

        System.out.println("Enter the input float :");
        float b = s.nextFloat();
        System.out.println("You entered float " + b);
    }
}
