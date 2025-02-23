import java.util.List;

public class FindElementIndex {
    public static <T> int findIndex(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "date");
        System.out.println(findIndex(words, "cherry")); // 2
        System.out.println(findIndex(words, "grape")); // -1
    }
}
