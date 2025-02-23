import java.util.List;
import java.util.Arrays;

public class AverageCalculator {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + average);
    }
}
