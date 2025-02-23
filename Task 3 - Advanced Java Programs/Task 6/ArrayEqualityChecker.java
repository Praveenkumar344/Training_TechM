import java.util.Arrays;

public class ArrayEqualityChecker {
    public static <T> boolean areArraysEqual(T[] arr1, T[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4 };
        Integer[] arr2 = { 1, 2, 3, 4 };
        Integer[] arr3 = { 1, 2, 4, 3 };

        System.out.println(areArraysEqual(arr1, arr2));
        System.out.println(areArraysEqual(arr1, arr3));
    }
}
