import java.util.Arrays;
import java.util.Objects;

public class EqualsVsDeepEquals {
    public static void main(String[] args) {
        String[] arr1 = { "apple", "banana" };
        String[] arr2 = { "apple", "banana" };

        System.out.println("Using equals(): " + Arrays.equals(arr1, arr2)); // true
        System.out.println("Using deepEquals(): " + Objects.deepEquals(arr1, arr2)); // true

        Object[] arr3 = { arr1 };
        Object[] arr4 = { arr2 };

        System.out.println("Using equals() on nested arrays: " + Arrays.equals(arr3, arr4)); // false
        System.out.println("Using deepEquals() on nested arrays: " + Objects.deepEquals(arr3, arr4)); // true
    }
}
