import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "mango", "blueberry");

        List<String> ascendingOrder = words.stream().sorted().collect(Collectors.toList());
        List<String> descendingOrder = words.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

        System.out.println("Ascending Order: " + ascendingOrder);
        System.out.println("Descending Order: " + descendingOrder);
    }
}
