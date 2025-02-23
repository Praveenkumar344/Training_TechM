import java.util.List;
import java.util.ArrayList;

public class MergeLists {
    public static <T> List<T> mergeAlternating(List<T> list1, List<T> list2) {
        List<T> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size())
                merged.add(list1.get(i++));
            if (j < list2.size())
                merged.add(list2.get(j++));
        }

        return merged;
    }

    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("1", "2", "3", "4");

        System.out.println(mergeAlternating(list1, list2));
    }
}
