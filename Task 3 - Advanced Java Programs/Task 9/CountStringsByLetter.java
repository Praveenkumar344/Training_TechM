import java.util.List;
import java.util.Arrays;

public class CountStringsByLetter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");
        char targetLetter = 'a';

        long count = words.stream().filter(word -> word.startsWith(String.valueOf(targetLetter))).count();

        System.out.println("Number of words starting with '" + targetLetter + "': " + count);
    }
}
