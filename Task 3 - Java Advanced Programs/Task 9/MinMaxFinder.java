import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class MinMaxFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 9, 1, 7, 2, 8, 6);

        Optional<Integer> max = numbers.stream().max(Integer::compare);
        Optional<Integer> min = numbers.stream().min(Integer::compare);

        System.out.println("Maximum Value: " + max.orElse(-1));
        System.out.println("Minimum Value: " + min.orElse(-1));
    }
}
