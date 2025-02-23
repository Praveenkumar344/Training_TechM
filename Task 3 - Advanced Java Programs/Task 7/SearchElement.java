import java.util.ArrayList;

public class SearchElement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Python");
        list.add("Java");
        list.add("C++");

        System.out.println(list.contains("Java") ? "Found" : "Not Found");
    }
}
