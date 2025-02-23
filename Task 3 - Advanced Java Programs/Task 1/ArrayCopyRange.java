import java.util.Arrays;

public class ArrayCopyRange {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50, 60 };
        int[] copiedRange = Arrays.copyOfRange(numbers, 1, 4);

        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Copied Range: " + Arrays.toString(copiedRange));
    }
}
