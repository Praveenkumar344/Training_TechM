import java.util.Arrays;

public class CopyAlternateElements {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int size = (numbers.length + 1) / 2;
        int[] alternate = new int[size];

        for (int i = 0, j = 0; i < numbers.length; i += 2, j++) {
            alternate[j] = numbers[i];
        }

        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Alternate Elements: " + Arrays.toString(alternate));
    }
}
