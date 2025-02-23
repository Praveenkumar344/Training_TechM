import java.util.ArrayList;
import java.util.Collections;

public class ShuffleArrayList {
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");

        Collections.shuffle(numbers);
        System.out.println(numbers);
    }
}
